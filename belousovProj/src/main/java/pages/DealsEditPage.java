package pages;

import org.apache.log4j.Logger;
//import org.apache.xpath.operations.String;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class DealsEditPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";
    final String canNotWork = "Can not work with element ";
    final String canNotFind = "Can not find element ";
    final String wasOpened = " Was opened";
    final String wasClicked = " Was clicked";
    final String wasEntered = " Was entered";

    @FindBy (xpath = ".//label[contains(text(),'Deal date')]")
    WebElement checkDealsEditPageElement;
    /**
     * DD parameters
     */
    @FindBy (id = "deal_dealDate_date_day")
    WebElement ddDayOfDeal;
    @FindBy (id = "deal_dealDate_date_month")
    WebElement ddMonthOfDeal;
    @FindBy (id = "deal_dealDate_date_year")
    WebElement ddYearOfDeal;
    @FindBy (id = "deal_dealDate_time_hour")
    WebElement ddHourOfDeal;
    @FindBy(id = "deal_dealDate_time_minute")
    WebElement ddMinuteOfDeal;
    @FindBy (id = "deal_dealType")
    WebElement ddTypeOfdeal;
    @FindBy (id = "deal_customer")
    WebElement ddCustomerOfDeal;
    @FindBy (id = "deal_provider")
    WebElement ddProviderOfDeal;

    /**
     *Buttons
     */
    @FindBy (xpath = ".//button[@name='add']")
    WebElement createButton;
    @FindBy (xpath = ".//button[@name='delete']")
    WebElement deleteButon;

    public DealsEditPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }
/**
 * Check the page is DealsEditPage
 */

public boolean checkDealsEditPage() {
    try {
        logger.info("If you dont see next message - Can't check the DealsPage, that's meens All Ok");
        return checkDealsEditPageElement.isDisplayed();
    }catch (Exception e){
        logger.fatal("Can't check DealsPage");
        return false;
    }
}
//        public  void selectDDDayOfDeal(String valueDDDay) {
//            try {
//                Select select = new Select(ddDayOfDeal);
//
//                select.selectByValue(valueDDDay);
//                logger.info(valueDDDay + "was selected in DD");
//
//            } catch (Exception e) {
//                logger.error(canNotWork + "ddDayOfDeal");
//                Assert.fail(canNotWork + "ddDayOfDeal");
//            }
//        }
    public  void selectDDDayOfDeal(String textInDD){
        try {
            Select select = new Select(ddDayOfDeal);
            select.selectByVisibleText(textInDD);
            logger.info(textInDD + "was selected in DD");

        }catch (Exception e){
            logger.error(canNotWork + "DDTupeOfSpears");
            Assert.fail(canNotWork + "DDTupeOfSpears");
        }
    }

            public void selectDDMothOfDeal(String valueDDMonth) {
                try {
                    Select select = new Select(ddMonthOfDeal);

                    select.selectByValue(valueDDMonth);
                    logger.info(valueDDMonth + "was selected in DD");

                } catch (Exception e) {
                    logger.error(canNotWork + ddMonthOfDeal);
                    Assert.fail(canNotWork + ddMonthOfDeal);
                }
            }
            public void selectDDYearOfDeal(String valueDDYearOfDeal) {
                try {
                    Select select = new Select(ddYearOfDeal);

                    select.selectByValue(valueDDYearOfDeal);
                    logger.info(valueDDYearOfDeal + "was selected in DD");

                } catch (Exception e) {
                    logger.error(canNotWork + ddYearOfDeal);
                    Assert.fail(canNotWork + ddYearOfDeal);
                }
            }
            public void selectDDHourOfDeal(String valueDDHourOfDeal) {
                try {
                    Select select = new Select(ddHourOfDeal);

                    select.selectByValue(valueDDHourOfDeal);
                    logger.info(valueDDHourOfDeal + "was selected in DD");

                } catch (Exception e) {
                    logger.error(canNotWork + ddHourOfDeal);
                    Assert.fail(canNotWork + ddHourOfDeal);
                }
            }
            public void selectDDMinuteOfDeal(String valueDDMinuteOfDeal) {
                try {
                    Select select = new Select(ddMinuteOfDeal);

                    select.selectByValue(valueDDMinuteOfDeal);
                    logger.info(valueDDMinuteOfDeal + "was selected in DD");

                } catch (Exception e) {
                    logger.error(canNotWork + ddMinuteOfDeal);
                    Assert.fail(canNotWork + ddMinuteOfDeal);
                }
            }

    /**
     * DD Type of Deal
     * @param valueDDTypeOfdeal
     */
    public void selectDDTypeOfdeal(String valueDDTypeOfdeal){
    try {
        Select select = new Select(ddTypeOfdeal);
        select.selectByVisibleText(valueDDTypeOfdeal);
        logger.info(valueDDTypeOfdeal + "was selected in DD");

    }catch (Exception e){
        logger.error(canNotWork + ddTypeOfdeal);
        Assert.fail(canNotWork + ddTypeOfdeal);
    }
}

    /**
     * DD Customer of Deal
     * @param valueDDCustomerOfDeal
     */
    public void selctDDCustomerOfDeal(String valueDDCustomerOfDeal){
    try {
        Select select = new Select(ddCustomerOfDeal);
        select.selectByVisibleText(valueDDCustomerOfDeal);
        logger.info(valueDDCustomerOfDeal + "was selected in DD");
    }catch (Exception e){
        logger.error(canNotWork + ddCustomerOfDeal);
        Assert.fail(canNotWork + ddCustomerOfDeal);
    }
}

    public void selectDDProviderOfDeal(String valueDDProviderOfDeal){
        try {
            Select select = new Select(ddProviderOfDeal);
            select.selectByVisibleText(valueDDProviderOfDeal);
            logger.info(valueDDProviderOfDeal + "was selected in DD");

        }catch (Exception e){
            logger.error(canNotWork + ddProviderOfDeal);
            Assert.fail(canNotWork + ddProviderOfDeal);
        }
    }

    /**
     * click create button
     */
    public void createButton() {
        try {
            createButton.click();
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
            deleteButon.click();
            logger.info("Button Delete" + wasClicked);
        }catch (Exception e){
            logger.error(canNotFind + "button delete");
            Assert.fail(canNotWork + "button delete");
        }
    }
public void DDDateOfDeal (String valueDDDayOfDeal, String valueDDMonthOfDeal, String valueDDYearOfDeal, String valueDDHourOfDeal, String valueDDMinuteOfDeal)
{
    selectDDDayOfDeal(valueDDDayOfDeal);
    selectDDMothOfDeal(valueDDMonthOfDeal);
    selectDDYearOfDeal(valueDDYearOfDeal);
    selectDDHourOfDeal(valueDDHourOfDeal);
    selectDDMinuteOfDeal(valueDDMinuteOfDeal);
    //createButton();
}

public void  DDParametersOfDeal (String valueDDTypeOfdeal, String  valueDDCustomerOfDeal, String valueDDProviderOfDeal)
{
    selctDDCustomerOfDeal(valueDDCustomerOfDeal);
    selectDDTypeOfdeal(valueDDTypeOfdeal);
    selectDDProviderOfDeal(valueDDProviderOfDeal);
    //createButton();
}






}