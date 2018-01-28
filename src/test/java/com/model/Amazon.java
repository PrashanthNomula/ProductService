/**
 * 
 */
package com.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Prashanth Nomula open Iphone product on Amazon commerce site
 *         input Webdriver return string price value
 *
 */
public class Amazon {

	public String findProductOnAmazon(WebDriver driver) {
		String price = null;
		try {
			ResourceLoader.logger.info("Amazon::findProductOnAmazon() called");
			if (verifyElement(driver, By.partialLinkText("Amazon"))) {
				driver.findElement(By.partialLinkText("Amazon")).click();
			} else {
				for (int i = 2; i < 10; i++) {
					driver.findElement(By.linkText(Integer.toString(i))).click();
					if (verifyElement(driver, By.partialLinkText("Amazon"))) {
						driver.findElement(By.partialLinkText("Amazon")).click();
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
		String price = driver.findElement(By.xpath("//*[@id='HLCXComparisonTable']//tr[5]//td[1]")).getText();
		System.out.println("Price: " + price);
		System.out.println(
				"Sold By: " + driver.findElement(By.xpath("//*[@id='HLCXComparisonTable']//tr[7]//td[1]")).getText());
		System.out.println(
				"Call Tech: " + driver.findElement(By.xpath("//*[@id='HLCXComparisonTable']//tr[8]//td[1]")).getText());
		System.out.println("Display size: "
				+ driver.findElement(By.xpath("//*[@id='HLCXComparisonTable']//tr[9]//td[1]")).getText());
		System.out.println("Item Dimensions: "
				+ driver.findElement(By.xpath("//*[@id='HLCXComparisonTable']//tr[10]//td[1]")).getText());
		System.out.println(
				"Weight: " + driver.findElement(By.xpath("//*[@id='HLCXComparisonTable']//tr[11]//td[1]")).getText());
		System.out.println("Memory Storage: "
				+ driver.findElement(By.xpath("//*[@id='HLCXComparisonTable']//tr[12]//td[1]")).getText());
		System.out.println(
				"OS: " + driver.findElement(By.xpath("//*[@id='HLCXComparisonTable']//tr[13]//td[1]")).getText());
		System.out.println("Wireless Comm Tech: "
				+ driver.findElement(By.xpath("//*[@id='HLCXComparisonTable']//tr[15]//td[1]")).getText());
		return price;
	}

	public static boolean verifyElement(WebDriver driver, By siteName) {
		try {
			driver.findElement(siteName);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
