package mainPack;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

public class AddNewRecordOnServicePage {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    DictionaryServicePage dictionaryServicePage = new DictionaryServicePage(driver);
    ServiceEdit serviceEdit = new ServiceEdit(driver);


    @Test
    public void setUp() {
        loginPage.LogOn("Student", "909090");
        loginPage.isFormLoginPresent();
        homePage.clickMenuService();
        dictionaryServicePage.isDictionaryServicePage();
        dictionaryServicePage.clickAddService();
        serviceEdit.addNewRecordInService("test", "test", "11", "10", "2016", "6", "30", "3", "2");
        dictionaryServicePage.isNewValueTable();


    }

    @After
    public void tearDown() {
        loginPage.closeLoginPegeAndBrowser();
    }
}
