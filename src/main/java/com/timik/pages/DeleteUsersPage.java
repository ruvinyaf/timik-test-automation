package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteUsersPage extends BasePage {

    public DeleteUsersPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");

    private By deleteIcon = By.xpath("");
    private By userInput = By.xpath("");
    private By deleteBtn = By.xpath("");
    private By closeBtn = By.xpath("");
  
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }
    
    public void clickDeleteIcon() {
        driver.findElement(deleteIcon).click();
    }

    public void enterUserName(String input) {
        driver.findElement(userInput).sendKeys(input);
    }

    public void clickDeleteButton() {
        driver.findElement(deleteBtn).click();
    }

    public void clickCloseButton() {
        driver.findElement(closeBtn).click();
    }
    
}

