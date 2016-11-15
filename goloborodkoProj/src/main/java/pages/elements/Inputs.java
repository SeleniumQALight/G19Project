package pages.elements;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Inputs {
    WebDriver driver;
    Logger logger;

    public Inputs(WebDriver exterDriver, Class exterClass) {
        this.driver = exterDriver;
        logger = Logger.getLogger(exterClass);
    }

    public void useInputByXPath(String inputName, String inputXPath, String inputData) {
        try {
            driver.findElement(By.xpath(inputXPath)).clear();
            driver.findElement(By.xpath(inputXPath)).sendKeys(inputData);
            logger.info(inputName + " '" + inputData + "'" + Messages.genInputMess());
        } catch (Exception e) {
            logger.error(Messages.genErrorMess() + "input: " + inputName);
            Assert.fail(Messages.genErrorMess() + "input: " + inputName);
        }
    }
    public void useInputByID(String inputName, String inputID, String inputData) {
        try {
            driver.findElement(By.id(inputID)).clear();
            driver.findElement(By.id(inputID)).sendKeys(inputData);
            logger.info(inputName + " '" + inputData + "'" + Messages.genInputMess());
        } catch (Exception e) {
            logger.error(Messages.genErrorMess() + "input: " + inputName);
            Assert.fail(Messages.genErrorMess() + "input: " + inputName);
        }
    }
}
