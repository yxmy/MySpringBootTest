package cn.gov.sapprft.mtms.external.hbase.convertor;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;

public interface HBaseConvertor<T> {

    T toBean(final Result result);
    
    Put toPut(T bean);
}
