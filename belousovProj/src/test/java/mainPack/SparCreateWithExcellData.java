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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.AllPages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

@RunWith(value = Parameterized.class)

public class SparCreateWithExcellData {
    //WebDriver driver = new FirefoxDriver();
    AllPages allPages;
    RemoteWebDriver driver;
    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";

    String spareName, textInDD;


    public SparCreateWithExcellData(String spareName, String textInDD)throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        this.spareName = spareName;
        this.textInDD = textInDD;
    }

    @Parameterized.Parameters
    public  static Collection testData () throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testData.xls");
        return new SpreadsheetData(spreadsheet,"SparCreate").getData();
    }




    @Test
    public void CreateSpar() {
        allPages = new AllPages(driver);
        allPages.loginPage.logOn(loginNameForLoginPage, passwordForLoginPage);
        Assert.assertTrue(allPages.mainPage.checkMainPage());
        allPages.mainPage.openSlovariOnMainPage();
        allPages.mainPage.openSpareOnMainPge();
        Assert.assertTrue(allPages.sparesPage.checkSparesPage());
        allPages.sparesPage.buttonAdd();
        Assert.assertTrue(allPages.editSparePage.checkEditSparePage());
        allPages.editSparePage.enterSpareName(spareName);
        allPages.editSparePage.selectValueInDDTypeOfSpears(textInDD);
        allPages.editSparePage.createButton();
        Assert.assertTrue(allPages.sparesPage.checkSparesPage());
        Assert.assertTrue(allPages.sparesPage.checkTestSpare(spareName));

    }

    @After
    public void tearDown() {
        allPages = new AllPages(driver);
        allPages.sparesPage.clouseSparePageAndBrowser();
    }
}
