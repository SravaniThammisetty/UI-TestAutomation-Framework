package com.ui.tests;


import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        HomePage homePage = new HomePage(driver);
        
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.doLoginWith("ropixet623@gamebcs.com", "password");

    }
}
