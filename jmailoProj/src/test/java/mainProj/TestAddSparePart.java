package mainProj;


import libs.ConfigData;
import libs.SpreadsheetData;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TestAddSparePart {
    WebDriver driver = new FirefoxDriver();
    AllPages allPages = new AllPages(driver);

    String email, pass, liida, liidd, sparePartName, valueInDD, sparePart, typeInDd;

    public TestAddSparePart(String email, String pass, String liida, String liidd, String sparePartName, String valueInDD, String sparePart, String typeInDd){
        this.email=email;
        this.pass=pass;
        this.liida=liida;
        this.liidd=liidd;
        this.sparePartName=sparePartName;
        this.valueInDD=valueInDD;
        this.sparePart=sparePart;
        this.typeInDd=typeInDd;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException{
        InputStream spreadSheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE")+"testData.xls");
        return new SpreadsheetData(spreadSheet, "TestAddSparePart").getData();
    }

    @Test
    public void setUp(){
        allPages.entrancePage.logOn(email, pass);
        allPages.mainPage.isMainPageOpened();
        allPages.mainPage.clickOnLeftSideMenuItem(liida);
        allPages.mainPage.clickOnLeftSideMenuItem(liidd);
        allPages.sparesPage.isSparesPageOpened();
        allPages.sparesPage.clickOnPlusButton();
        allPages.sparesEditorPage.enterSparePartName(sparePartName);
        //allPages.sparesEditorPage.clickOnDd();
        allPages.sparesEditorPage.selectValueOnDdTypeOfSparesByValue(valueInDD);
        //allPages.sparesEditorPage.selectValueOnDdTypeOfSpares("Механика");
        allPages.sparesEditorPage.clickONButtonAdd();
        allPages.sparesPage.isSparesPageOpened();
        allPages.sparesPage.checkRecord(sparePart);
        allPages.sparesPage.checkRecord(typeInDd);
    }

    @After
    public  void testDown(){
        allPages.entrancePage.closeEntrancePageAndBrowser();
    }
}
