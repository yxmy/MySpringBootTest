package cn.gov.sapprft.mtms;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import com.leadingsoft.bizfuse.common.web.annotation.EnableBizfuseWebMVC;
import com.leadingsoft.bizfuse.quartz.core.annotition.EnableBizfuseQuartzScheduling;

@EnableBizfuseWebMVC
@EnableBizfuseQuartzScheduling
@RestController
@EnableFeignClients
public class FtqrsDemoApplication {

    private static final Logger log = LoggerFactory.getLogger(FtqrsDemoApplication.class);

    @Autowired
    ApplicationContext context;

    public static void main(final String[] args) throws UnknownHostException {
        final HashMap<String, Object> props = new HashMap<>();
        props.put("spring.config.name", "ftqrs");

        final ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .properties(props)
                .sources(FtqrsDemoApplication.class)
                .run(args);

        final Environment env = context.getEnvironment();

        FtqrsDemoApplication.log.info("\n----------------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local: \t\thttp://127.0.0.1:{}\n\t" +
                "External: \thttp://{}:{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));

    }
}
