package mainPack;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DictProvidersPage;
import pages.EditProvidersPage;
import pages.LoginPage;
import pages.MainPage;

public class EditProviderListCheckboxIn {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    DictProvidersPage dictProvidersPage = new DictProvidersPage(driver);
    EditProvidersPage editProvidersPage = new EditProvidersPage(driver);

    @Test
    public void setUp(){
        loginPage.logOn("Student", "909090");
        mainPage.isAvatarLeftSidePresent();
        mainPage.clickMenuDictionary();
        mainPage.clickMenuProviders();
        int countList = dictProvidersPage.getListProvidersCount();
        for (int i=1;i<countList;i++){
            dictProvidersPage.clickCurrentProvider(i);
            editProvidersPage.checkInPrivatePerson();
            editProvidersPage.clickSaveProvider();
        }
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
