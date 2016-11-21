package mainPack;

import mainPack.data.MainPageTestConstants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import page.MainPage;

import java.util.List;

/**
 * Created by Alina on 21.11.2016.
 */
public class MainPageTest extends AbstractTest {

    final static Logger logger = LogManager.getLogger(MainPageTest.class);
    MainPage mainPage = null;

    public MainPageTest() {
        super(true);
        Configurator.setRootLevel(Level.DEBUG);
        mainPage = new MainPage (driver, false);
    }

    @Test
    public void checkLeftMenutItems () {
        List<String> menuItems = mainPage.getLeftMenuItems();
        Assert.assertEquals (MainPageTestConstants.LEFT_MENU_ITEMS_SIZE, menuItems.size());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
