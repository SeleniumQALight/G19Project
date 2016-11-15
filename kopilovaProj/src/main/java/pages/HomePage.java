package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    WebDriver driver;
    Logger logger;
    final String errorMenu = "Can't work with element menu ";
    final String errorInput = "Can not work with input ";
    final String errorButton = "Can not work with button ";

    @FindBy (xpath = ".//*[@class=\"user-image\"]")
    WebElement avatar;

    @FindBy (id = "dictionary")
    WebElement menuDictionary;

    @FindBy (xpath = ".//*[@href='/dictionary/spares']")
    WebElement subMenuSpares;

    @FindBy (xpath = ".//*[@href=\"/dictionary/service\"]" )
    WebElement munuService;

    @FindBy (xpath = ".//*[@href=\"/dictionary/providers\"]")
    WebElement subMenuProviders;

    public HomePage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver,this);
    }

    public void clickMenuService() {
        try {
            munuService.click();
            logger.info("Menu 'Obslujivanie' was found and clicked");
        } catch (Exception e) {
            logger.error(errorMenu + "'Obslujivanie'");
        }
    }
    public void checkAvatar(){
        try{
            waitSomeSec(10);
            avatar.isDisplayed();
            logger.info("Avatar is displayed");
        }catch (Exception e){
            logger.error("Avatar is not displayed");
            Assert.fail("Avatar is not displayed");
        }
    }

    public void clickMenuDictionary() {
        try {
            waitSomeSec(10);
            menuDictionary.click();
            logger.info("Menu Dictionery was clicked");
        }catch (Exception e){
            logger.error(errorButton + "Dictionary");
            Assert.fail(errorButton + "Dictionary");

        }
    }
    public void clickSubMenuSpares (){
        try {
            waitSomeSec(10);
            subMenuSpares.click();
            logger.info("Sub Menu Spares was clicked");
        }catch (Exception e){
            logger.error(errorButton + "Sub Menu Spares");
            Assert.fail(errorButton + "Sub Menu Spares");
        }
    }

    public void clickSubMenuProviders (){
        try {
            waitSomeSec(10);
            subMenuProviders.click();
            logger.info("Sub Menu Providers was clicked");
        }catch (Exception e){
            logger.error(errorButton + "Sub Menu Providers ");
            Assert.fail(errorButton + "Sub Menu Providers ");
        }
    }

    private void waitSomeSec (int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

