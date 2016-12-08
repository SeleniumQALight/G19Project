package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    Logger logger;

    final String errorInput = "Cannot work with input  ";
    final String errorButton = "Cannot work with button  ";
    @FindBy(xpath = ".//*[@class=\"user-image\"]")
    WebElement avatar;

    @FindBy(id = "dictionary")
    WebElement menuDictionary;
    @FindBy(xpath = ".//*[@href='/dictionary/spares']")
    WebElement subMenuSpares;

    public HomePage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public void checkAvatar() {
        try {
            waitSomeSec(5);
            avatar.isDisplayed();
            logger.info("Avatar is displayed");
        } catch (Exception e) {
            logger.error("Avatar is not displayed");
            Assert.fail("Avatar is not displayed");
        }
    }

    public void clickMenuDictionary() {
        try {
            waitSomeSec(1);
            menuDictionary.click();
            logger.info("Menu dictionary was clicked");

        } catch (Exception e) {
            logger.info(errorButton + " Dictionary ");
            Assert.fail(errorButton + "Dictionary");
        }
    }

    public void clickSubMenuSpares() {
        try {
            waitSomeSec(2);
            subMenuSpares.click();
            logger.info("button was cliced");
        } catch (Exception e) {
            logger.info(errorButton + " Sub Menu Spares ");
            Assert.fail(errorButton + "Sub Menu Spares");
        }
    }

    private void waitSomeSec(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
