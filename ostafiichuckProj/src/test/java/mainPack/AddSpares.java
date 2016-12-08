package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.DictionarySparesEdit;
import pages.HomePage;
import pages.LoginPage;


public class AddSpares {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);



    @Test
    public void setUp() {
        loginPage.LogOn("Student", "909090");
        homePage.checkAvatar();
        homePage.clickMenyDictionary();
        homePage.clickSubMenuSpares();

    }

    @After
    public void tearDown() {
        loginPage.closeLoginPageAndBrowser();

    }
}