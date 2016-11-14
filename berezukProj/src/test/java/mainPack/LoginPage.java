package mainPack;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alina on 27.10.2016.
 */
public class LoginPage {

    final static Logger logger = LogManager.getLogger(LoginPage.class);
    WebDriver  driver;

    final String CORRECT_LOGIN = "Student";
    final String WRONG_LOGIN = "Studen";
    final String CORRECT_PASSWORD = "909090";
    final String WRONG_PASSWORD = "906090";
    final String XPATH_FOR_LEFT_MENU_ITEMS = "//section[@class='sidebar']//ul[@class='sidebar-menu']/li//span";
    final int MENU_ITEMS_SIZE = 6;

    public LoginPage() {
        System.setProperty("webdriver.gecko.driver","C:/browserDrivers/geckodriver.exe");
        driver= new FirefoxDriver();
        Configurator.setRootLevel(Level.DEBUG);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://v3.test.itpmgroup.com/login");
        logger.info("Page was opened");
    }

    @Test
    public void runInvalidLogOnWithWrongPassword() {

        fillLoginFields(CORRECT_LOGIN, WRONG_PASSWORD);

        driver.findElement(By.tagName("button")).click();
        logger.info("Button was clicked. Login page is still presented: " + isLoginPresented ());
        Assert.assertTrue("Login failed", isLoginPresented ());

    }
    @Test
    public void runInvalidLogOnWithWrongName() {

        fillLoginFields(WRONG_LOGIN, CORRECT_PASSWORD);

        driver.findElement(By.tagName("button")).click();
        logger.info("Button was clicked. Login page is still presented: " + isLoginPresented ());
        Assert.assertTrue("Login failed", isLoginPresented ());
    }

    @Test
    public void runValidLogon() {

        login();
        Assert.assertTrue("Login successful", isMainPagePresented () );
    }

    @Test
    public void checkLeftMenuOnMainPage () {
        login();
        List<WebElement> menuItems = driver.findElements(By.xpath(XPATH_FOR_LEFT_MENU_ITEMS));
        logger.info("Found menu items:");
        for (WebElement we : menuItems) 
            logger.info("\t\t" + we.getText());
        logger.info("Total: " + menuItems.size());
        Assert.assertEquals (MENU_ITEMS_SIZE, menuItems.size());
    }


    private void login () {
        fillLoginFields(CORRECT_LOGIN, CORRECT_PASSWORD);
        driver.findElement(By.tagName("button")).click();
        logger.info("Button was clicked. Moved to main page: " + isLoginPresented ());
    }

    private void fillLoginFields (String login, String password ) {
        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.name("_username")).sendKeys(login);
        logger.info("login was entered: " + login);

        driver.findElement(By.name("_password")).clear();
        driver.findElement(By.name("_password")).sendKeys(password);
        logger.info("Password was entered: " + password);

    }


    private boolean isLoginPresented () {
        return  driver.findElement(By.className("login-page")).isDisplayed();
    }

    private boolean isMainPagePresented () {
        return  driver.findElement(By.className("box-title")).isDisplayed();
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}