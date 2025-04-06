package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import com.constants.Browser;

public abstract class BrowserUtilities {

    private WebDriver driver;
    
    public WebDriver getDriver() {
		return driver;
	}

	public BrowserUtilities(WebDriver driver) {
        super();
        this.driver = driver;
    }
	
	public BrowserUtilities(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		else {
			System.err.println("Invalid Browser Name.......Please select Chrome or Edge");
		}
	}
	
	public BrowserUtilities(Browser browserName) {
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
			System.err.println("Invalid Browser Name.......Please select Chrome or Edge");
		}
	}

    public void goToWebSite(String url) {
        driver.get(url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void clickOn(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public String getVisibleText(By locator) {
    	WebElement element = driver.findElement(locator);
    	return element.getText();
    }

}

