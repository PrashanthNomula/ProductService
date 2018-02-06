package com.trigger;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.model.CrossBrowser;
import com.model.EggTimer;
import com.model.ReadExcel;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class EggTimerTrigger {
	public final static Logger logger = Logger.getGlobal();
	static WebDriver driver;
	EggTimer eggtimer;

	@DataProvider
	public static Object[][] data() {
		ReadExcel readExcel = new ReadExcel();
		String[][] data = readExcel.readExcel("c:/TimerData.xlsx");
		return data;
	}

	@After
	public void closeDriver() {
		driver.quit();
	}

	@Test
	@UseDataProvider("data")
	public void testTimer(String value1, String value2) {

		CrossBrowser browser = new CrossBrowser();
		driver = browser.getDriver("chrome");
		driver.get("http://e.ggtimer.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		eggtimer = PageFactory.initElements(driver, EggTimer.class);
		eggtimer.provideData(value2);
		eggtimer.countDownTimer(value2);

	}
}
