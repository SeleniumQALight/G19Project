package mainPack;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;

/**
 * Created by V on 22.11.2016.
 */
public class StringParser {
    Logger logger = Logger.getLogger(getClass());

@Test
public void invaliLogOnwithStinrg(){
    String testString="<ACCOUNTINFO AccounID='11103485' HomeCurrency='EUR' Credit='0.0'>";
    logger.info(testString.split(" ")[1].split("'")[1].substring(3,5).replace("0","1").equals("23"));
}

@After
public void tearDown(){
}
}

