package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ServiceEdit {
    WebDriver driver;
    Logger logger;
    final String errorMenu = "Can't work with element menu ";
    final String errorInput = "Can't work with input ";
    final String errorButton = "Can't work with button ";
    final String errorDD = "Can't work with drop down ";
    final String errorField = "Can't work with field";

    @FindBy(id = "service_apparat_serviceChanges")
    WebElement inputServiceChanges;

    @FindBy(id = "service_apparat_serviceOperations")
    WebElement inputServiceOperations;

    @FindBy(id = "service_apparat_serviceDate_date_day")
    WebElement ddServceDateDay;

    @FindBy(id = "service_apparat_serviceDate_date_month")
    WebElement ddServiceDateMonth;

    @FindBy(id = "service_apparat_serviceDate_date_year")
    WebElement ddServceDateYear;

    @FindBy(id = "service_apparat_serviceDate_time_hour")
    WebElement ddServiceTimeHour;

    @FindBy(id = "service_apparat_serviceDate_time_minute")
    WebElement ddServiceDateMinute;

    @FindBy(id = "service_apparat_apparat")
    WebElement ddServiceApparat;

    @FindBy(id = "service_apparat_worker")
    WebElement ddServiceWorker;

    @FindBy(name = "add")
    WebElement buttonCreate;

    @FindBy (name = "save")
    WebElement buttonSave;

    @FindBy (name = "delete")
    WebElement buttonDelete;


    public ServiceEdit(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }


    public void inputValueServiceChanges(String serviceChanges) {
        try {
            inputServiceChanges.clear();
            inputServiceChanges.sendKeys(serviceChanges);
            logger.info("'" + serviceChanges + "' was inputed in Service Changes");

        } catch (Exception e) {
            logger.error(errorInput + "input Service Changes");
            Assert.fail(errorInput + "input Service Changes");
        }
    }

    public void inputValueServiceOperations(String serviceOperations) {
        try {
            inputServiceOperations.clear();
            inputServiceOperations.sendKeys(serviceOperations);
            logger.info("'" + serviceOperations + "' was input in Service Operations");

        } catch (Exception e) {
            logger.error(errorInput + "input Service Operations");
            Assert.fail(errorInput + "input Service Operations");
        }
    }

    public void selectValueInDDSrerviceDateDayByValue(String valueServiceDateDay) {
        try {
            Select select = new Select(ddServceDateDay);
            select.selectByValue(valueServiceDateDay);
            logger.info("'" + valueServiceDateDay + "' was selected in DD Day");

        } catch (Exception e) {
            logger.error(errorInput + "DD Service Date Day");
            Assert.fail(errorInput + "DD Service Date Day");
        }
    }



    public void selectValueInDDServiceDateMonthByValue(String valueServiceDateMonth) {
        try {
            Select select = new Select(ddServiceDateMonth);
            select.selectByValue(valueServiceDateMonth);
            logger.info("'" + valueServiceDateMonth + "' was selected in DD");

        } catch (Exception e) {
            logger.error(errorDD + "DD Service Date Month");
            Assert.fail(errorDD + "DD Service Date Month");
        }
    }



    public void selectValueInDDServiceDateYearsByValue(String valueServiceDateYear) {
        try {
            waitSomeSec(10);
            Select select = new Select(ddServceDateYear);
            select.selectByValue(valueServiceDateYear);
            logger.info("'" + valueServiceDateYear + "' was selected in DD");

        } catch (Exception e) {
            logger.error(errorInput + "DD Service Date Year");
            Assert.fail(errorInput + "DD Service Date Year");
        }
    }


    public void selectValueInDDServiceTimeHoerByValue(String valueServiceTimeHour) {
        try {
            Select select = new Select(ddServiceTimeHour);
            select.selectByValue(valueServiceTimeHour);
            logger.info(valueServiceTimeHour + " was selected");

        } catch (Exception e) {
            logger.error(errorDD + "DD Time Hour");
            Assert.fail(errorDD + "DD Time Hour");
        }
    }


    public void selectValueInDDServiceTimeMinuteByValue(String valueServiceTimeMinute) {
        try {
            Select select = new Select(ddServiceDateMinute);
            select.selectByValue(valueServiceTimeMinute);
            logger.info("'" + valueServiceTimeMinute + "' was selected in DD");

        } catch (Exception e) {
            logger.error(errorDD + "DD Time Minute");
            Assert.fail(errorDD + "DD Time Minute");
        }
    }

    public void selectValueInDDServiceApparatByValue(String ValueServiceApparat) {
        try {
            Select select = new Select(ddServiceApparat);
            select.selectByValue(ValueServiceApparat);
            logger.info("'" + ValueServiceApparat + "' was selected in DD");
        } catch (Exception e) {
            logger.error(errorDD + "DD Apparat");
            Assert.fail(errorDD + "DD Apparat");
        }
    }

    public void selectValueInDDServiceWorkerByValue(String valueServiceWorker) {
        try {
            Select select = new Select(ddServiceWorker);
            select.selectByValue(valueServiceWorker);
            logger.info("'" + valueServiceWorker + "' was selected in DD");
        } catch (Exception e) {
            logger.error(errorDD + "DD Service Worker");
            Assert.fail(errorDD + "DD Service Worker");
        }
    }

    public void clickButtonCreateNewRecodInService() {
        try {
            buttonCreate.click();
            logger.info("Button 'Create' was clicked");
        } catch (Exception e) {
            logger.error(errorButton + "button 'Create'");
            Assert.fail(errorButton + "button 'Create'");
        }
    }

    public void addNewRecordInService(String serviceChanges, String serviceOperations, String servceDateDay,
                                      String serviceDateMonth, String servceDateYear, String serviceTimeHour,
                                      String serviceDateMinute, String serviceApparat, String serviceWorker) {

        inputValueServiceChanges(serviceChanges);
        inputValueServiceOperations(serviceOperations);
        selectValueInDDSrerviceDateDayByValue(servceDateDay);
        selectValueInDDServiceDateMonthByValue(serviceDateMonth);
        selectValueInDDServiceDateYearsByValue(servceDateYear);
        selectValueInDDServiceTimeHoerByValue(serviceTimeHour);
        selectValueInDDServiceTimeMinuteByValue(serviceDateMinute);
        selectValueInDDServiceApparatByValue(serviceApparat);
        selectValueInDDServiceWorkerByValue(serviceWorker);
        clickButtonCreateNewRecodInService();
    }

    public void editRecordOnServiceValueWorker (String workerFIO){
        try {
            Select select = new Select(ddServiceWorker);
            select.selectByVisibleText(workerFIO);
            logger.info("'" + workerFIO + "' was selected");

        }catch (Exception e){
            logger.error(errorDD + "Worker");
            Assert.fail(errorDD + "Worker");
        }
    }

    public void saveEditRecordOnServiceFieldWorker () {
        try {
            buttonSave.click();
            logger.info("Button 'Save' was cliked");
        }catch (Exception e){
            logger.error(errorButton + "'Save'");
            Assert.fail(errorButton+ "'Save'");
        }
    }

    public void deleteRecordInService (){
        try {
            buttonDelete.click();
            logger.info("Button 'Delete' was clicked");
        }catch (Exception e){
            logger.error(errorButton + "'Delete'");
            Assert.fail(errorButton + "'Delete'");
        }
    }


    private void waitSomeSec(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
