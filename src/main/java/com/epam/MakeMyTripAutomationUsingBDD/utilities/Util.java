package com.epam.MakeMyTripAutomationUsingBDD.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

public class Util {

	static PropertiesFileReader reader = new PropertiesFileReader();

	public static String BASE_URL;
	public static String BASE_URL_FLIGHTS;
	public static String BASE_URL_HOTELS;
	public static String BASE_URL_VILLAS;
	public static String BASE_URL_HOLIDAYS;
	public static String BASE_URL_TRAINS;
	public static String BASE_URL_BUSES;
	public static String BASE_URL_CABS;
	public static String BASE_URL_DEALS;
	public static String BASE_URL_VISAS;
	public static String BASE_URL_GIFTCARDS;

	public static String CHROME_DRIVER_PATH;
	public static String GECKO_DRIVER_PATH;
	public static String EXPLORER_DRIVER_PATH;
	
	static File source;

	public static void initProperties() {
		try {
			Properties properties = reader.getProperty();
			BASE_URL = properties.getProperty("Base.url");
			BASE_URL_FLIGHTS = properties.getProperty("Base.url.flights");
			BASE_URL_HOTELS = properties.getProperty("Base.url.hotels");
			BASE_URL_VILLAS = properties.getProperty("Base.url.villas");
			BASE_URL_HOLIDAYS = properties.getProperty("Base.url.holidays");
			BASE_URL_TRAINS = properties.getProperty("Base.url.trains");
			BASE_URL_BUSES = properties.getProperty("Base.url.buses");
			BASE_URL_CABS =properties.getProperty("Base.url.cabs");
			BASE_URL_DEALS = properties.getProperty("Base.url.deals");
			BASE_URL_VISAS = properties.getProperty("Base.url.visa");
			BASE_URL_GIFTCARDS = properties.getProperty("Base.url.giftcards");
			CHROME_DRIVER_PATH = properties.getProperty("chromeDriverPath");
			GECKO_DRIVER_PATH = properties.getProperty("geckoDriverPath");
			EXPLORER_DRIVER_PATH = properties.getProperty("explorerDriverPath");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void screenShot(WebDriver driver) {
		try {
			String screenShotPath = "../MakeMyTrip_AT/test-output/screenshots/" + getCurrentDateTime() + ".png";
			TakesScreenshot screenShot = (TakesScreenshot) driver;
			source = screenShot.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(source, new File(screenShotPath));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getCurrentDateTime() {
		DateFormat format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return format.format(date);
	}

	public static String switchToLatestWindow(WebDriver driver) {
		try {
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
		} catch (Exception e) {
			return "Failed: Unable to Switch Window - " + e.getMessage();
		}
		return "Success!";
	}

}
