package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by dariia on 10/30/16.
 */
public class SparesPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";
    final String canNotWork = "Can not work with element ";
    final String canNotFind = "Can not find element ";
    final String wasOpened = " Was opened";
    final String wasClicked = " Was clicked";
    final String wasEntered = " Was entered";

    @FindBy (xpath = ".//h1[contains(text(),' Запчасти')]")
    WebElement zapcasty;
    @FindBy (xpath = ".//*[@class='fa fa-plus']")
    WebElement addPlus;

    public SparesPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());

    }
/**
 * check the page is SparesPage
 */
    public boolean checkSparesPage(){
        try {
            Thread.sleep(2000);
            logger.info("If you dont see next message - Cant check SparesPage, that's meens All Ok");
            return zapcasty.isDisplayed();

        }catch (Exception e){
            logger.error("Cant check SparesPage");
            return false;
        }
    }


    /**
     * Clousing page and browser
     */
    public void clouseWorkerPageAndBrowser(){
        driver.quit();
        logger.info("Worker page and browser was cloused");
    }


    /**
     * click add spare button
     */
    public void buttonAdd(){
        try {
            addPlus.click();
            logger.info("Plus" + wasClicked);
        }catch (Exception e){
            logger.error(canNotFind + "Plus");
            Assert.fail(canNotFind + "Plus");
        }
    }

    /**
     * Clousing page and browser
     */
    public void clouseSparePageAndBrowser(){
        driver.quit();
        logger.info("Spare page and browser was cloused");
    }

}
