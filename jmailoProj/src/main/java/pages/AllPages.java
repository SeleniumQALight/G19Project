package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class AllPages {
    WebDriver driver;
    Logger logger;
    public LoginPage loginPage;
    public EntrancePage entrancePage;
    public MainPage mainPage;
    public ApparatPage apparatPage;
    public ApparatEditorPage apparatEditorPage;
    public WorkerPage workerPage;
    public WorkerEditorPage workerEditorPage;
    public SparesPage sparesPage;
    public SparesEditorPage sparesEditorPage;
    public ServicePage servicePage;
    public ServiceEditorPage serviceEditorPage;

    public AllPages(WebDriver externalDriver){
        this.driver = externalDriver;
        loginPage = new LoginPage(driver);
        entrancePage = new EntrancePage(driver);
        mainPage = new MainPage(driver);
        apparatPage = new ApparatPage(driver);
        apparatEditorPage = new ApparatEditorPage(driver);
        workerPage = new WorkerPage(driver);
        workerEditorPage = new WorkerEditorPage(driver);
        sparesPage = new SparesPage(driver);
        sparesEditorPage = new SparesEditorPage(driver);
        servicePage = new ServicePage(driver);
        serviceEditorPage = new ServiceEditorPage(driver);
    }
}