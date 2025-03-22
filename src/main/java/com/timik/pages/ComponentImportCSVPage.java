package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComponentImportCSVPage extends BasePage {

	public ComponentImportCSVPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    
    private By importCSVBtn = By.xpath("//button[normalize-space()='Import CSV']");
    private By uploadCSVSection = By.xpath("");
    private By uploadCSV = By.xpath("");
    private By uploadCSVClose = By.xpath("");
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }
    
    public void clickImportCSV() {
    	driver.findElement(importCSVBtn).click();
    }
    
    public void clickUploadCSVSection() {
    	driver.findElement(uploadCSVSection).click();
    }
    
    public void clickUploadCSV() {
    	driver.findElement(uploadCSV).click();
    }
    
    public void clickUploadCSVClose() {
    	driver.findElement(uploadCSVClose).click();
    }
    
    

	

}

