package mainPack;

import junit.framework.Assert;
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


    String login,pass;

    public InvalidLogOn (String login,String pass) {
        this.login = login;
        this.pass = pass;

    }

    @Parameterized.Parameters
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student", "906090"},
                {"tudent", "909090"}
        });
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
