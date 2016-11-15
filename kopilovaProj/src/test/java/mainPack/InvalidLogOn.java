package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;

public class InvalidLogOn {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void setUp(){
        loginPage.LogOn("Student","906090");
        Assert.assertTrue(loginPage.isFormLoginPresent());
    }
    @After
    public  void tearDown(){
        loginPage.closeLoginPegeAndBrowser();
    }
}
