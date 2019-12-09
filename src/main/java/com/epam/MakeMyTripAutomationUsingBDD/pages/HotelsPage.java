package com.epam.MakeMyTripAutomationUsingBDD.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.MakeMyTripAutomationUsingBDD.config.DriverConfiguration;
import com.epam.MakeMyTripAutomationUsingBDD.config.DriverType;
import com.epam.MakeMyTripAutomationUsingBDD.debug.CustomLogger;
import com.epam.MakeMyTripAutomationUsingBDD.utilities.CustomWait;
import com.epam.MakeMyTripAutomationUsingBDD.utilities.Util;

public class HotelsPage{

	public WebDriver driver;
	Logger logger;

	
	@FindBy(xpath = "//li[@id='react-autowhatever-1-section-0-item-0']")
	WebElement inputCityAutoClick;

	// input[@class='react-autosuggest__input react-autosuggest__input--open']
	@FindBy(xpath = "//input[contains(@placeholder,'Enter city/ Hotel/ Area/ Building')]")
	WebElement inputCity;

	@FindBy(xpath = "//input[@id='city']")
	WebElement inputCityClick;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[2]/div/div/div[2]")
	WebElement checkinDate;

	@FindBy(xpath = "//div[@class='datePickerContainer']/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div[text()='23']")
	WebElement checkinDateSelect;

	@FindBy(xpath = "//div[@class='datePickerContainer']/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div[text()='26']")
	WebElement checkoutDateSelect;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[2]/div/div/div[3]/label")
	WebElement checkoutDate;

	@FindBy(xpath = "//input[@id='guest']")
	WebElement guestsButton;

	@FindBy(xpath = "//div[@class='widgetSection appendBottom40']//ul[1]//li[2]")
	WebElement numberOfAdults;

	@FindBy(xpath = "//button[contains(@class,'btnAddRoom')]")
	WebElement buttonAddAnotherRoom;

	@FindBy(xpath = "//button[contains(@class,'primaryBtn btnApply')]")
	WebElement buttonApplyRoomPreferences;

	@FindBy(xpath = "//button[@id='hsw_search_button']")
	WebElement buttonTriggerSearch;

	@FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	WebElement nextMonth;

	@FindBy(xpath = "//span[@class='customSelectTitle blueText latoBold']")
	WebElement dropDownSortBy;

	@FindBy(xpath = "//li[contains(text(),'Price - Low to High')]")
	WebElement priceLowToHighOption;

	@FindBy(xpath = "//a[@class='mapCont']")
	WebElement mapClick;

	@FindBy(xpath = "//span[@class='mapClose']")
	WebElement closeMap;

	@FindBy(xpath = "//label[contains(text(),'Free Breakfast')]")
	WebElement breakfastFilter;

	@FindBy(xpath = "//label[contains(text(),'Bonfire')]")
	WebElement resortFilter;

	@FindBy(xpath = "//a[@class='latoBold font12 capText']")
	WebElement clearFilters;

	@FindBy(xpath = "//div[@id='hlistpg_fr_facility']//span[text()='Show More']")
	WebElement showMoreFacilities;
	
	public HotelsPage() {
		driver = DriverConfiguration.getDriver(DriverType.CHROME);
		driver.get(Util.BASE_URL_HOTELS);
		logger = CustomLogger.logger;
		PageFactory.initElements(this.driver, this);
	}
	
	public List<WebElement> findElementsPrice() {
		return driver.findElements(By.xpath("//div[@class='priceDetails textRight']/div[2]/div/p[3]"));
	}

	public void sortByOptions() {
		CustomWait.waitFor(driver, mapClick);
		mapClick.click();
		CustomWait.waitFor(driver, closeMap);
		closeMap.click();
		CustomWait.waitFor(driver, breakfastFilter);
		breakfastFilter.click();
		//CustomWait.waitFor(driver, showMoreFacilities);
		//showMoreFacilities.click();
		//CustomWait.waitFor(driver, resortFilter);
		//resortFilter.click();
		CustomWait.waitFor(driver, dropDownSortBy);
		dropDownSortBy.click();
		CustomWait.waitFor(driver, priceLowToHighOption);
		priceLowToHighOption.click();
			}

	public List<WebElement> hotelPriceWebElements;
	public List<Integer> hotelPriceInteger;

	public void clearFilters() {
		clearFilters.click();
		hotelPriceWebElements = findElementsPrice();
		hotelPriceInteger = new ArrayList<Integer>();
		int count = 0;
		for (WebElement we : hotelPriceWebElements) {
			String currentElementPrice = we.getText();
			if (count < 5) {
				int size = currentElementPrice.length();
				String integertoBeAdded = "";
				for (int i = 0; i < size; i++) {
					if (Character.isDigit(currentElementPrice.charAt(i))) {
						integertoBeAdded += currentElementPrice.charAt(i);
					}
				}
				hotelPriceInteger.add(Integer.parseInt(integertoBeAdded));
				count++;
			}
		}
	}

	public boolean checkListIsSorted() {
		Iterator<Integer> iterator = hotelPriceInteger.iterator();
		Integer current, previous = iterator.next();
		while (iterator.hasNext()) {
			current = iterator.next();
			if (current < previous) {
				return false;
			}
		}
		return true;
	}
	
	
	

	public void insertDetails(String area) {
		CustomWait.waitFor(driver, inputCityClick);
		inputCityClick.click();
		inputCity.sendKeys(area);
		CustomWait.waitFor(driver, inputCityAutoClick);
		inputCityAutoClick.click();
		List<WebElement> captions = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']"));
		String caption = "";
		while (!caption.equals("January2020")) {
			caption = captions.get(1).getText();
			nextMonth.click();
		}
		checkinDate.click();
		checkinDateSelect.click();
		checkoutDateSelect.click();
		guestsButton.click();
		numberOfAdults.click();
		buttonAddAnotherRoom.click();
		buttonApplyRoomPreferences.click();
		
	}

	public void hitEnterSearch() {
		buttonTriggerSearch.click();
	}
	
	public void quitDriver() {
		driver.quit();
	}

}
