package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtilities;

public final class MyAccountPage extends BrowserUtilities{
	
	private static final By USER_NAME_LOCATOR = By.cssSelector("a[title='View my customer account'] span");

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getUserName() {
		return getVisibleText(USER_NAME_LOCATOR);
	}

}
