package test3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by admin on 2018/4/13.
 */
@Configuration
public class TestConfig {

    @Bean
    @Profile("prod")
    public TestBean prod(){
        return new TestBean("PROD");
    }

    @Bean
    @Profile("dev")
    public  TestBean dev(){
        return new TestBean("DEV");
    }
}
