package tests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class MMFO {


    WebDriver driver = new FirefoxDriver();
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void MMFO() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","D:\\install\\geckodriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://10.10.11.6:10556/barsroot");
        logger.info("Page was opened");
        driver.findElement(By.id("txtUserName")).clear();
        driver.findElement(By.id("txtUserName")).sendKeys("absadm01");
        logger.info("Login was entered");
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys("qwerty");
        logger.info("Pass was entered");
        driver.findElement(By.id("btLogIn")).click();
        logger.info("Button was clicked");
        driver.findElement(By.id("btChangDate")).sendKeys(Keys.ENTER);
        logger.info("Button Changedate was clicked");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Assert.assertTrue("Not homepage", driver.findElement(By.id("btnProfile")).isDisplayed());

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(".//*[@class='menu-block']/..//td[contains(text(),'АРМ Уповноваженої особи ФМ (W_FM)') ]"))).build().perform();
        logger.info("АРМ Уповноваженої особи ФМ (W_FM) was found");

        driver.findElement(By.xpath(".//*[@class='menu-block']/..//td[contains(text(),'АРМ Уповноваженої особи ФМ (W_FM)') ]")).click();
        logger.info("АРМ Уповноваженої особи ФМ (W_FM) was clicked");
//        driver.findElement(By.xpath("(.//div[contains(text(),'ФМ. Відбір документів [ВСІ ДОКУМЕНТИ]')])[4]")).click();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.findElement(By.id("diDat1_text")).sendKeys("01.09.2016");
//        driver.findElement(By.id("btSearch")).click();
//        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//        driver.findElement(By.id("gvFmDocs")).click();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.findElement(By.id("ibChangeHistory")).click();


    }

    @After
    public void tearDown() {
        driver.quit();
        logger.info("Quit from FF");
    }
}
