package cn.gov.sapprft.mtms.external.hbase.repository;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.gov.sapprft.mtms.external.hbase.bean.FilmTicketQrcodeScanBean;
import cn.gov.sapprft.mtms.external.hbase.convertor.FilmTicketQrcodeScanConvertor;
import cn.gov.sapprft.mtms.external.hbase.convertor.HBaseConvertor;

@Component
public class FilmTicketQrcodeScanRepository extends AbstractHBaseRepository<FilmTicketQrcodeScanBean> {

    private final String table = "mtms_ftqrs";

    @Autowired
    private FilmTicketQrcodeScanConvertor filmTicketQrcodeScanConvertor;

    public Map<String, FilmTicketQrcodeScanBean> findByRowkeys(final Set<String> rowkeys) {
        return super.findByRowkeys(this.table, rowkeys);
    }

    public boolean save(final Collection<FilmTicketQrcodeScanBean> filmTicketQrcodeScanBean) {
        // 执行异步批量更新
        return this.supplyAsync().addTask(() -> this.save(this.table, filmTicketQrcodeScanBean)).run();
    }

    @Override
    protected HBaseConvertor<FilmTicketQrcodeScanBean> getConvertor() {
        return this.filmTicketQrcodeScanConvertor;
    }

}
