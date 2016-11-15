package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DictionaryServicePage {
    WebDriver driver;
    Logger logger;
    final String errorButton = "Can't work with button ";
    final String errorRecord = "Can't work with recod ";


    @FindBy (xpath = ".//*[@class='btn btn-info btn-sm']")
    WebElement buttonAdd;

    @FindBy (xpath = ".//h1[contains(text(),'Обслуживание')]")
    WebElement titleServicePage;

    @FindBy (xpath = ".//tr[td[text()='3'] and td[text()='test'] " +
            "and td[text()='test'] and td[text()='Петров Петр Петрович'] and td[text()='11.10.2016 06:30']]")
    WebElement newRecordOnService;




    public DictionaryServicePage(WebDriver exterDriver) {

        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }


    /**
     * Metod clicke on button Add
     */

    public void clickAddService() {
        try {
            buttonAdd.click();
            logger.info("Button 'Add' was clicked");

        } catch (Error e) {
            logger.error(errorButton + "Add");
        }

        /**
         * Metod check opening  DictionaryService Page
         */
    }
    public boolean isDictionaryServicePage () {
       try {
            titleServicePage.isDisplayed();
        } catch (Exception e) {
           return false;
        }
        return true;
    }

    /**
     * Metod creating new recod in the table
     * @return
     */
    public boolean isNewValueTable() {
        try {
            newRecordOnService.isDisplayed();
            logger.info("New Value Table was found");
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void clickOnRecordInServiceForEdit (String xpathNewRecordOnSrvicePage){
        try {
            newRecordOnService.click();
            logger.info("'" + xpathNewRecordOnSrvicePage + "' was clicked");
        }catch (Exception e){
            logger.error(errorRecord + " " + newRecordOnService);
            Assert.fail(errorRecord + " " + newRecordOnService);
        }
    }



    private void waitSomeSec (int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
