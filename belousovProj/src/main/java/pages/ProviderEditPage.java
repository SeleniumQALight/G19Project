package pages;

import org.apache.log4j.Logger;
//import org.apache.xpath.operations.String;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.apache.xpath.operations.String;


public class ProviderEditPage {
    WebDriver driver;
    Logger logger;
    WebDriverWait webDriverWait;

    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";
    final String canNotWork = "Can not work with element ";
    final String canNotFind = "Can not find element ";
    final String wasOpened = " Was opened";
    final String wasClicked = " Was clicked";
    final String wasEntered = " Was entered";
    final String inField = "In field ";

    @FindBy(xpath = ".//input[@id='prov_cus_proCustIsFl']")
    WebElement checkProviderEditPageElement;
    /**
     * Fields parameters
     */
    @FindBy(xpath = ".//input[@id='prov_cus_proCustName']")
    WebElement fieldProCustNameOnPEP;
    @FindBy(xpath = ".//input[@id='prov_cus_proCustAddress']")
    WebElement fieldProCustAddressOnPEP;
    @FindBy(xpath = ".//input[@id='prov_cus_proCustPhone']")
    WebElement fieldProCustPhoneOnPEP;
    /**
     * Checkbox parameters
     */
    @FindBy(xpath = ".//input[@id='prov_cus_proCustIsFl']")
    WebElement checkBoxPrivatePersonOnPEP;
    @FindBy(xpath = ".//input[@id='prov_cus_isOurFirm']")
    WebElement checkBoxIsOurFirmOnPEP;
    /**
     * Buttons
     */
    @FindBy(xpath = ".//button[@name='add']")
    WebElement createButton;
    @FindBy(xpath = ".//button[@name='delete']")
    WebElement deleteButon;

    public ProviderEditPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver,30);

    }

    /**
     * Check the page is ProviderEditPage
     */

    public boolean checkProviderEditPage() {
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//input[@id='prov_cus_proCustIsFl']")));
            logger.info("If you dont see next message - Cant check ProviderEditPage, that's meens All Ok");
            return checkProviderEditPageElement.isDisplayed();
        } catch (Exception e) {
            logger.error("Cant check ProviderEditPage");
            return false;
        }
    }

    /**
     * nter value in field fieldProCustName
     *
     * @param proCustName
     */
    public void fieldProCustName(String proCustName) {
        try {
            fieldProCustNameOnPEP.sendKeys(proCustName);
            logger.info(inField + fieldProCustNameOnPEP + wasEntered + proCustName);
        } catch (Exception e) {
            logger.error(canNotWork + fieldProCustNameOnPEP);
            Assert.fail(canNotWork + fieldProCustNameOnPEP);
        }
    }

    /**
     * Enter value in fieldroCustAddress
     *
     * @param proCustAddress
     */
    public void fieldroCustAddresss(String proCustAddress) {
        try {
            fieldProCustAddressOnPEP.sendKeys(proCustAddress);
            logger.info(inField + fieldProCustAddressOnPEP + wasEntered + proCustAddress);

        } catch (Exception e) {
            logger.error(canNotWork + fieldProCustAddressOnPEP);
            Assert.fail(canNotWork + fieldProCustAddressOnPEP);
        }
    }

    /**
     * Enter value in fieldProCustPhone
     *
     * @param proCustPhone
     */
    public void fieldProCustPhone(String proCustPhone) {
        try {
            fieldProCustPhoneOnPEP.sendKeys(proCustPhone);
            logger.info(inField + fieldProCustPhoneOnPEP + wasEntered + proCustPhone);
        } catch (Exception e) {
            logger.error(canNotWork + fieldProCustPhoneOnPEP);
            Assert.fail(canNotWork + fieldProCustPhoneOnPEP);
        }

    }

    /**
     * CheckBox
     */
    public void checkBoxPrivatePerson() {
        try {
            checkBoxPrivatePersonOnPEP.click();
            logger.info(checkBoxPrivatePersonOnPEP + wasClicked);

        } catch (Exception e) {
            logger.error(canNotWork + checkBoxPrivatePersonOnPEP);
            Assert.fail(canNotWork + checkBoxPrivatePersonOnPEP);
        }
    }

    /**
     * click create button
     */
    public void createButton() {
        try {
            createButton.click();
            logger.info("Button Add" + wasClicked);
        } catch (Exception e) {
            logger.error(canNotWork + "Button Add");
            Assert.fail(canNotWork + "Button Add");
        }
    }

    /**
     * click Delete button
     */
    public void deleteButton() {
        try {
            waitSomeSec(1);
            deleteButon.click();
            logger.info("Button Delete" + wasClicked);
        } catch (Exception e) {
            logger.error(canNotFind + "button delete");
            Assert.fail(canNotWork + "button delete");
        }
    }

    /**
     * Enter value in fields fo Provider
     *
     * @param proCustName
     * @param proCustAddress
     * @param proCustPhone
     */
    public void enterValueInFields(String proCustName, String proCustAddress, String proCustPhone) {
        fieldProCustName(proCustName);
        fieldroCustAddresss(proCustAddress);
        fieldProCustPhone(proCustPhone);

    }

    /**
     * pause for some seconds
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