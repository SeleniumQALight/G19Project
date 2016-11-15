package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AllPages {
    WebDriver driver;

    public LoginPage loginpage;

    public AllPages(WebDriver exterDriver) {
        this.driver = exterDriver;
        loginpage = new LoginPage(driver);
    }


}

