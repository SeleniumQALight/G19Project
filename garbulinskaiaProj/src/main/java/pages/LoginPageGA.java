package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPageGA {

    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input emailLogin ";
    final String errorButton = "Can not work with button ";
    final String errorForgotPass = "Can not work with Forgot password";
    final String errorLogo = "Can not work with Logo";

    @FindBy(id = "emailLogin")
    WebElement inputEmailLogin;

    @FindBy(id = "password")
    WebElement inputPassWord;

    @FindBy(xpath = ".//input[@value='Login >>']")
    WebElement button;

    @FindBy(id = "emailloginreset")
    WebElement forgotPassEmail;

    @FindBy(id = "checkagreement")
    WebElement checkbox;

    @FindBy(xpath = ".//*[@href=\"http://greatagentusa.com/\"]")
    WebElement logo;

    public LoginPageGA(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    /**
     * Method open browser and Login Page
     */
    public void openBrowserAndLoginPage() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            driver.get("http://greatagentusa.com/login/");
            logger.info("Page Login was opened");
        } catch (Exception e) {
            logger.error("Can not work with browser");
            Assert.fail("Can not work with browser");
        }
    }

    /**
     * Method closes Login page and Browser
     */
    public void closeLoginPageAndBrowser() {
        driver.quit();
        logger.info("Page Login and Browser were closed");
    }

    /**
     * Method enters emailLogin
     *
     * @param emailLogin
     */
    public void enterEmailLogin(String emailLogin) {
        try {
            inputEmailLogin.clear();
            inputEmailLogin.sendKeys(emailLogin);
            logger.info(emailLogin + " was entered");
        } catch (Exception e) {
            logger.error(errorInput + "emailLogin");
            Assert.fail(errorInput + "emailLogin");
        }
    }

    /**
     * Method enter password
     *
     * @param pass
     */
    public void enterPassWord(String pass) {
        try {
            inputPassWord.clear();
            inputPassWord.sendKeys(pass);
            logger.info(pass + " was entered");
        } catch (Exception e) {
            logger.error(errorInput + "PassWord");
            Assert.fail(errorInput + "PassWord");
        }
    }

    /**
     * Method clicks checkbox
     */
    public void clickCheckbox() {
        try {
            checkbox.isSelected();
            logger.info("Checkbox was already checked");
        } catch (Exception e) {
            checkbox.click();
            logger.info("We clicked checkbox");
        }
    }

    /**
     * Method click on button
     */
    public void clickButtonVhod() {
        try {
            button.click();
            logger.info("Button was clicked");
        } catch (Exception e) {
            logger.error(errorButton + " Vhod");
            Assert.fail(errorButton + " Vhod");
        }
    }

    public void clickOnLogo() {
        try {
            logo.click();
            logger.info("Logo was clicked");
        } catch (Exception e) {
            logger.error(errorLogo+" Logo");
            Assert.fail(errorLogo+" Logo");
        }
    }


    /**
     * Method check if forgot password form present
     *
     * @return
     */
    public boolean isFormForgotPassPresent() {
        try {
            return forgotPassEmail.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method opens login page with Login and Pass
     * and click button Vhod
     *
     * @param emailLogin
     * @param pass
     */
    public void LogOn(String emailLogin, String pass) {
        openBrowserAndLoginPage();
        enterEmailLogin(emailLogin);
        enterPassWord(pass);
        clickCheckbox();
        clickButtonVhod();
    }

    /**
     * Method clicks Forgot password
     */
    public void clickForgotPass() {
        try {
            driver.findElement(By.xpath(".//*[contains(text(),'Forgot your password')]")).click();
            logger.info("Forgot password was clicked");

        } catch (Exception e) {
            logger.error(errorForgotPass + " ForgotPass");
            Assert.fail(errorForgotPass + " ForgotPass");
        }
    }
}
