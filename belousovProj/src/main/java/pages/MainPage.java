package pages;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MainPage {
    WebDriver driver;
    Logger logger;
    WebDriverWait webDriverWait;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";
    final String canNotWork = "Can not work with element ";
    final String canNotFind = "Can not find element ";
    final String wasOpened = " Was opened";
    final String wasClicked = " Was clicked";


    @FindBy(xpath = ".//li[@id='dictionary']//a//*[text()='Словари']")
    WebElement slovary;
    @FindBy(xpath = ".//li[@id='workers']")
    WebElement workers;
    @FindBy(xpath = ".//li[@id='spares']")
    WebElement spares;
    @FindBy(xpath = ".//li[text()='Главная']")
    WebElement mainPage;
    @FindBy(xpath = ".//*[@id='deal']")
    WebElement sdelki;
    @FindBy(xpath = ".//*[@id='prov_cus']")
    WebElement sideofDeals;

    public MainPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver,30);

    }

    /**
     * Check the page is Main
     *
     * @return
     */
    public boolean checkMainPage() {

        try {
            //Thread.sleep(1000);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//li[@id='dictionary']//a//*[text()='Словари']")));
            logger.info("If you dont see next message - Can't check the Main Page, that's meens All Ok");
            return mainPage.isDisplayed();

        } catch (Exception e) {
            logger.fatal("Can't check the Main Page");
            return false;
        }
    }

    /**
     * Clousing Main page and browser
     */
    public void clouseMainPageAndBrowser() {
        driver.quit();
        logger.info("Main Page and browser were cloused");
    }

    /**
     * Openning Slovary page
     */
    public void openSlovariOnMainPage() {
        try {
            waitSomeSec(1);
            slovary.click();
            logger.info("Slovary" + wasClicked);
        } catch (Exception e) {
            logger.error(canNotFind + "Slovary");
            Assert.fail(canNotFind + "Slovary");
        }
    }

    /**
     * Openning Sotrudniki page
     */
    public void openSotrudnikiOnMainPage() {
        try {
            waitSomeSec(1);
            workers.click();
            logger.info("Sotrudniki" + wasClicked);
        } catch (Exception e) {
            logger.error(canNotFind + "Sotrudniki");
            Assert.fail(canNotFind + "Sotrudniki");
        }
    }

    /**
     * Open Spare page
     */
    public void openSpareOnMainPge() {
        try {
            waitSomeSec(1);
            spares.click();
            logger.info("Zapchasti" + wasClicked);

        } catch (Exception e) {
            logger.error(canNotWork + "Zapchasti");
            Assert.fail(canNotWork + "Zapchasti");
        }


    }

    /**
     * Openning Sdelki page
     */
    public void openSdelkiOnMainPage() {
        try {
            sdelki.click();
            logger.info("Sdelki" + wasClicked);
        } catch (Exception e) {
            logger.error(canNotFind + "Sdelki");
            Assert.fail(canNotFind + "Sdelki");
        }
    }

    /**
     * Openning SideofDeals page
     */
    public void openSideofDealsOnMainPage() {
        try {
            openSlovariOnMainPage();
            waitSomeSec(1);
            sideofDeals.click();
            logger.info("SideofDeals" + wasClicked);
        } catch (Exception e) {
            logger.error(canNotFind + "SideofDeals");
            Assert.fail(canNotFind + "SideofDeals");
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