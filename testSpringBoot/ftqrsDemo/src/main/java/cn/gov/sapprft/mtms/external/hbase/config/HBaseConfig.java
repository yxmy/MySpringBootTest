package cn.gov.sapprft.mtms.external.hbase.config;

import java.io.IOException;

import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.config.annotation.EnableHadoop;
import org.springframework.data.hadoop.config.annotation.SpringHadoopConfigurerAdapter;
import org.springframework.data.hadoop.config.annotation.builders.HadoopConfigConfigurer;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

@Configuration
@EnableHadoop
public class HBaseConfig extends SpringHadoopConfigurerAdapter {

    @Autowired
    private org.apache.hadoop.conf.Configuration hbaseConfig;

    @Bean
    public HBaseProperties hBaseProperties() {
        return new HBaseProperties();
    }

    @Override
    public void configure(final HadoopConfigConfigurer config) throws Exception {

        config./* fileSystemUri("hdfs://192.168.0.51:8020"). */withProperties()
                .property("hbase.zookeeper.quorum", this.hBaseProperties().getZookeeper().getQuorum())
                .property("hbase.zookeeper.property.clientPort", this.hBaseProperties().getZookeeper().getClientPort()) //
                .property("hbase.client.scanner.caching", this.hBaseProperties().getClient().getScannerCaching()) //
                .property("hbase.client.write.buffer", this.hBaseProperties().getClient().getWriteBuffer());
    }

    @Bean
    public HbaseTemplate hbaseTemplate(final org.apache.hadoop.conf.Configuration configuration) {
        final HbaseTemplate hbaseTemplate = new HbaseTemplate(configuration);
        hbaseTemplate.setAutoFlush(false);
        return hbaseTemplate;
    }

    @Bean
    public HBaseAdmin hBaseAdmin() {
        HBaseAdmin admin = null;
        try {
            admin = new HBaseAdmin(this.hbaseConfig);
        } catch (final MasterNotRunningException e) {
            e.printStackTrace();
        } catch (final ZooKeeperConnectionException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return admin;
    }

}
