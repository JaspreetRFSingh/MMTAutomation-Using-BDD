package com.epam.MakeMyTripAutomationUsingBDD.driverFactory;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class ExplorerDriverManager extends DriverManager {

	@Override
	protected void createWebDriver() {
		// TODO Auto-generated method stub
		InternetExplorerOptions options = new InternetExplorerOptions();
		this.driver=new InternetExplorerDriver(options);
		
	}
}
