package pages;

import libs.ConfigData;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.elements.Messages;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with button ";
    final String enterString = " was entered";

    @FindBy(name = "_username")
    WebElement inputUserName;
    @FindBy(name = "_password")
    WebElement inputUserPassword;
    @FindBy(tagName = "button")
    WebElement buttonEnter;
    @FindBy(className = "_username")
    WebElement loginForm;

    public LoginPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 30);
    }

    /**
     * Method how to open browser and Login Page
     */
    public void openBrowserAndLoginPage() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.get(ConfigData.getCfgValue("BASE_URL")+"/login");
            logger.info("Page Login was opened");
        } catch (Exception e) {
            logger.error(Messages.genErrorMess() + "Browser");
            Assert.fail(Messages.genErrorMess() + "Browser");
        }
    }

    /**
     * Method how to close Login Page and browser
     */
    public void closeLoginPageAndBrowser() {
        driver.quit();
        logger.info("Login page and browser were closed");
    }

    /**
     * Method how to enter UserName
     *
     * @param userName String
     */
    public void enterUserName(String userName) {
        try {
            inputUserName.clear();
            inputUserName.sendKeys(userName);
            logger.info(userName + enterString);
        } catch (Exception e) {
            logger.error(Messages.genErrorMess() + "input 'UserName'");
            Assert.fail(Messages.genErrorMess() + "input 'UserName'");
        }
    }

    /**
     * Method how to enter password
     *
     * @param userPass String
     */
    public void enterPassword(String userPass) {
        try {
            inputUserPassword.clear();
            inputUserPassword.sendKeys(userPass);
            logger.info("Password" + enterString);
        } catch (Exception e) {
            logger.error(Messages.genErrorMess() + "input 'Password'");
            Assert.fail(Messages.genErrorMess() + "input 'Password'");
        }
    }

    /**
     * Method how to click button
     */
    public void clickButtonEnter() {
        try {
            buttonEnter.click();
            logger.info("Button Enter was clicked");
        } catch (Exception e) {
            logger.error(Messages.genErrorMess() + "button 'Enter'");
            Assert.fail(Messages.genErrorMess() + "button 'Enter'");
        }
    }

    /**
     * Method how to check is login and password valid
     *
     * @return boolean
     */
    public boolean isFormLoginPresent() {
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("_username")));
            if (loginForm.isDisplayed()) {
                logger.info("Invalid login or password");
            } else {
                logger.info("Login and password are valid");
            }
            return loginForm.isDisplayed();
        } catch (Exception e) {
            logger.info(Messages.genErrorMess() + "Login Page");
            return false;
        }
    }

    /**
     * Method, which opens login page with login and password, then it clicks button Enter
     *
     * @param login    String
     * @param password String
     */
    public void logOn(String login, String password) {
        openBrowserAndLoginPage();
        enterUserName(login);
        enterPassword(password);
        clickButtonEnter();
    }

    public MainPage clickButtonEnterWithNewPage() {
        try {
            buttonEnter.click();
            logger.info("Button Enter was clicked");
        } catch (Exception e) {
            logger.error(Messages.genErrorMess() + "button 'Enter'");
            Assert.fail(Messages.genErrorMess() + "button 'Enter'");
        }
        return new MainPage(driver);
    }
}
