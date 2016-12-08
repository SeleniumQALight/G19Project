package tests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(

        {
                InvalidLogOnTest.class,
                ValidLogOnWithOutPageObject.class
        }

)
public class SuitLoginPage {

}
