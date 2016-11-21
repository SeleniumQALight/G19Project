package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alina on 21.11.2016.
 */
public abstract class AbstractPage {

    protected WebDriver driver;
    protected Map<Enum, By> pageElements;

    public AbstractPage (WebDriver driver, boolean externalConfigSource) {
        this.driver = driver;
        pageElements = new HashMap<Enum, By>();
        if (!externalConfigSource)
            init();
        else
            initExternalSource(null);
    }

    protected void clearAndSetTextField (Enum textField, String value) {
        driver.findElement(pageElements.get(textField)).clear();
        driver.findElement(pageElements.get(textField)).sendKeys(value);
    }

    protected void clickOnButton (Enum button) {
        driver.findElement(pageElements.get(button)).click();
    }

    protected boolean isPageVisible (Enum elementToCheck ) {
        WebElement element;
        try {
            element = driver.findElement(pageElements.get(elementToCheck));
        }
        catch (NoSuchElementException ex) {
           return false;
        }
        return element.isDisplayed();
    }

    private void initExternalSource (Object source) {
        throw new UnsupportedOperationException ("Load from external source isn't implemented yet");
    }

    protected abstract void init ();
    public abstract boolean isThere ();

    public void setDriver (WebDriver driver) {
        this.driver = driver;
    }
}
