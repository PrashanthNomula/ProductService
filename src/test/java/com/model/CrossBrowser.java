package com.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CrossBrowser {

	WebDriver driver;

	public WebDriver getDriver(String browserType) {

		switch (browserType) {
		case "firefox":
			System.out.println("Firefox--start");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\my\\location\\binaries\\windows\\googlechrome\\64bit\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "IE":
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Browser : " + browserType + " is unavailable, Opening Chrome as defualt");
			driver = new ChromeDriver();
		}
		return driver;
	}

}
