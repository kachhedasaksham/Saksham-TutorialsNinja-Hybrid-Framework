package tutorialsninjaFramework.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tutorialsninjaFramework.base.BaseTest;
import tutorialsninjaFramework.pages.AccountPage;
import tutorialsninjaFramework.pages.HomePage;
import tutorialsninjaFramework.pages.LoginPage;
import tutorialsninjaFramework.utils.ExcelUtil;

public class LoginTest extends BaseTest {

	// 1. Setup the DataProvider to call our Excel utility
    @DataProvider
    public Object[][] getLoginData() {
        // We pass "Login" because that is the name of the sheet we created in Excel
        return ExcelUtil.getTestData("Login");
    }
	
    @Test(dataProvider = "getLoginData")
	public void verifyLoginWithValidCredentialsTest(String email, String password) {
		
		// 1. Start at the Home Page
		HomePage homePage = new HomePage(driver);
		
		// 2. Navigate to Login Page
		homePage.clickMyAccount();
		LoginPage loginPage = homePage.selectLoginOption();
		
		// 3. Perform Login
		AccountPage accountPage = loginPage.doLogin(email, password);
		
		// 4. Assertions
        Assert.assertTrue(accountPage.isAccountHeaderDisplayed(), "Account header is not displayed. Login might have failed.");
        Assert.assertEquals(accountPage.getAccountPageTitle(), "My Account", "Page title did not match!");
	}
	
}
