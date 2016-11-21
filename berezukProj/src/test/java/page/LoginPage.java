package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alina on 21.11.2016.
 */
public class LoginPage extends AbstractPage {

    final static Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage (WebDriver driver, boolean externalConfigSource) {
        super(driver, externalConfigSource);
    }

    @Override
    protected void init () {

        pageElements.put(LoginPageElement.LOGIN_NAME, By.name("_username"));
        pageElements.put(LoginPageElement.LOGIN_PASSWORD, By.name("_password"));
        pageElements.put(LoginPageElement.LOGIN_BUTTON, By.tagName("button"));
        pageElements.put(LoginPageElement.LOGIN_PAGE_DISPLAYED, By.className("login-page"));
    };

    public void setLoginName (String loginNameValue ) {
        clearAndSetTextField(LoginPageElement.LOGIN_NAME, loginNameValue);
    }

    public void setPassword (String passwordValue) {
        clearAndSetTextField(LoginPageElement.LOGIN_PASSWORD,passwordValue);
    }

    public void clickLoginButton () {
        clickOnButton(LoginPageElement.LOGIN_BUTTON);;
    }

    @Override
    public boolean isThere () {
        return isPageVisible(LoginPageElement.LOGIN_PAGE_DISPLAYED);
    }
}
