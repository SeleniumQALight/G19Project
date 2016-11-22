package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by SBeast on 11/15/2016.
 */
public class AllPages {
    WebDriver driver;
    public LoginPage loginPage;
    public MainPage mainPage;
    public DealsEditPage dealsEditPage;
    public DealsPage dealsPage;
    public EditSparePage editSparePage;
    public EditWorkerPage editWorkerPage;
    public ProviderEditPage providerEditPage;
    public ProviderPage providerPage;
    public SparesPage sparesPage;
    public WorkersPage workersPage;

    public AllPages(WebDriver exterDriver){
        this.driver = exterDriver;
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        dealsEditPage = new DealsEditPage(driver);
        dealsPage = new DealsPage(driver);
        editSparePage = new EditSparePage(driver);
        editWorkerPage = new EditWorkerPage(driver);
        providerEditPage = new ProviderEditPage(driver);
        providerPage = new ProviderPage(driver);
        sparesPage = new SparesPage(driver);
        workersPage = new WorkersPage(driver);
    }
}
