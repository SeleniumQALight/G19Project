package pages.elements;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ButtonsMenus {
    WebDriver driver;
    Logger logger;
    Actions action;

    public ButtonsMenus(WebDriver exterDriver, Class exterClass) {
        this.driver = exterDriver;
        logger = Logger.getLogger(exterClass);
        action = new Actions(exterDriver);
    }

    public void clickByXPath(String elementName, String buttonName, String buttonXPath) {
        try {
            driver.findElement(By.xpath(buttonXPath)).click();
            logger.info(elementName + " '" + buttonName + "'" + Messages.genButtonMess());
        } catch (Exception e) {
            logger.error(Messages.genErrorMess() + elementName + " '" + buttonName + "'");
            Assert.fail(Messages.genErrorMess() + elementName + " '" + buttonName + "'");
        }
    }

    public void clickByID(String elementName, String buttonName, String buttonID) {
        try {
            driver.findElement(By.id(buttonID)).click();
            logger.info(elementName + " '" + buttonName + "'" + Messages.genButtonMess());
        } catch (Exception e) {
            logger.error(Messages.genErrorMess() + elementName + " '" + buttonName + "'");
            Assert.fail(Messages.genErrorMess() + elementName + " '" + buttonName + "'");
        }
    }

    public void selectByXPath(String elementName, String buttonName, String buttonXPath) {
        try {
            action.moveToElement(driver.findElement(By.xpath(buttonXPath))).perform();
            logger.info(elementName + " - mouse over '" + buttonName + "' item");
        } catch (Exception e) {
            logger.error(Messages.genErrorMess() + elementName + " '" + buttonName + "'");
            Assert.fail(Messages.genErrorMess() + elementName + " '" + buttonName + "'");
        }

    }}
