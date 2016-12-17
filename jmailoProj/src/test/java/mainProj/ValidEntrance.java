package mainProj;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.EntrancePage;

import java.net.MalformedURLException;
import java.net.URL;

public class ValidEntrance {
    //WebDriver driver = new FirefoxDriver();
    //EntrancePage entrancePage = new EntrancePage(driver);

    RemoteWebDriver driver;

    public ValidEntrance() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.firefox());
    }
    EntrancePage entrancePage = new EntrancePage(driver);


    @Test
    public void setup(){
        entrancePage.openBrowserAndEntrancePage();
        entrancePage.enterEmail("Student");
        entrancePage.enterPassword("909090");
        entrancePage.clickOnButton();
        entrancePage.isEntranceCompleted();
    }

    @After
    public void testDown(){
        entrancePage.closeEntrancePageAndBrowser();
    }
}
