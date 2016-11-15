package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;


public class DealDelete {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    DealsPage dealsPage = new DealsPage(driver);
    DealsEditPage dealsEditPage = new DealsEditPage(driver);


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
        loginPage.logOn(loginNameForLoginPage, passwordForLoginPage);
        Assert.assertTrue(mainPage.checkMainPage());
        mainPage.openSdelkiOnMainPage();
        Assert.assertTrue(dealsPage.checkDealsPage());
        Assert.assertTrue(dealsPage.checkDealIsPresent(dealFulldate));
        dealsPage.clickDeal(dealFulldate);
        Assert.assertTrue(dealsEditPage.checkDealsEditPage());
        dealsEditPage.deleteButton();
        Assert.assertTrue(dealsPage.checkDealsPage());
        Assert.assertFalse(dealsPage.checkDealIsPresent(dealFulldate));
    }

    @After
    public void tearDown() {
        dealsPage.clouseDealsPageAndBrowser();
    }
}
