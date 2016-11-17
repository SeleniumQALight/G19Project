package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class DictionaryProvidersEdit {
    WebDriver driver;
    Logger logger;
    final String errorButton = "Can't work with button ";
    final String errorFoundPage = "Can`t found title of Page ";
    final String errorInput = "Can not work with input ";
    final String errorCheckbox = "Can`t work with checkbox";


    @FindBy(xpath = ".//h3[@class=\"box-title\"and text()=\"Редактирование\"]")
    WebElement titlePage;

    @FindBy(id = "prov_cus_proCustName")
    WebElement inputCustName;

    @FindBy(id = "prov_cus_proCustAddress")
    WebElement inputCustAddress;

    @FindBy(id = "prov_cus_proCustPhone")
    WebElement inputCustPhone;

    @FindBy(id = "prov_cus_proCustIsFl")
    WebElement checkBoxCustIsFl;

    @FindBy(id = "prov_cus_isOurFirm")
    WebElement checkBoxCustIsOurFirm;

    @FindBy(name = "add")
    WebElement buttonCreart;

    @FindBy (xpath =".//*[@name=\"save\"]" )
    WebElement buttonSave;

    @FindBy (xpath = ".//*[@name=\"delete\"]")
    WebElement buttonDelete;



    public DictionaryProvidersEdit(WebDriver exterDriver) {

        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public void inputValueCastName(String castName) {
        try {
            inputCustName.clear();
            inputCustName.sendKeys(castName);
            logger.info("'" + castName + "' was input");
        } catch (Exception e) {
            logger.error(errorInput + "Castomer Name");
            Assert.fail(errorInput + "Castomer Name");
        }
    }

    public void inputValueCastAddress(String castAddress) {
        try {
            inputCustAddress.clear();
            inputCustAddress.sendKeys(castAddress);
            logger.info("'" + castAddress + "' was input");
        } catch (Exception e) {
            logger.error(errorInput + "Castomer Address");
            Assert.fail(errorInput + "Castomer Address");
        }
    }

    public void inputValueCastPhone(String castPhone) {
        try {
            inputCustPhone.clear();
            inputCustPhone.sendKeys(castPhone);
            logger.info("'" + castPhone + "' was entered");
        } catch (Exception e) {
            logger.error(errorInput + "Castomer Phone");
            Assert.fail(errorInput + "Castomer Phone");
        }
    }

    public void isCheckBoxPrivatePersonCheck() {
        try {
            checkBoxCustIsFl.isDisplayed();
            checkBoxCustIsFl.click();
            logger.info("checkbox was clicked");
        } catch (Exception e) {
            logger.error(errorInput);
            Assert.fail(errorInput);
        }
    }

    public void isCheckBoxPrivateIsOurFirmCheck() {
        try {
            checkBoxCustIsOurFirm.isDisplayed();
            checkBoxCustIsOurFirm.click();
            logger.info("checkbox was clicked");
        } catch (Exception e) {
            logger.error(errorInput);
            Assert.fail(errorInput);
        }
    }


    public void clickCreateButton() {
        try {
            buttonCreart.click();
            logger.info("Button 'Create' was clicked");
        } catch (Exception e) {
            logger.error(errorInput + "Castomer Phone");
            Assert.fail(errorInput + "Castomer Phone");
        }
    }

    public void clickSaveButton (){
        try {
            buttonSave.click();
            logger.info("Button 'Save' was clicked");
        }catch (Exception e){
            logger.error(errorButton + "'Save'");
            Assert.fail(errorButton + "'Save'");
        }
    }


    public void addNewProviders(String custName, String custAddress, String custPhone) {
        inputValueCastName(custName);
        inputValueCastAddress(custAddress);
        inputValueCastPhone(custPhone);
        isCheckBoxPrivatePersonCheck();
        isCheckBoxPrivateIsOurFirmCheck();
        clickCreateButton();
    }

    public boolean unCheckProviderFl() {
        try {
            if (checkBoxCustIsFl.isSelected()) {
                checkBoxCustIsFl.click();
            }
            logger.info("Checkbox was uncheck");
        } catch (Exception e) {
            logger.error(errorCheckbox + "Private person");
            Assert.fail(errorCheckbox + "Private person");
        }
        return true;
    }


    public void isDictionaryProvidersPage() {
        try {
            titlePage.isDisplayed();
            logger.info("Title Page was displayed");
        } catch (Exception e) {
            logger.error(errorFoundPage + "Список контрагентов");
            Assert.fail(errorFoundPage + "Список контрагентов");
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
