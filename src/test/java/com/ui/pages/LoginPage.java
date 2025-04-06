package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtilities;

public class LoginPage extends BrowserUtilities{
	
    private static final By EMAIL_TEXT_BOX_LOCATOR = By.cssSelector("#email");
    private static final By PASSWORD_TEXT_BOX_LOCATOR = By.cssSelector("#passwd");
    private static final By SIGN_IN_BUTTON_LOCATOR = By.cssSelector("#SubmitLogin");

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public MyAccountPage doLoginWith(String emailAddress, String password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SIGN_IN_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
		
	}

}
