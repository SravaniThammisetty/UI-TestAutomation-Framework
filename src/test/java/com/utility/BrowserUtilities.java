package com.utility;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import com.constants.Browser;

public abstract class BrowserUtilities {

    private WebDriver driver;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    
    public WebDriver getDriver() {
		return driver;
	}

	public BrowserUtilities(WebDriver driver) {
        super();
        this.driver = driver;
    }
	
	public BrowserUtilities(String browserName) {
		logger.info("Launching the Browser for "+browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		else {
			logger.error("Invalid Browser Name.......Please select Chrome or Edge");
			System.err.println("Invalid Browser Name.......Please select Chrome or Edge");
		}
	}
	
	public BrowserUtilities(Browser browserName) {
		logger.info("Launching the Browser for "+browserName);
		if(browserName == Browser.CHROME) {
			driver = new ChromeDriver();
		}
		
		else if(browserName == Browser.EDGE) {
			driver = new EdgeDriver();
		}
		
		else if(browserName == Browser.FIREFOX) {
			driver = new EdgeDriver();
		}
		
		else {
			logger.error("Invalid Browser Name.......Please select Chrome or Edge");
			System.err.println("Invalid Browser Name.......Please select Chrome or Edge");
		}
	}

    public void goToWebSite(String url) {
    	logger.info("Visiting the website "+url);
        driver.get(url);
    }

    public void maximizeWindow() {
    	logger.info("Maximizing the browser window");
        driver.manage().window().maximize();
    }

    public void clickOn(By locator) {
    	logger.info("Finding element with the locator"+locator);
        WebElement element = driver.findElement(locator);
        logger.info("Element Found and now performing Click");
        element.click();
    }

    public void enterText(By locator, String textToEnter) {
    	logger.info("Finding element with the locator"+locator);
        WebElement element = driver.findElement(locator);
        logger.info("Element Found and now enter text "+textToEnter);
        element.sendKeys(textToEnter);
    }

    public String getVisibleText(By locator) {
    	logger.info("Finding element with the locator"+locator);
    	WebElement element = driver.findElement(locator);
    	logger.info("Element Found and now retruning the visible text "+element.getText());
    	return element.getText();
    }
    
    public void quitBrowser() {
        driver.quit();
    }

}

