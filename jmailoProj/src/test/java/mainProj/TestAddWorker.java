package mainProj;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.EntrancePage;
import pages.MainPage;
import pages.WorkerEditorPage;
import pages.WorkerPage;

public class TestAddWorker {
    WebDriver driver =new FirefoxDriver();
    EntrancePage entrancePage = new EntrancePage(driver);
    MainPage mainPage = new MainPage(driver);
    WorkerPage workerPage = new WorkerPage(driver);
    WorkerEditorPage workerEditorPage = new WorkerEditorPage(driver);

    @Test
    public  void setup(){
        entrancePage.openBrowserAndEntrancePage();
        entrancePage.enterEmail("Student");
        entrancePage.enterPassword("909090");
        entrancePage.clickOnButton();
        mainPage.isMainPageOpened();
        mainPage.clickOnLeftSideMenuItem("dictionary");
        mainPage.clickOnLeftSideMenuItem("workers");
        workerPage.isWorkerPagePresent();
        workerPage.clickOnPlusButton();
        workerEditorPage.isWorkerEditorPagePresent();
        workerEditorPage.enterWorkerSurname("Petrenko");
        workerEditorPage.enterWorkerName("Petro");
        workerEditorPage.enterWorkerMiddleName("Petrovych");
        workerEditorPage.enterWorkerPhoneNumber("+380501000001");
        workerEditorPage.clickOnButtonAdd();
        workerPage.isWorkerPagePresent();
        workerPage.checkRecord("Petrenko");
        //workerPage.checkRecord("+380501000001");
    }

    @After
    public void testDown(){
        mainPage.closeMainPageAndBrowser();
    }
}
