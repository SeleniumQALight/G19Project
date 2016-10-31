package mainPack;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DictWorkersPage;
import pages.EditWorkerPage;
import pages.LoginPage;

public class EditWorker {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    DictWorkersPage dictWorkers = new DictWorkersPage(driver);
    EditWorkerPage editWorkerPage = new EditWorkerPage(driver);

    @Test
    public void editWorker(){
        loginPage.openBrowserLoginPage();
        loginPage.enterUserName("Student");
        loginPage.enterPassWord("909090");
        loginPage.clickButtonVhod();
        dictWorkers.openDictWorkersPage();
        dictWorkers.chooseWorkerForEdit("Петров");
        //editWorkerPage.openEditWorkerPage(2);
        editWorkerPage.enterWorkerSurname("Петров", "new1");
        editWorkerPage.enterWorkerName("Петр","new2");
        editWorkerPage.enterWorkerMiddleName("Петрович","new123");
        editWorkerPage.enterWorkerPhone("+380123456");
        editWorkerPage.editWorkerSaveClick();
        editWorkerPage.closeEditWorkerPage();
    }

    @After
    public void tearDown(){
        editWorkerPage.closeEditWorkerPage();
    }

}
