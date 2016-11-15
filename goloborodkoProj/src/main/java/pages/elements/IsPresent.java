package pages.elements;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IsPresent {
    WebDriver driver;
    Logger logger;

    public IsPresent(WebDriver exterDriver, Class exterClass) {
        this.driver = exterDriver;
        logger = Logger.getLogger(exterClass);
    }

    public void elementbyXPath(String elementName, String elementXPath, boolean isDisplayed) {
        try {
            WaitSomeTime.seconds(2);
            if (driver.findElement(By.xpath(elementXPath)).isDisplayed() == isDisplayed) {
                logger.info(elementName + Messages.genDisplayedMess(driver.findElement(By.xpath(elementXPath)).isDisplayed()));
            } else {
                logger.error(elementName + Messages.genDisplayedMess(driver.findElement(By.xpath(elementXPath)).isDisplayed()) + Messages.genExpectedDisplayedMess(isDisplayed));
                Assert.fail(elementName + Messages.genDisplayedMess(driver.findElement(By.xpath(elementXPath)).isDisplayed()) + Messages.genExpectedDisplayedMess(isDisplayed));
            }
        } catch (Exception e) {
            if (driver.findElement(By.xpath(elementXPath)).isDisplayed() == isDisplayed) {
                logger.info(elementName + Messages.genDisplayedMess(false));
            } else {
                logger.error(elementName + Messages.genDisplayedMess(false) + Messages.genExpectedDisplayedMess(isDisplayed));
                Assert.fail(elementName + Messages.genDisplayedMess(false) + Messages.genExpectedDisplayedMess(isDisplayed));
            }
        }
    }

    public void elementbyID(String elementName, String elementID, boolean isDisplayed) {
        try {
            WaitSomeTime.seconds(4);
            if (driver.findElement(By.id(elementID)).isDisplayed() == isDisplayed) {
                logger.info(elementName + Messages.genDisplayedMess(driver.findElement(By.id(elementID)).isDisplayed()));
            } else {
                logger.error(elementName + Messages.genDisplayedMess(driver.findElement(By.id(elementID)).isDisplayed()) + Messages.genExpectedDisplayedMess(isDisplayed));
                Assert.fail(elementName + Messages.genDisplayedMess(driver.findElement(By.id(elementID)).isDisplayed()) + Messages.genExpectedDisplayedMess(isDisplayed));
            }
        } catch (Exception e) {
            if (driver.findElement(By.id(elementID)).isDisplayed() == isDisplayed) {
                logger.info(elementName + Messages.genDisplayedMess(false));
            } else {
                logger.error(elementName + Messages.genDisplayedMess(false) + Messages.genExpectedDisplayedMess(isDisplayed));
                Assert.fail(elementName + Messages.genDisplayedMess(false) + Messages.genExpectedDisplayedMess(isDisplayed));
            }
        }
    }

    public int getXLocationByXPath(String elementXPath) throws Exception {
        return driver.findElement(By.xpath(elementXPath)).getLocation().x;
    }
    public int getYLocationByXPath(String elementXPath) throws Exception {
        return driver.findElement(By.xpath(elementXPath)).getLocation().y;
    }

    public void pageByURL(String page, String pageURL, boolean isDisplayed) {
        WaitSomeTime.seconds(2);
        try {
            if (driver.getCurrentUrl().endsWith(pageURL)) {
                if (isDisplayed) {
                    logger.info("Page '" + page + "'" + Messages.genDisplayedMess(true));
                } else {
                    logger.error("Page '" + page + "'" + Messages.genDisplayedMess(true)+ Messages.genExpectedDisplayedMess(isDisplayed));
                    Assert.fail("Page '" + page + "'" + Messages.genDisplayedMess(true)+ Messages.genExpectedDisplayedMess(isDisplayed));
                }
            } else {
                if (isDisplayed) {
                    logger.error("Page '" + page + "'" + Messages.genDisplayedMess(false)+ Messages.genExpectedDisplayedMess(isDisplayed));
                    Assert.fail("Page '" + page + "'" + Messages.genDisplayedMess(false)+ Messages.genExpectedDisplayedMess(isDisplayed));
                } else {
                    logger.info("Page '" + page + "'" + Messages.genDisplayedMess(false));
                }
            }
        } catch (Exception e) {
            logger.error("Page '" + page + "'" + Messages.genDisplayedMess(false) + Messages.genExpectedDisplayedMess(isDisplayed));
            Assert.fail("Page '" + page + "'" + Messages.genDisplayedMess(false) + Messages.genExpectedDisplayedMess(isDisplayed));
        }
    }
}
