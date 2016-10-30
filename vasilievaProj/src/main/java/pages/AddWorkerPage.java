package pages;

import org.apache.bcel.generic.StackInstruction;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AddWorkerPage {
    WebDriver driver;
    Logger logger;
    final String enterMessage = "  was entered";
    final String errorMessage = " can't work with ";
    final String errorFindinput = " can't find input";

    public AddWorkerPage(WebDriver exterDriver){
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method opens page for adding new worker
     */
    public void openAddWorkerPage(){
        try{
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get("http://v3.test.itpmgroup.com/dictionary/workers/edit");
            logger.info("Add worker page was opened");
        } catch (Exception e){
            logger.error(errorMessage + "page");
            Assert.fail();
        }
    }

    /**
     * Method enters surname for new worker
     * @param surName
     */
    public void enterWorkerSurname(String surName){
        try{
            driver.findElement(By.name("workers[workerSurname]")).clear();
            driver.findElement(By.name("workers[workerSurname]")).sendKeys(surName);
            logger.info(surName + enterMessage);
        } catch (Exception e){
            logger.error(errorFindinput + " surname");
            Assert.fail();
        }
    }

    /**
     * Method enters name for new worker
     * @param name
     */
    public void enterWorkerName(String name){
        try{
            driver.findElement(By.name("workers[workerName]")).clear();
            driver.findElement(By.name("workers[workerName]")).sendKeys(name);
            logger.info(name + " Name" + enterMessage);
        } catch (Exception e){
            logger.error(errorFindinput + " name");
            Assert.fail();
        }
    }

    /**
     * Method enters middleName for new worker
     * @param middleName
     */
    public void enterWorkerMiddleName(String middleName){
        try{
            driver.findElement(By.name("workers[workerMiddleName]")).clear();
            driver.findElement(By.name("workers[workerMiddleName]")).sendKeys(middleName);
            logger.info(middleName + " MiddleName" + enterMessage);
        } catch (Exception e){
            logger.error(errorFindinput + " middleName");
            Assert.fail();
        }
    }

    /**
     * Method enters phone for new worker
     * @param phone
     */
    public void enterWorkerPhone(String phone){
        try{
            driver.findElement(By.name("workers[workerPhone]")).clear();
            driver.findElement(By.name("workers[workerPhone]")).sendKeys(phone);
            logger.info(phone + " Phone was entered ");
        } catch (Exception e){
            logger.error(errorFindinput + " Phone ");
            Assert.fail();
        }
    }

    /**
     * Method clicked on 'Sozdat''' button
     */
    public void addWorkerClick(){
        try{
            driver.findElement(By.name("add")).click();
            logger.info(" button 'Sozdat' was clicked");
        } catch (Exception e){
            logger.error("can't click");
            Assert.fail();
        }
    }


}
