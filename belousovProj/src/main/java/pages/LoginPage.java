package pages;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by SBeast on 10/27/2016.
 */
public class LoginPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";

    public LoginPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());

    }

    /**
     * Method open  browser  and login page
     */
    public void openBrowserAndLoginPage() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("http://v3.test.itpmgroup.com/login");
            logger.info("Page login was opened");

        } catch (Exception e) {
            logger.error(errorInput + "browser");
            Assert.fail(errorInput + "browser");
        }
    }

    /**
     * Method closes login page & browser
     */
    public void clouseLoginPageAndBrowser() {
        driver.quit();
        logger.info("Page Login and browser were cloused");
    }

    /**
     * Method enters UserName
     *
     * @param userName
     */
    public void enterUserName(String userName) {
        try {
            driver.findElement(By.xpath(".//input[@name='_username']")).clear();
            driver.findElement(By.xpath(".//input[@name='_username']")).sendKeys(userName);
            logger.info(userName + " was entered");

        } catch (Exception e) {
            logger.error(errorInput + "UserName");
            Assert.fail(errorInput + "UserName");
        }
    }

    /**
     * Method enter Password
     *
     * @param pass
     */
    public void enterUserPassword(String pass) {
        try {
            driver.findElement(By.name("_password")).clear();
            driver.findElement(By.name("_password")).sendKeys(pass);
            logger.info(pass + "was entered");

        } catch (Exception e) {
            logger.error(errorInput + "Password");
            Assert.fail(errorInput + "Password");
        }
    }

    /**
     * Methjd click on button
     */
    public void clickButtonVhod() {
        try {
            driver.findElement(By.tagName("button")).click();
            logger.info("Button Vhod was clicked");

        } catch (Exception e) {
            logger.error(errorButton + " Vhod");
            Assert.fail(errorButton + " Vhod");
        }
    }

    public boolean isFormLoginPresent() {
        try {
            return driver.findElement(By.className("login-box-body")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

