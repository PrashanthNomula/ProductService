package com.model;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResourceLoader {
	public final static Logger logger = Logger.getGlobal();

	static WebDriver driver;
	@Test
	public void loadDriver() {
		logger.info("ResourceLoader::loadDriver() called");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kolku\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement e = driver.findElement(By.name("q"));
		e.sendKeys("iphone");
		e.submit();
		Amazon amazon= new Amazon();
		String price = amazon.findProductOnAmazon(driver).replace("£", "");
		logger.info("ResourceLoader::loadDriver() price: "+price );
		double value = Double.parseDouble(price);
		if(value <= 1000) {
			logger.info("ResourceLoader::loadDriver() price: "+price +" is Equal/less than 1000" );	
		}else {
			logger.info("ResourceLoader::loadDriver() price: "+price +" is more than 1000" );	
		}

	}
}
