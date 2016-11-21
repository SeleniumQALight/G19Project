package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by dariia on 10/30/16.
 */
public class WorkerCreate {
    WebDriver driver = new FirefoxDriver();
    AllPages allPages = new AllPages(driver);
//    LoginPage loginPage = new LoginPage(driver);
//    MainPage mainPage = new MainPage(driver);
//    WorkersPage workersPage = new WorkersPage(driver);
//    EditWorkerPage editWorkerPage = new EditWorkerPage(driver);
    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";
    String workerSurname = "Тестовый";
    String workerName = "Тест";
    String workerMidleName = "Тестович";
    String workerFullName = workerSurname + " " + workerName + " " + workerMidleName;
    String workerPhoneNumber = "+380505050505";

    @Test
    public void CreateWorker() {

        allPages.loginPage.logOn(loginNameForLoginPage, passwordForLoginPage);
        Assert.assertTrue(allPages.mainPage.checkMainPage());
        allPages.mainPage.openSlovariOnMainPage();
        allPages.mainPage.openSotrudnikiOnMainPage();
        allPages.workersPage.buttonAdd();
        Assert.assertTrue(allPages.editWorkerPage.checkWorkerEditPage());
        allPages.editWorkerPage.enterWorkerSurname(workerSurname);
        allPages.editWorkerPage.enterWorkerName(workerName);
        allPages.editWorkerPage.enterWorkerMidleName(workerMidleName);
        allPages.editWorkerPage.enterWorkerPhoneNumber(workerPhoneNumber);
        allPages.editWorkerPage.createButton();
        Assert.assertTrue(allPages.workersPage.checkWorkersPage());
        Assert.assertTrue(allPages.workersPage.checkWorkerIsPresent(workerFullName));


    }

    @After
    public void tearDown() {
        allPages.workersPage.clouseWorkerPageAndBrowser();
    }
}
