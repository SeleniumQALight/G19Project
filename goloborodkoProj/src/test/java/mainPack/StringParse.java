package mainPack;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AllPages;

import java.util.Arrays;
import java.util.Collection;

public class StringParse {
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void setUp() {
        String ts = "<ACCOUNTINFO AccountID='111034485' HomeCurrency='EUR' Credit='0.00' />";
        for (int i = 0; i < ts.split(" ").length; i++) {
            logger.info(ts.split(" ")[i]);
        }
    }

    @After
    public void tearDown() {

    }

}
