package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPage {
    WebDriver driver;
    Logger logger;
    final String errorMess = "Can not work with ";

    @FindBy(xpath = ".//*[@class=\"user-image\"]")
    WebElement avatar;

    public MainPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    /**
     * Method, which opens Main page
     */
    public void openMainPage() {
        try {
            logger.info("Main page was opened");
        } catch (Exception e) {
            logger.error(errorMess + "MainPage");
            Assert.fail(errorMess + "MainPage");
        }
    }

    /**
     * Method, which checks an avatar
     */
    public void checkAvatar() {
        try {
            avatar.isDisplayed();
            logger.info("Avatar is displayed");
        } catch (Exception e) {
            logger.error("Avatar is displayed");
            Assert.fail("Avatar is displayed");
        }
    }

    /**
     * Method, which toggles slide bar
     */
    public void slideBarOnOff() {
        try {
            int state = driver.findElement(By.xpath(".//*[@id='dictionary']")).getLocation().x;
            driver.findElement(By.xpath(".//*[@class='sidebar-toggle']")).click();
            if (state == driver.findElement(By.xpath(".//*[@id='dictionary']")).getLocation().x) {
                logger.info("Slide bar was not toggled");
            } else {
                logger.warn("Slide bar was toggled");
            }
        } catch (Exception e) {
            logger.error(errorMess + "slide bar");
            Assert.fail(errorMess + "slide bar");
        }
    }

    /**
     * Method, which clicks slide buttons
     *
     * @param btnName       Name of the slide button
     * @param btnXPath      xPath of the slide button
     * @param btnCheckXPath xPath of the check tag
     */
    public void clickSlideButton(String btnName, String btnXPath, String btnCheckXPath) {
        try {
            waitSomeSec(1);
            int state = driver.findElement(By.xpath(btnCheckXPath)).getLocation().y;
            driver.findElement(By.xpath(btnXPath)).click();
            if (state == driver.findElement(By.xpath(btnCheckXPath)).getLocation().y) {
                logger.info("Button " + btnName + " was not clicked");
            } else {
                logger.warn("Button " + btnName + " was clicked");
            }
        } catch (Exception e) {
            logger.error(errorMess + "button " + btnName);
            Assert.fail(errorMess + "button " + btnName);
        }
    }

    /**
     * Method, which clicks buttons
     *
     * @param btnName       Name of the button
     * @param btnXPath      xPath of the button
     * @param btnCheckXPath xPath of the check tag
     */
    public void clickButton(String btnName, String btnXPath, String btnCheckXPath) {
        try {
            waitSomeSec(1);
            driver.findElement(By.xpath(btnXPath)).click();
            if (driver.findElement(By.xpath(btnCheckXPath)).isDisplayed()) {
                logger.info("Button " + btnName + " was clicked");
            } else {
                logger.warn("Button " + btnName + " was not clicked");
            }
        } catch (Exception e) {
            logger.error(errorMess + "button " + btnName);
            Assert.fail(errorMess + "button " + btnName);
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

