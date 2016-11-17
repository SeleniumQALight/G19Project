package mainPack;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ValidLogOnWithOutPageObject {

    WebDriver driver = new ChromeDriver();
    Logger logger = Logger.getLogger(getClass());


    @Test
    public void validLogOnWithOutPageObject() {

        //System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("http://v3.test.itpmgroup.com/login");
        logger.info("Page was opened");

        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
        logger.info("Login was entered");

        driver.findElement(By.name("_password")).clear();
        driver.findElement(By.xpath(".//*[@name='_password']")).sendKeys("909090");
        logger.info("Password was entered");

        driver.findElement(By.xpath(".//button")).click();
        logger.info("Button was clicked");

        Assert.assertTrue("Not Home Page", driver.findElement(By.xpath(".//img[@alt='student']")).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();

    }

}
