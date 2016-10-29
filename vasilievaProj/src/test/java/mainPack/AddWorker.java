package mainPack;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddWorkerPage;
import pages.LoginPage;
import pages.DictWorkersPage;

public class AddWorker {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    DictWorkersPage dictWorkers = new DictWorkersPage(driver);
    AddWorkerPage addWorker = new AddWorkerPage(driver);

    @Test
    public void openWorkers(){
        loginPage.openBrowserLoginPage();
        loginPage.enterUserName("Student");
        loginPage.enterPassWord("909090");
        loginPage.clickButtonVhod();
        dictWorkers.openDictWorkersPage();
        dictWorkers.addWorkersButtonClick();
        addWorker.openAddWorkerPage();
        addWorker.enterWorkerSurname("test1");
        addWorker.enterWorkerName("test1");
        addWorker.enterWorkerMiddleName("test1");
        addWorker.enterWorkerPhone("phone");
        addWorker.addWorkerClick();
        dictWorkers.openDictWorkersPage();
        dictWorkers.isWorkerAdded("test1","test1","test1","phone");
        dictWorkers.closeDictWorkersPage();
    }

    @After
    public void tearDown(){
        dictWorkers.closeDictWorkersPage();
    }

}
