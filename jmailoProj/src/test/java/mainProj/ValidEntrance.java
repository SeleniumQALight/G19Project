package mainProj;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.EntrancePage;

public class ValidEntrance {
    WebDriver driver = new FirefoxDriver();
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
