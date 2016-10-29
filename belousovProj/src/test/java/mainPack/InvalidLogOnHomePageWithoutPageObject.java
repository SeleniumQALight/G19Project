package mainPack;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by SBeast on 10/27/2016.
 */

public class InvalidLogOnHomePageWithoutPageObject
{
    Logger logger = Logger.getLogger(getClass());
    WebDriver driver = new ChromeDriver();

    @Test
    public void invalidLogOnHomePageWithoutPageObject()
    {
     driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://v3.test.itpmgroup.com/login");
        logger.info("Page opened");
        driver.findElement(By.xpath(".//input[@name='_username']")).clear();
        driver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student");
        logger.info("Login entered");
        driver.findElement(By.xpath(".//input[@id='password']")).clear();
        driver.findElement(By.xpath(".//input[@id='password']")).sendKeys("906090");
        logger.info("'906090' pass was entered");
        driver.findElement(By.tagName("button")).click();
        Assert.assertTrue("Not login page", driver.findElement(By.tagName("button")).isDisplayed());
        logger.info("Button was clicked");

    }
    @After
    public void tearDovn ()
    {
        driver.quit();
    }
}
