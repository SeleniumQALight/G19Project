package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dariia on 10/30/16.
 */
public class EditWorkerPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";
    final String canNotWork = "Can not work with element ";
    final String canNotFind = "Can not find element ";
    final String wasOpened = " Was opened";
    final String wasClicked = " Was clicked";
    final String wasEntered = " Was entered";

    public EditWorkerPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Chek the page is WorkerEditPage
     * @return
     */
    public boolean checkWorkerEditPage(){
        try {
            logger.info("If you dont see next message - Cant check WorkerEditPage, that's meens All Ok");
            return driver.findElement(By.xpath(".//input[@id='workers_workerSurname']")).isDisplayed();
        }catch (Exception e){
            logger.error("Cant check WorkerEditPage");
            return false;
        }
    }

    /**
     * enter worker Surname
     */
    public void  enterWorkerSurname(String workerSurname){
        try {
            driver.findElement(By.xpath(".//input[@id='workers_workerSurname']")).clear();
            driver.findElement(By.xpath(".//input[@id='workers_workerSurname']")).sendKeys(workerSurname);
            logger.info(workerSurname + wasEntered);
        }catch (Exception e){
            logger.error(canNotFind + "Worker Sername Input Field");
            Assert.fail(canNotFind + "Worker Sername Input Field");
        }
    }

    /**
     * Enter worker Name
     */
    public void enterWorkerName(String workerName) {
        try {
            driver.findElement(By.xpath("//input[@id='workers_workerName']")).clear();
            driver.findElement(By.xpath("//input[@id='workers_workerName']")).sendKeys(workerName);
            logger.info(workerName + wasEntered);
        } catch (Exception e) {
            logger.error(canNotFind + "Worker Name Input Field");
            Assert.fail(canNotFind + "Worker Name Input Field");
        }
    }

    /**
     * enter worker MidleName
     */
    public void enterWorkerMidleName(String workerMidleName){
        try {
            driver.findElement(By.xpath(".//input[@id='workers_workerMiddleName']")).clear();
            driver.findElement(By.xpath(".//input[@id='workers_workerMiddleName']")).sendKeys(workerMidleName);
            logger.info(workerMidleName + wasEntered);
        }catch (Exception e){
            logger.error(canNotWork + "Worker Midle Name Input Field");
            Assert.fail(canNotWork + "Worker Midle Name Input Field");
        }
    }

    /**
     * enter worker phonenumber
     */
    public void enterWorkerPhoneNumber(String workerPhoneNumber){
        try {
            driver.findElement(By.xpath(".//input[@id='workers_workerPhone']")).clear();
            driver.findElement(By.xpath(".//input[@id='workers_workerPhone']")).sendKeys(workerPhoneNumber);
            logger.info(workerPhoneNumber + wasEntered);
        }catch (Exception e){
            logger.error(canNotWork + "Worker PhoneNumber Input Field");
            Assert.fail(canNotWork + "Worker PhoneNumber Input Field");
        }
    }

    /**
     * click create button
     */
    public void createButton() {
        try {
            driver.findElement(By.xpath(".//button[@name='add']")).click();
            logger.info("Button Add" + wasClicked);
        }catch (Exception e){
            logger.error(canNotWork + "Button Add");
            Assert.fail(canNotWork + "Button Add");
        }
    }
}