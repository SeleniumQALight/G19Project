package mainPack;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.LoginPage;

public class AddSpares {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Test
    public void setUp() {
        loginPage.logOn("Student", "909090");
        homePage.checkAvatar();
        homePage.clickDictionaryMenu();
        homePage.clickSubMenuSpares();
    }
    @After
    public  void tearDown(){
        loginPage.closeLoginPageAndBrowser();
    }

}
