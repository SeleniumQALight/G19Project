package mainPack;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ValidLogOnWithOutPageObject_Test
{
    WebDriver driver = new ChromeDriver();
    Logger logger = Logger.getLogger(getClass()); //подключили логгер

    @Test
    public void validLogOnWithOutPageObject(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); //время ожидания результата дефолтное, будет каждый раз ожидать 15 секунд
        driver.get("http://v3.test.itpmgroup.com/login");
        logger.info("Page was opened");

        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student"); //добавляем в элемент текст по символьно
        logger.info("Login was entered");

        driver.findElement(By.name("_password")).clear();
        driver.findElement(By.name("_password")).sendKeys("909090");
        logger.info("Pass was entered");

        driver.findElement(By.xpath(".//button")).click();
        logger.info("button was clicked");

        //выведет сообщение, если тест зафейлится и не найдет элемент
        Assert.assertTrue("Not hame page",driver.findElement(By.xpath(".//img[@alt='Студент']")).isDisplayed());

    }

    @After
    public void tearDown(){
      driver.quit(); //закрывает весь браузер вместе с вкладками
        //а driver.close() - закрывает только вкладку, браузер остается


    }
}
