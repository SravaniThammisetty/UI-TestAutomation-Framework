package com.ui.tests;


import static com.constants.Browser.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;

public class LoginTest {
	
	private HomePage homePage;
	
	@BeforeTest(description = "Load the Homepage of the website")
	public void setUp() {
		homePage = new HomePage(CHROME);
	}
	
	@Test (description = "Verifies that the valid user is able to login into the application", groups = {"e2e", "sanity"})
    public void loginTest() {
        assertEquals(homePage.gotoLoginPage().doLoginWith("ropixet623@gamebcs.com", "password").getUserName(), "Sravani T");
    }
}
