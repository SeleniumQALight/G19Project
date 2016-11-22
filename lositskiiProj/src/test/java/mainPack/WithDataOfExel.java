package mainPack;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.sun.org.glassfish.gmbal.ParameterNames;
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
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class WithDataOfExel {
    WebDriver driver = new FirefoxDriver();
    AllPages allPages = new AllPages(driver);

    String login,pass;

    public WithDataOfExel(String login, String pass){
        this.login = login;
        this.pass = pass;
    }
@Parameterized.Parameters
public static Collection testData() throws IOException{
    InputStream spreadshit = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH")+"testData.xls");
    return new SpreadsheetData(spreadshit,"InvalidLogOn").getData();
}



//    @Parameterized.Parameters
//    public static Collection testData(){
//        return Arrays.asList(new Object[][]{
//                {"Student","906090"},
//                {"tudent","909090"}
//        });
//    }

    @Test
    public void setUp(){
        allPages.loginPage.openBrowserAndLoginPage();
        allPages.loginPage.enterUsername(login);
        allPages.loginPage.enterPassword(pass);
        allPages.loginPage.clickButtonVhod();


        Assert.assertTrue(allPages.loginPage.isFormLoginInPresent());
    }
    @After
    public  void tearDown(){
        allPages.loginPage.closeLoginPageAndBrowserBrowser();
    }

}

