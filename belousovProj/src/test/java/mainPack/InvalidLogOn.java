package mainPack;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

/**
 * Created by SBeast on 10/27/2016.
 */
public class InvalidLogOn {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);


    @Test
    public void setUp(){
        loginPage.openBrowserAndLoginPage();
        loginPage.enterUserName("Student");
        loginPage.enterUserPassword("906090");
        loginPage.clickButtonVhod();
        Assert.assertTrue(loginPage.isFormLoginPresent());

    }
    @After
    public  void tearDown(){
        loginPage.clouseLoginPageAndBrowser();
    }
}
