package com.trigger;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.model.Amazon;
import com.model.ResourceLoader;

public class TriggerTest {
	public final static Logger logger = Logger.getGlobal();
	static WebDriver driver;
	ResourceLoader googlepage;
	Amazon amazon;

	
	
	@Test
	public void test() {
		logger.info("ResourceLoader::loadDriver() called");
		System.setProperty("webdriver.chrome.driver",
				"C:\\my\\location\\binaries\\windows\\googlechrome\\64bit\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		googlepage=PageFactory.initElements(driver, ResourceLoader.class);
		amazon=PageFactory.initElements(driver, Amazon.class);
		googlepage.loadDriver();
		String price = amazon.findProductOnAmazon(driver).replace("£", "");
		logger.info("ResourceLoader::loadDriver() price: "+price );
		double value = Double.parseDouble(price);
		if(value < 1000) {
			logger.info("ResourceLoader::loadDriver() price: "+price +" is less than 1000" );	
		}else {
			logger.info("ResourceLoader::loadDriver() price: "+price +" is more than 1000" );	
		}
	}

}
