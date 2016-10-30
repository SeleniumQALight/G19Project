package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.rmi.runtime.Log;

public class ApparatPage {
    WebDriver driver;
    Logger logger;
    final String okInput = "Record was added: ";

    public ApparatPage(WebDriver externalDriver){
        this.driver=externalDriver;
        logger=Logger.getLogger(getClass());
    }

    /**
     * Method checks apparat page presence
     */
    public  void isApparatPagePresent() {
        try {
            driver.findElement(By.xpath(".//h1[contains(text(),'Аппарат')]")).isDisplayed();
            driver.findElement(By.xpath(".//h3[(text()='Список аппаратов')]")).isDisplayed();
            logger.info("Apparat page was opened");
        } catch (Exception e) {
            logger.error("Can't work with Apparat page");
            Assert.fail("Can't work with Apparat page");
        }
    }

    /**
     * Method clicks on Add(+) button
     */
    public void clickOnPlusButton(){
        try{
            driver.findElement(By.xpath(".//a[@href='http://v3.test.itpmgroup.com/dictionary/apparat/edit']")).click();
            logger.info("Button + was clicked");
        }catch (Exception e){
            logger.error("Can't work with Add(+) button");
            Assert.fail("Can't work with Add(+) button");
        }
    }

    /**
     * Method checks newly added record
     * @param record - number and comment
     */
    public  void checkRecord(String record){
        try {
            driver.findElement(By.xpath(".//td[text()='887']"));
            //driver.findElement(By.partialLinkText(record));
            logger.info(okInput + record);
        }catch (Exception e){
            logger.error("Can't find record " + record);
            Assert.fail("Can't find record " + record);
        }
    }
}
