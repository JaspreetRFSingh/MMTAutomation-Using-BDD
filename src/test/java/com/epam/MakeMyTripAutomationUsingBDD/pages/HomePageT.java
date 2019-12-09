package com.epam.MakeMyTripAutomationUsingBDD.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.MakeMyTripAutomationUsingBDD.exceptions.BrokenLinkException;
import com.epam.MakeMyTripAutomationUsingBDD.utils.RestAssuredHelper;

public class HomePageT extends HomePage {

	RestAssuredHelper restAssuredHelper;
	
	public HomePageT() {
		restAssuredHelper = new RestAssuredHelper();
	}
	public void openFooterLinks() {

		List<String> hrefs = new ArrayList<String>();
		WebElement element = driver.findElement(By.xpath("//div[@class='landingContainer']/div"));
		List<WebElement> anchorTags = element.findElements(By.tagName("a"));
		for (WebElement anchor : anchorTags) {
			if (anchor.getAttribute("href") != null) {
				hrefs.add(anchor.getAttribute("href"));
			}
		}
		for (String href : hrefs) {
			int responseCode = 0;
			try {
				responseCode = restAssuredHelper.getStatusCode(href);
				if (responseCode != 200) {
					throw new BrokenLinkException(String.valueOf(responseCode));
				} else {
					logger.info(href + " is working.");
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
	}
}
