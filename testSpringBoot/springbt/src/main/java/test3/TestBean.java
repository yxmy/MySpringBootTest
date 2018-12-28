package test3;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by admin on 2018/4/13.
 */
@Getter
@Setter
public class TestBean {

    private String context;

    public TestBean(String context) {
        this.context = context;
    }
}
