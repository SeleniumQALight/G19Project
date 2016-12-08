package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Test1 {


    @Test
    public void test1() {

        System.out.println("test 90k ");
        Assert.fail("Fail Test");

    }

    @After
    public void tearDown() {


    }
}
