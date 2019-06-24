package com.test.tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigurationSetUp {
	WebDriver driverLaunch;
	Properties properties = new Properties();
	InputStream inputStream;

	public WebDriver driverSetUp() {
		// WebDriverManager.getInstance(CHROME).setup();
		WebDriverManager.chromedriver().setup();
		driverLaunch = new ChromeDriver();
		driverLaunch.manage().window().maximize();

		return driverLaunch;
	}

	public String fileRead(String keyValue) {

		try {
			inputStream = getClass().getClassLoader().getResourceAsStream("cred.properties");
			
			if (inputStream == null) {
				throw new IOException("File not found");
			}
			properties.load(inputStream);
			inputStream.close();
			return properties.getProperty(keyValue);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}


	public void driverTerminate() {
		driverLaunch.quit();
	}

}
