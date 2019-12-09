package com.epam.MakeMyTripAutomationUsingBDD.pages;

import java.time.Duration;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.epam.MakeMyTripAutomationUsingBDD.config.DriverConfiguration;
import com.epam.MakeMyTripAutomationUsingBDD.config.DriverType;
import com.epam.MakeMyTripAutomationUsingBDD.debug.CustomLogger;
import com.epam.MakeMyTripAutomationUsingBDD.exceptions.FlightNotFoundException;
import com.epam.MakeMyTripAutomationUsingBDD.exceptions.FlightsSoldOutException;
import com.epam.MakeMyTripAutomationUsingBDD.utilities.CustomWait;
import com.epam.MakeMyTripAutomationUsingBDD.utilities.Util;

public class FlightsPage {
	public WebDriver driver;
	Logger logger;
	@FindBy(xpath = "//label[@for='fromCity']/input")
	WebElement fromCity;

	@FindBy(xpath = "//label[@for='toCity']/input")
	WebElement toCity;

	@FindBy(xpath = "//li[@id='react-autowhatever-1-section-0-item-0']")
	WebElement fromCityInput;

	@FindBy(xpath = "//li[@id='react-autowhatever-1-section-0-item-0']")
	WebElement toCityInput;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]")
	WebElement departureDateDiv;

	@FindBy(xpath = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div")
	WebElement elementNextMonth;

	@FindBy(xpath = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div")
	WebElement elementCurrentMonth;

	@FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	WebElement nextMonth;

	@FindBy(xpath = "//div[@class='dateInnerCell']/p[contains(text(),'25')]")
	WebElement datePicked;

	@FindBy(xpath = "//a[@class='primaryBtn font24 latoBlack widgetSearchBtn ']")
	WebElement searchButton;

	@FindBy(xpath = "//div[@class='fli-intl-lhs pull-left']/div[3]/div/div[1]/div/div")
	WebElement selectedFlight;

	@FindBy(xpath = "//div[@id='left-side--wrapper']//div[@class='fli-intl-lhs pull-left']/div/div[1]//div//div//div//div[1]/div[@class = 'pull-left']//div//div//div[@class='dept-time']")
	WebElement selectedFlightDepartureTime;
	String selectedFlightDepartureTimeText = "";

	@FindBy(xpath = "//div[@id='left-side--wrapper']//div[@class='fli-intl-lhs pull-left']/div/div[1]//div//div//div//div[1]/div[@class = 'pull-left']//div//div//p[@class='dept-city']")
	WebElement selectedFlightDepartureCity;
	String selectedFlightDepartureCityText = "";

	@FindBy(xpath = "//div[@id='left-side--wrapper']//div[@class='fli-intl-lhs pull-left']/div/div[1]//div//div//div//div[1]/div[@class = 'pull-left']//div//div//p[@class='reaching-time append_bottom3']")
	WebElement selectedFlightArrivalTime;
	String selectedFlightArrivalTimeText = "";

	@FindBy(xpath = "//div[@id='left-side--wrapper']//div[@class='fli-intl-lhs pull-left']/div/div[1]//div//div//div//div[1]/div[@class = 'pull-left']//div//div//p[@class='arrival-city']")
	WebElement selectedFlightArrivalCity;
	String selectedFlightArrivalCityText = "";

	@FindBy(xpath = "//div[@class='fli-intl-lhs pull-left']/div[3]/div/div[1]/div/div/div/div/div[3]/p/span")
	WebElement selectedFlightPrice;

	@FindBy(xpath = "//div[@class='fli-intl-lhs pull-left']/div[3]/div/div[1]/div/div/div/div/div[4]/button")
	WebElement buttonBooking;

	@FindBy(xpath = "//div[@class='fli_filter__col1 pull-left']/span[1]/label/span[@class='box']/span")
	WebElement checkBox;

	@FindBy(xpath = "//button[@id='review-continue']")
	WebElement continueButton;

	@FindBy(xpath = "//p[@class='fareSmry-row LatoBold']/span[2]/span/span")
	WebElement textPriceReviewpage;

	@FindBy(xpath = "//ul[@class='reviewStatus step2']/li[2]/span")
	WebElement progressBarReviewPage;

	@FindBy(xpath = "//ul[@class='reviewStatus step3']/li[3]/span")
	WebElement progressBarBookingPage;

	@FindBy(xpath = "//div[@id='insurance-section']//input[@value='no']/parent::label")
	WebElement insuranceNo;

	@FindBy(linkText = "More Filters")
	WebElement anchorMoreFilters;

	@FindBy(linkText = "Apply")
	WebElement anchorApply;

	@FindBy(xpath = "//div[@class='rc-slider']/div[4]")
	WebElement minimumPriceSlider;

	@FindBy(xpath = "//div[@class='rc-slider']/div[5]")
	WebElement maximumPriceSlider;

	@FindBy(xpath = "//div[@class='pull-left']/p[1]")
	WebElement tooManyFiltersText;

	@FindBy(linkText = "Flight details")
	WebElement flightDetailsAnchorTag;

	@FindBy(xpath = "//p[@class='dept-city']")
	WebElement flightDepartureCity;

	@FindBy(xpath = "//p[@class='dept-time append_bottom3']")
	WebElement flightDepartureTime;

	@FindBy(xpath = "//p[@class='arrival-city']")
	WebElement flightArrivalCity;

	@FindBy(xpath = "//p[@class='reaching-time append_bottom3']")
	WebElement flightArrivalTime;

	@FindBy(xpath = "//div[@class='fli_filter__col2 pull-left']/span[3]/label/span[1]")
	WebElement departureTimeFilter;

	@FindBy(xpath = "//div[@class='fli_filter__col3 pull-left']/span[3]/label/span[1]")
	WebElement arrivalTimeFilter;

	@FindBy(xpath = "//div[@class='fli_filter_extended-group__col pull-left col2 custom-scroll']/div/ul/li[1]")
	WebElement airlineFilter;

	@FindBy(xpath = "//span[@class='fullpage-error-icon']")
	WebElement errorPage;

	@FindBy(xpath = "//p[@class='fareSmry-row LatoBold']/span[2]")
	WebElement finalPrice;
	
	public void init() {
		logger = CustomLogger.logger;
		driver = DriverConfiguration.getDriver(DriverType.CHROME);
		driver.get(Util.BASE_URL_FLIGHTS);
		PageFactory.initElements(this.driver, this);
	}

	public void closeAd() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		String adframe = "webklipper-publisher-widget-container-notification-frame";
		String btn = "//a[@id='webklipper-publisher-widget-container-notification-close-div']";
		WebElement closeAd = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				driver.switchTo().frame(adframe);
				return driver.findElement(By.xpath(btn));
			}
		});
		if (closeAd != null) {
			closeAd.click();
		}
	}

	public boolean verifyDetails() {
		flightDetailsAnchorTag.click();
		CustomWait.waitFor(driver, flightDepartureCity);
		if (flightDepartureCity.getText().equals(selectedFlightDepartureCityText)
				&& flightArrivalCity.getText().equals(selectedFlightArrivalCityText)
				&& flightDepartureTime.getText().equals(selectedFlightDepartureTimeText)
				&& flightArrivalTime.getText().equals(selectedFlightArrivalTimeText)) {
			return true;
		}
		return false;
	}

	public String tooManyFiltersGetText() {
		CustomWait.waitFor(driver, tooManyFiltersText);
		return tooManyFiltersText.getText();
	}

	public void setMinimumPrice() {
		Actions actions = new Actions(driver);
		actions.moveToElement(minimumPriceSlider).dragAndDropBy(minimumPriceSlider, 0, 0).perform();
	}

	public void setMaximumPrice() {
		Actions actions = new Actions(driver);
		actions.moveToElement(maximumPriceSlider).dragAndDropBy(maximumPriceSlider, -100, 0).perform();
	}

	public String trackProgressBarOnReviewPage() {
		CustomWait.waitFor(driver, progressBarReviewPage);
		return progressBarReviewPage.getAttribute("class");
	}

	public String trackProgressBarOnBookingPage() {

		CustomWait.waitFor(driver, progressBarBookingPage);
		return progressBarBookingPage.getAttribute("class");
	}

	public void insertFilters() {
		checkBox.click();
		arrivalTimeFilter.click();
		anchorMoreFilters.click();
		airlineFilter.click();
		setMinimumPrice();
		setMaximumPrice();
		anchorApply.click();
	}

	public void enterSourceCity(String sourceCity) {
		fromCity.sendKeys(sourceCity);
		CustomWait.waitFor(driver, fromCityInput);
		fromCityInput.click();
	}

	public void enterDestinationCity(String destinationCity) {
		toCity.sendKeys(destinationCity);
		CustomWait.waitFor(driver, toCityInput);
		toCityInput.click();
	}

	public void sendDataToInputFields(String source, String destination, String date) {
		enterSourceCity(source);
		enterDestinationCity(destination);
		departureDateDiv.click();
		String caption = "";
		String currentMonthCaption = elementCurrentMonth.getText();
		String xpathForDateSelected = "//div[@class='dateInnerCell']/p[contains(text(),'" + date.substring(0, 2)
				+ "')]";
		if (!currentMonthCaption.equals(date.substring(3))) {
			while (!caption.equals("February 2020")) {
				caption = elementNextMonth.getText();
				logger.info(caption);
				nextMonth.click();
			}
		}

		WebElement datePicked = driver.findElement(By.xpath(xpathForDateSelected));
		CustomWait.waitFor(driver, datePicked);
		datePicked.click();

	}

	public void triggerSearchButton() {
		searchButton.click();
	}

	public boolean areFlightsAvailable() {
		if (DriverConfiguration.isElementPresent(By.xpath("//span[@class='fullpage-error-icon']"))) {
			return false;
		}
		return true;
	}

	public void quitDriver() {
		driver.quit();
	}

	String flightPrice = "";

	public boolean selectFlight() {

		try {
			if (DriverConfiguration.isElementPresent(
					By.xpath("//div[@class='fli-intl-lhs pull-left']/div[3]/div/div[1]/div[1]/div"))) {
				selectedFlightDepartureTimeText = selectedFlightDepartureTime.getText();
				selectedFlightDepartureCityText = selectedFlightDepartureCity.getText();
				selectedFlightArrivalTimeText = selectedFlightArrivalTime.getText();
				selectedFlightArrivalCityText = selectedFlightArrivalCity.getText();
				flightPrice = selectedFlightPrice.getText();
				CustomWait.waitFor(driver, buttonBooking);
				buttonBooking.click();
				return true;
			} else {
				throw new FlightNotFoundException(driver.getCurrentUrl());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	public void continueBooking() {
		try {
			if (areFlightsAvailable()) {
				Util.switchToLatestWindow(driver);
				insuranceNo.click();
				
				CustomWait.waitFor(driver, continueButton);
				continueButton.click();
				
				

			} else {
				throw new FlightsSoldOutException("Sorry!");
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public boolean checkPrice() {
		CustomWait.waitFor(driver, finalPrice);
		String flightPriceTemp = flightPrice.replaceAll(",", "");
		int selectedFlightPriceInt = Integer.parseInt(flightPriceTemp.substring(2)) + 5;
		String finalFlightPrice = finalPrice.getText().replaceAll(",", "").substring(2);
		return (finalFlightPrice.equals(String.valueOf(selectedFlightPriceInt)));
	}

}
