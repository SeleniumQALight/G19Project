package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApparatusPage {
    WebDriver driver;
    Logger logger;

    public ApparatusPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
    }

    public void initApparatusPage(){
        try {
            driver.get("http://v3.test.itpmgroup.com/dictionary/apparat");
            logger.info("Apparatus page was opened");
        } catch (Exception e) {
            logger.error("Can not work with Apparatus Page");
            Assert.fail("Can not work with Apparatus Page");
        }
    }

    /**
     * Method, which clicks Add button
     */
    public void clickBtnAdd() {
        try {
            driver.findElement(By.xpath(".//*[@class='fa fa-plus']")).click();
            logger.info("Button 'Add' was clicked");
        } catch (Exception e) {
            logger.error("Can not work with the button");
            Assert.fail("Can not work with the button");
        }
    }

    /**
     * Method, which checks Apparatus form
     *
     * @return boolean
     */
    public boolean isFormApparatusPresent() {
        try {
            if (driver.findElement(By.xpath(".//*[@class='fa fa-plus']")).isDisplayed()) {
                logger.info("Apparatus Form is not present");
            } else {
                logger.info("Apparatus Form is present");
            }
            return driver.findElement(By.xpath(".//*[@class='fa fa-plus']")).isDisplayed();
        } catch (Exception e) {
            logger.info("Can not work with Apparatus Form");
            return false;
        }
    }
}
