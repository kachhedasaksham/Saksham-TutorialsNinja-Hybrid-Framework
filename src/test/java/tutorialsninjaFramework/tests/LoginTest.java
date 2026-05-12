package tutorialsninjaFramework.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import tutorialsninjaFramework.base.BaseTest;

public class LoginTest extends BaseTest {

	@Test
	public void verifyLoginWithValidCredentialsTest() {
		
		// 1. Click on 'My Account' Dropmenu
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		// 2. Click on 'Login' option
		driver.findElement(By.linkText("Login")).click();
		
		// 3. Enter valid email address
		driver.findElement(By.id("input-email")).sendKeys("s.k@gmail.com");
		
		// 4. Enter valid password
		driver.findElement(By.id("input-password")).sendKeys("sk123");
		
		// 5. Click on 'Login' button
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		
		// 6. Verify User should get logged in and taken to the 'Account' page
		String expectedTitle = "My Account";
		String actualTitle = driver.getTitle();
		
		// TestNG assertion
		Assert.assertEquals(actualTitle, expectedTitle, "Login failed or Page Title did not match!!");
	}
	
}
