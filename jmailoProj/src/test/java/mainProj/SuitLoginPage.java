package mainProj;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                InvalidLogon.class,
                ValidLogOnWithoutPageObject.class

        }
)
public class SuitLoginPage {


}
