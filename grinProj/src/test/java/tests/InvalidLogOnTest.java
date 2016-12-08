package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.Allpages;
import pages.LoginPage;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Катюша on 27.10.2016.
 */
@RunWith(value = Parameterized.class)


public class InvalidLogOnTest {
    WebDriver driver = new FirefoxDriver();
    Allpages allpages = new Allpages(driver);

    String login, pass;

    public InvalidLogOnTest(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters
    public static Collection testData()

    {
        return Arrays.asList(new Object[][]{
                {"Student", "906090"},
                {"tudent", "909090"}

        });
    }


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
