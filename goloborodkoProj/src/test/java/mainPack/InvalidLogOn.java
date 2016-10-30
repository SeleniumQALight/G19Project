package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.MainPage;

public class InvalidLogOn {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);

    @Test
    public void setUp() {
        loginPage.openBrowserAndLoginPage();
        loginPage.enterUserName("Student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonVhod();
        loginPage.isFormLoginPresent();
        mainPage.openMainPage();
        mainPage.slideBarOnOff();
        mainPage.slideBarOnOff();
        mainPage.clickSlideButton("Dictionaries", ".//*[@id='dictionary']", ".//*[@id='apparat']");
        mainPage.clickButton("Apparatuses", "//*[@id='apparat']", ".//*[@href='http://v3.test.itpmgroup.com/dictionary/apparat/edit']");

    }

//    @After
//    public void tearDown() {
//        loginPage.closeLoginPageAndBrowser();
//    }
}
