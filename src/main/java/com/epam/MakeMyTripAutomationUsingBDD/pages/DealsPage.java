package com.epam.MakeMyTripAutomationUsingBDD.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.MakeMyTripAutomationUsingBDD.config.DriverConfiguration;
import com.epam.MakeMyTripAutomationUsingBDD.config.DriverType;
import com.epam.MakeMyTripAutomationUsingBDD.utilities.CustomWait;
import com.epam.MakeMyTripAutomationUsingBDD.utilities.Util;

public class DealsPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[@id='offers']")
	WebElement offersTab;

	@FindBy(xpath = "//input[@id='hp-widget__sfrom']")
	WebElement fromCity;

	@FindBy(xpath = "//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content hp-widget__sfrom']/li[2]")
	WebElement fromCityAutoSelect;

	@FindBy(xpath = "//input[@id ='hp-widget__sTo']")
	WebElement toCity;

	@FindBy(xpath = "//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content hp-widget__sTo']/li[2]")
	WebElement toCityAutoSelect;

	@FindBy(xpath = "//div[@class='inputM depart_input inputHlp inputDateFilter']/input")
	WebElement datePicker;

//	@FindBy(xpath = "//div[@class='ui-datepicker-group ui-datepicker-group-first']//td[contains(@class,'ui-datepicker-week-end')]//a[@class='ui-state-default'][contains(text(),'21')]")
//	WebElement departureDate;

	@FindBy(xpath = "//a[contains(@class,'ui-datepicker-next ui-corner-all')]")
	WebElement nextArrow;

	@FindBy(xpath = "//button[@id='searchBtn']")
	WebElement searchButton;

	@FindBy(xpath = "//div[@class='dateFilter hasDatepicker']//div[@class='ui-datepicker-group ui-datepicker-group-first']//div/div")
	WebElement currentMonth;

//	public DealsPage() {
//		DriverConfiguration.setDriverPath(DriverType.CHROME);
//		driver = DriverConfiguration.getDriver(DriverType.CHROME);
//		
//	}

	public void init() {
		driver = DriverConfiguration.getDriver(DriverType.CHROME);
		driver.navigate().to(Util.BASE_URL_DEALS);
		PageFactory.initElements(this.driver, this);
	}
	
	public void openOffers() {
		offersTab.click();
	}

	
	public void enterSourceCity(String source) {
		try {
			fromCity.sendKeys(source);
			CustomWait.waitFor(driver, fromCityAutoSelect);
			//Thread.sleep(2500);
			fromCityAutoSelect.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterDestinationCity(String destination) {
		try {
			toCity.sendKeys(destination);
			CustomWait.waitFor(driver, toCityAutoSelect);
			Thread.sleep(2500);
			toCityAutoSelect.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertData(String source, String destination, String date) {
		enterSourceCity(source);
		enterDestinationCity(destination);
		datePicker.click();
		String captionNextMonth = "";
		captionNextMonth = currentMonth.getText();
		while (!captionNextMonth.equals(date.substring(3))) {
			CustomWait.waitFor(driver, nextArrow);
			nextArrow.click();
			captionNextMonth = currentMonth.getText();
		}
		System.out.println(date.substring(0,2));
		String xpathForDate = "//div[@class='ui-datepicker-group ui-datepicker-group-first']//td[contains(@class,'ui-datepicker-week-end')]//a[@class='ui-state-default'][text()='"+date.substring(0,2)+"']";
		WebElement departureDate = driver.findElement(By.xpath(xpathForDate));
		departureDate.click();
	}

	public void quitDriver() {
		driver.quit();
	}

	public String searchFlights() {
		searchButton.click();
		CustomWait.waitForUrl(driver, "/flight/search?");
		return driver.getCurrentUrl();
	}

}
