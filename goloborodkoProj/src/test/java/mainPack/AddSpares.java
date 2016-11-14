package mainPack;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.ApparatusAddPage;
import pages.ApparatusPage;
import pages.LoginPage;
import pages.MainPage;

public class AddSpares {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    ApparatusPage apparatusPage = new ApparatusPage(driver);
    ApparatusAddPage apparatusAddPage = new ApparatusAddPage(driver);

    @Test
    public void setUp() {
        loginPage.logOn("Student", "909090");
        mainPage.checkAvatar();
        mainPage.clickSlideButton("Dictionaries", ".//*[@id='dictionary']", ".//*[@id='service_apparat']");
        mainPage.clickButton("Spares", ".//*[@href='/dictionary/spares']", ".//*[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']");


    }

//    @After
//    public void tearDown() {
//        loginPage.closeLoginPageAndBrowser();
//    }
}
