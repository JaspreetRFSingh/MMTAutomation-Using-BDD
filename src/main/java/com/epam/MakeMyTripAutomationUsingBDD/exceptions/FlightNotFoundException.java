package com.epam.MakeMyTripAutomationUsingBDD.exceptions;

import org.apache.log4j.Logger;

import com.epam.MakeMyTripAutomationUsingBDD.debug.CustomLogger;


public class FlightNotFoundException extends Exception{

	Logger logger = CustomLogger.logger;
	
	private static final long serialVersionUID = 1L;
	
	public FlightNotFoundException( String message) {
		logger.info("Flights not found!");
		logger.info(message);
		
		
	}
	
}
