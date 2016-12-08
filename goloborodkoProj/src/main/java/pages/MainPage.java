package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.elements.ButtonsMenus;
import pages.elements.IsPresent;
import pages.elements.Messages;

public class MainPage {
    WebDriver driver;
    Logger logger;
    IsPresent isPresent;
    ButtonsMenus buttonsMenus;
    int location;

    @FindBy(xpath = ".//*[@class='user-image']")
    WebElement avatar;

    public MainPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
        isPresent = new IsPresent(driver, getClass());
        buttonsMenus = new ButtonsMenus(driver, getClass());
    }

    /**
     * Method, which checks an avatar
     */
    public void checkAvatar() {
        isPresent.elementbyXPath("User avatar", ".//*[@class='user-image']", true);
    }

    /**
     * Method, which clicks button 'Dictionaries'
     */
    public void clickDictionaries() {
        buttonsMenus.clickByXPath("Slide button", "Dictionaries", ".//*[@id='dictionary']");
    }

    /**
     * Method, which clicks button 'Apparatus'
     */
    public void clickApparatus() {
        buttonsMenus.clickByXPath("Button", "Apparatus", ".//*[@id='apparat']");
    }

    /**
     * Method, which clicks button 'Workers'
     */
    public void clickWorkers() {
        buttonsMenus.clickByXPath("Button", "Workers", ".//*[@id='workers']");
    }

    /**
     * Method, which clicks button 'Spare types'
     */
    public void clickSpareTypes() {
        buttonsMenus.clickByXPath("Button", "Spare types", ".//*[@id='spareType']");
    }

    /**
     * Method, which clicks button 'Spares'
     */
    public void clickSpares() {
        buttonsMenus.clickByXPath("Button", "Spares", ".//*[@id='spares']");
    }

    /**
     * Method, which toggles slide bar
     */
    public void slideBarOnOff() {
        try {
            location = isPresent.getXLocationByXPath(".//*[@id='dictionary']");
            driver.findElement(By.xpath(".//*[@class='sidebar-toggle']")).click();
            if (location == isPresent.getXLocationByXPath(".//*[@id='dictionary']")) {
                logger.info("Slide bar was not toggled");
            } else {
                logger.warn("Slide bar was toggled");
            }
        } catch (Exception e) {
            logger.error(Messages.genErrorMess() + "slide bar");
            Assert.fail(Messages.genErrorMess() + "slide bar");
        }
    }

}

