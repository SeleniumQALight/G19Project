package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TermsOfServiceAgreementPageGA {

    WebDriver driver;
    Logger logger;


    @FindBy(className = "container")
    WebElement termsOfAgreeText;

    public TermsOfServiceAgreementPageGA(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    /**
     * Method check if Request a demo article is present
     */
    public void checkTermsOgAgreePresent() {
        try {
            termsOfAgreeText.isDisplayed();
            logger.info("Terms of Agree text is displayed");
        } catch (Exception e) {
            logger.error("Terms of Agree text is not displayed");
            Assert.fail("Terms of Agree text is not displayed");
        }
    }

    /**
     * Method closes Request a demo page and Browser
     */
    public void closeTermsOfAgreementPage() {
        driver.quit();
        logger.info("Page Terms of Agreement and Browser were closed");
    }
}

