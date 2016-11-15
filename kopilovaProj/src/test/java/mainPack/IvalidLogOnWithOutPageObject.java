package mainPack;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class IvalidLogOnWithOutPageObject {
    Logger logger = Logger.getLogger(getClass());
    WebDriver driver = new FirefoxDriver();

    @Test
    public void ivalidLogOnWithOutPageObject() {
      driver.manage().window().maximize();;
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      driver.get("http://v3.test.itpmgroup.com/login");

      driver.findElement(By.name("_username")).click();
      driver.findElement(By.name("_username")).sendKeys("Student");
      logger.info("Login was entered");

      driver.findElement(By.name("_password")).clear();
      driver.findElement(By.name("_password")).sendKeys("906090");
      logger.info("'906090' pass was entered");

      driver.findElement(By.tagName("button")).click();
      logger.info("button was clicked");

        Assert.assertTrue("Not login page ", driver.findElement(By.tagName("button")).isDisplayed());
    }
    @After
    public void tearDown (){
        driver.quit();
    }
}
