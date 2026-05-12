package tutorialsninjaFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	// 1. Locators
	private By emailInput = By.id("input-email");
	private By passwordInput = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");

	// 2. Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page Actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	// Page Chaining: Clicking login takes the user to the Account Page
	public AccountPage doLogin(String email, String pwd) {
		driver.findElement(emailInput).sendKeys(email);
		driver.findElement(passwordInput).sendKeys(pwd);
		driver.findElement(loginButton).click();

		return new AccountPage(driver);
	}
}
