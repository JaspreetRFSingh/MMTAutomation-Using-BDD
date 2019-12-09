package com.epam.MakeMyTripAutomationUsingBDD.config;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.epam.MakeMyTripAutomationUsingBDD.driverFactory.ChromeDriverManager;
import com.epam.MakeMyTripAutomationUsingBDD.driverFactory.DriverManager;
import com.epam.MakeMyTripAutomationUsingBDD.utilities.PropertiesFileReader;
import com.epam.MakeMyTripAutomationUsingBDD.utilities.Util;


public class DriverConfiguration {
	public static WebDriver driver;

	public static void setDriverPath(DriverType driverType) {
		if(driverType.equals(DriverType.CHROME)) {
			setChromeDriverPath();
			return;
		}
		else if(driverType.equals(DriverType.FIREFOX)) {
			setGeckoDriverPath();
			return;
		}
		else if(driverType.equals(DriverType.IE)) {
			setExplorerDriverPath();
			return;
		}
	}
	
	public static void setChromeDriverPath() {
		System.setProperty("webdriver.chrome.driver",
				Util.CHROME_DRIVER_PATH);
	}
	
	public static void setExplorerDriverPath() {
		System.setProperty("webdriver.ie.driver",
				Util.EXPLORER_DRIVER_PATH);
	}
	
	public static void setGeckoDriverPath() {
		System.setProperty("webdriver.gecko.driver",
				Util.GECKO_DRIVER_PATH);
	}

	public static WebDriver getDriver(DriverType driverType) {
		Util.initProperties();
		setDriverPath(driverType);
		DriverManager driverManager;
		driverManager = new ChromeDriverManager();
		driver = driverManager.getWebDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static Boolean isElementPresent(By locator) {
		return driver.findElements(locator).size() > 0;
	}

	public static void closeDriver() {
		driver.close();
	}
}

