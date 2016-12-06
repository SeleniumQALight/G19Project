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
public class TestAddApparat {
    WebDriver driver = new FirefoxDriver();
    AllPages allPages = new AllPages(driver);

    String email, pass, liida, liidb, apparatNumber, apparatComment, appNum, appCom;

    public TestAddApparat(String email, String pass, String liida, String liidb, String apparatNumber, String apparatComment, String appNum,String appCom) {
        this.email=email;
        this.pass=pass;
        this.liida=liida;
        this.liidb=liidb;
        this.apparatNumber=apparatNumber;
        this.apparatComment=apparatComment;
        this.appNum=appNum;
        this.appCom=appCom;
    }
    @Parameterized.Parameters
    public static Collection testData() throws IOException{
        InputStream spreadSheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE")+"testData.xls");
        return new SpreadsheetData(spreadSheet,"TestAddApparat").getData();
    }

    @Test
    public  void setup(){
        allPages.entrancePage.logOn(email,pass);
        allPages.mainPage.isMainPageOpened();
        allPages.mainPage.clickOnLeftSideMenuItem(liida);
        allPages.mainPage.clickOnLeftSideMenuItem(liidb);
        allPages.apparatPage.isApparatPagePresent();
        allPages.apparatPage.clickOnPlusButton();
        allPages.apparatEditorPage.isApparatEditorPagePresent();
        allPages.apparatEditorPage.enterApparatNumber(apparatNumber);
        allPages.apparatEditorPage.enterApparatComment(apparatComment);
        allPages.apparatEditorPage.clickOnButtonAdd();
        allPages.apparatPage.isApparatPagePresent();
        allPages.apparatPage.checkRecord(appNum);
        allPages.apparatPage.checkRecord(appCom);
    }

    @After
    public void testDown(){
        allPages.mainPage.closeMainPageAndBrowser();
    }
}
