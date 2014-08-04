package testng.webdriver.framework.setup;
/**
 * All page definition extends this
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static testng.webdriver.framework.setup.SeleniumDriver.getDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import testng.webdriver.framework.setup.PageConstant;

import java.util.logging.Logger;



public abstract class BasePage <T> implements IPageable {									
	
	 private static final Logger LOGGER = Logger.getLogger(
			    Thread.currentThread().getStackTrace()[0].getClassName() ); //  private static final Logger LOGGER = Logger.getLogger(AmazonView.class.getName());
	
	 
	 
	// Opens page URL and init page content 	
	@SuppressWarnings("rawtypes")
	public T openPage(Class<T> clazz) {
		log("  openPage :"+clazz.toString());			
		T page = PageFactory.initElements(getDriver(), clazz);
		                               //PageConstant.setBaseUrl(PageConstant.DEFAULT_PROTOCOL, PageConstant.BASE_URL_DE);	//getDriver().get(PageConstant.DEFAULT_PROTOCOL+"://"+PageConstant.BASE_URL + getPageUrl());
		log(" base url is: "+PageConstant.getBaseUrl() + getPageUrl());	
		getDriver().get(PageConstant.getBaseUrl() + getPageUrl());		
		ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadedCondition();
		waitForPageToLoad(pageLoadCondition);
		return page;
	}
	@SuppressWarnings("rawtypes")
	public T initPage(Class<T> clazz) {
		log("  Initialise page Object :"+clazz.toString());
		T page = PageFactory.initElements(getDriver(), clazz);		
		ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadedCondition();
		waitForPageToLoad(pageLoadCondition);
		return page;
	}

	private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {	
		log("  waitForPageToLoad :"+pageLoadCondition);
		Wait<EventFiringWebDriver> wait = new FluentWait<EventFiringWebDriver>(getDriver())
				.withTimeout(PageConstant.LOAD_TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(PageConstant.REFRESH_RATE, TimeUnit.SECONDS);
		wait.until(pageLoadCondition);
	}
	
	
	/**
	 * Provides condition when page can be considered as fully loaded.
	 *
	 * @return
	 */
	public abstract ExpectedCondition getPageLoadedCondition();

	/**
	 * Provides page relative URL/
	 *
	 * @return
	 */
	public abstract String getPageUrl();
	/**
	 * open page URL using get method (it waits for page to load...?)
	 */
	public static void open(String url) {
		log("open url : "+url);
		getDriver().get(url);
	}
	public void close() {
		log("close driver : ");
		getDriver().quit();
	}
	public String getTitle() {
		log("Get page Title : "+getDriver().getTitle());
		return getDriver().getTitle();
	}
	
	public boolean isPageTitle(String title) {		
		log("isPageTitle : "+getDriver().getTitle()+"equals to : "+title);
		return getTitle().equals(title);
	}
	
	/*public void enterText(WebDriver driver, String name, String text) {			
		driver.findElement(By.name(name)).sendKeys(text);
	}*/

	public void enterText(WebElement we, String text) {
		log("enterText on webelement : "+we+" text to enter : "+text);
		we.sendKeys(text);			
	}
	
	public void clickOnElement(WebElement we) {
		log("enterText on webelement : "+we);
		we.click();			
	}
	//??????
	@SuppressWarnings("unchecked") 
	public BasePage<T> clickOnElementAndInitNewPage(WebDriver driver, WebElement we, BasePage<T> page) {
		log("clickOnElementAndInitNewPage(. .) : "+we);
		we.click();	
		page = PageFactory.initElements(driver, BasePage.class);
		return page ;
	}
	
	
	public boolean isPageLoaded(WebElement we) {
		// TODO Auto-generated method stub
		return false;
	}
	
			
	//**************************
	public boolean validateWebElement(WebElement we) {
		log("validateWebElement()");
		if (we == null){
			return false  ; //throw new IllegalStateException("WebElement cannot be null");
		} else 
			return true;
	}
	
   
    public static void waitForElementVisible(WebElement elementToWaitFor, Integer waitTimeInSeconds) {
    	log("waitForElementVisible() - element :"+elementToWaitFor+" waitTime : "+waitTimeInSeconds);
        if (waitTimeInSeconds == null) {
            waitTimeInSeconds = WeddriverConstant.DEFAUL_WAIT; // 10
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), waitTimeInSeconds);
        wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));  //return wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
    }    
    public static WebElement isElementVisible(WebElement elementToWaitFor, Integer waitTimeInSeconds)   {
    	log("isElementVisible() - element :"+elementToWaitFor+" waitTime : "+waitTimeInSeconds);
    	if (waitTimeInSeconds == null)  {
            waitTimeInSeconds = WeddriverConstant.DEFAUL_WAIT; // 10
        }        
        WebDriverWait wait = new WebDriverWait(getDriver(), waitTimeInSeconds);
        
        return wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
    }
    // no wait
    public static boolean isElementDisplayed (WebElement element) {
    	log("isElementDisplayed - without wait");
        try{          
          element.isDisplayed();
          return true;
        }
        catch (Exception e) {
          LOGGER.info("Element is not displayed : "+e.toString());    
          return false;
        }
    }
	
    
    
    public static void log(String msg){
		 LOGGER.info(msg);
	}
	
    
    
  
    
    
}




//protected static SeleniumDriver sdriver; // TODO - THINK  could this be encapsulated using seleniumDriver.java		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);			//need to think about this constructor	/*public BasePage(SeleniumDriver driver){	driver=getDriver;		}*/



