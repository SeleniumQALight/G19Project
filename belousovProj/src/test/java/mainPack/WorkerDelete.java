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
 * Created by user on 31-Oct-16.
 */

public class WorkerDelete {
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
    ;

    @Test
    public void CreateWorker() {
        loginPage.logOn(loginNameForLoginPage, passwordForLoginPage);
        Assert.assertTrue(mainPage.checkMainPage());
        mainPage.openSlovariOnMainPage();
        mainPage.openSotrudnikiOnMainPage();
        Assert.assertTrue(workersPage.checkWorkersPage());
        Assert.assertTrue(workersPage.checkWorkerIsPresent(workerFullName));
        workersPage.findWorker(workerFullName);
        Assert.assertTrue(editWorkerPage.checkWorkerEditPage());
        editWorkerPage.deleteButton();
        Assert.assertTrue(workersPage.checkWorkersPage());
        Assert.assertFalse(workersPage.checkWorkerIsPresent(workerFullName));

    }

    @After
    public void tearDown() {
        workersPage.clouseWorkerPageAndBrowser();
    }
}
