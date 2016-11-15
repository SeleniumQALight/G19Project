package mainPack;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;

public class ValidLogOn {
    WebDriver driver = new ChromeDriver();
    Logger logger = Logger.getLogger(getClass());
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);

    @Test
    public void setUp() {
        loginPage.logOn("Student", "909090");
        mainPage.checkAvatar();
    }

    @After
    public void tearDown() {
        loginPage.closeLoginPageAndBrowser();
    }

}
