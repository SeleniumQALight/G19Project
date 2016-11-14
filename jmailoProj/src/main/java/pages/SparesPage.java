package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SparesPage {
    WebDriver driver;
    Logger logger;

    public SparesPage(WebDriver externalDriver){
        this.driver=externalDriver;
        logger=Logger.getLogger(getClass());
    }

    /**
     * Method checks if spares page is opened
     */
    public void isSparesPageOpened(){
        try {
            driver.findElement(By.xpath(".//h1[contains(text(),'Запчасти')]")).isDisplayed();
            driver.findElement(By.xpath(".//h3[(text()='Список запчастей')]")).isDisplayed();
            logger.info("Spares page was opened");
        }catch (Exception e){
            logger.error("Can't work with Spares page");
            Assert.fail("Can't work with Spares page");
        }
    }

    /**
     * Method clicks on button Add (+)
     */
    public void clickOnPlusButton(){
        try {
            driver.findElement(By.xpath(".//a[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")).click();
            logger.info("Button + was clicked");
        }catch (Exception e){
            logger.error("Can't work with Add(+) button");
            Assert.fail("Can't work with Add(+) button");
        }
    }

    /**
     * Method checks record in the list of parts
     * @param sparePartRecord - record
     */
    public void checkRecord(String sparePartRecord){
        try{
            //driver.findElement(By.xpath(".//td[text()="+sparePartRecord+"]")).isDisplayed();
            driver.findElement(By.xpath(".//td[contains(text(),"+sparePartRecord+")]")).isDisplayed();
            logger.info("Record was added: " + sparePartRecord);
        }catch (Exception e){
            logger.error("Can't find record: " + sparePartRecord);
            Assert.fail("Can't find record: " + sparePartRecord);
        }
    }
}
