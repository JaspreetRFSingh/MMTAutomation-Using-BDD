package com.epam.MakeMyTripAutomationUsingBDD.driverFactory;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager{
	@Override
	protected void createWebDriver() {
		// TODO Auto-generated method stub
		FirefoxOptions options = new FirefoxOptions();
		this.driver=new FirefoxDriver(options);
		
	}
}
