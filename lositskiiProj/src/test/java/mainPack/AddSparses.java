package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.LoginPage;

public class AddSparses {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Test
    public void setUp() {
        loginPage.logOn("Student", "909090");
        homePage.checkAvatar();
        homePage.clickMenuDictionary();
        homePage.clickSubMenu();
    }

    @After
    public void tearDown() {
        loginPage.closeLoginPageAndBrowserBrowser();
    }
}
