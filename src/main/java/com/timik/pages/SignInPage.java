package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

    private WebDriver driver;

    // Define locators
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[@type='submit']");

    // Constructor
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    } 

    // Methods to interact with the elements
    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickSignIn() {
        WebElement signInElement = driver.findElement(signInButton);
        signInElement.click();
    }

    public void signIn(String email, String password, boolean rememberMe) throws InterruptedException {
        enterEmail(email);
        enterPassword(password);
        Thread.sleep(3000); 
        clickSignIn();
        Thread.sleep(3000);
    }
    
    public boolean isPageLoaded() {
    	return driver.getPageSource().contains("dashboard");
    }
}