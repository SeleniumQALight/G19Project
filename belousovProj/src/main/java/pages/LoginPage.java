package pages;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by SBeast on 10/27/2016.
 */
public class LoginPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with Button ";

    @FindBy(xpath = ".//input[@name='_username']")
    WebElement inputUserName;
    @FindBy(xpath = ".//input[@id='password']")
    WebElement inputPassword;
    @FindBy(tagName = "button")
    WebElement buttonVhod;
    @FindBy(className = "login-box-body")
    WebElement loginForm;

    public LoginPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
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
            inputUserName.clear();
            inputUserName.sendKeys(userName);
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
            inputPassword.clear();
            inputPassword.sendKeys(pass);
            logger.info(pass + " was entered");

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
            buttonVhod.click();
            logger.info("Button Vhod was clicked");

        } catch (Exception e) {
            logger.error(errorButton + " Vhod");
            Assert.fail(errorButton + " Vhod");

        }
    }

    public boolean isFormLoginPresent() {
        try {
            return loginForm.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * method open login page enter logi enter password
     *
     * @param loginNameForLoginPage
     * @param passwordForLoginPage
     */
    public void logOn(String loginNameForLoginPage, String passwordForLoginPage) {
        openBrowserAndLoginPage();
        enterUserName(loginNameForLoginPage);
        enterUserPassword(passwordForLoginPage);
        clickButtonVhod();
    }
}

