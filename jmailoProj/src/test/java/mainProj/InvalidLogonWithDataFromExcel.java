package mainProj;


import libs.ConfigData;
import libs.SpreadsheetData;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AllPages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class InvalidLogonWithDataFromExcel {
    WebDriver driver = new FirefoxDriver();

    AllPages allPages = new AllPages(driver);

    String login, pass;

    public InvalidLogonWithDataFromExcel(String login, String pass){
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters
    public static Collection testData () throws IOException {
        InputStream spreadSheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE")+"testData.xls");
        return new SpreadsheetData(spreadSheet, "TestValidEntrance").getData();
    }

//    @Parameterized.Parameters
//    public static Collection testData(){
//        return Arrays.asList(new Object [][]{
//                {"Student","906090"},
//               {"tudent","909090"}
//        });
//    }

    @Test

    public void setUp(){
        allPages.loginPage.openBrowserAndLoginPage();
        allPages.loginPage.enterUserName(login);
        allPages.loginPage.enterPassword(pass);
        allPages.loginPage.clickButtonVhod();
        allPages.loginPage.isFormLoginPresent();

    }
    @After
    public void tearDown(){
        allPages.loginPage.closeLoginPageAndBrowser();
    }
}
