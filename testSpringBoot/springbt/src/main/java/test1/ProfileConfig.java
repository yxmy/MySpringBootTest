package test1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by admin on 2018/4/12.
 */
@Configuration
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public DemoBean devDemoBean(){
        return new DemoBean("DEV");
    }

    @Bean
    @Profile("prod")
    public DemoBean prodDemoBean(){
        return new DemoBean("PROD");
    }
}
