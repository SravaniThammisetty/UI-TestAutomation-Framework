package com.ui.tests;


import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojos.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase{
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	@Test (description = "Verifies that the valid user is able to login into the application", groups = {"e2e", "sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LogiTestDataProvider",
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void loginTest(User user) {
        assertEquals(homePage.gotoLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Sravani T");
    }
	
	@Test (description = "Verifies that the valid user is able to login into the application", groups = {"e2e", "sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider", 
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void loginCSVTest(User user) {
        assertEquals(homePage.gotoLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Sravani T");
    }
	
	@Test (description = "Verifies that the valid user is able to login into the application", groups = {"e2e", "sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider",
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	
    public void loginExcelTest(User user) {
        assertEquals(homePage.gotoLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Sravani T1");
    }
}
