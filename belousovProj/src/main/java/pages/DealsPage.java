package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by user on 31-Oct-16.
 */
public class DealsPage {
    WebDriver driver;
    Logger logger;
    WebDriverWait webDriverWait;

    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";
    final String canNotWork = "Can not work with element ";
    final String canNotFind = "Can not find element ";
    final String wasOpened = " Was opened";
    final String wasClicked = " Was clicked";

    @FindBy(xpath = ".//h3[contains(text(),'Список сделок')]")
    WebElement checkDealsPageElement;
    @FindBy(xpath = ".//*[@class='fa fa-plus']")
    WebElement buttonAddPlus;

    public DealsPage(WebDriver exterDraiver) {
        this.driver = exterDraiver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver,30);

    }

    public boolean checkDealsPage() {
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//h3[contains(text(),'Список сделок')]")));
            logger.info("If you dont see next message - Can't check the DealsPage, that's meens All Ok");
            return checkDealsPageElement.isDisplayed();
        } catch (Exception e) {
            logger.fatal("Can't check DealsPage");
            return false;
        }
    }

    public boolean checkDealIsPresent(String dealFulldate) {
        try {
            logger.info("If you dont see next message - " + "Deal with date " + dealFulldate + " not present" + ", that's meens All Ok");
            return driver.findElement(By.xpath(".//td[text()='" + dealFulldate + "']")).isDisplayed();

        } catch (Exception e) {
            logger.error("Deal with date " + dealFulldate + " not present");
            return false;
        }

    }

    public void clickDeal(String dealFuldate) {
        try {
            driver.findElement(By.xpath(".//td[text()='" + dealFuldate + "']")).click();
        } catch (Exception e) {
            logger.error(canNotFind + " Deal wit date " + dealFuldate);
            Assert.fail(canNotFind + " Deal wit date " + dealFuldate);
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
    public void clouseDealsPageAndBrowser() {
        driver.quit();
        logger.info("DealsPage and browser was cloused");
    }
}
