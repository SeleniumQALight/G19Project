package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPageGA;
import pages.RequestADemoPageGA;

public class RequestADemoGA {
    WebDriver driver = new ChromeDriver();
    LoginPageGA loginPageGA = new LoginPageGA(driver);
    RequestADemoPageGA requestADemoPageGA = new RequestADemoPageGA(driver);

    @Test
    public void SetUp() {
        loginPageGA.openBrowserAndLoginPage();
        loginPageGA.clickRequestADemo();
        requestADemoPageGA.checkFormRequestADemoPresent();

    }

    @After
    public void tearDown() {
        requestADemoPageGA.closeRequestADemoPage();
    }
}
