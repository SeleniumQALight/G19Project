package pages.elements;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckAndRadioBoxes {
    WebDriver driver;
    Logger logger;

    public CheckAndRadioBoxes(WebDriver exterDriver, Class exterClass) {
        this.driver = exterDriver;
        logger = Logger.getLogger(exterClass);
    }

    public void useCheckBoxByXPath(String checkBoxName, String checkBoxXPath, boolean status) {
        try {
            if (driver.findElement(By.xpath(checkBoxXPath)).isSelected()) {
                if (status) {
                    logger.info("Check box '" + checkBoxName + "' was checked, previously");
                } else {
                    driver.findElement(By.xpath(checkBoxXPath)).click();
                    logger.info("Check box '" + checkBoxName + "' was not checked");
                }
            } else {
                if (status) {
                    driver.findElement(By.xpath(checkBoxXPath)).click();
                    logger.info("Check box '" + checkBoxName + "' was checked");
                } else {
                    logger.info("Check box '" + checkBoxName + "' was not checked, previously");
                }
            }
        } catch (Exception e) {
            logger.error(Messages.genErrorMess() + "check box " + checkBoxName);
            Assert.fail(Messages.genErrorMess() + "check box " + checkBoxName);
        }
    }
}
