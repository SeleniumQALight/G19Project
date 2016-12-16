package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.LoginPageGA;

public class ForgotPassGA {
    WebDriver driver= new ChromeDriver();
    LoginPageGA loginPageGA= new LoginPageGA(driver);

    @Test
    public void SetUp(){
        loginPageGA.openBrowserAndLoginPage();
        loginPageGA.clickForgotPass();
        loginPageGA.isFormForgotPassPresent();

        Assert.assertTrue ("Not Forgot Password Form",driver.findElement(By.xpath(".//*[@id='resetPasswordDiv']/button")).isDisplayed());
    }
    @After
    public void tearDown(){
        loginPageGA.closeLoginPageAndBrowser();
    }
}
