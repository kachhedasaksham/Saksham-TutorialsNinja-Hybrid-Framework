package tutorialsninjaFramework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import tutorialsninjaFramework.base.BaseTest;
import tutorialsninjaFramework.pages.AccountPage;
import tutorialsninjaFramework.pages.HomePage;
import tutorialsninjaFramework.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void verifyLoginWithValidCredentialsTest() {
		
		// 1. Start at the Home Page
		HomePage homePage = new HomePage(driver);
		
		// 2. Navigate to Login Page
		homePage.clickMyAccount();
		LoginPage loginPage = homePage.selectLoginOption();
		
		// 3. Perform Login
		AccountPage accountPage = loginPage.doLogin("s.k@gmail.com", "sk123");
		
		// 4. Assertions
        Assert.assertTrue(accountPage.isAccountHeaderDisplayed(), "Account header is not displayed. Login might have failed.");
        Assert.assertEquals(accountPage.getAccountPageTitle(), "My Account", "Page title did not match!");
	}
	
}
