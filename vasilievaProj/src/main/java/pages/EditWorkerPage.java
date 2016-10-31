package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class EditWorkerPage {
    WebDriver driver;
    Logger logger;

    public EditWorkerPage(){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
    }

    public void openEditWorkerPage(int num){
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("http://v3.test.itpmgroup.com/dictionary/workers/edit/" + num);
        logger.info("Edit page was opened");
    }

    public void enterWorkerSurname(String old_surname, String new_surname){
       try {
           driver.findElement(By.name("workers[workerSurname]")).clear();
           driver.findElement(By.name("workers[workerSurname]")).sendKeys(old_surname + '_' + new_surname);
           logger.info("Surname was edited");
       }catch (Exception e){
           logger.error("can't edit Surname");
           Assert.fail();
       }
    }

    public void enterWorkerName(String old_name, String new_name){
        try{
            driver.findElement(By.name("workers[workerName]")).clear();
            driver.findElement(By.name("workers[workerName]")).sendKeys(old_name + '_' + new_name);
            logger.info("worker name was editing, new name: " + old_name + '_' + new_name);
        }catch (Exception e){
            logger.error("can't edit name");
            Assert.fail();
        }
    }

    public void enterWorkerMiddleName(String old_middleName, String new_middlName){
        try{
            driver.findElement(By.name("")).clear();

        } catch (Exception e){
            logger.error("can't edit MiddleName");
            Assert.fail();
        }
    }

}
