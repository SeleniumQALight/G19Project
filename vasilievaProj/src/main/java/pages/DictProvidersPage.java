package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DictProvidersPage {
    WebDriver driver;
    Logger logger;

    final String errorInput="can't work with input";
    final String errorButton="can't work with button";

    public DictProvidersPage(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver,this);
    }

    /**
     * Methos get count of records with providers in dictionary list
     * @return
     */
    public int getListProvidersCount(){
        try{

            int count = driver.findElements(By.xpath(".//tbody//tr[contains(@onclick,'providers/edit/')]")).size();
            logger.info("count of providers: " + count);
            return count;
        }catch (Exception e){
            logger.error("can't work with list");
            Assert.fail("can't work with list");
            return -1;
        }
    }

    /**
     * Method click on current provider with iterator-param
     * @param currProviderIter
     */
    public void clickCurrentProvider(int currProviderIter){
     try{
        driver.findElement(By.xpath(".//tr["+currProviderIter+"][contains(@onclick,'/providers/edit')]")).click();
        logger.info("provider " + currProviderIter + " was choosed");
     }catch (Exception e){
         logger.error("can't work with provider record");
         Assert.fail("can't work with provider record");
     }
    }

}
