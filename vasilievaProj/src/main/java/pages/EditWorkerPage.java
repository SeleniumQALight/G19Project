package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class EditWorkerPage {
    WebDriver driver;
    Logger logger;
    final String errormessage = "can't edit ";

    public EditWorkerPage(WebDriver driver){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method opens browser and page for editing workers
     * @param num
     */
    public void openEditWorkerPage(int num){
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("http://v3.test.itpmgroup.com/dictionary/workers/edit/" + num);
        logger.info("Edit page was opened");
    }

    /**
     * Method enters new Surname
     * @param old_surname
     * @param new_surname
     */
    public void enterWorkerSurname(String old_surname, String new_surname){
       try {
           driver.findElement(By.name("workers[workerSurname]")).clear();
           driver.findElement(By.name("workers[workerSurname]")).sendKeys(old_surname + '_' + new_surname);
           logger.info("Surname was edited, new surname: " + old_surname + '_' + new_surname);
       }catch (Exception e){
           logger.error(errormessage + "Surname");
           Assert.fail();
       }
    }

    /**
     * Method enters new Name
     * @param old_name
     * @param new_name
     */
    public void enterWorkerName(String old_name, String new_name){
        try{
            driver.findElement(By.name("workers[workerName]")).clear();
            driver.findElement(By.name("workers[workerName]")).sendKeys(old_name + '_' + new_name);
            logger.info("Name was edited, new name: " + old_name + '_' + new_name);
        }catch (Exception e){
            logger.error(errormessage + "name");
            Assert.fail();
        }
    }

    /**
     * Method enters new middleName
     * @param old_middleName
     * @param new_middlName
     */
    public void enterWorkerMiddleName(String old_middleName, String new_middlName){
        try{
            driver.findElement(By.name("workers[workerMiddleName]")).clear();
            driver.findElement(By.name("workers[workerMiddleName]")).sendKeys(old_middleName + '_' + new_middlName);
            logger.info("Middlename was edited, new middle name:" + old_middleName+'_'+new_middlName);
        } catch (Exception e){
            logger.error(errormessage + "MiddleName");
            Assert.fail();
        }
    }

    /**
     * Method adds worker phone
     * @param phone
     */
    public void enterWorkerPhone(String phone){
        try{
            driver.findElement(By.name("workers[workerPhone]")).clear();
            driver.findElement(By.name("workers[workerPhone]")).sendKeys(phone);
        } catch (Exception e){
            logger.error(errormessage + "Phone");
            Assert.fail();
        }
    }

    /**
     * Method edit back worker's changes
     * @param surname
     * @param name
     * @param middleName
     */
    public void enterWorkerFioForEditBack(String surname,String name,String middleName){
        try{
            driver.findElement(By.name("workers[workerSurname]")).clear();
            driver.findElement(By.name("workers[workerSurname]")).sendKeys(surname);
            logger.info("change back worker surname");
            driver.findElement(By.name("workers[workerName]")).clear();
            driver.findElement(By.name("workers[workerName]")).sendKeys(name);
            logger.info("change back worker name");
            driver.findElement(By.name("workers[workerMiddleName]")).clear();
            driver.findElement(By.name("workers[workerMiddleName]")).sendKeys(middleName);
            logger.info("change back worker middle name");
        }catch (Exception e){
            logger.error(errormessage + "can't edit back changes the worker");
            Assert.fail();
        }
    }

    /**
     * Method clicks on 'Save' button
     */
    public void editWorkerSaveClick(){
        try{
            driver.findElement(By.name("save")).click();
            logger.info("Button Save was clicked");
        }catch (Exception e){
            logger.error("can't click on button 'Save'");
            Assert.fail();
        }
    }

    /**
     * Method close the edit worker page
     */
    public void closeEditWorkerPage(){
        driver.quit();
        logger.info("Edit page and browser was closed");
    }

}
