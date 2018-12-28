package test3;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2018/4/13.
 */
@Service
public class ScheduledService {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void sche(){
        System.out.println("每隔五秒钟执行一次：" + sdf.format(new Date()));
    }

    @Scheduled(cron = "0 28 11 ? * *")
    public void sche2(){
        System.out.println("固定时间执行：" + sdf.format(new Date()));
    }
}
