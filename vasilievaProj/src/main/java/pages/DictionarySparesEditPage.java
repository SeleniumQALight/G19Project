package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DictionarySparesEditPage {
    WebDriver driver;
    Logger logger;
    final String errorInput="can't work with input";
    final String errorButton="can't work with button";

    @FindBy(tagName = "select")
    WebElement ddTypeOfSpares;

    @FindBy(id = "spares_spareName")
    WebElement spareName;

    @FindBy(name = "save")
    WebElement btnSaveEdit;

    @FindBy(name = "add")
    WebElement btnSaveAdd;

    public DictionarySparesEditPage(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        PageFactory .initElements(driver,this);
    }

    /**
     * Method enters spare name
     * @param spareNameValue
     */
    public void inputSpareName(String spareNameValue){
        try{
            spareName.clear();
            spareName.sendKeys(spareNameValue);
            logger.info("spare name was entered");
        }catch (Exception e){
            logger.error(errorInput+"spareName");
            Assert.fail(errorInput+"spareName");
        }
    }

    /**
     * Method select value from dropdown list by visible text
     * @param textInDD
     */
    public void selectValueInDDTypeOfSpares(String textInDD){
        try{
            Select select = new Select(ddTypeOfSpares);
            select.selectByVisibleText(textInDD);
            logger.info(textInDD + "was selected in DD");
        }catch (Exception e){
            logger.error(errorInput + "dd Type of Spares");
            Assert.fail();
        }
    }

    /**
     * Method select value from dropdown list by value
     * @param valueInDD
     */
    public void selectValueInDDTypeOfSparesByValue(String valueInDD){
        try{
            Select select = new Select(ddTypeOfSpares);
            select.selectByValue(valueInDD);
            logger.info(valueInDD + "was selected in DD");
        }catch (Exception e){
            logger.error(errorInput + "dd Type of Spares");
            Assert.fail();
        }
    }

    /**
     * Method clicks on button Save during add record
     */
    public void saveAddBtnClick(){
        try{
            btnSaveAdd.click();
            logger.info("Button save was clicked");
        }catch (Exception e){
            logger.error(errorButton);
            Assert.fail(errorButton);
        }
    }

    /**
     * Method clicks on button 'Save' during edit record
     */
    public void saveEditdBtnClick(){
        try{
            btnSaveEdit.click();
            logger.info("Button 'Save' was clicked");
        }catch (Exception e){
            logger.error(errorButton);
            Assert.fail(errorButton);
        }
    }

}
