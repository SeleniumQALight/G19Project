package mainProj;



import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class InvalidLogOnWithoutPageObject {
    Logger logger=Logger.getLogger(getClass().getClass());
    WebDriver driver=new FirefoxDriver();

    @Test
    public void invalidLogOnWithoutPageObject(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://v3.test.itpmgroup.com/login");

        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.name("_username")).sendKeys("Sudent");
        logger.info("Login was entered");

        driver.findElement(By.name("_password")).clear();
        driver.findElement(By.name("_password")).sendKeys("906090");
        logger.info("906090 was entered");

        driver.findElement(By.tagName("button")).clear();
        logger.info("button was clicked");

        Assert.assertTrue("Not login page", driver.findElement(By.tagName("button")).isDisplayed());


    }
    @After
    public void TestDown(){
        driver.quit();

    }

}
