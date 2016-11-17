package mainProj;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;


public class TestAddCustomer {
    WebDriver driver = new FirefoxDriver();
    EntrancePage entrancePage = new EntrancePage(driver);
    MainPage mainPage = new MainPage(driver);
    CustomersPage customersPage = new CustomersPage(driver);
    CustomersEditorPage customersEditorPage = new CustomersEditorPage(driver);




    @Test
    public void setup(){
        entrancePage.logOn("Student", "909090");
        mainPage.isMainPageOpened();
        mainPage.clickOnLeftSideMenuItem("dictionary");
        mainPage.clickOnLeftSideMenuItem("prov_cus");
        customersPage.isCustomersPageOpened();
        customersPage.clickOnPlusButton();
        customersEditorPage.isCustomersEditorPageOpened();
        customersEditorPage.enterCustomerName("customer");
        customersEditorPage.enterCustomerAddress("address");
        customersEditorPage.enterCustomerPhone("112233");
        customersEditorPage.clickOnCheckbox();

    }

    @After
    public void testDown(){
        entrancePage.closeEntrancePageAndBrowser();
    }
}
