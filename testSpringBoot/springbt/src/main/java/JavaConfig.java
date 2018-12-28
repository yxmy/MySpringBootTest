import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.FunctionService;
import service.UseFunctionService;

/**
 * Created by admin on 2018/4/12.
 */
@Configuration
public class JavaConfig {

    @Bean
    public FunctionService functionService(){
        return  new FunctionService();
    }

//    @Bean
//    public UseFunctionService useFunctionService(){
//        UseFunctionService useFunctionService = new UseFunctionService();
//        useFunctionService.setFunctionService(functionService());
//        return useFunctionService;
//    }

    @Bean
    public UseFunctionService useFunctionService(FunctionService functionService){
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService);
        return useFunctionService;
    }

}
