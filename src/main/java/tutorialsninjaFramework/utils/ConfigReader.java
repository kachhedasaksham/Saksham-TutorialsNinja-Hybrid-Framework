package tutorialsninjaFramework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties prop;

	/*
     * This method is used to load the properties from config.properties file.
     * returns Properties object containing all the key-value pairs.
     */
	public Properties initProp() {
		prop = new Properties();
		try {
			// FileInputStream reads the file from the specified path
			FileInputStream fis = 
					new FileInputStream("src\\test\\resources\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Config file not found at the specific path!!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading the config file!!");
			e.printStackTrace();
		}
		return prop;
	}
}
