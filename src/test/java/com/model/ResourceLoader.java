package com.model;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ResourceLoader {
	public final static Logger logger = Logger.getGlobal();
 
	private WebDriver driver=null;
	
	public ResourceLoader(WebDriver driver) {
		this.driver=driver;
		
	}
	
	@FindBy(how = How.NAME, using = "q") 
	WebElement e;
	
	
	public void loadDriver() {
			
		e.sendKeys("Iphone");
		e.submit();
		
		

	}
}
