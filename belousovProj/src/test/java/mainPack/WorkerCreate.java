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

import java.util.concurrent.TimeUnit;

/**
 * Created by dariia on 10/30/16.
 */
public class WorkerCreate {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    WorkersPage workersPage = new WorkersPage(driver);
    EditWorkerPage editWorkerPage = new EditWorkerPage(driver);
    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";
    String workerSurname = "Тестовый";
    String workerName = "Тест";
    String workerMidleName = "Тестович";
    String workerFullName = workerSurname + " " + workerName + " " + workerMidleName;
    String workerPhoneNumber = "+380505050505";

    @Test
    public void CreateWorker() {

        loginPage.logOn(loginNameForLoginPage, passwordForLoginPage);
        Assert.assertTrue(mainPage.checkMainPage());
        mainPage.openSlovariOnMainPage();
        mainPage.openSotrudnikiOnMainPage();
        workersPage.buttonAdd();
        Assert.assertTrue(editWorkerPage.checkWorkerEditPage());
        editWorkerPage.enterWorkerSurname(workerSurname);
        editWorkerPage.enterWorkerName(workerName);
        editWorkerPage.enterWorkerMidleName(workerMidleName);
        editWorkerPage.enterWorkerPhoneNumber(workerPhoneNumber);
        editWorkerPage.createButton();
        Assert.assertTrue(workersPage.checkWorkersPage());
        Assert.assertTrue(workersPage.checkWorkerIsPresent(workerFullName));


    }

    @After
    public void tearDown() {
        workersPage.clouseWorkerPageAndBrowser();
    }
}
