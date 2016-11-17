package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by SBeast on 11/15/2016.
 */
public class AllPages {
    WebDriver driver;
    public LoginPage loginPage;
    public MainPage mainPage;
    public AllPages(WebDriver exterDriver){
        this.driver = exterDriver;
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }
}
