package mainPack;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPageGA;
import pages.RequestADemoPageGA;
import pages.TermsOfServiceAgreementPageGA;

public class TermsOfServiceAgreementGA {
    WebDriver driver = new ChromeDriver();
    LoginPageGA loginPageGA = new LoginPageGA(driver);
    TermsOfServiceAgreementPageGA termsOfServiceAgreementPageGA = new TermsOfServiceAgreementPageGA(driver);


    @Test
    public void SetUp() {
        loginPageGA.openBrowserAndLoginPage();
        loginPageGA.clickTermsOfServiceAgreement();
        termsOfServiceAgreementPageGA.checkTermsOgAgreePresent();

    }

    @After
    public void tearDown() {
        termsOfServiceAgreementPageGA.closeTermsOfAgreementPage();
    }
}
