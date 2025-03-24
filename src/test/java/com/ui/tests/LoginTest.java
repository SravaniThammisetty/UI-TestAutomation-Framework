package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.pl");
        driver.findElement(By.className(".login")).click();
        driver.findElement(By.className(".login")).sendKeys("admin");

        driver.close();

	}

}
