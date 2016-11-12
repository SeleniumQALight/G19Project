package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        homePage.clickMenuDictionary();
        homePage.clickSubMenuSpares();
    }

    @After
    public void tearDown() {
        loginPage.closeLoginPageAndBrowser();

    }
}
