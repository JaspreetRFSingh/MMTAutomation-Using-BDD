package com.epam.MakeMyTripAutomationUsingBDD.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "../MakeMyTripAutomationUsingBDD/src/test/resources/features", 
			glue = {"com.epam.MakeMyTripAutomationUsingBDD.stepDefs" }, 
			tags = {"@MMTHomePageNavbar"}, dryRun = false)
public class TestHomePageNavBar {
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(TestHomePageNavBar.class);
	}

	@Test(dataProvider = "homePageNavBarFeature")
	public void testHomePageNavBar(CucumberFeatureWrapper cucumberFeature) throws Throwable {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	
	@DataProvider(name = "homePageNavBarFeature")
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
		
	}
}
