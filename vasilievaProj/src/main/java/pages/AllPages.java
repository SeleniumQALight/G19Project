package pages;

import org.openqa.selenium.WebDriver;



public class AllPages {
    WebDriver driver;
    public LoginPage loginPage;
    public MainPage mainPage;
    public AddWorkerPage addWorkerPage;


    public AllPages (WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        addWorkerPage = new AddWorkerPage(driver);
    }
}
