package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteUserRolesPage {
    WebDriver driver; 

    public DeleteUserRolesPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    
    private By deleteIcon = By.xpath("");
    private By inputField = By.xpath("//input[@id='name']");
    private By deleteBtn = By.xpath("//button[normalize-space()='Delete']");
    private By closeBtn = By.xpath("//a[@type='button']");
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }
    
    public void clickDeleteIcon() {
    	driver.findElement(deleteIcon).click();
    }
 
    public void enterText(String text) {
        WebElement input = driver.findElement(inputField);
        input.clear();
        input.sendKeys(text);
    }

    public void clickDeleteButton() {
        driver.findElement(deleteBtn).click();
    }

    public void clickCloseButton() {
        driver.findElement(closeBtn).click();
    }

    public boolean isPopupPresent() {
       return driver.findElement(deleteBtn).isDisplayed();
    } 
    
}

