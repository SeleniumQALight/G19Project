package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class DictionarySparesEdit {
    WebDriver driver;
    Logger logger;
    final String errorMenu = "Can't work with element menu ";
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with button ";


    @FindBy(tagName = "select")
    WebElement ddTypeOfSpares;

    public DictionarySparesEdit(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public void selectValueInDDTypeOfSpares(String textInDD) {
        try {
            Select select = new Select(ddTypeOfSpares);
            select.selectByVisibleText(textInDD);
            logger.info(textInDD + " was selected in DD");

        } catch (Exception e) {
            logger.error(errorInput + "DD Type of Spares");
            Assert.fail(errorInput + "DD Type of Spares");
        }
    }

    public void selectValueInDDTypeOfSparesByValue(String valueInDD) {
        try {
            Select select = new Select(ddTypeOfSpares);
            select.selectByValue(valueInDD);
            logger.info(valueInDD + " was selected i DD");

        } catch (Exception e) {
            logger.error(errorInput + "DD TypeofSpares");
            Assert.fail(errorInput + "DD TypeofSpares");
        }
    }
}
