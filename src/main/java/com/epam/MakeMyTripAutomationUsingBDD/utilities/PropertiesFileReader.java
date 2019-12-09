package com.epam.MakeMyTripAutomationUsingBDD.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	public Properties getProperty() throws IOException {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("../MakeMyTripAutomationUsingBDD/src/test/resources/url-config.properties"));
			properties.load(new FileInputStream("../MakeMyTripAutomationUsingBDD/src/test/resources/path-config.properties"));
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return properties;
	}
	

}
