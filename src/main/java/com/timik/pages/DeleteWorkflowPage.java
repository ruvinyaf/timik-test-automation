package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteWorkflowPage {
    WebDriver driver;
    
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");

    By deleteIcon = By.xpath(""); 
    By workflowNameInput = By.xpath("//input[@id='name']"); 
    By deleteButton = By.xpath("//button[normalize-space()='Delete']"); 
    By closeButton = By.xpath("//a[@type='button']");
  
    public DeleteWorkflowPage(WebDriver driver) {
        this.driver = driver;
    }
  
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }
    
    // Methods to interact with elements
    public void clickDeleteIcon() {
        driver.findElement(deleteIcon).click();
    }

    public void enterWorkflowName(String workflowName) {
        driver.findElement(workflowNameInput).sendKeys(workflowName);
    }

    public void clickDeleteButton() {
        driver.findElement(deleteButton).click();
    }

    public void clickCloseButton() {
        driver.findElement(closeButton).click();
    }
}

