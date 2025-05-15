package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.findElement(By.id("input")).sendKeys("Selenium Webdriver");
	}
	
	

}
