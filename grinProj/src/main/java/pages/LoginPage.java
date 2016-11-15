package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by kateryna.hryn on 15.11.2016.
 */
public class LoginPage {

    WebDriver driver;
    Logger logger;

    final String errorInput = "Cannot work with input";
    final String errorButton = "Cannot work with button";

    @FindBy(name = "_username")
    WebElement inputUsername;

    @FindBy(name = "_password")
    WebElement inputPassword;

    @FindBy(tagName = "button")
    WebElement button;

    @FindBy(className = "login-box-body")
    WebElement loginForm;

    public LoginPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }


    /**
     * Method open browser and login page
     */
    public void openBrowserAndLoginPage() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("http://v3.test.itpmgroup.com/");
            logger.info("Page Login was opened");
        } catch (Exception e) {
            logger.error("Cannot work with browser");
            Assert.fail("Cannot work with browser");
        }
    }

    /**
     * Method Enters user Name
     *
     * @param userName
     */
    public void enterUsername(String userName) {
        try {
            WebElement inputUserName;
            inputUsername.clear();
            inputUsername.sendKeys(userName);
            logger.info(userName + "was entered");

        } catch (Exception e) {
            logger.error(errorInput + "UserName");
            Assert.fail(errorInput + "UserName");
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
            return loginForm.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void closeLoginPageAndBrowser() {
        driver.quit();
        logger.info("Page Login and Browser were closed");
    }
}
