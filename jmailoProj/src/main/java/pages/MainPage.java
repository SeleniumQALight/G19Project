package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;
    Logger logger;

    public MainPage(WebDriver externalDriver){
        this.driver=externalDriver;
        logger=Logger.getLogger(getClass());
    }

    /**
     * Method checks main page presence
     */
    public void isMainPageOpened(){
        try{
            driver.findElement(By.xpath(".//img[@alt='student']")).isDisplayed();
            logger.info("Student's icon was found");
            driver.findElement(By.xpath(".//h1[contains(text(),'Главная')]")).isDisplayed();
            logger.info("Header Glavnaya was found");
        }catch (Exception e){
            logger.error("Can't work with main page");
        }
    }

    /**
     * Method clicks on left side menu element Apparat
     */

    public void clickOnLeftSideMenuItem(String liid){
        try {
            //driver.findElement(By.xpath(".//a[@href='http://v3.test.itpmgroup.com/dictionary/apparat/edit']")).click();
            driver.findElement(By.id(liid)).click();
            logger.info("Link " + liid + " was clicked");
        }catch (Exception e){
            logger.error("Can't work with " + liid + " link");
            Assert.fail("Can't work with "+ liid +" link");
        }
    }

    /**
     * Method closes main page and browser
     */
    public void closeMainPageAndBrowser(){
        driver.quit();
        logger.info("Main page and browser were closed");
    }
}
