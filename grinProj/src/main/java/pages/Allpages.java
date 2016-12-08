package pages;


import org.openqa.selenium.WebDriver;

public class Allpages {
    WebDriver driver;
    public LoginPage loginPage;

    public Allpages(WebDriver exterDriver) {
        this.driver = exterDriver;
        loginPage = new LoginPage(driver);
    }
}

