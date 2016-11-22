package mainProj;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.EntrancePage;
import pages.MainPage;
import pages.ServiceEditorPage;
import pages.ServicePage;

import java.util.List;
import java.util.Set;


public class TestAddServiceJob {
    WebDriver driver = new FirefoxDriver();
    EntrancePage entrancePage = new EntrancePage(driver);
    MainPage mainPage = new MainPage(driver);
    ServicePage servicePage = new ServicePage(driver);
    ServiceEditorPage serviceEditorPage = new ServiceEditorPage(driver);


    @Test
    public void setup(){
        entrancePage.logOn("Student", "909090");
        mainPage.isMainPageOpened();
        mainPage.clickOnLeftSideMenuItem("service_apparat");
        servicePage.isServicePageOpened();
        servicePage.clickOnPlusButton();
        serviceEditorPage.isServiceEditorPageOpened();
        serviceEditorPage.enterServiceChanges("Maintenance");
        serviceEditorPage.enterServiceOperations("Set#2");
        serviceEditorPage.selectServiceDateDayInDd("31");
        serviceEditorPage.selectServiceDateMonthInDd("10");
        serviceEditorPage.selectServiceDateYearInDd("2016");
        serviceEditorPage.selectServiceDateHourInDd("12");
        serviceEditorPage.selectServiceDateMinuteInDd("35");
        serviceEditorPage.selectApparatInDd("Apparat description");
        serviceEditorPage.selectWorkerInDd("Petrenko Petro Petrovych");
        serviceEditorPage.clickOnButtonAdd();
        servicePage.isServicePageOpened();
        servicePage.checkRecord("Maintenance");
    }

    @After
    public void testDown(){
        entrancePage.closeEntrancePageAndBrowser();
    }
}
