package com.epam.MakeMyTripAutomationUsingBDD.stepDefs;

import org.testng.Assert;

import com.epam.MakeMyTripAutomationUsingBDD.pages.DealsPage;
import com.epam.MakeMyTripAutomationUsingBDD.pages.FlightsPage;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlightBookStepDef {

	FlightsPage flightsPage;
	String source = "";
	String destination = "";
	DealsPage deals;
	String searchOption = "";

	@Given("^Open MMT \"([^\"]*)\" page and click flights tag$")
	public void open_MMT_page_and_click_flights_tag(String arg1) throws Throwable {
		searchOption = arg1;
		flightsPage = new FlightsPage();
		flightsPage.init();
		if (searchOption.equalsIgnoreCase("deals")) {
			deals = new DealsPage();
			deals.init();
		}
	}

	@When("^Enter source city as \"([^\"]*)\"$")
	public void enter_source_city_as(String arg1) throws Throwable {
		source = arg1;
	}

	@When("^Enter destination city as \"([^\"]*)\"$")
	public void enter_destination_city_as(String arg1) throws Throwable {
		destination = arg1;
	}

	@When("^Enter values in input fields on \"([^\"]*)\" and hit search$")
	public void enter_values_in_input_fields_on_and_hit_search(String arg1) throws Throwable {
		String date = arg1;
		if (searchOption.equalsIgnoreCase("home")) {
			flightsPage.sendDataToInputFields(source, destination, date);
			flightsPage.triggerSearchButton();
		} else {
			deals.insertData(source, destination, date);
			deals.searchFlights();
		}
	}

	boolean flag = false;

	@When("^select the flight$")
	public void select_the_flight() throws Throwable {
		if (searchOption.equalsIgnoreCase("home")) {
			flag = flightsPage.selectFlight();
		}

	}

	@Then("^Continue the booking and check whether the flight booking progress bar is at right page\\.$")
	public void continue_the_booking_and_check_whether_the_flight_booking_progress_bar_is_at_right_page()
			throws Throwable {
		if (searchOption.equalsIgnoreCase("home")) {
			if (flag) {
				flightsPage.continueBooking();
				Assert.assertEquals(flightsPage.trackProgressBarOnBookingPage(), "numbering onpage");
			} else {
				Assert.assertEquals(flightsPage.tooManyFiltersGetText(), "Too many filters applied!");
			}
			Assert.assertTrue(flightsPage.verifyDetails());
			Assert.assertTrue(flightsPage.checkPrice());
		}

	}

	@After("@MMTFlightSearch")
	public void shutOff() {
		flightsPage.quitDriver();
	}
}
