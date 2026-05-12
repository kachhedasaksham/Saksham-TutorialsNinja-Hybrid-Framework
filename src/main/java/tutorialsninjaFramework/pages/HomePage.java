package tutorialsninjaFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;
	
	// 1. By Locators: Kept private so tests cannot manipulate them directly (Encapsulation)
	private By myAccountDropdownMenu = By.xpath("//span[text()='My Account']");
	private By loginOption = By.linkText("Login");
	
	// 2. Constructor: Initializes the driver for this page
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// 3. Page Actions: Public methods that tests can call
	public void clickMyAccount() {
		driver.findElement(myAccountDropdownMenu).click();
	}
	
	// 4. This method navigates the user to the Login Page, so it returns a new LoginPage object (Page Chaining)
	public LoginPage selectLoginOption() {
		driver.findElement(loginOption).click();
		return new LoginPage(driver);
	}
}
