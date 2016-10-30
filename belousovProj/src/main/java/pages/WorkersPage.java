package pages;

import org.apache.bcel.classfile.AccessFlags;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dariia on 10/30/16.
 */
public class WorkersPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";
    final String canNotWork = "Can not work with element ";
    final String canNotFind = "Can not find element ";
    final String wasOpened = " Was opened";
    final String wasClicked = " Was clicked";
    final String wasEntered = " Was entered";

    public WorkersPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());

    }
/**
 * check the page is WorkersPage
 */
    public boolean checkWorkersPage(){
        try {
            return driver.findElement(By.xpath(".//a[@href='http://v2.qalight.com.ua/dictionary/workers/edit']")).isDisplayed();

        }catch (Exception e){
            return false;
        }
    }

    /**
     * check the test worker was added
     * @return
     */
    public boolean checkWorkerIsPresent() {
        try {
            return driver.findElement(By.xpath(".//td[text()='Тестовый Тест Тестович']")).isDisplayed();
           // logger.info("test user was created");
        }catch (Exception e){
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
     * click add worker button
     */
    public void buttonAdd(){
        try {
            driver.findElement(By.xpath(".//a[@href='http://v2.qalight.com.ua/dictionary/workers/edit']")).click();
            logger.info("Plus" + wasClicked);
        }catch (Exception e){
            logger.error(canNotFind + "Plus");
            Assert.fail(canNotFind + "Plus");
        }
    }


}
