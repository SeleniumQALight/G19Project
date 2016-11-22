package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;


public class SparDelete {
    WebDriver driver = new FirefoxDriver();
    AllPages allPages = new AllPages(driver);

//    LoginPage loginPage = new LoginPage(driver);
//    MainPage mainPage = new MainPage(driver);
//    EditSparePage editSparePage = new EditSparePage(driver);
//    ;
//    SparesPage sparesPage = new SparesPage(driver);
    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";
    String spareName = "Рулетка 2";


    @Test
    public void CreateWorker() {

        allPages.loginPage.logOn(loginNameForLoginPage, passwordForLoginPage);
        Assert.assertTrue(allPages.mainPage.checkMainPage());
        allPages.mainPage.openSlovariOnMainPage();
        allPages.mainPage.openSpareOnMainPge();
        Assert.assertTrue(allPages.sparesPage.checkSparesPage());
        Assert.assertTrue(allPages.sparesPage.checkTestSpare(spareName));
        allPages.sparesPage.clickTestSpare(spareName);
        Assert.assertTrue(allPages.editSparePage.checkEditSparePage());
        allPages.editSparePage.deleteButton();
        Assert.assertTrue(allPages.sparesPage.checkSparesPage());
        Assert.assertFalse(allPages.sparesPage.checkTestSpare(spareName));
    }

    @After
    public void tearDown() {
        allPages.sparesPage.clouseSparePageAndBrowser();
    }
}
