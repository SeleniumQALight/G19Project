package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class Registration {
    WebDriver driver= new ChromeDriver();
    LoginPage loginPage= new LoginPage(driver);

    @Test
    public void SetUp(){
        loginPage.openBrowserAndLoginPage();
        loginPage.clickRegisterLink();

        Assert.assertTrue ("Not Register Page",driver.findElement(By.xpath(".//*[@href='/']")).isDisplayed());
    }
    @After
    public void tearDown(){
        loginPage.closeLoginPageAndBrowser();
    }
}
