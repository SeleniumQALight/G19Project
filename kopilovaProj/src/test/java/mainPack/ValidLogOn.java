package mainPack;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;

public class ValidLogOn {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void setUp (){
        loginPage.LogOn("Student","909090");
        loginPage.isFormLoginPresent();

    }
    @After
    public void tearDown(){
        loginPage.closeLoginPegeAndBrowser();
    }
}
