package mainPack;


import libs.ConfigData;
import libs.SpreadsheetData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AllPages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(value = Parameterized.class)

public class DealCreateWithExcellData {
    WebDriver driver = new FirefoxDriver();
    AllPages allPages = new AllPages(driver);


    /**
     * value for login
     */
    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";
    /**
     * Value for DDDateOfDeal
     */
    String valueDDDayOfDeal, valueDDMonthOfDeal, valueDDYearOfDeal, valueDDHourOfDeal, valueDDMinuteOfDeal;


    /**
     * Value for DD ParametersOfDeal
     */
    String valueDDTypeOfdeal, valueDDCustomerOfDeal, valueDDProviderOfDeal;


    public DealCreateWithExcellData(String valueDDDayOfDeal, String valueDDMonthOfDeal, String valueDDYearOfDeal, String valueDDHourOfDeal, String valueDDMinuteOfDeal, String valueDDTypeOfdeal, String valueDDCustomerOfDeal, String valueDDProviderOfDeal) {
        this.valueDDDayOfDeal = valueDDDayOfDeal;
        this.valueDDMonthOfDeal = valueDDMonthOfDeal;
        this.valueDDYearOfDeal = valueDDYearOfDeal;
        this.valueDDHourOfDeal = valueDDHourOfDeal;
        this.valueDDMinuteOfDeal = valueDDMinuteOfDeal;
        this.valueDDTypeOfdeal = valueDDTypeOfdeal;
        this.valueDDCustomerOfDeal = valueDDCustomerOfDeal;
        this.valueDDProviderOfDeal = valueDDProviderOfDeal;

    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testData.xls");
        return new SpreadsheetData(spreadsheet, "DealCreate").getData();
    }

    String dealFulldate = valueDDDayOfDeal + "." + "0" + valueDDMonthOfDeal + "." + valueDDYearOfDeal + " " + valueDDHourOfDeal + ":" + valueDDMinuteOfDeal;

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
