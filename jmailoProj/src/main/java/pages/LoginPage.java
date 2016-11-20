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

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    Logger logger;
    WebDriverWait webDriverWait;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with button ";

    @FindBy(name = "_username")
    WebElement inputUserName;

    @FindBy(name = "_password")
    WebElement inputPassword;

    @FindBy(tagName = "button")
    WebElement button;

    @FindBy(className = "login-box-body")
    WebElement loginForm;

    public LoginPage (WebDriver externalDriver){
        this.driver=externalDriver;
        logger=Logger.getLogger(getClass());
        PageFactory.initElements(driver,this);
        webDriverWait = new WebDriverWait(driver,30);
    }

    /**
     * Method opens browser and Login Page
     */
    public void openBrowserAndLoginPage(){
        try{
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            //driver.get("http://v3.test.itpmgroup.com/login");
            driver.get(ConfigData.getCfgValue("BASE_URL") +"/login");
            logger.info("Page Login was opened");
        } catch (Exception e) {
            logger.error("Can not work with browser");
            Assert.fail("Can not work with browser");
        }
    }

    /**
     * Method closes Login Page and Browser
     */
    public void closeLoginPageAndBrowser(){
        driver.quit();
        logger.info("Page Login and browser were closed");
    }

    /**
     * Method enters username
     * @param userName
     */
    public void enterUserName (String userName){
        try {
            inputUserName.clear();
            inputUserName.sendKeys(userName);
            logger.info(userName + " was entered");
        }catch (Exception e){
            logger.error(errorInput + "UserName");
            Assert.fail(errorInput + "UserName");
        }
    }

    /**
     * Method enters password
     * @param pass
     */
    public void enterPassword(String pass){
        try{
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("_password")));
            inputPassword.clear();
            inputPassword.sendKeys(pass);
            logger.info(pass + " was entered");
        }catch(Exception e){
            logger.error(errorInput + "Password");
            Assert.fail(errorInput + "Password");
        }

    }

    /**
     * Method clickes on button
      */
    public void clickButtonVhod(){
        try{
            button.click();
            //driver.findElement(By.tagName("button")).click();
            logger.info("Button Vhod was clicked");
        }catch (Exception e) {
            logger.error(errorButton + "Vhod");
            Assert.fail(errorButton + "Vhod");

        }
    }

    /**
     * После клика на кнопку ожидаем главную сраницу (PageObject)
     * @return
     */
    public MainPage clickButtonVhodWithNewPage(){
        try{
            button.click();
            //driver.findElement(By.tagName("button")).click();
            logger.info("Button Vhod was clicked");
        }catch (Exception e) {
            logger.error(errorButton + "Vhod");
            Assert.fail(errorButton + "Vhod");
        }
        return new MainPage(driver);
    }

    public boolean isFormLoginPresent(){
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("login-box-body")));
            //webDriverWait.until(ExpectedConditions.not(ExpectedConditions.invisibilityOfAllElements()));
            return loginForm.isDisplayed();
            //return driver.findElement(By.className("login-box-body")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Method opens Login page with login and password and clicks button Vhod
     * @param login login
     * @param pass - password
     */
    public  void logOn(String login, String pass){
        openBrowserAndLoginPage();
        enterUserName(login);
        enterPassword(pass);
        clickButtonVhod();
    }
}
