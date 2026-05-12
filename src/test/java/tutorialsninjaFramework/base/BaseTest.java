package tutorialsninjaFramework.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import tutorialsninjaFramework.factory.DriverFactory;
import tutorialsninjaFramework.utils.ConfigReader;

public class BaseTest {
	public DriverFactory driverFactory;
	public ConfigReader configReader;
	public Properties prop;
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		// 1. Initialize Properties
		configReader = new ConfigReader();
		prop = configReader.initProp();
		
		// 2. Initialize driver using browser value from config.properties
		driverFactory = new DriverFactory();
		String browserName = prop.getProperty("browser").trim();
		driver = driverFactory.initDriver(browserName);
		
		// 3. Set implicit wait and navigate to url
		long implicitWaitTime = Long.parseLong(prop.getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
		driver.get(prop.getProperty("url").trim());
	}
	
	@AfterMethod
	public void tearDown() {
		// Quit the browser session and cleanup the ThreadLocal memory
		if (driver != null) {
			driver.quit();
		}
	}
}
