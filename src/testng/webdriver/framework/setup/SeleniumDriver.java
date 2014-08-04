package testng.webdriver.framework.setup;
/**
 * Selenium driver wrapper
 *
 * TODO - should be singleton OR not? .... add other drivers 
 */
import static testng.webdriver.framework.setup.SeleniumDriver.getDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.james.mime4j.field.datetime.DateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.*;
import com.sun.jna.platform.FileUtils;
import testng.webdriver.framework.setup.WeddriverConstant;


public class SeleniumDriver {
	
	private static volatile EventFiringWebDriver driver;  //WebDriver  EventFiringWebDriver
	 
	
	
	public static EventFiringWebDriver getDriver() {
		if (driver == null) {													//driver = new FirefoxDriver();	//can be replaced with HtmlUnitDriver for better performance		EventFiringWebDriver Driver = new EventFiringWebDriver(driver);
		    driver = new EventFiringWebDriver(new FirefoxDriver());			    //firingDriver.ExceptionThrown += firingDriver_TakeScreenshotOnException;
			WebDriverEventListener eventListener = new WebDriverListener(driver);//WebDriverEventListener
			driver.register(eventListener);
		}
		allBrowserSetup(driver);												//	/*driver.manage().timeouts().implicitlyWait(WeddriverConstant.IMPLICIT_WAIT, TimeUnit.SECONDS);			if(WeddriverConstant.isMaxWindow())        driver.manage().window().maximize();		if(WeddriverConstant.isDeleteCookies())    driver.manage().deleteAllCookies();*/																		//File srcFile =  driver.getScreenshotAs(OutputType.FILE);//((EventFiringWebDriver)	//FileUtils.copyFile(srcFile, new File("testimage.png"));
		return driver;
	}
	
	public static void getDriver(String browserType){	
		//TODO add else 
		if( BrowserType.checkBrowser(browserType) != null ) {
			switch (BrowserType.checkBrowser(browserType)){
			    case IE:
			        driver =  createInternetExplorerDriver();
			        break;
			    case SAFARI:
			        driver =  createSafariDriver();
			        break;
			    case CHROME:
			        driver =  createChromeDriver();
			        break;
			    case FIREFOX:
			    default:
			        driver =  createFirefoxDriver(getFirefoxProfile());
			        break;
			}
		}
	}
	

	private static FirefoxProfile getFirefoxProfile()	{
		FirefoxProfile firefoxProfile = new FirefoxProfile();	
		firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.9.2");
		return firefoxProfile;
	}	
	private static EventFiringWebDriver createChromeDriver()	{
	    //System.setProperty("webdriver.chrome.driver", "");
	    return new EventFiringWebDriver( new ChromeDriver());
	}	
	private static EventFiringWebDriver createSafariDriver(){
	    return new EventFiringWebDriver( new SafariDriver()) ;
	}	
	private static EventFiringWebDriver createInternetExplorerDriver()	{
		//TODO	//		System.setProperty("EventFiringWebDriver.ie.driver", "src/main/resources/IEDriverServer.exe");
		return new EventFiringWebDriver( new InternetExplorerDriver() );
	}	
	public static EventFiringWebDriver createFirefoxDriver(FirefoxProfile firefoxProfile)	{
		return new EventFiringWebDriver( new FirefoxDriver(firefoxProfile) );
	}
	
	
	
	private static void allBrowserSetup(EventFiringWebDriver driver)	{				
		driver.manage().timeouts().implicitlyWait(WeddriverConstant.IMPLICIT_WAIT, TimeUnit.SECONDS);		
		if(WeddriverConstant.isMaxWindow())        driver.manage().window().maximize();
		if(WeddriverConstant.isDeleteCookies())    driver.manage().deleteAllCookies();
		
	}
	
	public static void openUrl(String url){
		driver.get(url);
	}
	
	
    
	
	
}


/*
private void firingDriver_TakeScreenshotOnException(object sender, WebDriverExceptionEventArgs e) {
    //String timestamp = Date.Now.ToString("yyyy-MM-dd-hhmm-ss");
    driver.TakeScreenshot().SaveAsFile("Exception-" + timestamp + ".png", ImageFormat.Png);
}*/

/* EventFiringWebDriver event = new EventFiringWebDriver(driver);
WebDriverListerners eventListener = new WebDriverListerners();
event.register(eventListener);
*/

//move to this directory
	/*
	File file = new File("C:/Users/nikol/Downloads/IEDriverServer_Win32_2.42.0/IEDriverServer.exe") ;//("C:/Selenium/iexploredriver.exe");
	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());		
	driver = new InternetExplorerDriver();//		driver = new InternetExplorerDriver(); //FirefoxDriver();
	driver.get(ACCOUNTATN_URL+SIGNUP_URL); 
	Thread.sleep(3000);
	driver.navigate().to("javascript:document.getElementById('overridelink').click()");   
	System.out.println(driver.getTitle());
	Thread.sleep(3000);
	*/



/** 
+ How do you handle https website in selenium ?
FirefoxProfile profile = new FirefoxProfile();
profile.setAcceptUntrustedCertificates(false);
WebDriver driver = new FirefoxDriver(profile);

+ whenever “Assert.assertEquals()” function fails automatically it has to take screenshot
EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(srcFile, new File(imgPath));



+Open browser in memory
HtmlUnitDriver driver = new HtmlUnitDriver(true);
driver.setJavascriptEnabled(false);
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


+ How do you take screen shot without using EventFiringWebDriver ?
File srcFile = ((TakeScreenshot)driver).getScreenshotAs(OutputType.FILE); //now we can do anything with this screenshot
like copy this to any folder-
FileUtils.copyFile(srcFile,new File(“folder name where u want to copy/file_name.png”));


+
import org.apache.log4j.Logger;
import org.testng.Reporter;
Log.info("Web application launched");
        // Our first step is complete, so we produce a main event log here for our reports.
Reporter.log("Application Lauched successfully | ");


-+

+

+
 * 
 * */
 