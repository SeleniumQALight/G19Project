package pages;

import org.apache.bcel.verifier.exc.AssertionViolatedException;
import org.apache.bcel.verifier.exc.StructuralCodeConstraintException;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ReportPage {

    WebDriver driver;
    Logger logger;

    public ReportPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method inspection link report
     */
    public void inspectionLinkReport() {
        try {
            driver.findElement(By.xpath(".//a[@href='/statistic']")).click();
        } catch (Exception e) {
            logger.error("Not link Report");
            Assert.fail("Not link Report");
        }

    }


}
