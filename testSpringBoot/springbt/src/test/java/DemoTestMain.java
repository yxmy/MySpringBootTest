import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test3.TestBean;
import test3.TestConfig;

/**
 * Created by admin on 2018/4/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("dev")
public class DemoTestMain {

    @Autowired
    private TestBean testBean;

    @Test
    public void main(){
        String expected = "PROD";
        String actual = testBean.getContext();
        Assert.assertEquals(expected, actual);
    }
}
