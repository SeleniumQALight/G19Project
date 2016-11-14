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
        loginPage.logOn("Student", "906090");
        loginPage.isFormLoginPresent();
    }

    @After
    public void tearDown() {
        loginPage.closeLoginPageAndBrowser();
    }
}
