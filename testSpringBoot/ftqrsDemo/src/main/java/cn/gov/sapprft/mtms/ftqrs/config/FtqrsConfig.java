package cn.gov.sapprft.mtms.ftqrs.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class FtqrsConfig {

	@Bean
	@Primary // 标记为主数据源
	@ConfigurationProperties(prefix = "spring.datasource")
	DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
    @Primary
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(this.dataSource());
    }

    @Bean(name = "impalaDataSource")
    @ConfigurationProperties(prefix = "bigdata.impala.datasource")
    DataSource tssDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "impalaJdbcTemplate")
    public JdbcTemplate impalaJdbcTemplate() {
        return new JdbcTemplate(this.tssDataSource());
    }
}
