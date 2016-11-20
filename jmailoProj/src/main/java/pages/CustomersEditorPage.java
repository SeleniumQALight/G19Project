package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CustomersEditorPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with button ";
    final String okInput = " was entered";



    public CustomersEditorPage(WebDriver externalDriver){
        this.driver = externalDriver;
        logger=Logger.getLogger(getClass());
    }

    /**
     * Method checks if service editor page is opened
     */
    public void isCustomersEditorPageOpened(){
        try {
            driver.findElement(By.xpath(".//h3[text()='Редактирование ']")).isDisplayed();
            logger.info("Customers editor page was opened");
        }catch (Exception e){
            logger.error("Can't work with Customers editor page");
            Assert.fail("Can't work with Customers editor page");
        }
    }

    /**
     * Method enters customer name
     * @param customerName - name of customer
     */
    public void enterCustomerName(String customerName){
        try {
            driver.findElement(By.id("prov_cus_proCustName")).clear();
            driver.findElement(By.id("prov_cus_proCustName")).sendKeys(customerName);
            logger.info(customerName+okInput);
        }catch (Exception e){
            logger.error(errorInput+customerName);
            Assert.fail(errorInput+customerName);
        }
    }

    /**
     * Method enters customer address
     * @param customerAddress - address of customer
     */
    public void enterCustomerAddress(String customerAddress){
        try{
            driver.findElement(By.id("prov_cus_proCustAddress")).clear();
            driver.findElement(By.id("prov_cus_proCustAddress")).sendKeys(customerAddress);
            logger.info(customerAddress+okInput);
        }catch (Exception e){
            logger.error(errorInput+customerAddress);
            Assert.fail(errorInput+customerAddress);
        }
    }

    /**
     * Method enters customer phone
     * @param customerPhone - phone of customer
     */
    public void enterCustomerPhone(String customerPhone){
        try{
            driver.findElement(By.id("prov_cus_proCustPhone")).clear();
            driver.findElement(By.id("prov_cus_proCustPhone")).sendKeys(customerPhone);
            logger.info(customerPhone+okInput);
        }catch (Exception e){
            logger.error(errorInput+customerPhone);
            Assert.fail(errorInput+customerPhone);
        }
    }

    public void clickOnCheckbox(){
        try {
            driver.findElement(By.id("prov_cus_proCustIsFl")).click();
            logger.info("Checkbox was marked");
        }catch (Exception e){
            logger.error("Can't work with checkbox");
            Assert.fail("Can't work with checkbox");
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
