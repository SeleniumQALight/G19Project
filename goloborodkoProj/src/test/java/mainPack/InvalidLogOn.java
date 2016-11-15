package mainPack;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AllPages;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class InvalidLogOn {
    WebDriver driver = new ChromeDriver();
    AllPages allPages = new AllPages(driver);

    String login, pass;

    public InvalidLogOn(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student", "906090"},{"Students", "909090"},{"A student", "909090"}
        });
    }

    @Test
    public void setUp() {
        allPages.loginPage.logOn(login, pass);
        allPages.loginPage.isFormLoginPresent();
    }

    @After
    public void tearDown() {
        allPages.loginPage.closeLoginPageAndBrowser();
    }

}
