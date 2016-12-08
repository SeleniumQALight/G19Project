package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.LoginPage;

/**
 * Created by Катюша on 27.10.2016.
 */
public class AddSpare {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Test
    public void setUp() {
        loginPage.logOn("Student", "909090");
        homePage.checkAvatar();
        homePage.clickMenuDictionary();
        homePage.clickSubMenuSpares();
    }

    @After
    public void tearDown() {

        loginPage.closeLoginPageAndBrowser();
    }
}
