//package tests;
//
//import org.apache.log4j.Logger;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by kateryna.Gryn on 27.10.2016. МОЙ ПЕРВЫЙ АВТОТЕСТ
// */
//public class ValidLogOnWithOutPageObject {
//
////WebDriver driver=new FirefoxDriver();
////    Logger logger = Logger.getLogger(getClass());
////    @Test
////    public void ValidLogOnWithOutPageObject(){
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
////        driver.get("http://10.10.11.6:556/barsroot/account/login/");
////        logger.info("Page was opened");
////        driver.findElement(By.id("txtUserName")).clear();
////        driver.findElement(By.id("txtUserName")).sendKeys("absadm01");
////        logger.info("Login was entered");
////        driver.findElement(By.id("txtPassword")).sendKeys("qwerty");
////        logger.info("Pass was entered");
////        driver.findElement(By.id("btLogIn")).click();
////        logger.info("Button Log in was clicked");
////        driver.findElement(By.id("btChangDate")).click();
////        logger.info("Button Changedate was clicked");
////
////        Assert.assertTrue("Not homepage", driver.findElement(By.id("btnProfile")).isDisplayed());
////
////    }
////@After
////    public void tearDown(){
////    driver.quit();
////    }
////
////}
//
//    WebDriver driver = new FirefoxDriver();
//    Logger logger = Logger.getLogger(getClass());
//
//    @Test
//    public void validLogOnWithOutPageObdect() {
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.get("http://v3.test.itpmgroup.com/login");
//        logger.info("Page was opened");
//        driver.findElement(By.name("_username")).clear();
//        driver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
//        logger.info("Login was entered");
//        driver.findElement(By.name("_password")).clear();
//        driver.findElement(By.name("_password")).sendKeys("909090");
//        logger.info("Pass was entered");
//        driver.findElement(By.xpath(".//button")).click();
//        logger.info("Button was clicked");
//
//        Assert.assertTrue("Not homepage", driver.findElement(By.className("user-image")).isDisplayed());
//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
//}
//
