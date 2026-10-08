package com.salesforce.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageInvalidTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        loginPage = new LoginPage(driver);
        loginPage.open(System.getProperty("salesforce.url", "https://login.salesforce.com/?locale=in"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void invalidLoginShouldShowError() {
        String username = System.getProperty("salesforce.invalid.username", "invalid.user@test.com");
        String password = System.getProperty("salesforce.invalid.password", "InvalidPassword123!");

        try {
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickLogin();

            Assert.assertTrue(loginPage.isErrorVisible(), "Expected login error message for an invalid login attempt.");
            String errorText = loginPage.getErrorMessage();
            Assert.assertTrue(errorText.toLowerCase().contains("username") || errorText.toLowerCase().contains("password") || errorText.toLowerCase().contains("check"),
                    "Expected an authentication error text after invalid login.");
        } catch (Exception e) {
            Assert.fail("Invalid login test failed: " + e.getMessage());
        }
    }
}
