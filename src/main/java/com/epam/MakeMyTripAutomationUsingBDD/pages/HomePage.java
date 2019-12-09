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
import com.epam.MakeMyTripAutomationUsingBDD.utilities.CustomWait;
import com.epam.MakeMyTripAutomationUsingBDD.utilities.Util;

public class HomePage {

	public WebDriver driver;
	Logger logger;

	@FindBy(linkText = "Flights")
	WebElement flightAnchorTag;
	@FindBy(linkText = "Hotels")
	WebElement hotelAnchorTag;
	@FindBy(linkText = "Villas & Apts")
	WebElement villasAnchorTag;
	@FindBy(linkText = "Holidays")
	WebElement holidaysAnchorTag;
	@FindBy(linkText = "Trains")
	WebElement trainsAnchorTag;
	@FindBy(linkText = "Buses")
	WebElement busesAnchorTag;
	@FindBy(linkText = "Cabs")
	WebElement cabsAnchorTag;
	@FindBy(linkText = "Visa")
	WebElement visaAnchorTag;
	@FindBy(linkText = "Giftcards")
	WebElement giftCardsAnchorTag;
	@FindBy(xpath = "//li[@data-cy='menu_More']/a")
	WebElement moreAnchorTag;
	@FindBy(linkText = "Deals")
	WebElement dealsAnchorTag;
	

	public HomePage() {
		logger = CustomLogger.logger;
		driver = DriverConfiguration.getDriver(DriverType.CHROME);
		driver.get(Util.BASE_URL);
		PageFactory.initElements(this.driver, this);
	}

	public void refreshLoadHomePage() {
		driver.navigate().to(Util.BASE_URL);
	}
	
	public void closeAd() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)                           
                .withTimeout(Duration.ofSeconds(10))            
                .pollingEvery(Duration.ofSeconds(5))            
                .ignoring(NoSuchElementException.class);
        String adframe = "webklipper-publisher-widget-container-notification-frame";
        String btn = "//a[@id='webklipper-publisher-widget-container-notification-close-div']";
        WebElement closeAd = wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver ) {
                driver.switchTo().frame(adframe);
                return driver.findElement(By.xpath(btn));
            }
        });
        if(closeAd!=null) {
        closeAd.click();
        }
        //CustomWait.waitFor(2800);
	}


	public FlightsPage navigateToFlightsPage() {
		return new FlightsPage();
	}

	public DealsPage navigateToDealsPage() {
		return new DealsPage();
	}

	public HotelsPage navigateToHotelsPage() {
		return new HotelsPage();
	}

	public String openFlightsPage() {
		flightAnchorTag.click();
		CustomWait.waitForUrl(driver, "flights");
		return driver.getCurrentUrl();
	}

	public String openHotelsPage() {
		hotelAnchorTag.click();
		CustomWait.waitForUrl(driver, "hotels");
		return driver.getCurrentUrl();
	}

	public String openVillasAndAptsPage() {
		villasAnchorTag.click();
		CustomWait.waitForUrl(driver, "homestays");
		return driver.getCurrentUrl();
	}

	public String openHolidaysPage() {
		holidaysAnchorTag.click();
		CustomWait.waitForUrl(driver, "holidays-india");
		return driver.getCurrentUrl();
	}

	public String openTrainsPage() {
		trainsAnchorTag.click();
		CustomWait.waitForUrl(driver, "railways");
		return driver.getCurrentUrl();
	}

	public String openBusesPage(){
		busesAnchorTag.click();
		CustomWait.waitForUrl(driver, "bus-tickets");
		return driver.getCurrentUrl();
	}

	public String openCabsPage() {
		cabsAnchorTag.click();
		CustomWait.waitForUrl(driver, "cabs");
		return driver.getCurrentUrl();
	}

	public String openVisaPage() {
		visaAnchorTag.click();
		CustomWait.waitForUrl(driver, "visa");
		return driver.getCurrentUrl();
	}

	public String openGiftCardsPage() {
		giftCardsAnchorTag.click();
		CustomWait.waitForUrl(driver, "gift-cards");
		return driver.getCurrentUrl();
	}

	public void openMoreMenuPage() {
		CustomWait.waitFor(driver, moreAnchorTag);
		Actions actions = new Actions(driver);
		actions.moveToElement(moreAnchorTag).click().perform();
	}

	public void openDealsPage() {
		CustomWait.waitFor(driver, dealsAnchorTag);
		Actions actions = new Actions(driver);
		actions.moveToElement(dealsAnchorTag).click().perform();
	}
	public String getUrlOfDealsPage() {
		CustomWait.waitForUrl(driver, "daily-deals");
		return driver.getCurrentUrl();
	}
	public void quitDriver() {
		driver.quit();
	}
}
