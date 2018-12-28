import filetest.FileConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UseFunctionService;
import test1.DemoBean;
import test1.ProfileConfig;
import test2.AsynTaskService;
import test2.TaskConfig;
import test3.ScheduleConfig;

/**
 * Created by admin on 2018/4/12.
 */
public class Main {
    public static void main(String args []){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduleConfig.class);
//        AsynTaskService service = context.getBean(AsynTaskService.class);
//        for(int i = 0;i < 10; i++){
//            service.excute(i);
//            service.excute2(i);
//        }
//        context.close();
    }
}
