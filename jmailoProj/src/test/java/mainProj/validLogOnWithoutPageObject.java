package mainProj;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ValidLogOnWithoutPageObjectOld {
    WebDriver driver = new FirefoxDriver();
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void validLogOnWithoutPageObject(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://v3.test.itpmgroup.com/login");
        logger.info("Page was opened");

        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
        logger.info("login was entered");

        driver.findElement(By.name("_password")).clear();
        driver.findElement(By.name("_password")).sendKeys("909090");
        logger.info("Pass was entered");

        driver.findElement(By.xpath(".//button")).click();
        logger.info("button was clicked");

        Assert.assertTrue("Not homepage",driver.findElement(By.xpath(".//img[@alt='student']")).isDisplayed());


    }

    @After
    public void testDown () {
        driver.quit();
    }

}
