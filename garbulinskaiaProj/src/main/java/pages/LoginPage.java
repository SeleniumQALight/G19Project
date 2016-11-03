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
    final String errorInput = "Can not work with input UserName ";
    final String errorButton = "Can not work with button ";
    final String errorLink= "Can not work with link";


    @FindBy (name= "_username")
    WebElement inputUserName;

    @FindBy(name= "_password")
    WebElement inputPassWord;

    @FindBy(tagName = "button")
    WebElement button;

    @FindBy (className = "login-box-body")
    WebElement loginForm;

    public LoginPage(WebDriver exterDriver) {
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
            driver.get("http://v3.test.itpmgroup.com/login");
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
     * Method enters User Name
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

    public void clickRegisterLink() {
        try{
            driver.findElement(By.xpath(".//*[@href='/']")).getAttribute("onclick");
            logger.info("Link was clicked");

        }catch (Exception e){
            logger.error(errorLink+ " RegisterLink");
            Assert.fail(errorLink+ " RegisterLink");
        }
    }


    /**
     * Method check if login form present
     * @return
     */
    public boolean isFormLoginPresent(){
        try{
           return loginForm.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Method opens login page with Login and Pass
     * and click button Vhod
     * @param login
     * @param pass
     */
    public void LogOn(String login, String pass){
        openBrowserAndLoginPage();
        enterUserName(login);
        enterPassWord(pass);
        clickButtonVhod();
    }
}
