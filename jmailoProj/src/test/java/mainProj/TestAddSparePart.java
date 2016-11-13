package mainProj;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.EntrancePage;
import pages.MainPage;
import pages.SparesEditorPage;
import pages.SparesPage;

public class TestAddSparePart {
    WebDriver driver = new FirefoxDriver();
    EntrancePage entrancePage = new EntrancePage(driver);
    MainPage mainPage = new MainPage(driver);
    SparesPage sparesPage = new SparesPage(driver);
    SparesEditorPage sparesEditorPage = new SparesEditorPage(driver);

    @Test
    public void setUp(){
        entrancePage.logOn("Student", "909090");
        mainPage.isMainPageOpened();
        mainPage.clickOnLeftSideMenuItem("dictionary");
        mainPage.clickOnLeftSideMenuItem("spares");
        sparesPage.isSparesPageOpened();
        sparesPage.clickOnPlusButton();
        sparesEditorPage.enterSparePartName("Turbocharger");
        //sparesEditorPage.clickOnDd();
        sparesEditorPage.selectValueOnDdTypeOfSparesByValue("1");
        //sparesEditorPage.selectValueOnDdTypeOfSpares("Механика");
        sparesEditorPage.clickONButtonAdd();
        sparesPage.isSparesPageOpened();
        sparesPage.checkRecord("Turbocharger");
    }

    @After
    public  void testDown(){
        entrancePage.closeEntrancePageAndBrowser();
    }
}
