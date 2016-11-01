package mainPack;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InvalidLogOnWithOutPageObject {
    Logger logger=Logger.getLogger(getClass());
    WebDriver driver= new ChromeDriver();

    @Test
    public void invalidLogOnWithOutPageObject(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("http://v3.test.itpmgroup.com/login");
        logger.info("Page was opened");

        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.name("_username")).sendKeys("Student");
        logger.info("Login was entered");

        driver.findElement(By.name("_password")).clear();
        driver.findElement(By.name("_password")).sendKeys("906090");
        logger.info("Wrong pass was entered");

        driver.findElement(By.tagName("button")).click();
        logger.info("Button was clicked");

        Assert.assertTrue("Not login page", driver.findElement(By.tagName("button")).isDisplayed());

}
@After
public void tearDown(){
driver.quit();
}
}