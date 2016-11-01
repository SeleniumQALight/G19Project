package mainPack;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DictWorkersPage;
import pages.EditWorkerPage;
import pages.LoginPage;

public class EditWorker {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    DictWorkersPage dictWorkers = new DictWorkersPage(driver);
    EditWorkerPage editWorkerPage = new EditWorkerPage(driver);

    @Test
    public void editWorker(){
        String surname_old="Петров",
                name_old="Петр",
                middleName_old="Петрович";
        String surname_new="new1",
                name_new="new2",
                middleName_new="new3";

        loginPage.openBrowserLoginPage();
        loginPage.enterUserName("Student");
        loginPage.enterPassWord("909090");
        loginPage.clickButtonVhod();
        dictWorkers.openDictWorkersPage();
        dictWorkers.chooseWorkerForEdit(surname_old+" "+name_old +" "+ middleName_old);
        editWorkerPage.enterWorkerSurname(surname_old, surname_new);
        editWorkerPage.enterWorkerName(name_old,name_new);
        editWorkerPage.enterWorkerMiddleName(middleName_old,middleName_new);
        editWorkerPage.enterWorkerPhone("+380123456");
        editWorkerPage.editWorkerSaveClick();
    }

    @After
    public void tearDown(){
        String surname_old="Петров",
                name_old="Петр",
                middleName_old="Петрович";
        String surname_new="new1",
                name_new="new2",
                middleName_new="new3";
        String fioToChangeBack = surname_old +"_"+ surname_new+" "+name_old+"_"+name_new+" "+middleName_old+"_"+middleName_new;
        dictWorkers.openDictWorkersPage();
        dictWorkers.chooseWorkerForEdit(fioToChangeBack);
        editWorkerPage.enterWorkerFioForEditBack(surname_old, name_old, middleName_old);
        editWorkerPage.enterWorkerPhone("+3809060902");
        editWorkerPage.editWorkerSaveClick();
        editWorkerPage.closeEditWorkerPage();
    }

}
