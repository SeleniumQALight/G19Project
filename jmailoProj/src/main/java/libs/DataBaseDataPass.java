package libs;

import org.apache.log4j.Logger;
import org.apache.xerces.impl.xpath.XPath;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


//import pages.Contacts;

public class DataBaseDataPass {
	static Logger log = Logger.getLogger(DataBaseDataPass.class);
	static Database dB;
	
	public void dataBaseData (WebDriver driver) throws ClassNotFoundException, IOException, SQLException {

		
	}

	/**
	 * Method get password for login
	 * @param login
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
     */
	public static String getPassForLogin(String login) throws SQLException, IOException, ClassNotFoundException {
		dB = new Database("MySQL_PADB_DB","MySQL");
		String pass = dB.selectValue("select pass from table_selenium where Login='"+login+"'");
		dB.quit();
		return pass;
	}


	public String getSomeValue(String someData) throws SQLException, ClassNotFoundException, IOException{
		//log.info("Данные будут выбраны");
		log.info("someData = " + someData);
		dB = new Database("PADB_DB","Oracle");
		String someValue1 = dB.selectValue("select HASH,CREATE_DATE from cs_check_portal where " + someData + "");
		return someValue1;
		//log.info("Данные выбраны");
	}
	
}

