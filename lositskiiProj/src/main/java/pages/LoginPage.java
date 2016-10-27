package pages;


import org.apache.bcel.verifier.exc.AssertionViolatedException;
import org.apache.bcel.verifier.exc.StructuralCodeConstraintException;
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

    public LoginPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method open browser and Login Page
     */

    public void openBrowserAndLoginPage() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("http://v3.test.itpmgroup.com/login");
            logger.info("Page login was opened");


        } catch (Exception e) {
            logger.error("Can not open browser");
            Assert.fail("Can not open browser");
        }


    }

    /**
     * Page Login and Browser were closed
     */
    public void closeLoginPageAndBrowserBrowser() {
        driver.quit();
        logger.info("Page Login and Browser were closed");

    }

    /**
     * Method Press userName in Email
     *
     * @param userName
     */
    public void enterUsername(String userName) {
        try {
            driver.findElement(By.name("_username")).clear();
            driver.findElement(By.name("_username")).sendKeys(userName);
            logger.info(userName + " was entered");
        } catch (Exception e) {
            logger.error(errorInput + " Email");
            Assert.fail(errorInput + " Email");
        }
    }

    /**
     * Method Pres password
     *
     * @param passName
     */
    public void enterPassword(String passName) {
        try {
            driver.findElement(By.name("_password")).clear();
            driver.findElement(By.name("_password")).sendKeys(passName);
            logger.info(passName + "was entered");
        } catch (Exception e) {
            logger.error(errorInput + "Password");
            Assert.fail(errorInput + "Password");
        }
    }

    /**
     * Method button VHOD
     */

    public void clickButtonVhod() {
        try {
            driver.findElement(By.tagName("button")).click();
            logger.info("Button Vhod was click ");

        } catch (Exception e) {
            logger.error(errorButton + " 'Vhod'");
            Assert.fail(errorButton + "'Vhod' ");
        }
    }

    /**
     * Method form login in Present
     *
     * @return
     */
    public boolean isFormLoginInPresent() {
        try {
            return driver.findElement(By.className("login-box-body")).isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }
}
