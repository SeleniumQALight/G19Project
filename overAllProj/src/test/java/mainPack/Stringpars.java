package mainPack;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Stringpars {
    Logger logger = Logger.getLogger(getClass());
//    WebDriver driver = new ChromeDriver();

    @Test
    public void invalideLogOnWithOutPageObject(){
        String testString = "<ACCOUNTINFO AccountID='111034485' HomeCurrency='EUR' Credit='0.00' />";
         logger.info(testString.split(" ")[1].split("'")[1].substring(3,5).replace("0","1").equals("23"));
    }

    @After
    public void tearDown(){

    }
}
