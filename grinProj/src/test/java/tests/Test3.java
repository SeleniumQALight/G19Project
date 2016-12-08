    package tests;

    import org.apache.log4j.Logger;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.util.concurrent.TimeUnit;

    /**
     * Created by user on 06-Dec-16.
     */
    public class Test3 {
        WebDriver driver = new FirefoxDriver();
        Logger logger = Logger.getLogger(getClass());
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        @Test
        public void test3() {

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("https://corplighttest.unity-bars.com:3443/#/auth/logon");
            logger.info("Page was opened");
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[@data-translate='components.auth.ForLogin']")));
            logger.info("isDisplayed");
            waitSomeSec(1);
            driver.findElement(By.xpath(".//span[@data-translate='components.auth.ForLogin']")).click();
            logger.info("Go to another VKLADKA");

            driver.findElement(By.xpath(".//*[@type='email' and @name='login']")).clear();
            driver.findElement(By.xpath(".//*[@type='email' and @name='login']")).sendKeys("demo@ub.com");
            logger.info("Login was entered");
            driver.findElement(By.name("loginpass")).sendKeys("qwerty");

            logger.info("Pass was entered");
            driver.findElement(By.xpath(".//*[@type='submit'] ")).click();
            logger.info("Button was clicked");
/**
 *  Verification if main page logined successfully
 */
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("app-logo")));
            logger.info("Login was successfully");


            /**
             *  Verification of changing of clients
             */
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[@data-translate='aside.nav.changeCustomer']")));
            waitSomeSec(1);
            driver.findElement(By.xpath(".//span[@data-translate='aside.nav.changeCustomer']")).click();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[contains(text(),' ГРІНЧЕНКО ОЛЕГ СПЕПАНОВИЧ')]")));
            waitSomeSec(1);
            driver.findElement(By.xpath(".//a[contains(text(),' ГРІНЧЕНКО ОЛЕГ СПЕПАНОВИЧ')]")).click();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@ng-bind='currentCustomer.Name' and contains(text(),'ГРІНЧЕНКО ОЛЕГ СПЕПАНОВИЧ')]")));
            waitSomeSec(1);
            logger.info("Client was changed");
            /**
             *  Verification of presence of Accounts
             */
            driver.findElement(By.xpath(".//*[@data-translate='aside.nav.ACCOUNTS']")).click();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@data-translate='components.acct.Accounts']")));
            logger.info("Accounts loaded succsessfully");


        }

        private void waitSomeSec(int sec) {
            try {
                Thread.sleep(sec * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }





