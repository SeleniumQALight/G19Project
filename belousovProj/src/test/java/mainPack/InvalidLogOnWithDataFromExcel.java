package mainPack;

import junit.framework.Assert;
import libs.ConfigData;
import libs.SpreadsheetData;
import org.junit.After;
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
import java.util.Arrays;
import java.util.Collection;


@RunWith(value = Parameterized.class)


public class InvalidLogOnWithDataFromExcel {


    //WebDriver driver = new FirefoxDriver();
    //AllPages allPages = new AllPages(driver);


    String login,pass;


    RemoteWebDriver driver;

    public InvalidLogOnWithDataFromExcel(String login, String pass) throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());
        this.login = login;
        this.pass = pass;

    }
    AllPages allPages = new AllPages(driver);

    @Parameterized.Parameters
    public  static  Collection testData () throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testData.xls");
        return new SpreadsheetData(spreadsheet,"InvalidLogOn").getData();
    }



    @Test
    public void setUp() {

        allPages.loginPage.openBrowserAndLoginPage();
        allPages.loginPage.enterUserName(login);
        allPages.loginPage.enterUserPassword(pass);
        allPages.loginPage.clickButtonVhod();
        Assert.assertTrue(allPages.loginPage.isFormLoginPresent());

    }

    @After
    public void tearDown() {
        allPages.loginPage.clouseLoginPageAndBrowser();
    }
}
