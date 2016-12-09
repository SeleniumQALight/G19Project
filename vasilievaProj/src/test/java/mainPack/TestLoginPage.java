package mainPack;

import  org.junit.runner.RunWith;
import org.junit.runners.Suite;
//запуск нескольких тестов в тестсьюте, если нужно ранить по порядку несколько тестов
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                InvalidLogOnTest.class,
                ValidLogOnWithOutPageObject_Test.class
        }
)

public class TestLoginPage {
}
