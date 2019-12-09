package com.epam.MakeMyTripAutomationUsingBDD.stepDefs;

import com.epam.MakeMyTripAutomationUsingBDD.pages.HomePageT;

import cucumber.api.java.en.When;

public class HomePageFooterLinksStepDef {
	
	HomePageT hpt = new HomePageT();
	@When("^Hit every link just above the footer$")
	public void hit_every_link_just_above_the_footer() throws Throwable {
		hpt.openFooterLinks();
	}
}
