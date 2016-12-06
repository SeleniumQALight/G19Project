package mainProj;


import libs.ConfigData;
import libs.SpreadsheetData;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.EntrancePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TestValidEntrance {
    WebDriver driver = new FirefoxDriver();
    EntrancePage entrancePage = new EntrancePage(driver);

    String email, pass;

    public TestValidEntrance (String email, String pass){
        this.email=email;
        this.pass=pass;
    }

    @Parameterized.Parameters
    public static Collection testData () throws IOException{
        InputStream spreadSheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE")+"testData.xls");
        return new SpreadsheetData(spreadSheet, "TestValidEntrance").getData();
    }

    @Test
    public void setup(){

        entrancePage.logOn(email,pass);
        entrancePage.isEntranceCompleted();

    }

    @After
    public void testDown(){
        entrancePage.closeEntrancePageAndBrowser();
    }
}
