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

public class LoginPageValidTest {
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
    public void validLoginShouldSucceed() {
        String username = System.getProperty("salesforce.username");
        String password = System.getProperty("salesforce.password");

        try {
            Assert.assertNotNull(username, "Salesforce username is not configured.");
            Assert.assertNotNull(password, "Salesforce password is not configured.");

            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickLogin();

            boolean successfulLogin = !loginPage.isLoginPageDisplayed() || !driver.getCurrentUrl().contains("login.salesforce.com");
            Assert.assertTrue(successfulLogin, "Valid Salesforce login did not redirect to an authenticated page.");
        } catch (Exception e) {
            Assert.fail("Valid login test failed: " + e.getMessage());
        }
    }
}
