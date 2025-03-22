package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UpdateCustomerPage extends BasePage {
	
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    
    private By updateCustomerBtn = By.xpath("");
    private By customerNameField = By.xpath("//input[@id='customerName']");
    private By customerCompanyField = By.xpath("//input[@id='customerCompany']");
    private By customerContactField = By.xpath("//input[@id='customerContact']");
    private By customerContactPersonField = By.xpath("//input[@id='customerContactPerson']");
    private By customerEmailField = By.xpath("//input[@id='customerEmail']");
    private By customerAddressField = By.xpath("//input[@id='customerAddress']");
    private By updateBtn = By.xpath("//button[normalize-space()='Update']");
    private By closeBtn = By.xpath("//a[@type='button']");
	

    public UpdateCustomerPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    public void setCustomerName(String customerName) {
        driver.findElement(customerNameField).clear();
        driver.findElement(customerNameField).sendKeys(customerName);
    }

    public void setCustomerCompany(String customerCompany) {
        driver.findElement(customerCompanyField).clear();
        driver.findElement(customerCompanyField).sendKeys(customerCompany);
    }

    public void setCustomerContact(String customerContact) {
        driver.findElement(customerContactField).clear();
        driver.findElement(customerContactField).sendKeys(customerContact);
    }

    public void setCustomerContactPerson(String customerContactPerson) {
        driver.findElement(customerContactPersonField).clear();
        driver.findElement(customerContactPersonField).sendKeys(customerContactPerson);
    }

    public void setCustomerEmail(String customerEmail) {
        driver.findElement(customerEmailField).clear();
        driver.findElement(customerEmailField).sendKeys(customerEmail);
    }

    public void setCustomerAddress(String customerAddresss) {
        driver.findElement(customerAddressField).clear();
        driver.findElement(customerAddressField).sendKeys(customerAddresss);
    }
    
    public void clickUpdate() {
    	driver.findElement(updateBtn).click();
    }
    
    public void clickClose() {
    	driver.findElement(closeBtn).click();
    }
    
	public String getRequiredFieldErrorMessage(String fieldName) {
		return driver.findElement(By.id(fieldName + "Error")).getText();
	}
    
}


