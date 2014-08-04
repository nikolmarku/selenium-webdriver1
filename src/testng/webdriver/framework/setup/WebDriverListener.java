/**
 * 
 */
package testng.webdriver.framework.setup;

/**
 * @author nikolmarku
 *
 */

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
 
public class WebDriverListener implements WebDriverEventListener {  

	private EventFiringWebDriver webDriver = SeleniumDriver.getDriver();
	
	public WebDriverListener(EventFiringWebDriver webDriver){
		this.webDriver = webDriver;
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		log("afterChangeValueOf ");
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		log("afterClickOn ");
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		log("afterFindBy ");
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		log("afterNavigateBack ");
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		log("afterNavigateForward ");
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		log("afterNavigateTo ");
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		log("afterScript ");
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		log("beforeChangeValueOf ");
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		log("beforeClickOn ");
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		log("beforeFindBy ");
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		log("beforeNavigateForward ");
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		log("beforeNavigateForward ");
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		log("beforeNavigateTo ");
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		log("beforeScript ");
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		log("onException ");
	}
	
	private static final Logger LOGGER = Logger.getLogger(WebDriverListener.class.getName());
	public static void log(String msg){
		 LOGGER.info(msg);
	}
	
	
 
}



/*
public void beforeNavigateTo(String url, EventFiringWebDriver driver) {
	System.out.println("Before navigating to url printing the browser associated capabilities");
	//System.out.println(((RemoteWebDriver) this.webDriver).getCapabilities());

}

public void afterNavigateTo(String url, EventFiringWebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("[ INFO ] - ");
}

public void beforeNavigateBack(EventFiringWebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("[ INFO ] - ");
}

public void afterNavigateBack(EventFiringWebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("[ INFO ] - ");
}

public void beforeNavigateForward(EventFiringWebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("[ INFO ] - ");
}

public void afterNavigateForward(EventFiringWebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("[ INFO ] - ");
}

public void beforeFindBy(By by, WebElement element, EventFiringWebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("[ INFO ] - ");
}

public void afterFindBy(By by, WebElement element, EventFiringWebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("[ INFO ] - ");
}

public void beforeClickOn(WebElement element, EventFiringWebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("[ INFO ] - ");
}

public void afterClickOn(WebElement element, EventFiringWebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("[ INFO ] - ");
}

public void beforeChangeValueOf(WebElement element, EventFiringWebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("[ INFO ] - ");
}

public void afterChangeValueOf(WebElement element, EventFiringWebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("[ INFO ] - ");
}

public void beforeScript(String script, EventFiringWebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("[ INFO ] - ");
}

public void afterScript(String script, EventFiringWebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("[ INFO ] - ");
}

public void onException(Throwable throwable, EventFiringWebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("[ INFO ] - ");
}
*/


