package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


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
     *
     * @return
     */
    public boolean checkMainPage() {

        try {
            Thread.sleep(1000);
            logger.info("If you dont see next message - Can't check the Main Page, that's meens All Ok");
            return driver.findElement(By.xpath(".//*[text()='Главная']")).isDisplayed();

        } catch (Exception e) {
            logger.fatal("Can't check the Main Page");
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
    public void openSlovariOnMainPage() {
        try {
            driver.findElement(By.xpath(".//li[@id='dictionary']//a//*[text()='Словари']")).click();
            logger.info("Slovary" + wasClicked);
        } catch (Exception e) {
            logger.error(canNotFind + "Slovary");
            Assert.fail(canNotFind + "Slovary");
        }
    }

    /**
     * Openning Sotrudniki page
     */
    public void openSotrudnikiOnMainPage() {
        try {
            Thread.sleep(500);
            driver.findElement(By.xpath(".//li[@id='workers']")).click();
            logger.info("Sotrudniki" + wasClicked);
        } catch (Exception e) {
            logger.error(canNotFind + "Sotrudniki");
            Assert.fail(canNotFind + "Sotrudniki");
        }
    }
    /**
     * Openning Sdelki page
     */
    public void openSdelkiOnMainPage (){
        try {
            driver.findElement(By.xpath(".//li[@id='deal']")).click();
            logger.info("Sdelki" + wasClicked);
        }catch (Exception e){
            logger.error(canNotFind + "Sdelki");
            Assert.fail(canNotFind + "Sdelki");
        }
    }
}