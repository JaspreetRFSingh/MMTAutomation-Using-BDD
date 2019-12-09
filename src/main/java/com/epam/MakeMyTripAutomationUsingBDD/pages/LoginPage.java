package com.epam.MakeMyTripAutomationUsingBDD.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.MakeMyTripAutomationUsingBDD.config.DriverConfiguration;
import com.epam.MakeMyTripAutomationUsingBDD.config.DriverType;
import com.epam.MakeMyTripAutomationUsingBDD.utilities.CustomWait;
import com.epam.MakeMyTripAutomationUsingBDD.utilities.Util;


public class LoginPage{

	public WebDriver driver;

	@FindBy(xpath = "//p[contains(text(),'Login or Create Account')]")
	WebElement loginButton;

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	@FindBy(xpath = "//*[@id='password']")
	WebElement passwordField;

	@FindBy(xpath = "//button[@data-cy='login']")
	WebElement login;

	@FindBy(xpath = "//span[@class='crossIcon popupSprite popupCrossIcon']")
	WebElement modalClose;

	@FindBy(xpath = "//p[@class='whiteText appendBottom3 truncate']")
	WebElement loggedInUser;

	public LoginPage() {
		driver = DriverConfiguration.getDriver(DriverType.CHROME);
		driver.navigate().to(Util.BASE_URL);
		PageFactory.initElements(this.driver, this);
	}

	public void loginWithCredentials(String userName, String password) {
	
			loginButton.click();
			username.sendKeys(userName);
			username.submit();
			CustomWait.waitFor(driver, passwordField);
			passwordField.sendKeys(password);
			passwordField.submit();
			CustomWait.waitFor(driver, modalClose);
			modalClose.click();
	}

	public boolean checkWhetherUserIsLoggedIn() {
		return loggedInUser.getAttribute("data-cy").equals("loggedInUser");
	}
	
	public void quitDriver() {
		driver.quit();
	}
	
}
