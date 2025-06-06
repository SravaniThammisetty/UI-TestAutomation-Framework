package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import com.constants.Browser;

public abstract class BrowserUtilities {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    Logger logger = LoggerUtility.getLogger(this.getClass());
    
    public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtilities(WebDriver driver) {
        super();
        this.driver.set(driver);
    }
	
	public BrowserUtilities(String browserName) {
		logger.info("Launching the Browser for "+browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}
		
		else {
			logger.error("Invalid Browser Name.......Please select Chrome or Edge");
			System.err.println("Invalid Browser Name.......Please select Chrome or Edge");
		}
	}
	
	public BrowserUtilities(Browser browserName) {
		logger.info("Launching the Browser for "+browserName);
		if(browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		}
		
		else if(browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		}
		
		else if(browserName == Browser.FIREFOX) {
			driver.set(new EdgeDriver());
		}
		
		else {
			logger.error("Invalid Browser Name.......Please select Chrome or Edge");
			System.err.println("Invalid Browser Name.......Please select Chrome or Edge");
		}
	}

    public void goToWebSite(String url) {
    	logger.info("Visiting the website "+url);
        driver.get().get(url);
    }

    public void maximizeWindow() {
    	logger.info("Maximizing the browser window");
        driver.get().manage().window().maximize();
    }

    public void clickOn(By locator) {
    	logger.info("Finding element with the locator"+locator);
        WebElement element = driver.get().findElement(locator);
        logger.info("Element Found and now performing Click");
        element.click();
    }

    public void enterText(By locator, String textToEnter) {
    	logger.info("Finding element with the locator"+locator);
        WebElement element = driver.get().findElement(locator);
        logger.info("Element Found and now enter text "+textToEnter);
        element.sendKeys(textToEnter);
    }

    public String getVisibleText(By locator) {
    	logger.info("Finding element with the locator"+locator);
    	WebElement element = driver.get().findElement(locator);
    	logger.info("Element Found and now retruning the visible text "+element.getText());
    	return element.getText();
    }
    
    public void quitBrowser() {
        driver.get().quit();
    }
    
    public String takeScreenShot(String name) {
    	TakesScreenshot screenshot = (TakesScreenshot) driver.get();
    	File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
    	Date date = new Date();
    	SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
    	String timeStamp = format.format(date);
//    	String path = System.getProperty("user.dir") + "//screenshots//" + name +" - "+timeStamp+".png";
		String path = "screenshots/" + name + " - " + timeStamp + ".png";
    	File screenshotFile = new File(path);
    	try {
    		FileUtils.copyFile(screenshotData, screenshotFile);
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	return path;
    }
}

