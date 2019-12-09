package com.epam.MakeMyTripAutomationUsingBDD.stepDefs;

import org.testng.Assert;
import com.epam.MakeMyTripAutomationUsingBDD.pages.HotelsPage;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HotelBookStepDef {
	HotelsPage hotelsPage;
	
	@Given("^Hotels link is opened from Homepage$")
	public void hotels_link_is_opened_from_Homepage() throws Throwable {
		hotelsPage = new HotelsPage();
	}

	@When("^Enter data in input fields in area \"([^\"]*)\"\\.$")
	public void enter_data_in_input_fields_in_area(String arg1) throws Throwable {
		hotelsPage.insertDetails(arg1);
	}

	@When("^Click on search button$")
	public void click_on_search_button() throws Throwable {
		hotelsPage.hitEnterSearch();
	}

	@When("^Apply filters and sort by price$")
	public void apply_filters_and_sort_by_price() throws Throwable {
		hotelsPage.sortByOptions();
	}

	@When("^Clear filters$")
	public void clear_filters() throws Throwable {
		hotelsPage.clearFilters();
	}

	@Then("^page should return a list of hotels with all filters cleared$")
	public void page_should_return_a_list_of_hotels_with_all_filters_cleared() throws Throwable {
		Assert.assertTrue(hotelsPage.checkListIsSorted());
	}
	
	@After("@MMTHotelSearch")
	void quitDriver() {
		hotelsPage.quitDriver();
	}
	
}
