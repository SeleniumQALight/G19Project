package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.EditWorkerPage;
import pages.LoginPage;
import pages.MainPage;
import pages.WorkersPage;

/**
 * Created by dariia on 10/30/16.
 */
public class CreateWorker {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    WorkersPage workersPage = new WorkersPage(driver);
    EditWorkerPage editWorkerPage = new EditWorkerPage(driver);
    String workerSurname = "Тестовый";
    String workerName = "Тест";
    String workerMidleName = "Тестович";
    String workerPhoneNumber = "+380505050505";

    @Test
    public void setUp(){

        loginPage.openBrowserAndLoginPage();
        loginPage.enterUserName("Student");
        loginPage.enterUserPassword("909090");
        loginPage.clickButtonVhod();
        Assert.assertFalse(mainPage.checkMainPage());
        mainPage.openSlovariOnMainPage();
        mainPage.openSotrudnikiOnMainPage();
        Assert.assertTrue(workersPage.checkWorkersPage());
        workersPage.checkWorkersPage();
        workersPage.buttonAdd();
        Assert.assertTrue(editWorkerPage.checkWorkerEditPage());
        editWorkerPage.checkWorkerEditPage();
        editWorkerPage.enterWorkerSurname(workerSurname);
        editWorkerPage.enterWorkerName(workerName);
        editWorkerPage.enterWorkerMidleName(workerMidleName);
        editWorkerPage.enterWorkerPhoneNumber(workerPhoneNumber);
        editWorkerPage.createButton();
        Assert.assertTrue(workersPage.checkWorkersPage());
        Assert.assertTrue(workersPage.checkWorkerIsPresent());

    }
    //@After
    //public void tearDown() {workersPage.clouseWorkerPageAndBrowser();}
}
