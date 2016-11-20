package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SdelkiPage;

public class Sdelki {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    SdelkiPage sdelkipage = new SdelkiPage(driver);

    @Test
    public void addingRecordToSdelkiMenu_S_1() {

        String year = "2016";
        String month = "1";
        String day = "1";
        String dealType = "1";
        String customer = "12";
        String provider = "13";

        loginPage.openBrowserAndLoginPage();
        loginPage.logOn("Student", "909090");
        Assert.assertTrue("'Sdelki' menu is not displayed", homePage.isSdelkiMenuDisplayed());
        Assert.assertTrue("'Sdelki' menu is not enabled", homePage.isSdelkiMenuEnabled());
        homePage.clickSdelkiMenu();
        Assert.assertTrue("'Sdelki' title is not displayed", sdelkipage.isSdelkiTitleDisplayed());
        Assert.assertTrue("Devices table is not displayed", sdelkipage.isDevicesTableDisplayed());
        Assert.assertTrue("'Add' button is not displayed",sdelkipage.isAddButtonDisplayed());
        Assert.assertTrue("'Add' button is not clckable", sdelkipage.isAddButtonClickable());
        int initialDevicesListSize = sdelkipage.getDealsCount();
        sdelkipage.clickAddButton();
        Assert.assertTrue("Adding form is not displayed", sdelkipage.isAddingFormDisplayed());
        Assert.assertTrue("'Type of deal' input is not displayed", sdelkipage.isDealTypeDisplayed());
        Assert.assertTrue("'Type of deal' input is not clickable", sdelkipage.isdealTypeClickable());
        Assert.assertTrue("'Customer' input is not displayed", sdelkipage.isCustomerInputDisplayed());
        Assert.assertTrue("'Customer' input is not clickable", sdelkipage.isCustomerInputClickable());
        Assert.assertTrue("'Provider' input is not displayed", sdelkipage.isProviderInputDisplayed());
        Assert.assertTrue("'Provider' input is not clickable", sdelkipage.isProviderInputClickable());
        Assert.assertTrue("Years selector is not displayed", sdelkipage.isYearSelectorDisplayed());
        Assert.assertTrue("Years selector is not clickable", sdelkipage.isYearSelectorClickable());
        Assert.assertTrue("Months selector is not displayed", sdelkipage.isMonthSelectorDisplayed());
        Assert.assertTrue("Months selector is not clickable", sdelkipage.isMonthsSelectorCickable());
        Assert.assertTrue("Days selector is not displayed", sdelkipage.isDaySelectorDisplayed());
        Assert.assertTrue("Days selector is not clickable", sdelkipage.isDaysSelectorCickable());
        Assert.assertTrue("Hours selector is not displayed", sdelkipage.isHoursSelectorDisplayed());
        Assert.assertTrue("Hours selector is not clickable", sdelkipage.isHoursSelectorClickable());
        Assert.assertTrue("Minutes selector is not displayed", sdelkipage.isMinutesSelectorDisplayed());
        Assert.assertTrue("Minutes selector is not clickable", sdelkipage.isMinutesSelectoreClickable());
        sdelkipage.selectYear(year);
        sdelkipage.selectMonth(month);
        sdelkipage.selectDay(day);
        sdelkipage.selectDealType(dealType);
        sdelkipage.selectCustomer(customer);
        sdelkipage.selectProvider(provider);
        sdelkipage.clickSubmitButton();
        homePage.clickSdelkiMenu();
        int finalDevicesListSize = sdelkipage.getDealsCount();
        Assert.assertTrue("Deal was not added to the list of deals", ((finalDevicesListSize - initialDevicesListSize) == 1));

    }
    @After
    public void tearDown () {
        loginPage.closeLoginPageAndBrowser();
    }


}
