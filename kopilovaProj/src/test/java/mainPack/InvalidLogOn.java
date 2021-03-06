package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AllPages;
import pages.LoginPage;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)

public class InvalidLogOn {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    AllPages allPages = new AllPages(driver);

    String login, pass;

    public InvalidLogOn(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"Student", "906090"},
                {"tudent","909090"}
        });
    }

    @Test
    public void setUp() {
        loginPage.LogOn(login, pass);
        Assert.assertTrue(loginPage.isFormLoginPresent());
    }

    @After
    public void tearDown() {
        loginPage.closeLoginPegeAndBrowser();
    }
}
