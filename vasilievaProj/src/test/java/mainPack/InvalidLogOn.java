package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class InvalidLogOn {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void setUp(){
        loginPage.openBrowserLoginPage();
        loginPage.enterUserName("Student");
        loginPage.enterPassWord("906090");
        loginPage.clickButtonVhod();
        Assert.assertTrue(loginPage.isFormLoginPresent());
    }

    @After
    public void tearDown(){
        loginPage.closeLoginPageAndBrowser();
    }
}
