package testng.webdriver.framework.pages.englishtown.page.uk;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testng.webdriver.framework.pages.github.GitHubHomePage;
import testng.webdriver.framework.setup.BasePage;
import testng.webdriver.framework.setup.SeleniumDriver;


/**
 * EF home page - uk
 * @author nikolmarku
 *
 */
public class EfHomePage extends BasePage<EfHomePage>{
	
	public static final String EfHomePageUrl = "";
	public static final String TITLE ="Learn English Online | EF Englishtown";    //"Learn English Online - Englishtown"; 
	
	@FindBy(className = "login-link")	//@CacheLookup
	WebElement loginLink;
	
	@FindBy(id = "et_ee_popup_content")	//
	@CacheLookup    	
	WebElement homePopupId;
	
	@FindBy(className = "eet-btn-close")	//
	@CacheLookup    	
	static WebElement homePopupCloseIcon;
	
	
	
	@Override
	public boolean simpleTest() {
		log("simpleTest()");
		boolean isDisplayed = loginLink.isDisplayed();
		return isDisplayed;
	}

	@Override
	public boolean extendedTest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EfHomePage open() {		
		return new EfHomePage().openPage(EfHomePage.class);
	}

	@Override
	public EfHomePage init() {
		return new EfHomePage().initPage(EfHomePage.class);
	}

	@Override
	public ExpectedCondition getPageLoadedCondition() {		
		return ExpectedConditions.visibilityOf(loginLink);  //titleContains("Learn English Online - Englishtown");
	}

	@Override
	public String getPageUrl() {		
		return EfHomePageUrl; //en-gb/
	}

	
	
	
	  // HELPERs
    //close pop up on home page - Get free english lesson
    public static void closeHomePopup(){  
    	log("closeHomePopup");
    	try{
    		log("closeHomePopup()   waitForElementVisible .");
    		waitForElementVisible(SeleniumDriver.getDriver().findElement(By.className("et-btn-close")), 15);
	    	if(SeleniumDriver.getDriver().findElement(By.className("et-btn-close")).isDisplayed())		{ 
	    		log("close pop up");
	    		SeleniumDriver.getDriver().findElement(By.className("et-btn-close")).click();
			} else {
				log("No pop up");
			}	    	/*if(homePopupCloseIcon.isDisplayed()){		log("close pop up");   		homePopupCloseIcon.click();   	}  */ 	
    	}catch(NoSuchElementException nee){
	    	log(nee.toString());
	    }
	    
    }
	
	
}
