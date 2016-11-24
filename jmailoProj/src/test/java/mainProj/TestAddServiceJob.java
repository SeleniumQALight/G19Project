package mainProj;

import libs.ConfigData;
import libs.SpreadsheetData;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@RunWith(value = Parameterized.class)
public class TestAddServiceJob {
    WebDriver driver = new FirefoxDriver();
    AllPages allPages = new AllPages(driver);

    String email, pass, liide, serviceChanges, serviceOperations, day, month, year, hour, minute, apparat, worker, service;

    public  TestAddServiceJob(String email, String pass, String liide, String serviceChanges, String serviceOperations, String day, String month, String year, String hour, String minute, String apparat, String worker, String service){
        this.email=email;
        this.pass=pass;
        this.liide=liide;
        this.serviceChanges=serviceChanges;
        this.serviceOperations=serviceOperations;
        this.day=day;
        this.month=month;
        this.year=year;
        this.hour=hour;
        this.minute=minute;
        this.apparat=apparat;
        this.worker=worker;
        this.service=service;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException{
        InputStream spreadSheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE")+"testData.xls");
        return new SpreadsheetData(spreadSheet,"TestAddServiceJob").getData();
    }

    @Test
    public void setup(){
        allPages.entrancePage.logOn(email, pass);
        allPages.mainPage.isMainPageOpened();
        allPages.mainPage.clickOnLeftSideMenuItem(liide);
        allPages.servicePage.isServicePageOpened();
        allPages.servicePage.clickOnPlusButton();
        allPages.serviceEditorPage.isServiceEditorPageOpened();
        allPages.serviceEditorPage.enterServiceChanges(serviceChanges);
        allPages.serviceEditorPage.enterServiceOperations(serviceOperations);
        allPages.serviceEditorPage.selectServiceDateDayInDd(day);
        allPages.serviceEditorPage.selectServiceDateMonthInDd(month);
        allPages.serviceEditorPage.selectServiceDateYearInDd(year);
        allPages.serviceEditorPage.selectServiceDateHourInDd(hour);
        allPages.serviceEditorPage.selectServiceDateMinuteInDd(minute);
        allPages.serviceEditorPage.selectApparatInDd(apparat);
        allPages.serviceEditorPage.selectWorkerInDd(worker);
        allPages.serviceEditorPage.clickOnButtonAdd();
        allPages.servicePage.isServicePageOpened();
        allPages.servicePage.checkRecord(service);
    }

    @After
    public void testDown(){
        allPages.entrancePage.closeEntrancePageAndBrowser();
    }
}
