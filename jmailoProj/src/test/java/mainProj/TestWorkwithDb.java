package mainProj;




import libs.DataBaseDataPass;
import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class TestWorkwithDb {
    Logger logger = Logger.getLogger(getClass());

    Database db;

    @Before
    public void testWithDb() throws SQLException, IOException, ClassNotFoundException {
        db = new Database("MySQL_PADB_DB","MySQL");
    }

    @Test
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        List<Map<String,String>> testData = db.selectTable("select * from table_selenium where login='Dmitriy'");
        logger.info("values = " + testData);
        //db.changeDataInDataBase("Insert into table_selenium values (123,'Dmitriy','909090')");
        logger.info(DataBaseDataPass.getPassForLogin("Dmitriy"));

    }
    @After
    public void testDown() throws SQLException {
       db.quit();
    }
}
