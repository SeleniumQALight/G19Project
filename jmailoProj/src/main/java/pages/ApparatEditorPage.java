package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApparatEditorPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with button ";
    final String okInput = " was entered";

    public ApparatEditorPage(WebDriver externalDriver){
        this.driver=externalDriver;
        logger=Logger.getLogger(getClass());
    }

    /**
     * Method checks Apparat edit page presence
     */
    public void isApparatEditirPagePresent(){
        try{
            driver.findElement(By.xpath(".//h3[text()='Редактирование ']")).isDisplayed();
            logger.info("Apparat editor page was opened");
        }catch (Exception e){
            logger.error("Can't work with Apparat editor page");
            Assert.fail("Can't work with Apparat editor page");
        }
    }

    /**
     * Method enters number
     * @param apparatNumber - number
     */
    public  void enterApparatNumber(String apparatNumber){
        try{
            driver.findElement(By.id("apparat_apparatNumber")).clear();
            driver.findElement(By.id("apparat_apparatNumber")).sendKeys(apparatNumber);
            logger.info(apparatNumber + okInput);
        }catch (Exception e){
            logger.error(errorInput + apparatNumber);
            Assert.fail(errorInput + apparatNumber);
        }
    }

    /**
     * Method enters comment
     * @param apparatComment - text comment
     */
    public void enterApparatComment(String apparatComment){
        try{
            driver.findElement(By.id("apparat_apparatComment")).clear();
            driver.findElement(By.id("apparat_apparatComment")).sendKeys(apparatComment);
            logger.info(apparatComment + okInput);
        }catch (Exception e){
            logger.error(errorInput + apparatComment);
            Assert.fail(errorInput + apparatComment);
        }
    }

    /**
     * Method clicks on Button Create
     */
    public void clickOnButtonAdd(){
        try {
            driver.findElement(By.name("add")).click();
            logger.info("Buton Create was clicked");
        }catch (Exception e){
            logger.error(errorButton + "Create");
            Assert.fail(errorButton + "Create");
        }
    }
}
