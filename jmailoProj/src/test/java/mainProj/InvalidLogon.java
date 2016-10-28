package mainProj;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;

public class InvalidLogon {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void setUp(){
        loginPage.openBrowserAndLoginPage();
        loginPage.enterUserName("Student");
        loginPage.enterPassword("906090");
        loginPage.clickButtonVhod();
        loginPage.isFormLoginPresent();

    }
    @After
    public void tearDown(){
        loginPage.closeLoginPageAndBrowser();
    }
}
