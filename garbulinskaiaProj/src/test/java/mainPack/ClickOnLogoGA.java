package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPageGA;

public class ClickOnLogoGA {
    WebDriver driver= new ChromeDriver();
    LoginPageGA loginPageGA= new LoginPageGA(driver);

    @Test
    public void SetUp(){
        loginPageGA.openBrowserAndLoginPage();
        loginPageGA.clickOnLogo();

        Assert.assertTrue ("Not Main Page",driver.findElement(By.xpath(".//a[@class='videoshow1']")).isDisplayed());

    }
    @After
    public void tearDown(){
        loginPageGA.closeLoginPageAndBrowser();
    }
}
