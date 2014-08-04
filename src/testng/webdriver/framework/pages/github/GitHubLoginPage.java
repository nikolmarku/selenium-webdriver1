package testng.webdriver.framework.pages.github;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testng.webdriver.framework.setup.BasePage;

/**
 * Page object representing github login page.
 */
public class GitHubLoginPage extends BasePage<GitHubLoginPage> {

	/*public GitHubLoginPage(WebDriver driver) {
		super(driver);		
	}*/

	@FindBy(id = "login_field")
	@CacheLookup
	WebElement loginField;

	@FindBy(name = "password")
	@CacheLookup
	WebElement passwordField;

	@FindBy(name = "commit")
	@CacheLookup
	WebElement commitButton;

	@FindBy(className = "flash-error")
	WebElement errorBox;

	@Override
	public ExpectedCondition getPageLoadedCondition() {
		return ExpectedConditions.visibilityOf(loginField);
	}

	@Override
	public String getPageUrl() {
		return "/login";
	}

	public void login(String login, String password) {
		loginField.sendKeys(login);
		passwordField.sendKeys(password);
		commitButton.click();

	}

	public boolean isLoginError() {
		return errorBox.isDisplayed();
	}

	public String getErrorMessage() {
		return errorBox.getText();
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
	public Object open() {
		return new GitHubLoginPage().openPage(GitHubLoginPage.class);
	}
	@Override
	public GitHubLoginPage init() {
		return new GitHubLoginPage().initPage(GitHubLoginPage.class);
	}

}

