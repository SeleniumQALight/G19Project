package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DictionaryProvidersPage {
    WebDriver driver;
    Logger logger;
    final String errorButton = "Can't work with button ";
    final String errorRecord = "Can't work with recod ";
    final String errorFoundPage = "Can`t found title of Page ";


    @FindBy(xpath = ".//a[@class=\"btn btn-info btn-sm\"]")
    WebElement buttonAdd;

    @FindBy(xpath = ".//h3[@class=\"box-title\"and text()=\"Список контрагентов\"]")
    WebElement titlePage;

    @FindBy (xpath = ".//tr[@onclick]/td[contains(text(),\"Name Provider\") and //td[contains(text(),\"Address Provider\")]]")
    WebElement provider;

    public DictionaryProvidersPage(WebDriver exterDriver) {

        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public boolean isDictionaryProvidersPage() {
        try {
            return titlePage.isDisplayed();
        } catch (Exception e) {
            return true;
        }
    }

    public void clickOnAddbuttonOnProvidersPage() {
        try {
            buttonAdd.click();
        } catch (Exception e) {
            logger.error(errorButton + "'Add'");
            Assert.fail(errorButton + "'Add'");
        }
    }

    public void clickOnProvider (){
        provider.isDisplayed();
        logger.info("Record was found");
        provider.click();
        logger.info("Record was clicked");
    }

    private void waitSomeSec(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
