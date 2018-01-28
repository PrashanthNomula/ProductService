/**
 * 
 */
package com.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Prashanth Nomula open Iphone product on Amazon commerce site
 *         input Webdriver return string price value
 *
 */
public class Amazon {
	private WebDriver driver=null;
	
	public Amazon(WebDriver driver) {
		this.driver=driver;
		
	}
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Amazon") 
	WebElement amazonLink;
	
	@FindBy(how = How.XPATH, using = "//*[@id='HLCXComparisonTable']//tr[5]//td[1]") 
	WebElement Price;
	
	@FindBy(how = How.XPATH, using = "//*[@id='HLCXComparisonTable']//tr[7]//td[1]") 
	WebElement Sold_By;
	@FindBy(how = How.XPATH, using = "//*[@id='HLCXComparisonTable']//tr[8]//td[1]") 
	WebElement Call_Tech;
	@FindBy(how = How.XPATH, using = "//*[@id='HLCXComparisonTable']//tr[9]//td[1]") 
	WebElement Display_size;
	@FindBy(how = How.XPATH, using = "//*[@id='HLCXComparisonTable']//tr[10]//td[1]") 
	WebElement Item_Dimensions;
	@FindBy(how = How.XPATH, using = "//*[@id='HLCXComparisonTable']//tr[11]//td[1]") 
	WebElement Weight;
	@FindBy(how = How.XPATH, using = "//*[@id='HLCXComparisonTable']//tr[12]//td[1]") 
	WebElement Memory_Storage;
	@FindBy(how = How.XPATH, using = "//*[@id='HLCXComparisonTable']//tr[13]//td[1]") 
	WebElement OS;
	@FindBy(how = How.XPATH, using = "//*[@id='HLCXComparisonTable']//tr[15]//td[1]") 
	WebElement Wireless_Comm;

	
	
	public String findProductOnAmazon(WebDriver driver) {
		String price = null;
		try {
			ResourceLoader.logger.info("Amazon::findProductOnAmazon() called");
			if (verifyElement(driver,amazonLink)) {
				amazonLink.click();
			} else {
				for (int i = 2; i < 10; i++) {
					driver.findElement(By.linkText(Integer.toString(i))).click();
					if (verifyElement(driver,amazonLink)) {
						amazonLink.click();
						break;
					}
				}
				price = printProperties(driver);
			}
		} catch (Exception E) {
			ResourceLoader.logger.info(" Amazon page not found");
		}
		return price;
	}

	private String printProperties(WebDriver driver) {
		ResourceLoader.logger.info("Amazon::printProperties() called");
		String price = Price.getText();
		System.out.println("Price: " + price);
		System.out.println(
				"Sold By: " + Sold_By.getText());
		System.out.println(
				"Call Tech: " + Call_Tech.getText());
		System.out.println("Display size: "
				+ Display_size.getText());
		System.out.println("Item Dimensions: "
				+ Item_Dimensions.getText());
		System.out.println(
				"Weight: " + Weight.getText());
		System.out.println("Memory Storage: "
				+ Memory_Storage.getText());
		System.out.println(
				"OS: " + OS.getText());
		System.out.println("Wireless Comm Tech: "
				+ Wireless_Comm.getText());
		return price;
	}

	public static boolean verifyElement(WebDriver driver, WebElement wb) {
		try {
			wb.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
