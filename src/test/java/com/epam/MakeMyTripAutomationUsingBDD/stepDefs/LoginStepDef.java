package com.epam.MakeMyTripAutomationUsingBDD.stepDefs;

import org.testng.Assert;
import com.epam.MakeMyTripAutomationUsingBDD.pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef {

	LoginPage loginPage;
	
	String userName = "";
	String pass = "";
	
	@Given("^Open mmt home page$")
	public void open_mmt_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    loginPage = new LoginPage();
	}

	@When("^Enter username as \"([^\"]*)\"$")
	public void enter_username_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		userName = arg1;
	}

	@When("^Enter password as \"([^\"]*)\"$")
	public void enter_password_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		pass = arg1;
		System.out.println(userName+" - "+ pass);
		loginPage.loginWithCredentials(userName, pass);
	}

	@Then("^Login should be successful$")
	public void login_should_be_successful() throws Throwable {
		Assert.assertTrue(loginPage.checkWhetherUserIsLoggedIn());
	}
	
	@After("@MMTLogin")
	public void shutDown() {
		loginPage.quitDriver();
	}
}
