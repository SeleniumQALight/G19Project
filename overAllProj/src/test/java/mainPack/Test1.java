package mainPack;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test1 {
    WebDriver driver = new ChromeDriver();

    @Test
    public void test1() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qalight.com.ua/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test 3");
        System.out.println("test 80");
        System.out.println("test 90k ");

    }

    @After
    public void tearDown() {
        driver.quit();

    }
}
