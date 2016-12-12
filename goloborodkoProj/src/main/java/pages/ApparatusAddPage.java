package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ApparatusAddPage {
    WebDriver driver;
    Logger logger;

    public ApparatusAddPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        Logger.getLogger(getClass());
    }

    public void initApparatusAddPage() {
        try {
//            driver.get("http://v3.test.itpmgroup.com/dictionary/apparat/edit");
            logger.info("Apparatus add page was opened");
        } catch (Exception e) {
            logger.error("Can not work with Apparatus add page");
            Assert.fail("Can not work with Apparatus add page");
        }
    }

    /**
     * Method, which is used for input fields data set
     *
     * @param fieldName  name of the field
     * @param fieldXPath field xPath
     * @param fieldData  data to set
     */
    public void setInputData(String fieldName, String fieldXPath, String fieldData) {
        try {
            driver.findElement(By.xpath(fieldXPath)).clear();
            driver.findElement(By.xpath(fieldXPath)).sendKeys(fieldData);
            logger.info("Data sent into the field " + fieldName);
        } catch (Exception e) {
            logger.error("Can not work with the field " + fieldName);
            Assert.fail("Can not work with the field " + fieldName);
        }
    }

    /**
     * Method, which clicks button Add
     */
    public void clickBtnAdd() {
        try {
            driver.findElement(By.xpath(".//*[@name='add']")).click();
            logger.info("Button Add was clicked");
        } catch (Exception e) {
            logger.error("Can not work with the button 'Add'");
            Assert.fail("Can not work with the button 'Add'");
        }
    }
}
