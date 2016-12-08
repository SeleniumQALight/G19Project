package pages;

import org.openqa.selenium.WebDriver;

public class AllPages {
    public LoginPage loginPage;
    public MainPage mainPage;

    public AllPages(WebDriver exterDriver) {
        loginPage = new LoginPage(exterDriver);
        mainPage = new MainPage(exterDriver);

    }
}
