package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class ValidLogOn {
    WebDriver driver= new ChromeDriver();
    LoginPage loginPage=new LoginPage(driver);

    @Test
    public void setUp(){
        loginPage.openBrowserAndLoginPage();
        loginPage.enterUserName("Student");
        loginPage.enterPassWord("909090");
        loginPage.clickButtonVhod();

        Assert.assertTrue("Not Home Page",driver.findElement(By.xpath(".//img[@alt='student']")).isDisplayed());
    }

    @After
    public void tearDown(){
        loginPage.closeLoginPageAndBrowser();
    }
}
