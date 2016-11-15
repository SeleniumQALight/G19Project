package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkerPage {
    WebDriver driver;
    Logger logger;
    final String okInput = "Record was added: ";

    public WorkerPage(WebDriver externalDriver){
        this.driver=externalDriver;
        logger=Logger.getLogger(getClass());
    }

    /**
     * Method checks apparat page presence
     */
    public void isWorkerPagePresent(){
        try{
            driver.findElement(By.xpath(".//h1[contains(text(),'Сотрудники')]")).isDisplayed();
            driver.findElement(By.xpath(".//h3[(text()='Список сотрудников')]")).isDisplayed();
            logger.info("Worker page was opened");
        }catch (Exception e){
            logger.error("Can't work with Worker page");
            Assert.fail("Can't work with Worker page");
        }
    }

    /**
     * Method clicks on Add(+) button
     */
    public void clickOnPlusButton(){
        try{
            driver.findElement(By.xpath(".//a[@href='http://v3.test.itpmgroup.com/dictionary/workers/edit']")).click();
            logger.info("Button + was clicked");
        }catch (Exception e){
            logger.error("Can't work with Add(+) button");
            Assert.fail("Can't work with Add(+) button");
        }
    }

    /**
     * Method checks newly added record
     * @param workerRecord - worker's FIO or phone number
     */
    public  void checkRecord(String workerRecord){
        try {
            driver.findElement(By.xpath(".//td[contains(text(),"+workerRecord+")]")).isDisplayed();
            //driver.findElement(By.partialLinkText(record));
            logger.info(okInput + workerRecord);
        }catch (Exception e){
            logger.error("Can't find record " + workerRecord);
            Assert.fail("Can't find record " + workerRecord);
        }
    }

}
