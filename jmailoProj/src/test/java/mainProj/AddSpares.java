package mainProj;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.MainPage;

public class AddSpares {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);

    @Test
    public void setUp(){
        loginPage.logOn("Student","909090");
        mainPage.isMainPageOpened();
        mainPage.clickOnLeftSideMenuItem("dictionary");
        mainPage.clickOnLeftSideMenuItem("spares");



    }
    @After
    public void testDown(){
        loginPage.closeLoginPageAndBrowser();
    }
}
