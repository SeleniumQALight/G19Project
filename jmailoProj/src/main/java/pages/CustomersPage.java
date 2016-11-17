package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomersPage {
    WebDriver driver;
    Logger logger;
    final String okInput = "Record was added: ";

    public CustomersPage(WebDriver externalDriver){
        this.driver=externalDriver;
        logger=Logger.getLogger(getClass());
    }

    /**
     * Method checks if service age is opened
     */
    public void isCustomersPageOpened(){
        try {
            driver.findElement(By.xpath(".//h1[contains(text(),'Стороны сделок')]")).isDisplayed();
            driver.findElement(By.xpath(".//h3[(text()='Список контрагентов')]")).isDisplayed();
            logger.info("Customers page was opened");
        }catch (Exception e){
            logger.error("Can't work with Customers page");
            Assert.fail("Can't work with Customers page");
        }
    }

    /**
     * Method clicks on Add(+) button
     */
    public void clickOnPlusButton(){
        try {
            driver.findElement(By.xpath(".//a[@href='http://v3.test.itpmgroup.com/dictionary/providers/edit']")).click();
            logger.info("Button + was clicked");
        }catch (Exception e){
            logger.error("Can't work with Add(+) button");
            Assert.fail("Can't work with Add(+) button");
        }
    }

    /**
     * Method checks newly added record
     * @param serviceRecord - record
     */
    public void checkRecord(String serviceRecord){
        try {
            driver.findElement(By.xpath(".//td[text()='"+serviceRecord+"']")).isDisplayed();
            //driver.findElement(By.xpath(".//td[contains(text()='Maintenance')]")).isDisplayed();
            //driver.findElement(By.xpath(".//*[@id='device_list']/tbody/tr/td[text()="+serviceRecord+"]")).isDisplayed();
            logger.info(okInput+serviceRecord);
        }catch (Exception e){
            logger.error("Can't find record: " + serviceRecord);
            Assert.fail("Can't find record: " + serviceRecord);
        }
    }
}

