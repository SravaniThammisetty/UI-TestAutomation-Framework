package com.ui.tests;


import static com.constants.Browser.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojos.User;

public class LoginTest {
	
	private HomePage homePage;
	
	@BeforeTest(description = "Load the Homepage of the website")
	public void setUp() {
		homePage = new HomePage(FIREFOX);
	}
	
	@Test (description = "Verifies that the valid user is able to login into the application", groups = {"e2e", "sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LogiTestDataProvider")
    public void loginTest(User user) {
        assertEquals(homePage.gotoLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Sravani T");
    }
	
	@Test (description = "Verifies that the valid user is able to login into the application", groups = {"e2e", "sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
    public void loginCSVTest(User user) {
        assertEquals(homePage.gotoLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Sravani T");
//        homePage.quitBrowser();
    }
}
