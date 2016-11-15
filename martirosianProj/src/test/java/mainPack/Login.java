package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.LoginPage;

public class Login {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);


    @Test
    public void loginToSystemWithValidCredentials_L_1() {
        loginPage.openBrowserAndLoginPage();
        Assert.assertTrue("'Uchet Zapicej' title is not displayed", loginPage.isUchetZapisejTitleDisplayed());
        Assert.assertTrue("Email input is not displayed", loginPage.isEmailInputDisplayed());
        Assert.assertTrue("Email input is not clickable", loginPage.isEmailInputEnabled());
        Assert.assertTrue("Password input is not displayed", loginPage.isPasswordInputDisplayed());
        Assert.assertTrue("Password input is not clickable", loginPage.isPasswordInputEnabled());
        Assert.assertTrue("'Vhod' button is not displayed", loginPage.isVhodButtonDisplayed());
        Assert.assertTrue("'Vhod' button is not clickable", loginPage.isVhodButtonEnabled());
        Assert.assertTrue("'Zaregistrirovatsa' button is not displayed", loginPage.isZaregistrirovatsaButtonDisplayed());
        Assert.assertTrue("'Zaregistrirovatsa' button is not clickable", loginPage.isZaregistrirovatsaButtonEnabled());
        Assert.assertTrue("'Napomnit Parol' button is not visible", loginPage.isNapomnitParolButtonDisplayed());
        Assert.assertTrue("'Napomnit Parol' button is not clickable", loginPage.isNapomnitParolButtonEnabled());
        loginPage.logOn("Student", "909090");
        Assert.assertTrue("'Glavnaya' title is not displayed", loginPage.isGlavnayaTitileDisplayed());
        Assert.assertTrue("Avatar is not displayed", homePage.isAvatarDisplayed());
        Assert.assertTrue("Avatar is not clickable", homePage.isAvatarEnabled());
    }
    @After
        public void tearDown () {
            loginPage.closeLoginPageAndBrowser();
    }


}




