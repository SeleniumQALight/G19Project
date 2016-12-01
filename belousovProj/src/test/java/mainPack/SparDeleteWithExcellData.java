package mainPack;

import libs.ConfigData;
import libs.SpreadsheetData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AllPages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(value = Parameterized.class)

public class SparDeleteWithExcellData {
    WebDriver driver = new FirefoxDriver();
    AllPages allPages = new AllPages(driver);

    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";
    // String spareName = "Рулетка 2";
    String spareName, textInDD;

    public SparDeleteWithExcellData(String spareName, String textInDD) {
        this.spareName = spareName;
        this.textInDD = textInDD;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testData.xls");
        return new SpreadsheetData(spreadsheet, "SparCreate").getData();
    }


    @Test
    public void DeleteSpar() {

        allPages.loginPage.logOn(loginNameForLoginPage, passwordForLoginPage);
        Assert.assertTrue(allPages.mainPage.checkMainPage());
        allPages.mainPage.openSlovariOnMainPage();
        allPages.mainPage.openSpareOnMainPge();
        Assert.assertTrue(allPages.sparesPage.checkSparesPage());
        Assert.assertTrue(allPages.sparesPage.checkTestSpare(spareName));
        allPages.sparesPage.clickTestSpare(spareName);
        Assert.assertTrue(allPages.editSparePage.checkEditSparePage());
        allPages.editSparePage.deleteButton();
        Assert.assertTrue(allPages.sparesPage.checkSparesPage());
        Assert.assertFalse(allPages.sparesPage.checkTestSpare(spareName));
    }

    @After
    public void tearDown() {
        allPages.sparesPage.clouseSparePageAndBrowser();
    }
}
