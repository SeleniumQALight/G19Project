package pages;


import org.openqa.selenium.WebDriver;


public class AllPages {
    WebDriver driver;
    public LoginPage loginPage;

    public AllPages(WebDriver exterDriver) {
        this.driver = exterDriver;
        loginPage = new LoginPage(driver);

    }


}
