package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrokersOwnersPageGA {

    WebDriver driver;
    Logger logger;


    @FindBy(xpath = ".//*[contains(text(),'For Teams, Owners and Brokers')]")
    WebElement brokersOwnersArticle;

    public BrokersOwnersPageGA(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    /**
     * Method check if Brokers & Owners article is present
     */
    public void checkBrokersOwnersArticlePresent() {
        try {
            brokersOwnersArticle.isDisplayed();
            logger.info("Brokers & Owners article is displayed");
        } catch (Exception e) {
            logger.error("Brokers & Owners article is not displayed");
            Assert.fail("Brokers & Owners article is not displayed");
        }
    }
}
