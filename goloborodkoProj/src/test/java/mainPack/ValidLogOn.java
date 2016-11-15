package mainPack;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AllPages;

@RunWith(value = Parameterized.class)
public class ValidLogOn {
    WebDriver driver = new ChromeDriver();
    AllPages allPages = new AllPages(driver);

    String login, pass;


    @Test
    public void setUp() {
        allPages.loginPage.logOn("Student", "909090");
        allPages.mainPage.checkAvatar();
    }

    @After
    public void tearDown() {
        allPages.loginPage.closeLoginPageAndBrowser();
    }

}
