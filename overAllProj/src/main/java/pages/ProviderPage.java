package pages;

import org.apache.log4j.Logger;
import org.apache.xerces.impl.xpath.XPath;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 31-Oct-16.
 */
public class ProviderPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";
    final String canNotWork = "Can not work with element ";
    final String canNotFind = "Can not find element ";
    final String wasOpened = " Was opened";
    final String wasClicked = " Was clicked";

    @FindBy(xpath = ".//h1[contains(text(),'Стороны сделок')]")
    WebElement checkProviderPageElement;
    @FindBy(xpath = ".//*[@class='fa fa-plus']")
    WebElement buttonAddPlus;

    public ProviderPage(WebDriver exterDraiver) {
        this.driver = exterDraiver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);

    }

    public boolean checkProviderPage() {
        try {
            logger.info("If you dont see next message - Can't check the ProviderPage, that's meens All Ok");
            return checkProviderPageElement.isDisplayed();
        } catch (Exception e) {
            logger.fatal("Can't check ProviderPage");
            return false;
        }
    }

    public void findProvader(String proCustName) {
        try {
            driver.findElement(By.xpath(".//td[contains(text(),'" + proCustName + "')]")).click();

        } catch (Exception e) {
            logger.error(canNotFind + proCustName);
            Assert.fail(canNotFind + proCustName);
        }
    }

    public boolean checkProviderIsPresent(String proCustName) {
        try {
            logger.info("If you dont see next message -" + canNotFind + proCustName + ", that's meens All Ok");
            return driver.findElement(By.xpath(".//td[contains(text(),'" + proCustName + "')]")).isDisplayed();
        } catch (Exception e) {
            logger.fatal(canNotFind + proCustName);
            return false;
        }
    }

    public void buttonAdd() {
        try {
            buttonAddPlus.click();
            logger.info("Plus + " + wasClicked);
        } catch (Exception e) {
            logger.error(canNotFind + "Plus + ");
            Assert.fail(canNotFind + "Plus + ");
        }
    }

    /**
     * Clousing page and browser
     */
    public void clouseProviderPageAndBrowser() {
        driver.quit();
        logger.info("DealsPage and browser was cloused");
    }
}
