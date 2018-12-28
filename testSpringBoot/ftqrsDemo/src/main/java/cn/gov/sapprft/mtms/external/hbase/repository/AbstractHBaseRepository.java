package cn.gov.sapprft.mtms.external.hbase.repository;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

import cn.gov.sapprft.mtms.external.hbase.convertor.HBaseConvertor;

import com.leadingsoft.bizfuse.common.web.utils.json.JsonUtils;

@Slf4j
public abstract class AbstractHBaseRepository<T> {

	@Autowired
    private HbaseTemplate hbaseTemplate;

    /**
     * 获取Convertor
     *
     * @return
     */
    protected abstract HBaseConvertor<T> getConvertor();
    
    /**
     * 根据Rowkey批量查询
     *
     * @param tableName
     * @param rowkeys
     * @return
     */
    protected Map<String, T> findByRowkeys(final String tableName, final Set<String> rowkeys) {
        //转换成org.apache.hadoop.hbase.client.Get数组
        try {
            final List<Get> gets = rowkeys.stream()
                    .map(rowkey -> new Get(rowkey.getBytes(Charset.forName("UTF-8"))))
                    .collect(Collectors.toList());

            return this.hbaseTemplate.execute(tableName, table -> {
                try {
                    final Result[] results = table.get(gets);
                    final Map<String, T> rMap = new HashMap<>();
                    for (final Result r : results) {
                        if ((null == r) || (r.size() == 0)) {
                            continue;
                        }
                        final T bean = this.getConvertor().toBean(r);
                        rMap.put(Bytes.toString(r.getRow()), bean);
                    }
                    return rMap;
                } catch (final Exception e) {
                    AbstractHBaseRepository.log.error("根据rowkey查询结果转化为Bean时失败.", e);
                    throw e;
                }
            });
        } catch (final Exception e) {
            final String keys = JsonUtils.pojoToJson(rowkeys);
            final String msg = "HBase根据rowkey查询发生异常: " + tableName + ": " + keys;
            AbstractHBaseRepository.log.error(msg, e);
            throw new HBaseException(msg, e);
        }
    }

    /**
     * 根据Rowkey批量查询
     *
     * @param tableName
     * @param rowkeys
     * @return
     */
    protected List<T> findByTimeRange(final String tableName, final Date startTime, final Date endTime) {
        try {
            final Scan scan = new Scan();
            // 时间戳，过滤器
            scan.setTimeRange(startTime.getTime(), endTime.getTime());
            // scan.setStartRow(Bytes.toBytes(startRow));
            // scan.setStopRow(Bytes.toBytes(stopRow));
            /*
             * PageFilter filter = new PageFilter(5); scan.setFilter(filter);
             */

            final List<T> entities = this.hbaseTemplate.find(tableName, scan, results -> {
                final List<T> objectList = new ArrayList<T>();
                final Iterator<Result> iterator = results.iterator(); // 这个迭代器只能获取一次
                while (iterator.hasNext()) {
                    final Result next = iterator.next();
                    final T bean = this.getConvertor().toBean(next);
                    objectList.add(bean);
                }
                return objectList;
            });
            return entities;

        } catch (final Exception e) {
            final String keys = JsonUtils.pojoToJson("");
            final String msg = "HBase查询发生异常: " + tableName + ": " + keys;
            AbstractHBaseRepository.log.error(msg, e);
            throw new HBaseException(msg, e);
        }
    }

    protected boolean save(final String tableName, final Collection<T> beans) {
        if ((beans == null) || beans.isEmpty()) {
            return true;
        }
        final List<Put> puts = beans.stream().map(v -> this.getConvertor().toPut(v)).filter(v -> v != null)
                .collect(Collectors.toList());

        return this.hbaseTemplate.execute(tableName, table -> {
            try {
                table.put(puts);
                table.flushCommits();
            } catch (final Throwable e) {
                final String msg = "HBase批量存储失败。";
                AbstractHBaseRepository.log.error(msg, e);
                throw new HBaseException(msg, e);
            }
            if (AbstractHBaseRepository.log.isDebugEnabled()) {
                AbstractHBaseRepository.log.debug("HBase table {} 批量存储数据 {} 条", tableName, beans.size());
            }
            return true;
        });
    }
    
    protected AsyncBatchSaveBuilder supplyAsync() {
        return new AsyncBatchSaveBuilder();
    }

    class AsyncBatchSaveBuilder {
        List<Supplier<Boolean>> asyncTasks = new ArrayList<>();

        public AsyncBatchSaveBuilder addTask(final Supplier<Boolean> task) {
            this.asyncTasks.add(task);
            return this;
        }

        public boolean run() {
            return AbstractHBaseRepository.this.asyncBatchSave(this.asyncTasks);
        }
    }
    
    /**
     * 异步的批量更新
     *
     * @return
     */
    protected boolean asyncBatchSave(final List<Supplier<Boolean>> tasks) {
        final List<CompletableFuture<Boolean>> asyncTasks =
                tasks.stream().map(task -> CompletableFuture.supplyAsync(task)).collect(Collectors.toList());
        // 等待所有任务完成（Java8的CompletableFuture 参考 http://www.infoq.com/cn/articles/Functional-Style-Callbacks-Using-CompletableFuture）
        final boolean isSuccess = asyncTasks.stream().allMatch(task -> Boolean.TRUE.equals(task.join()));
        if (!isSuccess) {
            throw new HBaseException("HBase异步批量存储失败。");
        }
        return isSuccess;
    }

    public static class HBaseException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public HBaseException(final String message) {
            super(message);
        }

        public HBaseException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }

}
