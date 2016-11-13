package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPage {
    WebDriver driver;
    Logger logger;

    final String  errorButton = "can't work with button";

    @FindBy(xpath = ".//*[@class=\"user-image\"]")
    WebElement avatar;

    @FindBy(id = "dictionary")
    WebElement menuDictionary;

    @FindBy(xpath = ".//*[@href='/dictionary/spares']")
    WebElement subMenuSpares;

    @FindBy(xpath = ".//*[@href='/dictionary/providers']")
    WebElement subMenuProviders;

    @FindBy(xpath = ".//a[@href='#' and @class='sidebar-toggle']")
    WebElement btnSandwich;

    @FindBy(className = "pull-left info")
    WebElement leftAva;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver,this);
    }

    /**
     * Method opens Main page in browser
     */
    public void openBrowserMainPage(){
        try{
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            driver.get("http://v3.test.itpmgroup.com/dashboard");
            logger.info("Main page opens");
        }catch (Exception e){
            logger.error("can't open Main page");
            Assert.fail();
        }
    }

    /**
     * Method find SandwichButton and click on it
     */
    public void findSandwichClick(){
        try{
            btnSandwich.isDisplayed();
            btnSandwich.click();
            logger.info("element sandwich was found on page and clicked");
        }catch(Exception e){
            logger.error("can't find element sandwich");
            Assert.fail();
        }
    }

    /**
     * Method find Avatar in left side
     * @return
     */
    public boolean isAvatarLeftSidePresent(){
        try{
            return  leftAva.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void mainPageClose(){
        driver.quit();
        logger.info("Main page was closed");
    }

    /**
     * Method checks avatar on main page after login
     */
    public void checkAvatar(){
        try{
            waitSomeSec(2);
            avatar.isDisplayed();
            logger.info("Avatar is displayed");
        } catch (Exception e){
            logger.error("Avatar is not displayed");
            Assert.fail("Avatar is absent");
        }
    }

    /**
     * Method click on menu Dictionary
     */
    public void clickMenuDictionary() {
        try{
            menuDictionary.click();
            logger.info("page Dictionary was clicked");

        }catch (Exception e){
            logger.error(errorButton + "Dictionary");
            Assert.fail(errorButton + "Dictionary");
        }
    }

    /**
     * Method clicks on SubMenu Dictionary->Spares
     */
    public void clickMenuSpares(){
        try{
            waitSomeSec(1);
            subMenuSpares.click();
            logger.info("Sub menu spares was clicked");
        }catch (Exception e){
            logger.error(errorButton + "Sub menu Spares");
            Assert.fail(errorButton + "Sub menu Spares");
        }
    }

    /**
     * Method clicks on sub menu Dictionary->Providers
     */
    public void clickMenuProviders(){
        try{
            waitSomeSec(1);
            subMenuProviders.click();
            logger.info("Sub menu Providers was clicked");
        } catch (Exception e){
            logger.error(errorButton + "Sub menu Providers");
            Assert.fail(errorButton + "Sub menu Providers");
        }
    }

    /**
     * Method wait for some seconds
     * @param sec
     */
    public void waitSomeSec(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
