package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dariia on 10/30/16.
 */
public class SparesPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";
    final String canNotWork = "Can not work with element ";
    final String canNotFind = "Can not find element ";
    final String wasOpened = " Was opened";
    final String wasClicked = " Was clicked";
    final String wasEntered = " Was entered";


    @FindBy(xpath = ".//h3[contains(text(),'Список запчастей')]")
    WebElement zapcasty;
    @FindBy(xpath = ".//*[@class='fa fa-plus']")
    WebElement addPlus;
//    @FindBy(xpath = ".//td[text()='Рулетка']")
//            WebElement testSpare;
//    public void testSpareName (String testSpare){
//        @FindBy(xpath = ".//td[text()='" + testSpare + "']")
//        WebElement testSpare;
//    }

    public SparesPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    /**
     * check the page is SparesPage
     */
    public boolean checkSparesPage() {
        try {
            waitSomeSec(1);

            logger.info("If you dont see next message - Cant check SparesPage, that's meens All Ok");
            return zapcasty.isDisplayed();

        } catch (Exception e) {
            logger.error("Cant check SparesPage");
            return false;
        }
    }


    /**
     * click add spare button
     */
    public void buttonAdd() {
        try {
            waitSomeSec(1);
            addPlus.click();
            logger.info("Plus" + wasClicked);
        } catch (Exception e) {
            logger.error(canNotFind + "Plus");
            Assert.fail(canNotFind + "Plus");
        }
    }

    /**
     * Clousing page and browser
     */
    public void clouseSparePageAndBrowser() {
        driver.quit();
        logger.info("Spare page and browser was cloused");
    }

    /**
     * Check testSpare is present
     *
     * @param spareName
     * @return
     */
    public boolean checkTestSpare(String spareName) {
        try {
            logger.info("If you dont see next message - testSpare ne sozdan, that's meens All Ok");
            return driver.findElement(By.xpath(".//td[text()='" + spareName + "']")).isDisplayed();
            //logger.info("Test spare" + wasClicked);

        } catch (Exception e) {
            logger.error("testSpare was not created");
            return false;
        }

    }

    /**
     * Click TestSpare
     *
     * @param spareName
     */
    public void clickTestSpare(String spareName) {
        try {
            driver.findElement(By.xpath(".//td[text()='" + spareName + "']")).click();
            logger.info("TestSpare" + spareName + wasClicked);
        } catch (Exception e) {
            logger.error(canNotFind + "TestSpare" + spareName);
        }
    }

    /**
     * wait method
     *
     * @param sec
     */
    private void waitSomeSec(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
