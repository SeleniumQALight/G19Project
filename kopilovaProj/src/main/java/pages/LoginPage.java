package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with button ";

    @FindBy(name = "_username")
    WebElement inputUserName;

    @FindBy(name = "_password")
    WebElement inputUserPassword;

    @FindBy (tagName = "button")
    WebElement button;

    @FindBy (className =  "login-box-body")
    WebElement loginForm;

    public LoginPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);

    }

    /**
     * Metod open browser and Login Page
     */
    public void openBroweserAndLoginPage() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("http://v3.test.itpmgroup.com/login");
            logger.info("Page Login was opend");
        } catch (Exception e) {
            logger.error("Can not work with browser");
            Assert.fail("Can not work with browser");
        }
    }

    /**
     * Metod close Login Page And Browser
     */
    public void closeLoginPegeAndBrowser() {
        driver.quit();
        logger.info("Page Login and Browser were closed");
    }

    /**
     * Metod enters User Name
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
     * Metod enter password
     *
     * @param pass
     */
    public void enterPassWord(String pass) {
        try {
            inputUserPassword.clear();
            inputUserPassword.sendKeys(pass);
            logger.info(pass + " was entered");
        } catch (Exception e) {
            logger.error(errorInput + "PassWord");
            Assert.fail(errorInput + "PassWord");
        }
    }

    /**
     * Metod click on buttton
     */
    public void clickButtonVhod() {
        try {
            button.click();
            logger.info("Button was clicked");
        } catch (Exception e) {
            logger.error(errorButton + "'Vhod'");
            Assert.fail(errorButton + "'Vhod'");
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
     * @param login
     * @param pass
     */
    public void LogOn(String login, String pass) {
        openBroweserAndLoginPage();
        enterUserName(login);
        enterPassWord(pass);
        clickButtonVhod();
    }

}

