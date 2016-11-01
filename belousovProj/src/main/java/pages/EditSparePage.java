package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by dariia on 10/30/16.
 */
public class EditSparePage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";
    final String canNotWork = "Can not work with element ";
    final String canNotFind = "Can not find element ";
    final String wasOpened = " Was opened";
    final String wasClicked = " Was clicked";
    final String wasEntered = " Was entered";
    //final String spareName = "Рулетка";

    @FindBy(id = "spares_spareName")
    WebElement spareNameField;
    @FindBy (tagName = "select")
    WebElement ddTipeOfSoears;

    public EditSparePage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
    }



    /**
     * Chek the page is EditSparePage
     * @return
     */
    public boolean checkEditSparePage(){
        try {
            Thread.sleep(1000);
            logger.info("If you dont see next message - Cant check EditSparePage, that's meens All Ok");
            return spareNameField.isDisplayed();
        }catch (Exception e){
            logger.error("Cant check EditSparePage");
            return false;
        }
    }

    public void enterSpareName(String spareName){
        try {
            Thread.sleep(2000);
            spareNameField.clear();
            spareNameField.sendKeys(spareName);

        }catch (Exception e) {
            logger.error(canNotWork + "Spare name field");
            Assert.fail(canNotWork + "Spare name field");
        }
    }

    /**
     * chose element from DD
     * @param textInDD
     */

    public  void selectValueInDDTypeOfSpears(String textInDD){
    try {
        Select select = new Select(ddTipeOfSoears);
        select.selectByVisibleText(textInDD);
        logger.info(textInDD + "was selected in DD");

    }catch (Exception e){
        logger.error(canNotWork + "DDTupeOfSpears");
        Assert.fail(canNotWork + "DDTupeOfSpears");
    }
    }

        public  void valueIbDDTypeOfSparesByValue(String valueInDD)
        {
            try {
                Select select = new Select(ddTipeOfSoears);
                select.selectByVisibleText(valueInDD);
                logger.info(valueInDD + "was selected in DD");

            }catch (Exception e){
                logger.error(canNotWork + "DDTupeOfSpears");
                Assert.fail(canNotWork + "DDTupeOfSpears");
            }
        }


    /**
     * click create button
     */
    public void createButton() {
        try {
            driver.findElement(By.xpath(".//button[@name='add']")).click();
            logger.info("Button Add" + wasClicked);
        }catch (Exception e){
            logger.error(canNotWork + "Button Add");
            Assert.fail(canNotWork + "Button Add");
        }
    }
    /**
     * click Delete button
     */
    public void deleteButton(){
        try {
            //Thread.sleep(1000);
            driver.findElement(By.xpath(".//button[@name='delete']")).click();
            logger.info("Button Delete" + wasClicked);
        }catch (Exception e){
            logger.error(canNotFind + "button delete");
            Assert.fail(canNotWork + "button delete");
        }
    }
}