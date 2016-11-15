package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    final String wasEntered = " Was entered in ";

    @FindBy (xpath = ".//input[@id='workers_workerSurname']")
    WebElement workerSurnameField;
    @FindBy (xpath = ".//input[@id='workers_workerName']")
    WebElement workerNameField;
    @FindBy (xpath = ".//input[@id='workers_workerMiddleName']")
    WebElement workerMiddleNameField;
    @FindBy (xpath = ".//input[@id='workers_workerPhone']")
    WebElement workerPhoneField;

    public EditWorkerPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    /**
     * Chek the page is WorkerEditPage
     * @return
     */
    public boolean checkWorkerEditPage(){
        try {
            //Thread.sleep(1000);
            logger.info("If you dont see next message - Cant check WorkerEditPage, that's meens All Ok");
            return workerSurnameField.isDisplayed();
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

            workerSurnameField.clear();
            workerSurnameField.sendKeys(workerSurname);
            logger.info(workerSurname + wasEntered + workerSurnameField);
        }catch (Exception e){
            logger.error(canNotWork + workerSurnameField);
            Assert.fail(canNotWork + workerSurnameField);
        }
    }

    /**
     * Enter worker Name
     */
    public void enterWorkerName(String workerName) {
        try {
            workerNameField.clear();
            workerNameField.sendKeys(workerName);
            logger.info(workerName + wasEntered + workerNameField);
        } catch (Exception e) {
            logger.error(canNotWork + workerNameField);
            Assert.fail(canNotWork + workerNameField);
        }
    }

    /**
     * enter worker MidleName
     */
    public void enterWorkerMidleName(String workerMidleName){
        try {
            workerMiddleNameField.clear();
            workerMiddleNameField.sendKeys(workerMidleName);
            logger.info(workerMidleName + wasEntered + workerMiddleNameField);
        }catch (Exception e){
            logger.error(canNotWork + workerMiddleNameField);
            Assert.fail(canNotWork + workerMiddleNameField);
        }
    }

    /**
     * enter worker phonenumber
     */
    public void enterWorkerPhoneNumber(String workerPhoneNumber){
        try {
            workerPhoneField.clear();
            workerPhoneField.sendKeys(workerPhoneNumber);
            logger.info(workerPhoneNumber + wasEntered);
        }catch (Exception e){
            logger.error(canNotWork + workerPhoneField);
            Assert.fail(canNotWork + workerPhoneField);
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
    /**
     * click Delete button
     */
    public void deleteButton(){
        try {
            //Thread.sleep(1000);
            driver.findElement(By.xpath(".//button[@name='delete']")).click();
            logger.info("Button Delete" + wasClicked);
        }catch (Exception e){
            logger.error(canNotFind + "button delete");
            Assert.fail(canNotWork + "button delete");
        }
    }
}