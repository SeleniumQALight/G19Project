package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.MainPage;

public class EditProvidersPage {
    WebDriver driver;
    Logger logger;

    final String errorInput="can't work with input";
    final String errorButton="can't work with button";

    @FindBy(name = "prov_cus[proCustIsFl]")
    WebElement chBoxPrivatePerson;

    @FindBy(name = "save")
    WebElement btnSave;

    MainPage mainPage = new MainPage(driver);

    public EditProvidersPage(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver,this);
    }

    /**
     * Method checks the checkbox Private Person parameter
     */
    public void checkInPrivatePerson(){
        try{mainPage.waitSomeSec(1);
            if (chBoxPrivatePerson.isSelected()){
                logger.info("Private person was already checked");
            }else{ chBoxPrivatePerson.click();
                logger.info("Private person was checked");
            }
        }catch (Exception e){
            logger.error("can't work with checkbox");
            Assert.fail("can't work with checkbox");
        }
    }

    /**
     * Method clicks 'Save' button
     */
    public void clickSaveProvider(){
        try{
            btnSave.click();
            logger.info("buton 'Save' was clicked");
        }catch (Exception e){
            logger.error(errorButton);
            Assert.fail(errorButton);
        }
    }

}
