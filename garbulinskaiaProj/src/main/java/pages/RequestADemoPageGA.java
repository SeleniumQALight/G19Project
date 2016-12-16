package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class RequestADemoPageGA {

    WebDriver driver;
    Logger logger;


    @FindBy(xpath = ".//*[contains(text(),'Ready for a Personal Demo?')]")
    WebElement requestADemoArticle;

    public RequestADemoPageGA(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    /**
     * Method check if Request a demo article is present
     */
    public void checkFormRequestADemoPresent() {
        try {
            requestADemoArticle.isDisplayed();
            logger.info("Demo article is displayed");
        } catch (Exception e) {
            logger.error("Demo article is not displayed");
            Assert.fail("Demo article is not displayed");
        }
    }

    /**
     * Method closes Request a demo page and Browser
     */
    public void closeRequestADemoPage() {
        driver.quit();
        logger.info("Page Request a demo and Browser were closed");
    }
}

