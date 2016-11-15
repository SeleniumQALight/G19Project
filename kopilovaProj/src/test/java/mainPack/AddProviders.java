package mainPack;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.DictionaryProvidersEdit;
import pages.DictionaryProvidersPage;
import pages.HomePage;
import pages.LoginPage;

public class AddProviders {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    DictionaryProvidersPage dictionaryProvidersPage = new DictionaryProvidersPage(driver);
    DictionaryProvidersEdit dictionaryProvidersEdit = new DictionaryProvidersEdit(driver);

    @Test
    public void setUp() {
        loginPage.LogOn("Student", "909090");
        homePage.checkAvatar();
        homePage.clickMenuDictionary();
        homePage.clickSubMenuProviders();
        dictionaryProvidersPage.isDictionaryProvidersPage();
        dictionaryProvidersPage.clickOnAddbuttonOnProvidersPage();
        dictionaryProvidersEdit.addNewProviders("Add Provider", "Add Address", "Add Phone");


    }

    @After
    public void tearDown() {
        loginPage.closeLoginPegeAndBrowser();
    }
}
