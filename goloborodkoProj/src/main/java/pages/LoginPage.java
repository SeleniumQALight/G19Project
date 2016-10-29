package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with button ";
    final String enterSring = " was entered";

    public LoginPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method how to open browser and Login Page
     */
    public void openBrowserAndLoginPage() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://v3.qalight.com.ua/login");
            logger.info("Page Login was opened");

        } catch (Exception e) {
            logger.error(errorInput + "Browser");
            Assert.fail(errorInput + "Browser");
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
            driver.findElement(By.name("_username")).clear();
            driver.findElement(By.name("_username")).sendKeys(userName);
            logger.info(userName + enterSring);
        } catch (Exception e) {
            logger.error(errorInput + "UserName");
            Assert.fail(errorInput + "UserName");
        }
    }

    /**
     * Method how to enter password
     *
     * @param userPass String
     */
    public void enterPassword(String userPass) {
        try {
            driver.findElement(By.name("_password")).clear();
            driver.findElement(By.name("_password")).sendKeys(userPass);
            logger.info("Password" + enterSring);
        } catch (Exception e) {
            logger.error(errorInput + "Password");
            Assert.fail(errorInput + "Password");
        }
    }

    /**
     * Method how to click button
     */
    public void clickButtonVhod() {
        try {
            driver.findElement(By.tagName("button")).click();
            logger.info("Button Vhod was clicked");
        } catch (Exception e) {
            logger.error(errorButton + "Vhod");
            Assert.fail(errorButton + "Vhod");
        }
    }

    /**
     * Method how to check is login and password valid
     * @return boolean
     */
    public boolean isFormLoginPresent() {
        try {
            return driver.findElement(By.className("login-box-body")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
