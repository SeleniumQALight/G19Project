package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AllPages {
WebDriver driver;
    public LoginPage loginPage;
    public  HomePage homePage;


    public AllPages(WebDriver exterDriver) {
        this.driver = exterDriver;
        loginPage= new LoginPage(driver);
        homePage= new HomePage(driver);

    }


}
