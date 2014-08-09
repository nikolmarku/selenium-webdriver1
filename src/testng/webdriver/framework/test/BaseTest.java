package testng.webdriver.framework.test;

import org.testng.log4testng.Logger;

/**
 * All test cases should extend this class
 * @author nikolmarku
 *
 */
public class BaseTest implements IBaseTest {

	  private static final Logger LOGGER = Logger.getLogger(BaseTest.class);
	
	
	
	  public static void log(String msg){
			 LOGGER.info(msg);
		}
}
