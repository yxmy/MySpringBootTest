package cn.gov.sapprft.mtms.external.hbase.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@ConfigurationProperties(prefix = "hbase", ignoreUnknownFields = false)
public class HBaseProperties {
    private final Zookeeper zookeeper = new Zookeeper();
    private final Client client = new Client();

    @Getter
    @Setter
    public class Zookeeper {
        private String quorum;
        private String clientPort = "2181";
    }

    @Getter
    @Setter
    public class Client {
        private String scannerCaching = "100";
        private String writeBuffer = "2097152";
    }
}
