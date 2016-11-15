package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.EditSparePage;
import pages.LoginPage;
import pages.MainPage;
import pages.SparesPage;


public class SparDelete {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    EditSparePage editSparePage = new EditSparePage(driver);;
    SparesPage sparesPage = new SparesPage(driver);
    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";
    String spareName = "Рулетка 2";


    @Test
    public void CreateWorker(){

        loginPage.logOn(loginNameForLoginPage,passwordForLoginPage);
        Assert.assertTrue(mainPage.checkMainPage());
        mainPage.openSlovariOnMainPage();
        mainPage.openSpareOnMainPge();
        Assert.assertTrue(sparesPage.checkSparesPage());
        Assert.assertTrue(sparesPage.checkTestSpare(spareName));
        sparesPage.clickTestSpare(spareName);
        Assert.assertTrue(editSparePage.checkEditSparePage());
        editSparePage.deleteButton();
        Assert.assertTrue(sparesPage.checkSparesPage());
        Assert.assertFalse(sparesPage.checkTestSpare(spareName));
    }
    @After
    public void tearDown() {sparesPage.clouseSparePageAndBrowser();}
}
