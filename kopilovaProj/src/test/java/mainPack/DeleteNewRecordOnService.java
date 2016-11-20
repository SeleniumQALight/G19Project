package mainPack;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.DictionaryServicePage;
import pages.HomePage;
import pages.LoginPage;
import pages.ServiceEdit;

public class DeleteNewRecordOnService {
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
        dictionaryServicePage.clickOnRecordInServiceForEdit(".//tr[td[text()='3'] and td[text()='test'] " +
                "and td[text()='test'] and td[text()='Петров Петр Петрович'] and td[text()='11.10.2016 06:30']]");
        serviceEdit.deleteRecordInService();


    }

    @After
    public void tearDown() {
        loginPage.closeLoginPegeAndBrowser();
    }
}
