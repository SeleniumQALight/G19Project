package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;

/**
 * Created by kateryna.hryn on 15.11.2016.
 */
public class InvalidLogOn {
    WebDriver driver=new FirefoxDriver();
    LoginPage loginPage=new LoginPage(driver);

    @Test
    public void setUp(){
        loginPage.openBrowserAndLoginPage();
        loginPage.enterUsername("Student");
        loginPage.clickButtonVhod();
        Assert.assertTrue(loginPage.isFormLoginPresent());

    }
    @After
    public void tearDown(){
        loginPage.closeLoginPageAndBrowser();
    }

}
