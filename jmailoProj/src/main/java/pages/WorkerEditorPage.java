package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkerEditorPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with button ";
    final String okInput = " was entered";

    public WorkerEditorPage(WebDriver externalDriver){
        this.driver = externalDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method checks Worker edit page presence
     */
    public void isWorkerEditorPagePresent(){
        try {
            driver.findElement(By.xpath(".//h3[text()='Редактирование ']")).isDisplayed();
            logger.info("Worker editor page was opened");
        }catch (Exception e){
            logger.error("Worker editor page was opened");
            Assert.fail("Worker editor page was opened");
        }
    }

    /**
     * Method enters workr's surname
     * @param workerSurname - surname
     */
    public void enterWorkerSurname(String workerSurname){
        try {
            driver.findElement(By.id("workers_workerSurname")).clear();
            driver.findElement(By.id("workers_workerSurname")).sendKeys(workerSurname);
            logger.info(workerSurname + okInput);
        }catch (Exception e){
            logger.error(errorInput + workerSurname);
            Assert.fail(errorInput + workerSurname);
        }
    }

    /**
     * Method enters worker's name
     * @param workerName - name
     */
    public void enterWorkerName (String workerName){
        try {
            driver.findElement(By.id("workers_workerName")).clear();
            driver.findElement(By.id("workers_workerName")).sendKeys(workerName);
            logger.info(workerName + okInput);
        }catch (Exception e){
            logger.error(errorInput + workerName);
            Assert.fail(errorInput + workerName);
        }
    }

    /**
     * Method enters worker's middle name
     * @param workerMiddleName - middle name
     */
    public void enterWorkerMiddleName(String workerMiddleName){
        try {
            driver.findElement(By.id("workers_workerMiddleName")).clear();
            driver.findElement(By.id("workers_workerMiddleName")).sendKeys(workerMiddleName);
            logger.info(workerMiddleName + okInput);
        }catch (Exception e){
            logger.error(errorInput + workerMiddleName);
            Assert.fail(errorInput + workerMiddleName);
        }
    }

    /**
     * Method enters worker's phone number
     * @param workerPhoneNumber - phone number
     */
    public void enterWorkerPhoneNumber(String workerPhoneNumber){
        try {
            driver.findElement(By.id("workers_workerPhone")).clear();
            driver.findElement(By.id("workers_workerPhone")).sendKeys(workerPhoneNumber);
            logger.info(workerPhoneNumber + okInput);
        }catch (Exception e){
            logger.error(errorInput + workerPhoneNumber);
            Assert.fail(errorInput + workerPhoneNumber);
        }
    }

    /**
     * Method clicks on button Create
     */
    public void clickOnButtonAdd(){
        try {
            driver.findElement(By.name("add")).click();
            logger.info("Buton Create was clicked");
        }catch (Exception e){
            logger.error(errorButton + "Create");
            Assert.fail(errorButton + "Create");
        }
    }
}
