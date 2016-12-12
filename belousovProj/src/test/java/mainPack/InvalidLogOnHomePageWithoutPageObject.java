package mainPack;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class InvalidLogOnHomePageWithoutPageObject {
    @FindBy(xpath = ".//input[@name='_username']")
    WebElement inputUserName;
    @FindBy(xpath = ".//input[@id='password']")
    WebElement inputPassword;
    @FindBy(tagName = "button")
    WebElement buttonVhod;

    Logger logger = Logger.getLogger(getClass());


    WebDriver driver = new FirefoxDriver();
//    RemoteWebDriver driver;
//
//    public  InvalidLogOnHomePageWithoutPageObject() throws  MalformedURLException {
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
//            DesiredCapabilities.firefox());




    @Test
    public void invalidLogOnHomePageWithoutPageObject() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://v3.test.itpmgroup.com/login");
        logger.info("Page opened");
        inputUserName.clear();
        inputUserName.sendKeys("Student");
        logger.info("Login entered");
        inputPassword.clear();
        inputPassword.sendKeys("906090");
        logger.info("'906090' pass was entered");
        buttonVhod.click();
        Assert.assertTrue("Not login page", buttonVhod.isDisplayed());
        logger.info("Button was clicked");

    }

    @After
    public void tearDovn() {
        driver.quit();
    }
}
