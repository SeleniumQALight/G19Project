package mainPack;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import pages.LoginPage;
import pages.MainPage;

public class HideLeftPanelBySandwichButton {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);

    @Test
    public void hideLeftPanelBySandwichButton(){
        loginPage.openBrowserLoginPage();
        loginPage.enterUserName("Student");
        loginPage.enterPassWord("909090");
        loginPage.clickButtonVhod();
        mainPage.openBrowserMainPage();
        mainPage.findSandwichClick();
        Assert.assertFalse(mainPage.isAvatarLeftSidePresent());
    }

    @After
    public void tearDown(){
        mainPage.mainPageClose();
    }

}
