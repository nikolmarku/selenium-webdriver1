package testng.webdriver.framework.pages.github;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testng.webdriver.framework.setup.BasePage;

/**
 * Page object representing github home page.
 *
 * @author mlipski
 */
public class GitHubHomePage extends BasePage<GitHubHomePage> {

	/*public GitHubHomePage(WebDriver driver) {
		super(driver);		
	}*/

	@SuppressWarnings("rawtypes")
	@Override
	public ExpectedCondition getPageLoadedCondition() {
		return ExpectedConditions.titleContains("GitHub · Build software better, together.");
	}

	@Override
	public String getPageUrl() {
		return "";
	}

	public GitHubLoginPage goToLoginPage() {
		return new GitHubLoginPage().openPage(GitHubLoginPage.class);
	}

	public GitHubHomePage open() {
		return new GitHubHomePage().openPage(GitHubHomePage.class);
	}

	@Override
	public boolean simpleTest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean extendedTest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GitHubHomePage init() {
		return new GitHubHomePage().initPage(GitHubHomePage.class);
	}

	

}
