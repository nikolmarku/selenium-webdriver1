package testng.webdriver.framework.test;
/**
 * 
 */
import static testng.webdriver.framework.setup.SeleniumDriver.getDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.jna.platform.FileUtils;

import testng.webdriver.framework.pages.englishtown.page.uk.EfHomePage;
import testng.webdriver.framework.setup.BasePage;
import testng.webdriver.framework.setup.PageConstant;


public class EfTestHelp extends BaseTest {
	
	private static List<String> testUrls ; 
	private String testUrl ;
	
	BasePage ef ;
	
	//@BeforeClass
	public static void intURL() {
		PageConstant.initTestUrls(testUrls);
	}
	
	@AfterClass
	public static void tearDown() {
		getDriver().close();
	}
	
	
	@Test(priority = 1)
	public void open_ef_home_page() {
		for(int i=0; i<PageConstant.DOMAIN_LIST.size(); i++){ //testUrls
			//set and open url	
			//PageConstant.setBaseUrl(PageConstant.HTTP, PageConstant.URL_BASE, PageConstant.DOMAIN_LIST.get(i), "");
			//BasePage.open(PageConstant.BASE_URL);
			//intURL();    //
			testUrls=PageConstant.initTestUrls(testUrls);
			BasePage.open(testUrls.get(i));
			((EfHomePage) ef).closeHomePopup();
			//given
			ef = new EfHomePage().init();
			log(" is is : "+i+" Domain list :"+PageConstant.DOMAIN_LIST.get(i));
			//when
			log(" title is : "+ef.getTitle()+"   Should match :"+EfHomePage.TITLE);
			//Assert.assertTrue(ef.getTitle().equals(EfHomePage.TITLE));
			//((EfHomePage) ef).closeHomePopup();
			Assert.assertTrue(ef.simpleTest());
			
			//then	
		}
		
	}

	
	

}



/*	//use param
public void open_ef_home_pageParam() {	
	    log("URL: "+testUrl) ;
		BasePage.open(testUrl);
		((EfHomePage) ef).closeHomePopup();			
		ef = new EfHomePage().init();			             
		log(" title is : "+ef.getTitle()+"   Should match :"+EfHomePage.TITLE);			
		Assert.assertTrue(ef.simpleTest());
}*/	//@Ignore  testUrls
