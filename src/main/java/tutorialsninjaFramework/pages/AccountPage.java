package tutorialsninjaFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;

    // 1. Locators
    private By accountHeader = By.xpath("//h2[normalize-space()='My Account']");

    // 2. Constructor
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Page Actions
    public String getAccountPageTitle() {
        return driver.getTitle();
    }

    public boolean isAccountHeaderDisplayed() {
        return driver.findElement(accountHeader).isDisplayed();
    }
}
