package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ServiceEditorPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with button ";
    final String okInput = " was entered";
    final String okSelect = " was selected in DD";
    final String errorSelect = "Can not work with select ";

    @FindBy(id = "service_apparat_serviceDate_date_day")
    WebElement ddServiceDateDay;

    @FindBy(id = "service_apparat_serviceDate_date_month")
    WebElement ddServiceDateMonth;

    @FindBy(id ="service_apparat_serviceDate_date_year")
    WebElement ddServiceDateYear;

    @FindBy(id ="service_apparat_serviceDate_time_hour")
    WebElement ddServiceDateHour;

    @FindBy(id ="'service_apparat_serviceDate_time_minute")
    WebElement ddServiceDateMinute;

    @FindBy(id ="service_apparat_apparat")
    WebElement ddApparat;

    @FindBy(id ="service_apparat_worker")
    WebElement ddWorker;


    public ServiceEditorPage(WebDriver externalDriver){
        this.driver = externalDriver;
        logger=Logger.getLogger(getClass());
        PageFactory.initElements(driver,this);
    }

    /**
     * Method checks if service editor page is opened
     */
    public void isServiceEditorPageOpened(){
        try {
            driver.findElement(By.xpath(".//h3[text()='Редактирование ']")).isDisplayed();
            logger.info("Service editor page was opened");
        }catch (Exception e){
            logger.error("Can't work with Service editor page");
            Assert.fail("Can't work with Service editor page");
        }
    }

    /**
     * Method enters service changes
     * @param serviceChanges - name of service changes
     */
    public void enterServiceChanges(String serviceChanges){
        try {
            driver.findElement(By.id("service_apparat_serviceChanges")).clear();
            driver.findElement(By.id("service_apparat_serviceChanges")).sendKeys(serviceChanges);
            logger.info(serviceChanges+okInput);
        }catch (Exception e){
            logger.error(errorInput+serviceChanges);
            Assert.fail(errorInput+serviceChanges);
        }
    }

    /**
     * Method enters service operations
     * @param serviceOperations - name of service operation
     */
    public void enterServiceOperations(String serviceOperations){
        try{
            driver.findElement(By.id("service_apparat_serviceOperations")).clear();
            driver.findElement(By.id("service_apparat_serviceOperations")).sendKeys(serviceOperations);
            logger.info(serviceOperations+okInput);
        }catch (Exception e){
            logger.error(errorInput+serviceOperations);
            Assert.fail(errorInput+serviceOperations);
        }
    }

    /**
     * Method selects day in dropdown
     * @param day - day
     */
    public void selectServiceDateDayInDd(String day){
        try {
            Select select = new Select(ddServiceDateDay);
            //Select select = new Select(driver.findElement(By.id("service_apparat_serviceDate_date_day")));
            select.selectByValue(day);
            logger.info(day + okSelect);

        }catch (Exception e){
            logger.error(errorSelect + day);
            Assert.fail(errorSelect + day);
        }
    }

    /**
     * Method selects month in dropdown
     * @param month - month
     */
    public void selectServiceDateMonthInDd(String month){
        try{
            Select select = new Select(ddServiceDateMonth);
            //Select select = new Select(driver.findElement(By.id("service_apparat_serviceDate_date_month")));
            select.selectByValue(month);
            logger.info(month + okSelect);
        }catch (Exception e){
            logger.error(errorSelect + month);
            Assert.fail(errorSelect + month);
        }
    }

    /**
     * Method selects year in dropdown
     * @param year - year
     */
    public void selectServiceDateYearInDd(String year){
        try {
            Select select = new Select(ddServiceDateYear);
            //Select select =     new Select(driver.findElement(By.id("service_apparat_serviceDate_date_year")));
            select.selectByValue(year);
            logger.info(year + okSelect);
        }catch (Exception e){
            logger.error(errorSelect + year);
            Assert.fail(errorSelect + year);
        }
    }

    /**
     * Method selects hour in dropdown
     * @param hour - hour
     */
    public void selectServiceDateHourInDd(String hour){
        try {
            Select select = new Select(ddServiceDateHour);
            //Select select = new Select(driver.findElement(By.id("service_apparat_serviceDate_time_hour")));
            select.selectByValue(hour);
            logger.info(hour + okSelect);
        }catch (Exception e){
            logger.error(errorSelect + hour);
            Assert.fail(errorSelect + hour);
        }
    }

    /**
     * Method selects minute in dropdown
     * @param minute - minute
     */
    public void selectServiceDateMinuteInDd(String minute){
        try {
            Select select = new Select(ddServiceDateMinute);
            //Select select = new Select(driver.findElement(By.id("service_apparat_serviceDate_time_minute")));
            select.selectByValue(minute);
            logger.info(minute + okSelect);
        }catch (Exception e){
            logger.error(errorSelect + minute);
            Assert.fail(errorSelect + minute);
        }
    }

    /**
     * Method selects apparat in dropdown
     * @param apparat - apparat
     */
    public void selectApparatInDd(String apparat){
        try {
            Select select = new Select(ddApparat);
            //Select select =new Select(driver.findElement(By.id("service_apparat_apparat")));
            select.selectByVisibleText(apparat);
            logger.info(apparat + okSelect);
        }catch (Exception e){
            logger.error(errorSelect + apparat);
            Assert.fail(errorSelect + apparat);
        }
    }

    /**
     * Method selects worker in dropdown
     * @param worker - worker
     */
    public void selectWorkerInDd(String worker){
        try {
            Select select = new Select(ddWorker);
            //Select select = new Select(driver.findElement(By.id("service_apparat_worker")));
            select.selectByVisibleText(worker);
            logger.info(worker + okSelect);
        }catch (Exception e){
            logger.error(errorSelect + worker);
            Assert.fail(errorSelect + worker);
        }
    }

    /**
     * Method clicks on button Create
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
