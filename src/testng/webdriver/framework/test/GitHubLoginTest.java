package testng.webdriver.framework.test;
/**
 * Test
 */
import static testng.webdriver.framework.setup.SeleniumDriver.getDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import testng.webdriver.framework.pages.github.GitHubHomePage;
import testng.webdriver.framework.pages.github.GitHubLoginPage;
import testng.webdriver.framework.pages.github.GitHubUserLogedInPage;

import org.testng.Assert;

public class GitHubLoginTest {

	GitHubLoginPage       loginPage;
	GitHubUserLogedInPage landingPage;
	
	
	@AfterClass
	public static void tearDown() {
		getDriver().close();
	}

	@Test(priority = 1)
	public void should_not_login_with_wrong_credentials() {
		//given
		loginPage = new GitHubHomePage().open().goToLoginPage();
		//when
		loginPage.login("user", "password");
		//then																			//assertThat(loginPage.isLoginError()).isTrue();		
		Assert.assertTrue( loginPage.isLoginError() );
	}
	@Test(priority = 2)
	public void should_login_with_credentials() {
		//given
		loginPage = new GitHubHomePage().open().goToLoginPage();
		//when
		loginPage.login("nikolmarku", "K222222-75");
		//then																			//assertThat(loginPage.isLoginError()).isTrue();		
		Assert.assertTrue( !loginPage.isLoginError() );
	}//GitHubUserLogedInPage
	@Test(priority = 3)
	public void landing_page_shown() {
		//given
		////landingPage = new GitHubUserLogedInPage().init();
		//when
		landingPage = new GitHubUserLogedInPage().init();
		//then	
		//assertThat(loginPage.isLoginError()).isTrue();	
		System.out.println("Title is :"+getDriver().getTitle());
		Assert.assertTrue( getDriver().getTitle().equals("GitHub") );
	}
	 
}

