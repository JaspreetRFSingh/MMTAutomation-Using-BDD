package com.epam.MakeMyTripAutomationUsingBDD.driverFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

	@Override
	protected void createWebDriver() {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		this.driver=new ChromeDriver(options);
		
	}

}
