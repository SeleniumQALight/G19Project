package pages;


import libs.ConfigData;
import org.apache.log4j.Logger;
import org.jboss.netty.channel.ExceptionEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    Logger logger;
    WebDriverWait webDriverWait;

    final String errorInput = "Cannot work with input  ";
    final String errorButton = "Cannot work with button  ";

    @FindBy(name = "_username")
    WebElement inputUserName;

    @FindBy(name = "_password")
    WebElement inputPassWord;

    @FindBy(tagName = "button")
    WebElement button;

    @FindBy(className = "login-box-body")
    WebElement loginForm;

    public LoginPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 30);
    }

    /**
     * Method open browser and Login Page
     */
    public void openBrowserAndLoginPage() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get(ConfigData.getCfgValue("BASE_URL")+"/login");
            logger.info("Page Login was opened");
        } catch (Exception e) {
            logger.error("Cannot work with browser");
            Assert.fail("Cannot work with browser");
        }
    }

    /**
     * Method closes Login Page and Browser
     */
    public void closeLoginPageAndBrowser() {
        driver.quit();
        logger.info("Page Login and Browser were closed");
    }

    /**
     * Method Enters user Name
     *
     * @param userName
     */
    public void enterUsername(String userName) {
        try {
            inputUserName.clear();
            inputUserName.sendKeys(userName);
            logger.info(userName + "was entered");

        } catch (Exception e) {
            logger.error(errorInput + "UserName");
            Assert.fail(errorInput + "UserName");
        }
    }

    /**
     * Method enters password
     *
     * @param pass
     */
    public void enterPassWord(String pass) {
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("_password")));
            driver.findElement(By.name("_password")).clear();
            inputPassWord.sendKeys(pass);
            logger.info(pass + "pass was entered");
        } catch (Exception e) {
            logger.error(errorInput + "PassWord");
            Assert.fail(errorInput + "PassWord");
        }
    }

    public void clickButtonVhod() {
        try {
            button.click();
            logger.info("Button vhod was clicked");
        } catch (Exception e) {
            logger.error(errorButton + "Vhod");
            Assert.fail(errorButton + "Vhod");
        }
    }

    public boolean isFormLoginPresent() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-box-body")));
//            webDriverWait.until(ExpectedConditions.not(ExpectedConditions.invisibilityOfAllElements()));
            return loginForm.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method opens LoginPage with Login and Pass
     * and click button Vhod
     *
     * @param login
     * @param pass
     */
    public void logOn(String login, String pass) {
        openBrowserAndLoginPage();
        enterUsername(login);
        enterPassWord(pass);
        clickButtonVhod();
    }

    public HomePage clickButtonVhodWithNewPage() {
        try {
            button.click();
            logger.info("Button vhod was clicked");
        } catch (Exception e) {
            logger.error(errorButton + "Vhod");
            Assert.fail(errorButton + "Vhod");


    }
        return new HomePage(driver);

}}

