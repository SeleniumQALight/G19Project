package mainPack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                InvalidLogOn.class,
                ValidLogOnWithOutPageObject.class
        }
)
public class SuitLoginPage {
}
