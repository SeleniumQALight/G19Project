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
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    ProviderPage providerPage = new ProviderPage(driver);
    ProviderEditPage providerEditPage = new ProviderEditPage(driver);


    /**
     * value for login
     */
    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";

    String proCustName = "New Customer For Test";
    String proCustAddress = "Customer's address For Test";
    String proCustPhone = "Customer's Phone For Test";




    @Test
    public void CreateDeal(){
        loginPage.logOn(loginNameForLoginPage, passwordForLoginPage);
        Assert.assertTrue(mainPage.checkMainPage());
        mainPage.openSideofDealsOnMainPage();
        Assert.assertTrue(providerPage.checkProviderPage());
        providerPage.buttonAdd();
        Assert.assertTrue(providerEditPage.checkProviderEditPage());
        providerEditPage.enterValueInFields(proCustName,proCustAddress,proCustPhone);
        providerEditPage.checkBoxPrivatePerson();
        providerEditPage.createButton();
        Assert.assertTrue(providerPage.checkProviderPage());



    }
    @After
    public void tearDown() {providerPage.clouseProviderPageAndBrowser();}
}
