package pages;

import org.apache.bcel.generic.StackInstruction;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AddWorkerPage {
    WebDriver driver;
    Logger logger;

    @FindBy(name = "workers[workerSurname]")
    WebElement workerSurname;

    @FindBy(name = "workers[workerName]")
    WebElement workerName;

    @FindBy(name = "workers[workerMiddleName]")
    WebElement workerMiddleName;

    @FindBy(name = "workers[workerPhone]")
    WebElement workerPhone;

    @FindBy(name = "add")
    WebElement btnAdd;

    final String urlToConnectEditPage = "http://v3.test.itpmgroup.com/dictionary/workers/edit";
    final String enterMessage = "  was entered";
    final String errorMessage = " can't work with ";
    final String errorFindinput = " can't find input";

    public AddWorkerPage(WebDriver exterDriver){
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    /**
     * Method opens page for adding new worker
     */
    public void openAddWorkerPage(){
        try{
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get(urlToConnectEditPage);
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
            workerSurname.clear();
            workerSurname.sendKeys(surName);
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
            workerName.clear();
            workerName.sendKeys(name);
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
            workerMiddleName.clear();
            workerMiddleName.sendKeys(middleName);
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
            workerPhone.clear();
            workerPhone.sendKeys(phone);
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
            btnAdd.click();
            logger.info(" button 'Sozdat' was clicked");
        } catch (Exception e){
            logger.error("can't click");
            Assert.fail();
        }
    }


}
