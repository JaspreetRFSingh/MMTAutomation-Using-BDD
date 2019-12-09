package com.epam.MakeMyTripAutomationUsingBDD.stepDefs;

import org.testng.Assert;
import com.epam.MakeMyTripAutomationUsingBDD.pages.HomePage;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomeNavBarStepDefs {

	HomePage homePage;

	@Given("^Open homePage$")
	public void open_homePage() throws Throwable {
		homePage = new HomePage();
	}

	@Then("^Assert nav link for flights$")
	public void assert_nav_link_for_flights() throws Throwable {
		homePage.openFlightsPage();
		Assert.assertTrue(homePage.driver.getCurrentUrl().contains("flights"));
	}


	@Then("^Assert nav link for cabs$")
	public void assert_nav_link_for_cabs() throws Throwable {
		homePage.openCabsPage();
		Assert.assertTrue(homePage.driver.getCurrentUrl().contains("cabs"));
	}

	@Then("^Assert nav link for buses$")
	public void assert_nav_link_for_buses() throws Throwable {
		homePage.openBusesPage();
		Assert.assertTrue(homePage.driver.getCurrentUrl().contains("bus-tickets"));
	}

	@Then("^Assert nav link for holidays$")
	public void assert_nav_link_for_holidays() throws Throwable {
		homePage.openHolidaysPage();
		Assert.assertTrue(homePage.driver.getCurrentUrl().contains("holidays"));
	}

	@Then("^Assert nav link for trains$")
	public void assert_nav_link_for_trains() throws Throwable {
		homePage.openTrainsPage();
		Assert.assertTrue(homePage.driver.getCurrentUrl().contains("railways"));
	}

	@Then("^Assert nav link for hotels$")
	public void assert_nav_link_for_hotels() throws Throwable {
		homePage.openHotelsPage();
		Assert.assertTrue(homePage.driver.getCurrentUrl().contains("hotels"));
	}


	@Then("^Assert nav link for Villas And Apartments$")
	public void assert_nav_link_for_Villas_And_Apartments() throws Throwable {
		homePage.openVillasAndAptsPage();
		Assert.assertTrue(homePage.driver.getCurrentUrl().contains("homestays"));

	}

	@Then("^Assert nav link for visa$")
	public void assert_nav_link_for_visa() throws Throwable {
		homePage.openVisaPage();
		Assert.assertTrue(homePage.driver.getCurrentUrl().contains("visa"));
	}

	@Then("^Assert nav link for gift-cards$")
	public void assert_nav_link_for_gift_cards() throws Throwable {
		homePage.openGiftCardsPage();
		Assert.assertTrue(homePage.driver.getCurrentUrl().contains("gift-cards"));
	}
	

	@Then("^Assert nav link for deals$")
	public void assert_nav_link_for_deals() throws Throwable {
		homePage.refreshLoadHomePage();
		homePage.openMoreMenuPage();
		homePage.openDealsPage();
	}
	
	@After("@MMTHomePageNavbar")
	public void shutOff() {
		homePage.quitDriver();
	}
}
