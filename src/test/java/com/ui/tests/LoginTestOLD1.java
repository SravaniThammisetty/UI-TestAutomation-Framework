package com.ui.tests;


import com.utility.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestOLD1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        BrowserUtilities browserUtilities = new BrowserUtilities(driver);
        browserUtilities.goToWebSite("http://automationpractice.pl");
        browserUtilities.maximizeWindow();

        By signInLinkLocator = By.cssSelector(".login");
        browserUtilities.clickOn(signInLinkLocator);

        By emailBoxLocator = By.cssSelector("#email");
        browserUtilities.enterText(emailBoxLocator,"ropixet623@gamebcs.com");

        By passwordBoxLocator = By.cssSelector("#passwd");
        browserUtilities.enterText(passwordBoxLocator,"password");

        By signInButtonLocator = By.cssSelector("#SubmitLogin");
        browserUtilities.clickOn(signInButtonLocator);

       // browserUtilities.closeWindow();

    }
}
