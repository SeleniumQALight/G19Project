package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.sql.SQLException;


//import pages.Contacts;

public class DataBaseData {
	static Logger log = Logger.getLogger(DataBaseData.class);
	static  WebDriver driver;
	static Database dB;
	
	public void dataBaseData (WebDriver driver) throws ClassNotFoundException, IOException, SQLException {
		this.driver = driver;
		
	}
	
	public String getSomeValue(String someData) throws SQLException, ClassNotFoundException, IOException{
		//log.info("Данные будут выбраны");
		log.info("someData = " + someData);
		dB = new Database("PADB_DB","Oracle");
		String someValue1 = dB.selectValue("select HASH,CREATE_DATE from cs_check_portal where " + someData + "");
		return someValue1;
		//log.info("Данные выбраны");
	}

	public static String getPassForLogin(String login) throws SQLException, IOException, ClassNotFoundException {
		dB = new Database("MySQL_PADB_DB", "MySQL");
		String pass = dB.selectValue("select pass from table_selenium where login = '" + login + "'");

		dB.quit();
		return pass;
	}


















}

