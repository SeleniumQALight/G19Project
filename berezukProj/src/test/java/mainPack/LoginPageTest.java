package mainPack;

import mainPack.data.LoginPageTestConstants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import page.LoginPage;

/**
 * Created by Alina on 27.10.2016.
 */
public class LoginPageTest extends AbstractTest {

    final static Logger logger = LogManager.getLogger(LoginPageTest.class);

    public LoginPageTest() {
        super(false);
        Configurator.setRootLevel(Level.DEBUG);
        //System.setProperty("webdriver.chrome.driver","C:/browserDrivers/chromedriver.exe");
    }

   @Test
    public void runInvalidLogOnWithWrongPassword() {

        loginPage.setLoginName(LoginPageTestConstants.LOGIN_NAME_CORRECT);
        loginPage.setPassword(LoginPageTestConstants.PASSWORD_WRONG);
        loginPage.clickLoginButton();

        Assert.assertTrue("Login failed", loginPage.isThere());

    }
    @Test
    public void runInvalidLogOnWithWrongName() {

        loginPage.setLoginName(LoginPageTestConstants.LOGIN_NAME_WRONG);
        loginPage.setPassword(LoginPageTestConstants.PASSWORD_CORRECT);
        loginPage.clickLoginButton();
        Assert.assertTrue("Login failed", loginPage.isThere());
    }

    @Test
    public void runValidLogon()  {
        loginPage.setLoginName(LoginPageTestConstants.LOGIN_NAME_CORRECT);
        loginPage.setPassword(LoginPageTestConstants.PASSWORD_CORRECT);
        loginPage.clickLoginButton();
        Assert.assertFalse("Login successful", loginPage.isThere());
    }

    @After
    public void tearDown(){
       driver.quit();
    }
}




