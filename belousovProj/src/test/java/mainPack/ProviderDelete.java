package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;


public class ProviderDelete {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    ProviderPage providerPage = new ProviderPage(driver);
    ProviderEditPage providerEditPage = new ProviderEditPage(driver);

    /**
     * value for login
     */
    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";




    @Test
    public void CreateDeal(){
    loginPage.logOn(loginNameForLoginPage, passwordForLoginPage);
        Assert.assertTrue(mainPage.checkMainPage());
        mainPage.openSdelkiOnMainPage();
        Assert.assertTrue(providerPage.checProviderPage());
//
//        Assert.assertTrue(dealsPage.checkDealIsPresent(dealFulldate));
//        dealsPage.clickDeal(dealFulldate);
//        Assert.assertTrue(dealsEditPage.checkDealsEditPage());
//        dealsEditPage.deleteButton();
//        Assert.assertTrue(dealsPage.checkDealsPage());
//        Assert.assertFalse(dealsPage.checkDealIsPresent(dealFulldate));
    }
    @After
    public void tearDown() {providerPage.clouseProviderPageAndBrowser();}
}
