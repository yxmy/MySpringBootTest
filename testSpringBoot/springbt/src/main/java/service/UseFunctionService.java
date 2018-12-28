package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/4/12.
 */
public class UseFunctionService {

    private FunctionService functionService;

    public void setFunctionService(FunctionService functionService){
        this.functionService = functionService;
    }

    public String callFunction(){
        return functionService.hello();
    }
}
