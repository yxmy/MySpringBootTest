package test3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by admin on 2018/4/13.
 */
@Configuration
@ComponentScan("test3")
@EnableScheduling
public class ScheduleConfig {
}
