package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.LoginPageGA;

public class ValidLogOnGA {
    WebDriver driver= new ChromeDriver();
    LoginPageGA loginPageGA =new LoginPageGA(driver);

    @Test
    public void setUp(){
        loginPageGA.LogOn("subrosafortuna@gmail.com","greatagent" );

        Assert.assertTrue("Not Home Page",driver.findElement(By.xpath(".//div[@class='user-panel']")).isDisplayed());
    }

    @After
    public void tearDown(){
        loginPageGA.closeLoginPageAndBrowser();
    }
}
