package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtilities;
import com.utility.JsonUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtilities {
	
	// This class follows Page Object Design Pattern
	// The first variables will be present here are Locators with the help of By class.
	// In Page object design pattern functions cannot have void return type.
	/* In POM if we click on a link and it's going to redirect to some other page, then we  
	 * are going to create the object of that other class and return that object.
	 */
	
	
	private static final By SIGN_IN_LINK_LOCATOR = By.cssSelector(".login");

	
	public HomePage(Browser browserName) {
		super(browserName);
		goToWebSite(JsonUtility.readJson(QA));
	}
	
	public LoginPage gotoLoginPage() {  
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	

}
