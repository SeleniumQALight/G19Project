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
    final String errorInput="Can't work with input ";
    final String errorButton="Can't work with button ";
    final String inputText=" was entered";

    @FindBy(name="_username")
    WebElement inputUserName;

    @FindBy(name="_password")
    WebElement inputUserPassWord;

    @FindBy (tagName = "button")
    WebElement button;

    @FindBy (className = "login-box-body")
    WebElement loginForm;

    public LoginPage(WebDriver exterDriver){
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    /**
     * Method open browser and Login Page
     */
    public void openBrowserLoginPage(){
        try{
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get("http://v3.test.itpmgroup.com/login");
            logger.info("Page Login was opened");

        } catch (Exception e){
            logger.error("Can't work with browser");
            Assert.fail("Can't work with browser");
        }
    }

    /**
     * Method closes Login Page and Browser
     */
    public void closeLoginPageAndBrowser(){
        driver.quit();
        logger.info("Page Login and Browser were closed");
    }

    /**
     * Method enters User Name to Login Page
     * @param userName
     */
    public void enterUserName(String userName){
        try{
            inputUserName.clear();
            inputUserName.sendKeys(userName);
            logger.info(userName + inputText);
        }catch(Exception e){
            logger.error(errorInput + "Username");
            Assert.fail(errorInput + "Username");
        }
    }

    /**
     * Method enters password
     * @param pass
     */
    public void enterPassWord(String pass){
        try{
            inputUserPassWord.clear();
            inputUserPassWord.sendKeys(pass);
            logger.info(pass + inputText);
        }catch (Exception e){
            logger.error(errorInput + "PassWord");
            Assert.fail(errorInput + "PassWord");
        }
    }

    /**
     * Method click on button
     */
    public void clickButtonVhod(){
        try{
            button.click();
            logger.info("Button 'Vhod' was clicked");
        }catch (Exception e){
            logger.error(errorButton + "Vhod");
            Assert.fail(errorButton + "Vhod");
        }

    }

    /**
     *
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
     * Method opens LoginPage with Login and Pass
     * and click button 'Vhod'
     * @param login
     * @param pass
     */
    public void logOn(String login, String pass){
        openBrowserLoginPage();
        enterUserName(login);
        enterPassWord(pass);
        clickButtonVhod();
    }

}
