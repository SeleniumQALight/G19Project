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
        loginPage.openBrowserAndLoginPage();
        loginPage.enterUserName("Student1");
        loginPage.enterPassWord("906090");
        loginPage.clickButtonVhod();
        Assert.assertTrue(loginPage.isFormLoginPresent());
    }
    @After
    public  void tearDown(){
        loginPage.closeLoginPageAndBrowser();
    }

}
