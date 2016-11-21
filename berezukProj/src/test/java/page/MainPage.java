package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alina on 21.11.2016.
 */
public class MainPage extends AbstractPage {

    final static Logger logger = LogManager.getLogger(MainPage.class);

    public MainPage (WebDriver driver, boolean externalConfigSource) {
        super(driver, externalConfigSource);
    }

    @Override
    protected void init () {

        pageElements.put(MainPageElement.MAIN_PAGE_DISPLAYED  ,By.className("box-title"));
        pageElements.put(MainPageElement.MAIN_PAGE_LEFT_MENU_ITEMS
                                , By.xpath("//section[@class='sidebar']//ul[@class='sidebar-menu']/li//span"));

    };

    @Override
    public boolean isThere () {
        return isPageVisible(MainPageElement.MAIN_PAGE_DISPLAYED);
    }

    public List<String> getLeftMenuItems () {
        List<WebElement> menuItems = driver.findElements(pageElements.get(MainPageElement.MAIN_PAGE_LEFT_MENU_ITEMS));
        List<String> result = new ArrayList<String>();
        logger.info("Found menu items:");
        for (WebElement we : menuItems) {
            logger.info("\t\t" + we.getText());
            result.add(we.getText());
        }
        logger.info("Total: " + menuItems.size());
        return result;
    }
}
