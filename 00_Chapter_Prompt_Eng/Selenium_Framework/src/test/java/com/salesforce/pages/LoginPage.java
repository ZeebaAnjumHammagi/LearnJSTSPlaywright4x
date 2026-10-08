package com.salesforce.pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='Login' or @name='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='rememberUn']")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//div[contains(@id,'error') or contains(@class,'error')][not(contains(@style,'display: none'))]")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        try {
            driver.get(url);
            wait.until(ExpectedConditions.visibilityOf(usernameInput));
        } catch (TimeoutException | NoSuchElementException e) {
            throw new RuntimeException("Salesforce login page did not load successfully.", e);
        }
    }

    public void enterUsername(String username) {
        try {
            wait.until(ExpectedConditions.visibilityOf(usernameInput));
            usernameInput.clear();
            usernameInput.sendKeys(username);
        } catch (TimeoutException | NoSuchElementException e) {
            throw new RuntimeException("Username field is not available.", e);
        }
    }

    public void enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            passwordInput.clear();
            passwordInput.sendKeys(password);
        } catch (TimeoutException | NoSuchElementException e) {
            throw new RuntimeException("Password field is not available.", e);
        }
    }

    public void clickLogin() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        } catch (TimeoutException | NoSuchElementException e) {
            throw new RuntimeException("Login button is not clickable.", e);
        }
    }

    public void selectRememberMe() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckbox));
            if (!rememberMeCheckbox.isSelected()) {
                rememberMeCheckbox.click();
            }
        } catch (TimeoutException | NoSuchElementException e) {
            throw new RuntimeException("Remember me checkbox is not available.", e);
        }
    }

    public boolean isLoginPageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(usernameInput)).isDisplayed()
                    && wait.until(ExpectedConditions.visibilityOf(passwordInput)).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public boolean isErrorVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
        } catch (TimeoutException | NoSuchElementException e) {
            return "";
        }
    }
}
