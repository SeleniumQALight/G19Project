package mainPack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                InvalidLogOn.class,
                ValidLogOn.class,
                AddSpares.class,
                ValidLogOnWithOutPageObject.class,
                Registration.class,
                InvalidLogOnWithDataFromExcel.class,
                InvalidLogOnWithOutPageObject.class,
                Test1.class,
                WorkWithDB.class

        }
)

public class SuitLoginPage {


}
