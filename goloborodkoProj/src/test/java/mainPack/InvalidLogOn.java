package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.ApparatusAddPage;
import pages.ApparatusPage;
import pages.LoginPage;
import pages.MainPage;

public class InvalidLogOn {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    ApparatusPage apparatusPage = new ApparatusPage(driver);
    ApparatusAddPage apparatusAddPage = new ApparatusAddPage(driver);

    @Test
    public void setUp() {
        loginPage.openBrowserAndLoginPage();
        loginPage.enterUserName("Student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonEnter();
        loginPage.isFormLoginPresent();
        mainPage.openMainPage();
        mainPage.clickSlideButton("Dictionaries", ".//*[@id='dictionary']", ".//*[@id='service_apparat']");
        mainPage.clickButton("Apparatuses", "//*[@id='apparat']", ".//*[@href='http://v3.test.itpmgroup.com/dictionary/apparat/edit']");
        apparatusPage.initApparatusPage();
        apparatusPage.clickBtnAdd();
        //apparatusAddPage.initApparatusAddPage();
        apparatusAddPage.setInputData("Apparat number", ".//*[@id='apparat_apparatNumber']", "8328");
        //apparatusAddPage.setInputData("Apparat comment", ".//*[@id='apparat_apparatComment']", "XPEHb");
        apparatusAddPage.clickBtnAdd();

    }

//    @After
//    public void tearDown() {
//        loginPage.closeLoginPageAndBrowser();
//    }
}
