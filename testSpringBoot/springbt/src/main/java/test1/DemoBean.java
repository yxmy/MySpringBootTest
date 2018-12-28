package test1;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by admin on 2018/4/12.
 */
@Getter
@Setter
public class DemoBean {

    private String context;

    public DemoBean(String context){
        this.context = context;
    }

}
