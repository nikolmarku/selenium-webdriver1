/**
 * 
 */
package testng.webdriver.framework.pages.github;


import testng.webdriver.framework.setup.BasePage;
import testng.webdriver.framework.setup.IPageable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
/**
 * @author nikolmarku
 * user loged in page
 */
public class GitHubUserLogedInPage extends BasePage<GitHubUserLogedInPage> implements IPageable {

	@FindBy(className = "js-select-button")
	@CacheLookup
	WebElement dashboard;
	

	
	@Override
	public boolean simpleTest() {
		
		return false;
	}

	@Override
	public boolean extendedTest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GitHubUserLogedInPage open() {
		return new GitHubUserLogedInPage().openPage(GitHubUserLogedInPage.class);
	}
	public GitHubUserLogedInPage init() {
		return new GitHubUserLogedInPage().initPage(GitHubUserLogedInPage.class);
	}
	

	@Override
	public ExpectedCondition getPageLoadedCondition() {
		return ExpectedConditions.visibilityOf(dashboard);
		
	}

	@Override
	public String getPageUrl() {
		// TODO Auto-generated method stub
		return "";
	}



}
