package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DictWorkersPage {
    WebDriver driver;
    Logger logger;

    public DictWorkersPage(WebDriver exterDriver){
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method opens Dictionary workers page
     */
    public void openDictWorkersPage(){
        try{
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get("http://v3.test.itpmgroup.com/dictionary/workers");
        }catch (Exception e){
            logger.error("Can't open page");
            Assert.fail();
        }
    }

    /**
     * Method closes the Dictionary workers page
     */
    public void closeDictWorkersPage(){
        driver.quit();
    }

    /**
     * Method click on the button '+' for add new worker
     */
    public void addWorkersButtonClick(){
        try{
            driver.findElement(By.className("box-tools")).click();
            logger.info("Button '+' was clicked");
        }catch (Exception e){
            logger.error("Can't find button '+'");
            Assert.fail();
        }
    }

    /**
     *Method get worker fio
     * @param editWorkerFIO
     */
    public void chooseWorkerForEdit(String editWorkerFIO){
        try{
            String listPageRef;
            listPageRef = driver.findElement(By.xpath(".//td[contains(text(),'"+editWorkerFIO+"')]//..//*")).getText();
            logger.info("Worker was found for edit");
            logger.info(listPageRef + " page for edit");
            driver.findElement(By.xpath(".//td[contains(text(),'"+editWorkerFIO+"')]")).click();
            logger.info("Worker was clicked for editing");
        }catch (Exception e){
            logger.error("Can't find this worker");
            Assert.fail();
        }
    }


    /**
     * Method checked the new person
     * @param surName
     * @param name
     * @param middleName
     * @param phone
     * @return
     */
    public boolean isWorkerAdded(String surName, String name, String middleName, String phone) {
        try {
            return driver.findElement(By.xpath(".//tr//td[contains(text(),'" + surName+" "+name +" " + middleName +"')]//..//td[contains(text(),'" + phone + "')]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
