package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class EntrancePage {
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can't work with input ";
    final String errorButton = "Can't work with button ";
    final String okInput = " was entered";


    public EntrancePage (WebDriver externalDriver){
        this.driver=externalDriver;
        logger=Logger.getLogger(getClass());
    }

    /**
     * Method opens browser and entrance page
     */
    public void openBrowserAndEntrancePage(){
        try{
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("http://v3.test.itpmgroup.com/login");
            logger.info("Entrance Page was opened");
        }catch (Exception e){
            logger.error("Can not work with browser");
            Assert.fail("Can not work with browser");
        }
    }

    /**
     * Method enters user's E-mail
     * @param email - user's E-mail
     */
    public void enterEmail(String email){

        try{
            driver.findElement(By.name("_username")).clear();
            driver.findElement(By.name("_username")).sendKeys(email);
            logger.info(email + okInput);
        }catch (Exception e){
            logger.error(errorInput + "Email");
            Assert.fail(errorInput + "Email");
        }
    }

    /**
     * Method enters user's password
     * @param password - user's password
     */
    public void enterPassword(String password){

        try{
            driver.findElement(By.name("_password")).clear();
            driver.findElement(By.name("_password")).sendKeys(password);
            logger.info(password + okInput);
        }catch (Exception e){
            logger.error(errorInput + "Password");
            Assert.fail(errorInput + "Password");
        }
    }

    /**
     * Method clicks on button
     */
    public void clickOnButton(){
        try {
            driver.findElement(By.tagName("button")).click();
            logger.info("Button Vhod was clicked");
        }catch (Exception e){
            logger.error(errorButton + "Vhod");
            Assert.fail(errorButton + "Vhod");
        }
    }

    /**
     * Method closes entrance page and browser
     */
    public void closeEntrancePageAndBrowser(){
        driver.quit();
        logger.info("Entrance page and browser were closed");
    }

    /**
     * Method checks entrance completion
      */
    public void isEntranceCompleted(){
        try {
            driver.findElement(By.xpath(".//img[@alt='student']")).isDisplayed();
            logger.info("Entrance completed");
        }catch (Exception e){
            logger.error("You are still on login page");
            Assert.fail("You are still on login page");
        }
    }

    public  void logOn(String login, String pass){
        openBrowserAndEntrancePage();
        enterEmail(login);
        enterPassword(pass);
        clickOnButton();
    }
}