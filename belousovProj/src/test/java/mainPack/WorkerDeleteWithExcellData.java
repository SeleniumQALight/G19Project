package mainPack;

import libs.ConfigData;
import libs.SpreadsheetData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(value = Parameterized.class)

public class WorkerDeleteWithExcellData {
    WebDriver driver = new ChromeDriver();
    AllPages allPages = new AllPages(driver);

    String workerSurname, workerName, workerMidleName, workerPhoneNumber;
    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";

    public WorkerDeleteWithExcellData(String workerSurname, String workerName, String workerMidleName, String workerPhoneNumber) {
        this.workerName = workerName;
        this.workerSurname = workerSurname;
        this.workerMidleName = workerMidleName;
        this.workerPhoneNumber = workerPhoneNumber;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testData.xls");
        return new SpreadsheetData(spreadsheet, "WorkerCreate").getData();
    }

    @Test
    public void DeleteWorker() {
        String workerFullName = workerSurname + " " + workerName + " " + workerMidleName;
        allPages.loginPage.logOn(loginNameForLoginPage, passwordForLoginPage);
        Assert.assertTrue(allPages.mainPage.checkMainPage());
        allPages.mainPage.openSlovariOnMainPage();
        allPages.mainPage.openSotrudnikiOnMainPage();
        Assert.assertTrue(allPages.workersPage.checkWorkersPage());
        Assert.assertTrue(allPages.workersPage.checkWorkerIsPresent(workerFullName));
        allPages.workersPage.findWorker(workerFullName);
        Assert.assertTrue(allPages.editWorkerPage.checkWorkerEditPage());
        allPages.editWorkerPage.deleteButton();
        Assert.assertTrue(allPages.workersPage.checkWorkersPage());
        Assert.assertFalse(allPages.workersPage.checkWorkerIsPresent(workerFullName));

    }

    @After
    public void tearDown() {
        allPages.workersPage.clouseWorkerPageAndBrowser();
    }
}
