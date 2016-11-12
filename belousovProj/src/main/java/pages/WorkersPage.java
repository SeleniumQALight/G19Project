package pages;

import org.apache.bcel.classfile.AccessFlags;
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
public class WorkersPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";
    final String canNotWork = "Can not work with element ";
    final String canNotFind = "Can not find element ";
    final String wasOpened = " Was opened";
    final String wasClicked = " Was clicked";
    final String wasEntered = " Was entered";

    @FindBy (xpath = ".//h3[contains(text(),'Список сотрудников')]")
    WebElement chekWorkerPageElement;
    @FindBy (xpath = ".//*[@class='fa fa-plus']")
    WebElement buttonAddPlus;

    public WorkersPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);

    }
/**
 * check the page is WorkersPage
 */
    public boolean checkWorkersPage(){
        try {
            logger.info("If you dont see next message - Cant check WorkersPage, that's meens All Ok");
            return  chekWorkerPageElement.isDisplayed();

        }catch (Exception e){
            logger.error("Cant check WorkersPage");
            return false;
        }
    }

    /**
     * check the test worker was created
     * @return
     */
    public boolean checkWorkerIsPresent(String workerFullName) {
        try {
            logger.info("If you dont see next message - Sotrudnik ne sozdan, that's meens All Ok");
            return driver.findElement(By.xpath(".//td[text()='" + workerFullName + "']")).isDisplayed();

        }catch (Exception e){
            logger.error(workerFullName + " not created");
            return false;
        }
    }
    /**
     * Clousing page and browser
     */
    public void clouseWorkerPageAndBrowser(){
        driver.quit();
        logger.info("Worker page and browser was cloused");
    }


    /**
     * click add worker button
     */
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
         * Find test worker an click
         */

    public void findWorker(String workerFullName) {
        try {
            driver.findElement(By.xpath(".//td[text()='" + workerFullName + "']")).click();
            logger.info(workerFullName + wasClicked);

        } catch (Exception e) {
            logger.error(canNotFind + workerFullName);
            Assert.fail(canNotFind + workerFullName);
        }

    }

}
