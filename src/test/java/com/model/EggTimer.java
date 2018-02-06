package com.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EggTimer {
	final static Logger logger = Logger.getLogger(EggTimer.class);
	final WebDriver driver;
	@FindBy(how = How.ID, using = "start_a_timer")
	private WebElement SearchBox;


	@FindBy(how = How.ID, using = "timergo")
	private WebElement Go;


	@FindBy(how = How.ID, using = "progressText")
	private WebElement ProgressValue;




	/**
	 * @param driver
	 */
	public EggTimer(WebDriver driver)

	{
		this.driver = driver;
	}


	/**
	 * @param input
	 * @throws IOException
	 */
	public void provideData(String input) {
		SearchBox.clear();
		SearchBox.sendKeys(input);
		logger.info("Count down the timer with " +input );
		Go.click();

	}
	

	/**
	 * @param input
	 */
	public void countDownTimer(String input) {
		String before=input;

		String after=null;
        if(!ProgressValue.isDisplayed()) {
				logger.error("Incorrect input");
				
        }
		while(!isAlertPresent(driver)){

			if(ProgressValue.isDisplayed()) {
				after=ProgressValue.getText();
				if(!after.equals(before)){
					logger.info("Current value is  " +after );
					before=after;

				}
			}
			

		}
	}

public boolean isAlertPresent(WebDriver driver){
		
		try{
			 Alert alert =driver.switchTo().alert();
			 alert.accept();
			 return true;
		}
		catch(NoAlertPresentException e){
			return false;
			
			
		}
		
		
	}
}
