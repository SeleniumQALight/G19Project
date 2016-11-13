
package pages;


import org.apache.log4j.Logger;
import org.apache.log4j.varia.StringMatchFilter;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.internal.Streams;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DictionaruSpaseEdit {

    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input UserName ";
    final String errorButton = "Can not work with button ";

    @FindBy(tagName = "seect")
    WebElement ddTypeOfSparces;


    public DictionaruSpaseEdit(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public void selectValueInDdTypeOfSpares(String textInDD){
        try {
            Select select = new Select(ddTypeOfSparces);
            select.selectByVisibleText(textInDD);
            logger.info(textInDD + "Was selected in DD");

        }catch (Exception e){
            logger.error(errorInput + "DD Type Of Sparec");
            Assert.fail(errorInput + "DD Type Of Sparec");
        }

    }
public void selectValueInDDTypeOfSparesByValue(String valueInDD){
    try {
        Select select = new Select(ddTypeOfSparces);
        select.selectByValue(valueInDD);
        logger.info(valueInDD + "Was selected in DD");

    }catch (Exception e){
        logger.error(errorInput + "DD Type Of Sparec");
        Assert.fail(errorInput + "DD Type Of Sparec");
    }

    }


}