package mainProj;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.ApparatEditorPage;
import pages.ApparatPage;
import pages.EntrancePage;
import pages.MainPage;

public class TestAddApparat {
    WebDriver driver = new FirefoxDriver();
    EntrancePage entrancePage = new EntrancePage(driver);
    MainPage mainPage = new MainPage(driver);
    ApparatPage apparatPage = new ApparatPage(driver);
    ApparatEditorPage apparatEditorPage = new ApparatEditorPage(driver);

    @Test
    public  void setup(){
        entrancePage.openBrowserAndEntrancePage();
        entrancePage.enterEmail("Student");
        entrancePage.enterPassword("909090");
        entrancePage.clickOnButton();
        mainPage.isMainPageOpened();
        mainPage.clickOnLeftSideMenuItem("dictionary");
        mainPage.clickOnLeftSideMenuItem("apparat");
        apparatPage.isApparatPagePresent();
        apparatPage.clickOnPlusButton();
        apparatEditorPage.isApparatEditorPagePresent();
        apparatEditorPage.enterApparatNumber("999");
        apparatEditorPage.enterApparatComment("Apparat description");
        apparatEditorPage.clickOnButtonAdd();
        apparatPage.isApparatPagePresent();
        apparatPage.checkRecord("999");
        apparatPage.checkRecord("Apparat description");
    }

    @After
    public void testDown(){
        mainPage.closeMainPageAndBrowser();
    }
}
