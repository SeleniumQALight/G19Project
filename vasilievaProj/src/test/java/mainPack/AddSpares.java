package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DictSparesPage;
import pages.DictionarySparesEditPage;
import pages.LoginPage;
import pages.MainPage;

public class AddSpares {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    DictionarySparesEditPage dictionarySparesEditPage = new DictionarySparesEditPage(driver);
    DictSparesPage dictSparesPage = new DictSparesPage(driver);

    String spareNameParam = "newSpare1";
    String spareTypeValue = "1";

    @Test
    public void setUp(){
        loginPage.logOn("Student", "909090");
        mainPage.checkAvatar();
        mainPage.clickMenuDictionary();
        mainPage.clickMenuSpares();
        dictSparesPage.btnAddSpareClick();
        dictionarySparesEditPage.inputSpareName(spareNameParam);
        dictionarySparesEditPage.selectValueInDDTypeOfSparesByValue(spareTypeValue);
        dictionarySparesEditPage.saveAddBtnClick();
        dictSparesPage.isSparePresented(spareNameParam,spareTypeValue);
    }

    @After
    public void tearDown(){
        loginPage.closeLoginPageAndBrowser();
    }
}
