package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by user on 31-Oct-16.
 */
public class DealsPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";
    final String canNotWork = "Can not work with element ";
    final String canNotFind = "Can not find element ";
    final String wasOpened = " Was opened";
    final String wasClicked = " Was clicked";

    public DealsPage (WebDriver exterDraiver) {
        this.driver = exterDraiver;
        logger = Logger.getLogger(getClass());

    }

    public boolean checkDealsPage() {
     try {
         logger.info("If you dont see next message - Can't check the DealsPage, that's meens All Ok");
         return driver.findElement(By.xpath(".//h1[contains(text(),' Сделки')]")).isDisplayed();
     }catch (Exception e){
         logger.fatal("Can't check DealsPage");
         return false;
     }
    }
public void buttonAdd() {
    try {
        driver.findElement(By.xpath(".//*[@class='fa fa-plus']"));
        logger.info("Plus + " + wasClicked);

    }catch (Exception e) {
        logger.error(canNotFind + "Plus + ");
        Assert.fail(canNotFind + "Plus + ");
    }
}
}
