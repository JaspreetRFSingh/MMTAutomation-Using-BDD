package com.epam.MakeMyTripAutomationUsingBDD.exceptions;

import org.apache.log4j.Logger;

import com.epam.MakeMyTripAutomationUsingBDD.debug.CustomLogger;


public class FlightsSoldOutException extends Exception {

Logger logger = CustomLogger.logger;
	
	private static final long serialVersionUID = 1L;
	public FlightsSoldOutException(String message) {
		logger.error(message);
		
	}
}
