package mainPack;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class InValidLogOnWithOutPageObject {
    WebDriver driver = new FirefoxDriver();
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void inValidLogOnWithOutPageObject() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://v3.qalight.com.ua/login");
        logger.info("Page was opened");

        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.name("_username")).sendKeys("Student");
        logger.info("Login was entered");

        driver.findElement(By.name("_password")).clear();
        driver.findElement(By.name("_password")).sendKeys("906090");
        logger.info("Wrong password \"906090\" was entered");

        driver.findElement(By.tagName("button")).click();
        logger.info("Button was clicked");

        Assert.assertTrue(driver.findElement(By.name("_password")).isDisplayed());
        logger.info("Still login page");
    }

    @After
    public void tearDown() {
        driver.quit();

    }
}
