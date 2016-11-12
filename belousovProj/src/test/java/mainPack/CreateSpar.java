package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

/**
 * Created by dariia on 10/30/16.
 */
public class CreateSpar {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    WorkersPage workersPage = new WorkersPage(driver);
    EditSparePage editSparePage = new EditSparePage(driver);
    //EditWorkerPage editWorkerPage = new EditWorkerPage(driver);
    SparesPage sparesPage = new SparesPage(driver);
    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";
    String workerSurname = "Тестовый";
    String workerName = "Тест";
    String workerMidleName = "Тестович";
    String workerPhoneNumber = "+380505050505";
    String spareName = "Рулетка";

    @Test
    public void CreateWorker(){


        loginPage.logOn(loginNameForLoginPage,passwordForLoginPage);
        Assert.assertTrue(mainPage.checkMainPage());
        mainPage.openSlovariOnMainPage();
        mainPage.openSpareOnMainPge();
        Assert.assertTrue(sparesPage.checkSparesPage());
        sparesPage.buttonAdd();
        editSparePage.enterSpareName(spareName);








    }
    @After
    public void tearDown() {sparesPage.clouseSparePageAndBrowser();}
}
