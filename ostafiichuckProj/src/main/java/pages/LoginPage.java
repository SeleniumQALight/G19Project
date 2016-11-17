package pages;


import org.apache.log4j.Logger;
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
    final String errorInput = "Cannot work with input ";
    final String errorButton = "Cannot work button ";

    @FindBy(name = "_username")
    WebElement inputUserName;

    @FindBy(tagName = "button")
    WebElement button;


    @FindBy(className = "login-box-body")
    WebElement loginForm;

    @FindBy(name = "_password")
    WebElement inputPassword;



    public LoginPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 30);

    }

    /**
     * Method open browser and login page
     */
    public void openBrowserAndLoginPage()

    {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get("http://v3.test.itpmgroup.com/login");
            logger.info("Page Login was opened");


        } catch (Exception e) {
            logger.error("Cannot work with browser");
            Assert.fail("Cannot work with browser");
        }
    }

    /**
     * Method closes Page Login and browser
     */
    public void closeLoginPageAndBrowser() {
        driver.quit();
        logger.info("Page Login and browser were closed");
    }

    /**
     * Method enteres UserName
     *
     * @param userName
     */
    public void enterUserName(String userName) {
        try {
            inputUserName.clear();
            inputUserName.sendKeys(userName);
            //driver.findElement(By.name("_username")).clear();
            //driver.findElement(By.name("_username")).sendKeys(userName);
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
    public void enterPassword(String pass) {
        try {

            inputPassword.clear();
            inputPassword.sendKeys(pass);

            //driver.findElement(By.name("_password")).clear();
            //driver.findElement(By.name("_password")).sendKeys(pass);

            logger.info(pass + "was entered");


        } catch (Exception e) {
            logger.error(errorInput + "Password");
            Assert.fail(errorInput + "Password");
        }
    }

    /**
     * Method click on button
     */
    public void clickButtonVhod() {
        try {

            button.click();
            //driver.findElement(By.tagName("button")).click();
            logger.info("Button Vhod was clicked");

        } catch (Exception e) {
            logger.error(errorButton + "Vhod");
            Assert.fail(errorButton + "Vhod");
        }
    }

    public HomePage clickButtonVhodWithNewPage() {
        try {

            button.click();
            //driver.findElement(By.tagName("button")).click();
            logger.info("Button Vhod was clicked");

        } catch (Exception e) {
            logger.error(errorButton + "Vhod");
            Assert.fail(errorButton + "Vhod");
        }
        return new HomePage(driver);
    }

    public boolean isFormLoginPresent() {
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("login-box-body")));
            return loginForm.isDisplayed();

            //return driver.findElement(By.className("login-box-body")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method openes LoginPage with Login and Pass and click button vhod
     */
    public void LogOn(String login, String pass) {
        openBrowserAndLoginPage();
        enterUserName(login);
        enterPassword(pass);
        clickButtonVhod();

    }


}
