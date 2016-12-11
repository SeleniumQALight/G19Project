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

public class ProviderDeleteWithExcellData {
    WebDriver driver = new FirefoxDriver();
    AllPages allPages = new AllPages(driver);

    /**
     * value for login
     */
    String loginNameForLoginPage = "Student";
    String passwordForLoginPage = "909090";


    String proCustName, proCustAddress, proCustPhone;

    public ProviderDeleteWithExcellData(String proCustName, String proCustAddress, String proCustPhone) {
        this.proCustName = proCustName;
        this.proCustAddress = proCustAddress;
        this.proCustPhone = proCustPhone;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testData.xls");
        return new SpreadsheetData(spreadsheet, "ProviderCreate").getData();
    }



    @Test
    public void providerDelete() {
        allPages.loginPage.logOn(loginNameForLoginPage, passwordForLoginPage);
        Assert.assertTrue(allPages.mainPage.checkMainPage());
        allPages.mainPage.openSideofDealsOnMainPage();
        Assert.assertTrue(allPages.providerPage.checkProviderPage());
        allPages.providerPage.findProvader(proCustName);
        Assert.assertTrue(allPages.providerEditPage.checkProviderEditPage());
        allPages.providerEditPage.deleteButton();
        Assert.assertTrue(allPages.providerPage.checkProviderPage());
        Assert.assertFalse(allPages.providerPage.checkProviderIsPresent(proCustName));


    }
    @After
    public void tearDown() {allPages.providerPage.clouseProviderPageAndBrowser();}
}
