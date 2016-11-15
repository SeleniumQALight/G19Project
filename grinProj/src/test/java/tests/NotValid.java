package tests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class NotValid {

    WebDriver driver = new FirefoxDriver();
    Logger logger = Logger.getLogger(getClass());

    @Test

    public void NotValid() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://v3.test.itpmgroup.com/");
        logger.info("Page was opened");
        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.name("_username")).sendKeys("Student");
        logger.info("User name was entered");
        driver.findElement(By.name("_password")).clear();
        driver.findElement(By.name("_password")).sendKeys("906090");
        driver.findElement(By.xpath(".//button")).click();

//        Assert.assertTrue();
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}