package testng.webdriver.framework.setup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author nikolmarku
 * 
 * All the constant values used by pages
 *
 */
public class PageConstant {
	public static final String URL_BASE   = "englishtown"; // e.g englishtown
	public static final String URL_DOMAIN = ""; // e.g uk, de, it
	public static final String URL_EXTENTION="";
	public static final List<String> DOMAIN_LIST = Arrays.asList("it","co.uk","de","fr","it");  // e.g de, it  //Arrays.asList("A", "B", "C")
	public static final int LOAD_TIMEOUT = 20;
	public static final int REFRESH_RATE = 2;		 		
	public static final String BASE_URL_GITHUB = "github.com";  	
	public static final String BASE_URL_EF = "englishtown.com";  ///en-gb
	public static final String BASE_URL_DE = "englishtown.de";
	public static final String HTTPS = "https";			
	public static final String HTTP  = "http";
	public static final String DEFAULT_PROTOCOL  = HTTP;
	public static String BASE_URL = "BASE URL NOT INIT" ;  //"github.com"; 
	public static List<String> testUrls ; //= new ArrayList();
	
	public static final void setBaseUrl(String protocol, String url){
		BASE_URL = protocol+"://www."+url;	
	}
	public static final void setBaseUrl(String protocol, String urlBase, String urlDomain, String urlExtention){
		BASE_URL = protocol+"://www."+urlBase+"."+urlDomain+urlExtention;	
	}
	
	
	public static final String getBaseUrl(){
		return BASE_URL;
	}
	
	/**
	 * Return full URL for the page
	 *
	 */
	public static String getPageUrl(String pageUrl){		
		return getBaseUrl()+pageUrl;
	}
	
	
	public static final List<String> initTestUrls(List<String> urlList){
		urlList = new ArrayList();
		String temUrl = "";
		
		for(int i=0; i< DOMAIN_LIST.size(); i++){ 
			temUrl = DEFAULT_PROTOCOL+"://www."+URL_BASE+"."+DOMAIN_LIST.get(i);	
			urlList.add(temUrl);			
		}	
		testUrls = urlList;
		return urlList;
	}
	
}
