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

public class SparCreateWithExcellData {
    WebDriver driver = new ChromeDriver();
    AllPages allPages = new AllPages(driver);

    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";

    String spareName, textInDD;


    public SparCreateWithExcellData(String spareName, String textInDD){
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
        allPages.sparesPage.clouseSparePageAndBrowser();
    }
}
