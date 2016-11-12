package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by user on 31-Oct-16.
 */
public class DealsPageEdit {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";
    final String canNotWork = "Can not work with element ";
    final String canNotFind = "Can not find element ";
    final String wasOpened = " Was opened";
    final String wasClicked = " Was clicked";
    final String wasEntered = " Was entered";

    public DealsPageEdit(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
    }
/**
 * Check the page is DealsEditPage
 */
//    public boolean checkDealsPageEdit() {
//        try {
//
//        } catch (Exception e) {
//            logger.error("Can't check DealsEditPage");
//            return false;
//        }
//    }
}
