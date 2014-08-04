/**
 * 
 */
package testng.webdriver.framework.setup;

/**
 * @author nikolmarku
 * Supported browser list
 */
public enum BrowserType {
	
	FIREFOX,
    CHROME,
    IE,
    SAFARI;

     public static BrowserType checkBrowser (String browser ) throws IllegalArgumentException
     {
         for (BrowserType b: values())
         {
             if(b.toString().equalsIgnoreCase(browser))
             {
                 return b;
             } 
         }

         throw BrowserNotFound(browser);
     }

    private static IllegalArgumentException BrowserNotFound(String browser)
    {
        return new IllegalArgumentException("browser type: " + browser + " could not be found");
    }
	

}
