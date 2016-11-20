package pages;


import libs.ConfigData;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    Logger logger;
    WebDriverWait webDriverWait;
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with button ";

    public LoginPage(WebDriver exterDriver){
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait = new WebDriverWait(driver,30);
    }

    /**
     * Method open browser and Login Page
     */
    public void openBrowserAndLoginPage(){
        try{
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get(ConfigData.getCfgValue("BASE_URL") +"/login");
            logger.info("Page Login was opened");
        } catch (Exception e) {
            logger.error("Can not work with browser");
            Assert.fail("Can not work with browser");
        }
    }

    /**
     * Method closes Login Page And Browser
     */
    public void closeLoginPageAndBrowser(){
        driver.quit();
        logger.info("Page Login and Browser were closed");
    }

    /**
     * Method enters User Name
     * @param userName
     */
    public void enterUserName(String userName){
        try {
            driver.findElement(By.name("_username")).clear();
            driver.findElement(By.name("_username")).sendKeys(userName);
            logger.info(userName + " was entered");
        } catch (Exception e){
            logger.error(errorInput + "UserName");
            Assert.fail(errorInput + "UserName");
        }
    }

    /**
     * Method entere password
     * @param pass
     */
    public void enterPassWord(String pass){
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("_password")));
            driver.findElement(By.name("_password")).clear();
            driver.findElement(By.name("_password")).sendKeys(pass);
            logger.info(pass + " was entered");
        } catch (Exception e){
            logger.error(errorInput + "PassWord");
            Assert.fail(errorInput + "PassWord");
        }
    }

    /**
     * Method click on button
     */
    public void clickButtonVhod(){
        try{
            driver.findElement(By.tagName("button")).click();
            logger.info("Button vhod was clicked");
        }catch (Exception e){
            logger.error(errorButton + " 'Vhod'");
            Assert.fail(errorButton + " 'Vhod'");
        }
    }

    public MainPage clickButtonVhodWithNewPage(){
        try{
            driver.findElement(By.tagName("button")).click();
            logger.info("Button vhod was clicked");
        }catch (Exception e){
            logger.error(errorButton + " 'Vhod'");
            Assert.fail(errorButton + " 'Vhod'");
        }
        return new MainPage(driver);
    }

    public boolean isFormLoginPresent(){
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("login-box-body")));
//            webDriverWait.until(ExpectedConditions.not(ExpectedConditions.invisibilityOfAllElements()));
            return driver.findElement(By.className("login-box-body")).isDisplayed();
        }catch ( Exception e){
            return  false;
        }
    }

}
