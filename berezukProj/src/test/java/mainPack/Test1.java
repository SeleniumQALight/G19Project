package mainPack;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

    @Test
    public void test1(){

        System.setProperty("webdriver.chrome.driver","C:/browserDrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("test");
    }
}
