package filetest;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/4/12.
 */
@Service
@Getter
@Setter
public class DemoService {

    @Value("其他类的属性")
    private String another;

}
