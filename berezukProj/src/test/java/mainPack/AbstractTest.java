package mainPack;

import mainPack.data.LoginPageTestConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alina on 21.11.2016.
 */
public abstract class AbstractTest {

    protected WebDriver driver;
    protected LoginPage loginPage = null;

    // doLogin parameter indicates that we have to perform automatic login before run these tests
    public AbstractTest (boolean doLogin) {
        System.setProperty("webdriver.gecko.driver","C:/browserDrivers/geckodriver.exe");
        driver= new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver, false);

        driver.get(LoginPageTestConstants.LOGIN_PAGE_URL);

        if (!loginPage.isThere())
            throw new RuntimeException("Login page is not shown");

        if (doLogin)
            login();
    }

    protected void login () {
        loginPage.setLoginName(LoginPageTestConstants.LOGIN_NAME_CORRECT);
        loginPage.setPassword(LoginPageTestConstants.PASSWORD_CORRECT);
        loginPage.clickLoginButton();
    }
}
