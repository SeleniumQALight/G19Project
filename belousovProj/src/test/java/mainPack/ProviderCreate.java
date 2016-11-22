package mainPack;

//import org.apache.xpath.operations.String;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;


public class ProviderCreate {
    WebDriver driver = new FirefoxDriver();
    AllPages allPages = new AllPages(driver);
//    LoginPage loginPage = new LoginPage(driver);
//    MainPage mainPage = new MainPage(driver);
//    ProviderPage providerPage = new ProviderPage(driver);
//    ProviderEditPage providerEditPage = new ProviderEditPage(driver);


    /**
     * value for login
     */
    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";

    String proCustName = "New Customer For Test";
    String proCustAddress = "Customer's address For Test";
    String proCustPhone = "Customer's Phone For Test";


    @Test
    public void CreateDeal() {
        allPages.loginPage.logOn(loginNameForLoginPage, passwordForLoginPage);
        Assert.assertTrue(allPages.mainPage.checkMainPage());
        allPages.mainPage.openSideofDealsOnMainPage();
        Assert.assertTrue(allPages.providerPage.checkProviderPage());
        allPages.providerPage.buttonAdd();
        Assert.assertTrue(allPages.providerEditPage.checkProviderEditPage());
        allPages.providerEditPage.enterValueInFields(proCustName, proCustAddress, proCustPhone);
        allPages.providerEditPage.checkBoxPrivatePerson();
        allPages.providerEditPage.createButton();
        Assert.assertTrue(allPages.providerPage.checkProviderPage());


    }

    @After
    public void tearDown() {
        allPages.providerPage.clouseProviderPageAndBrowser();
    }
}
