package mainPack;

//import org.apache.xpath.operations.String;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;


public class DealCreate {
   WebDriver driver = new FirefoxDriver();
    AllPages allPages = new AllPages(driver);

//    RemoteWebDriver driver;
//
//    public  DealCreate() throws MalformedURLException {
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
//                DesiredCapabilities.firefox());
//    }
//
//    AllPages allPages = new AllPages(driver);



    /**
     * value for login
     */
    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";
    /**
     * Value for DDDateOfDeal
     */
    String valueDDDayOfDeal = "22";
    String valueDDMonthOfDeal = "8";
    String valueDDYearOfDeal = "2012";
    String valueDDHourOfDeal = "11";
    String valueDDMinuteOfDeal = "58";
    String dealFulldate = valueDDDayOfDeal + "." + "0" + valueDDMonthOfDeal + "." + valueDDYearOfDeal + " " + valueDDHourOfDeal + ":" + valueDDMinuteOfDeal;

    /**
     * Value for DD ParametersOfDeal
     */
    String valueDDTypeOfdeal = "Бонус";
    String valueDDCustomerOfDeal = "Лукашин Олег Степанович";
    String valueDDProviderOfDeal = "ЧП \"Рога и Копыта\"";


    @Test
    public void CreateDeal() {
        allPages.loginPage.logOn(loginNameForLoginPage, passwordForLoginPage);
        Assert.assertTrue(allPages.mainPage.checkMainPage());
        allPages.mainPage.openSdelkiOnMainPage();
        Assert.assertTrue(allPages.dealsPage.checkDealsPage());
        allPages.dealsPage.buttonAdd();
        Assert.assertTrue(allPages.dealsEditPage.checkDealsEditPage());
        allPages.dealsEditPage.DDDateOfDeal(valueDDDayOfDeal, valueDDMonthOfDeal, valueDDYearOfDeal, valueDDHourOfDeal, valueDDMinuteOfDeal);
        allPages.dealsEditPage.DDParametersOfDeal(valueDDTypeOfdeal, valueDDCustomerOfDeal, valueDDProviderOfDeal);
        allPages.dealsEditPage.createButton();
        Assert.assertTrue(allPages.dealsPage.checkDealsPage());
        Assert.assertTrue(allPages.dealsPage.checkDealIsPresent(dealFulldate));

    }

    @After
    public void tearDown() {
        allPages.dealsPage.clouseDealsPageAndBrowser();
    }
}
