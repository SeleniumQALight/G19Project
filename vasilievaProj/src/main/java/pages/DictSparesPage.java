package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DictSparesPage {
    WebDriver driver;
    Logger logger;

    final String errorInput="can't work with input";
    final String errorButton="can't work with button";

    @FindBy(xpath = ".//a[@data-original-title='Add']")
    WebElement btnPlus;

    @FindBy(xpath = "")
    WebElement currentSpareInList;

    public DictSparesPage(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver,this);
    }

   public void btnAddSpareClick(){
       try{
           btnPlus.click();
           logger.info("button '+' was clicked");
       }catch (Exception e){
           logger.error(errorButton);
           Assert.fail(errorButton);
       }
   }

   public boolean isSparePresented(String spareName,String spareType){
       try{
           if (driver.findElement(By.xpath(".//tr//td[contains(text(),'"+spareName +"')]//..//td[contains(text(),'"+spareType +"')]")).isDisplayed()
                   ){
               logger.info("Spare is presented in list");
               return true;
           }else{
               logger.info("Spare is NOT presented in list");
               return false;
           }
       }catch (Exception e){
           logger.error("can't work with spares list");
           Assert.fail("can't work with spares list");
           return false;
       }
   }

}
