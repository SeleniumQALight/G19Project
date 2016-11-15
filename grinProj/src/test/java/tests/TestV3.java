package tests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class TestV3 {


    WebDriver driver = new FirefoxDriver();
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void TestV3() {
        System.setProperty("webdriver.gecko.driver","D:\\install\\geckodriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://v3.test.itpmgroup.com/");
        logger.info("Page was opened");
        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.name("_username")).sendKeys("Student");
        logger.info("Login was entered");
        driver.findElement(By.name("_password")).clear();
        driver.findElement(By.name("_password")).sendKeys("909090");
        logger.info("Pass was entered");
        driver.findElement(By.xpath(".//button")).click();
        logger.info("Button was clicked");
        driver.findElement(By.xpath(".//button"));
        driver.findElement(By.className("user-image")).isDisplayed();
        logger.info("User image displayed");

    }

    @After
    public void tearDown() {
        driver.quit();
        logger.info("Quit from FF");
    }
}
