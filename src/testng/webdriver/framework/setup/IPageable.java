package testng.webdriver.framework.setup;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * 
 * @author nikol
 * 
 * Interface to be implemented by Page definition classes
 * To ensure the common methods are implemented by all page definition classes
 *  
 *
 */
public interface IPageable {
	
	boolean simpleTest();						 // basic test
	boolean extendedTest(); 					 // extended test
	ExpectedCondition getPageLoadedCondition();  //	replaced boolean isPageLoaded(); // each page should implement page loaded in specific
	Object open(); 								 // return the implementing Page object
	Object init();  							 // Initialize page object
	String getPageUrl();
	
	
}
