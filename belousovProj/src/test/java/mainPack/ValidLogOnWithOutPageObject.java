package mainPack;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by SBeast on 10/26/2016.
 */
public class ValidLogOnWithOutPageObject {
    //WebDriver driver = new FirefoxDriver();
    WebDriver driver = new ChromeDriver();
    Logger logger = Logger.getLogger(getClass());


    @Test
    public void validLogOnWithOutPageObject() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // таймаут ожидания для попыток взаимодействия с объектом
        driver.get("http://v3.test.itpmgroup.com/login");
        logger.info("Page was opened");
        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student"); //sendKeys - посимвольный ввод
        logger.info("Login was entered");
        driver.findElement(By.name("_password")).clear();
        driver.findElement(By.name("_password")).sendKeys("909090");
        logger.info("Password was entered");
        driver.findElement(By.xpath(".//button")).click();
        logger.info("Button was clicked");
        Assert.assertTrue("Not Home Page", driver.findElement(By.xpath(".//img[@alt='student']")).isDisplayed());


    }

    @After
    public void tearDown() // выносим те действия которые надо выполнить после теста в любом случае
    {
        driver.quit();
    }
}
