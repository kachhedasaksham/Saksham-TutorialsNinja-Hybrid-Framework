package tutorialsninjaFramework.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

	/*
	 * ThreadLocal ensures that every thread (test) running in parallel gets its own
	 * isolated WebDriver instance
	 */
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/*
     * This method is used to initialize the ThreadLocal driver based on the given browser.
     * browser: The name of the browser (chrome, firefox, edge)
     * return: The WebDriver instance
     */
	public WebDriver initDriver(String browser) {
		System.out.println("Initializing browser: " + browser);

		switch (browser) {
			case "chrome":
				tlDriver.set(new ChromeDriver());
				break;
			case "firefox":
				tlDriver.set(new FirefoxDriver());
				break;
			case "edge":
				tlDriver.set(new EdgeDriver());
				break;
			default:
				System.out.println("Pass a supported driver: " +browser);
		}
		
		// Browser configurations
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}
	
	/*
     * This method returns the thread-safe WebDriver instance.
     * Synchronized is used to ensure thread safety if multiple threads try to access it simultaneously.
     */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
