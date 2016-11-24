package mainProj;


import libs.ConfigData;
import libs.SpreadsheetData;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TestAddWorker {
    WebDriver driver =new FirefoxDriver();
    AllPages allPages = new AllPages(driver);

    String email, pass, liida, liidc, workerSurname, workerName, workerMiddleName, workerPhoneNumber, workerFio, workerPhN;

    public TestAddWorker(String email, String pass, String liida, String liidc, String workerSurname, String workerName, String workerMiddleName, String workerPhoneNumber, String workerFio, String workerPhN){
        this.email=email;
        this.pass=pass;
        this.liida=liida;
        this.liidc=liidc;
        this.workerSurname=workerSurname;
        this.workerName=workerName;
        this.workerMiddleName=workerMiddleName;
        this.workerPhoneNumber=workerPhoneNumber;
        this.workerFio=workerFio;
        this.workerPhN=workerPhN;
    }
    @Parameterized.Parameters
    public static Collection testData() throws IOException{
        InputStream spreadSheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE")+"testData.xls");
        return  new SpreadsheetData(spreadSheet,"TestAddWorker").getData();
    }

    @Test
    public  void setup(){
        allPages.entrancePage.openBrowserAndEntrancePage();
        allPages.entrancePage.logOn(email,pass);
        allPages.mainPage.isMainPageOpened();
        allPages.mainPage.clickOnLeftSideMenuItem(liida);
        allPages.mainPage.clickOnLeftSideMenuItem(liidc);
        allPages.workerPage.isWorkerPagePresent();
        allPages.workerPage.clickOnPlusButton();
        allPages.workerEditorPage.isWorkerEditorPagePresent();
        allPages.workerEditorPage.enterWorkerSurname(workerSurname);
        allPages.workerEditorPage.enterWorkerName(workerName);
        allPages.workerEditorPage.enterWorkerMiddleName(workerMiddleName);
        allPages.workerEditorPage.enterWorkerPhoneNumber(workerPhoneNumber);
        allPages.workerEditorPage.clickOnButtonAdd();
        allPages.workerPage.isWorkerPagePresent();
        allPages.workerPage.checkRecord(workerFio);
        allPages.workerPage.checkRecord(workerPhN);
    }

    @After
    public void testDown(){
        allPages.mainPage.closeMainPageAndBrowser();
    }
}
