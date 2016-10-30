package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by dariia on 10/30/16.
 */
public class MainPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";
    final String canNotWork = "Can not work with element ";
    final String canNotFind = "Can not find element ";
    final String wasOpened = " Was opened";
    final String wasClicked = " Was clicked";

    public MainPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());

    }

    /**
     * Check the page is Main
     * @return
     */
    public boolean checkMainPage(){
        try {
            return driver.findElement(By.xpath("//title[text()='Учет запчастей'")).isDisplayed();
            //return driver.findElement(By.xpath(".//li[text()='Главная']")).isDisplayed();

        }catch (Exception e) {
            return false;
        }
    }

    /**
     * Clousing Main page and browser
     */
    public void clouseMainPageAndBrowser() {
        driver.quit();
        logger.info("Main Page and browser were cloused");

    }

    /**
     * Openning Slovary menu
     */
    public void openSlovariOnMainPage (){
        try {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.findElement(By.xpath(".//*[@id='dictionary']")).click();
            logger.info("Slovary" + wasClicked);


        } catch (Exception e) {
            logger.error(canNotFind + "Slovary");
            Assert.fail(canNotFind + "Slovary");
        }


    }

    /**
     * Openning Sotrudniki page
     */
    public void openSotrudnikiOnMainPage(){
        try {
            driver.wait();
            driver.findElement(By.xpath(".//li[@id='workers']/a")).click();
            logger.info("Sotrudniki" + wasClicked);
        } catch (Exception e) {
            logger.error(canNotFind + "Sotrudniki");
            Assert.fail(canNotFind + "Sotrudniki");
        }
    }

}