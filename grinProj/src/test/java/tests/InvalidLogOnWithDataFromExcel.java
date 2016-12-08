package tests;

import libs.ConfigData;
import libs.SpreadsheetData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.Allpages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Катюша on 27.10.2016.
 */
@RunWith(value = Parameterized.class)


public class InvalidLogOnWithDataFromExcel {
    WebDriver driver = new FirefoxDriver();
    Allpages allpages = new Allpages(driver);

    String login, pass;

    public InvalidLogOnWithDataFromExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testData.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOnTest").getData();
    }


//    @Parameterized.Parameters
//    public static Collection testData()
//
//    {
//        return Arrays.asList(new Object[][]{
//                {"Student", "906090"},
//                {"tudent", "909090"}
//
//        });
//    }


    @Test
    public void setUp() {
        allpages.loginPage.openBrowserAndLoginPage();
        allpages.loginPage.enterUsername(login);
        allpages.loginPage.enterPassWord(pass);
        allpages.loginPage.clickButtonVhod();
        Assert.assertTrue(allpages.loginPage.isFormLoginPresent());
    }

    @After
    public void tearDown() {
        allpages.loginPage.closeLoginPageAndBrowser();
    }
}
