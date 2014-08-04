package testng.webdriver.framework.setup;

/**
 * @author nikolmarku
 * All the constants values used by webdriver instance
 *
 */
public class WeddriverConstant {
	
	public static int IMPLICIT_WAIT = 2;
	public static final Integer DEFAUL_WAIT = 10; // SECONDS
	

	private static boolean isMaxWindow       = false;
	private static boolean isDeleteCookies   = true;
	
		
	
	public static boolean isMaxWindow() {
		return isMaxWindow;
	}
	public static void setMaxWindow(boolean isMaxWindow) {
		isMaxWindow = isMaxWindow;
	}
	public static boolean isDeleteCookies() {
		return isDeleteCookies;
	}
	public static void setDeleteCookies(boolean isDeleteCookies) {
		isDeleteCookies = isDeleteCookies;
	}
	
	
}
