package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;


public class DealEdit {
    WebDriver driver = new FirefoxDriver();
    AllPages allPages = new AllPages(driver);
//    LoginPage loginPage = new LoginPage(driver);
//    MainPage mainPage = new MainPage(driver);
//    WorkersPage workersPage = new WorkersPage(driver);
//    DealsPage dealsPage = new DealsPage(driver);
//    DealsEditPage dealsEditPage = new DealsEditPage(driver);
//    EditWorkerPage editWorkerPage = new EditWorkerPage(driver);
    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";
    String workerSurname = "Тестовый";
    String workerName = "Тест";
    String workerMidleName = "Тестович";
    String workerPhoneNumber = "+380505050505";

    @Test
    public void CreateDeal() {
        allPages.loginPage.openBrowserAndLoginPage();
        allPages.loginPage.enterUserName(loginNameForLoginPage);
        allPages.loginPage.enterUserPassword(passwordForLoginPage);
        allPages.loginPage.clickButtonVhod();
        Assert.assertTrue(allPages.mainPage.checkMainPage());
        allPages.mainPage.openSdelkiOnMainPage();
        Assert.assertTrue(allPages.dealsPage.checkDealsPage());
        allPages.dealsPage.buttonAdd();

    }

    @After
    public void tearDown() {
    }
}
