package com.epam.MakeMyTripAutomationUsingBDD.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions (
        features = {"../MakeMyTripAutomationUsingBDD/src/test/resources/features"}
        ,glue = {"com.epam.MakeMyTripAutomationUsingBDD.stepDefs"}
        ,tags = {"@MMTHotelSearch"}
        ,monochrome = true, dryRun = false)

public class TestHotelBooking {

	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {    	
        testNGCucumberRunner = new TestNGCucumberRunner(TestHotelBooking.class);
    }
    
    @Test(dataProvider = "hotelDataProvider")    
    public void feature(CucumberFeatureWrapper cucumberFeature) throws Throwable {
    	testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
     
    @DataProvider(name = "hotelDataProvider")
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();   	
    }
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {    	
        testNGCucumberRunner.finish();        
    }
}
