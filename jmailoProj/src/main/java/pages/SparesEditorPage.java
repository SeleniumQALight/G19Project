package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SparesEditorPage {

    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with button ";
    final String okInput = " was entered";

    @FindBy(tagName = "select")
    WebElement ddTypeOfSpares;

    //@FindBy(id = "spares_spareType")
    //WebElement ddTypeOfSpares;



    public SparesEditorPage(WebDriver externalDriver){
        this.driver=externalDriver;
        logger=Logger.getLogger(getClass());
    }

    /**
     * Method works with dropdown
     * @param textInDD text in dropdown
     */
    public void selectValueOnDdTypeOfSpares(String textInDD){
        try {
            Select select = new Select(ddTypeOfSpares);
            select.selectByVisibleText(textInDD);
            logger.info(textInDD + " was selected in DD");
        }catch (Exception e){
            logger.error(errorInput+textInDD);
            Assert.fail(errorInput+textInDD);
        }
    }

    /**
     * Method works more fast
     * @param valueInDD - value
     */
    public void selectValueOnDdTypeOfSparesByValue(String valueInDD){
        try {
            //Select select = new Select(ddTypeOfSpares);
            Select select = new Select(driver.findElement(By.id("spares_spareType")));
            select.selectByValue(valueInDD);
            logger.info(valueInDD + " was selected in DD");

        }catch (Exception e) {
            logger.error(errorInput + valueInDD);
            Assert.fail(errorInput + valueInDD);
        }
    }

    /**
     * Mthod enters spare part name
     * @param sparePartName - spar part name
     */
    public void enterSparePartName(String sparePartName){
        try {
            driver.findElement(By.id("spares_spareName")).clear();
            driver.findElement(By.id("spares_spareName")).sendKeys(sparePartName);
            logger.info(sparePartName + okInput);
        }catch (Exception e){
            logger.error(errorInput + sparePartName);
            Assert.fail(errorInput + sparePartName);
        }
    }

    /**
     * Method clicks on button Create
     */
    public void clickONButtonAdd(){
        try {
            driver.findElement(By.name("add")).click();
            logger.info("Buton Create was clicked");
        }catch (Exception e){
            logger.error(errorButton + "Create");
            Assert.fail(errorButton + "Create");
        }
    }

    public void clickOnDd(){
        try {
            driver.findElement(By.id("spares_spareType")).click();
            logger.info("DD was clicked");
        }catch (Exception e){
            logger.error("Can't work with DD");
            Assert.fail("Can't work with DD");
        }
    }
}
