package test2;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/4/13.
 */
@Service
@Async
public class AsynTaskService {

    public void excute(int i){
        System.out.println("执行异步任务:" + i);
    }

    public void excute2(int i){
        System.out.println("执行异步任务PLUS:" + i);
    }
}
