package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class AllPages {
    WebDriver driver;
    Logger logger;
    public LoginPage loginPage;

    public AllPages(WebDriver externalDriver){
        this.driver = externalDriver;
        loginPage = new LoginPage(driver);
    }
}