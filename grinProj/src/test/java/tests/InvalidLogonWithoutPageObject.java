package tests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Катюша on 27.10.2016.
 */
public class InvalidLogonWithoutPageObject {
    Logger logger= Logger.getLogger(getClass());
    //    WebDriver driver=new FirefoxDriver();
    RemoteWebDriver driver;

    public InvalidLogonWithoutPageObject() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.firefox());
    }

    @Test
    public void invalidLogonWithoutPageObject(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://v3.test.itpmgroup.com/login");
        logger.info("Page was opened");
        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.name("_username")).sendKeys("Student");
        logger.info("login was entered");
        driver.findElement(By.name("_password")).clear();
        driver.findElement(By.name("_password")).sendKeys("906090");
        logger.info("incorrect pass was entered");
        driver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Not login page",driver.findElement(By.tagName("button")).isDisplayed());

    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
