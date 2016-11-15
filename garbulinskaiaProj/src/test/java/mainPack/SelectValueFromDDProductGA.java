package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BrokersOwnersPageGA;
import pages.LoginPageGA;

public class SelectValueFromDDProductGA {
    WebDriver driver = new ChromeDriver();
    LoginPageGA loginPageGA = new LoginPageGA(driver);
    BrokersOwnersPageGA brokersOwnersPageGA = new BrokersOwnersPageGA(driver);

    @Test
    public void SetUp() {
        loginPageGA.openBrowserAndLoginPage();
        loginPageGA.clickProduct();
        loginPageGA.clickBrokersOwners();
        brokersOwnersPageGA.checkBrokersOwnersArticlePresent();

    }

    @After
    public void tearDown() {
        loginPageGA.closeLoginPageAndBrowser();
    }
}
