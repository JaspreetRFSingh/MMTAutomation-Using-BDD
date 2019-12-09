package com.epam.MakeMyTripAutomationUsingBDD.exceptions;

import org.apache.log4j.Logger;

import com.epam.MakeMyTripAutomationUsingBDD.debug.CustomLogger;


public class BrokenLinkException extends Exception {

	Logger logger = CustomLogger.logger;
	private static final long serialVersionUID = 1L;

	public BrokenLinkException(String message) {
		logger.error("Link is broken with returned status code: " + message);
	}

}
