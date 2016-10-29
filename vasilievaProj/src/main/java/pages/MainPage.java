package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {
    WebDriver driver;
    Logger logger;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method opens Main page in browser
     */
    public void openBrowserMainPage(){
        try{
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            driver.get("http://v3.test.itpmgroup.com/dashboard");
            logger.info("Main page opens");
        }catch (Exception e){
            logger.error("can't open Main page");
            Assert.fail();
        }
    }

    /**
     * Method find SandwichButton and click on it
     */
    public void findSandwichClick(){
        try{
            driver.findElement(By.xpath(".//a[@href='#' and @class='sidebar-toggle']")).isDisplayed();
            driver.findElement(By.xpath(".//a[@href='#' and @class='sidebar-toggle']")).click();
            logger.info("element sandwich was found on page and clicked");
        }catch(Exception e){
            logger.error("can't find element sandwich");
            Assert.fail();
        }
    }

    /**
     * Method find Avatar in left side
     * @return
     */
    public boolean isAvatarLeftSidePresent(){
        try{
            return  driver.findElement(By.className("pull-left info")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void mainPageClose(){
        driver.quit();
        logger.info("Main page was closed");
    }

}
