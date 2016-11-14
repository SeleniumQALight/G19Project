package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;


public class DealCreate {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    WorkersPage workersPage = new WorkersPage(driver);
    DealsPage dealsPage = new DealsPage(driver);
    DealsPageEdit dealsPageEdit = new DealsPageEdit(driver);
    EditWorkerPage editWorkerPage = new EditWorkerPage(driver);
    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";
    String workerSurname = "Тестовый";
    String workerName = "Тест";
    String workerMidleName = "Тестович";
    String workerPhoneNumber = "+380505050505";


    @Test
    public void CreateDeal(){

        loginPage.openBrowserAndLoginPage();
        loginPage.enterUserName(loginNameForLoginPage);
        loginPage.enterUserPassword(passwordForLoginPage);
        loginPage.clickButtonVhod();
        Assert.assertTrue(mainPage.checkMainPage());
        mainPage.openSdelkiOnMainPage();
        Assert.assertTrue(dealsPage.checkDealsPage());
        dealsPage.buttonAdd();

    }
    @After
    public void tearDown() {}
}
