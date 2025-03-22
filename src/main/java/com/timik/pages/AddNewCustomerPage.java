package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewCustomerPage extends BasePage {

    public AddNewCustomerPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    
    private By addNewCustomerBtn = By.xpath("//button[normalize-space()='Add new customer']");
    private By customerNameField = By.xpath("//input[@id='customerName']");
    private By customerCompanyField = By.xpath("//input[@id='customerCompany']");
    private By customerContactField = By.xpath("//input[@id='customerContact']");
    private By customerContactPersonField = By.xpath("//input[@id='customerContactPerson']");
    private By customerEmailField = By.xpath("//input[@id='customerEmail']");
    private By customerAddressField = By.xpath("//input[@id='customerAddress']");
    private By createBtn = By.xpath("//button[normalize-space()='Create']");
    private By closeBtn = By.xpath("//a[@type='button']");
    
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    public void clickAddNewCustomer() {
        driver.findElement(addNewCustomerBtn).click();
    }

    public void enterCustomerName(String name) {
        driver.findElement(customerNameField).sendKeys(name);
    }

    public void enterCustomerComapnyName(String companyName) {
        driver.findElement(customerCompanyField).sendKeys(companyName);
    }

    public void enterCustomerContact(String contact) {
        driver.findElement(customerContactField).sendKeys(contact);
    }

    public void enterCustomerContactPerson(String contactPerson) {
        driver.findElement(customerContactPersonField).sendKeys(contactPerson);
    }

    public void enterCustomerEmail(String customerEmail) {
        driver.findElement(customerEmailField).sendKeys(customerEmail);
    }

    public void enterCustomerAddress(String address) {
        driver.findElement(customerAddressField).sendKeys(address);
    }

    public void clickCreate() {
        driver.findElement(createBtn).click();
    }
    
    public void clickClose() {
    	driver.findElement(closeBtn).click();
    }
    
	public String getRequiredFieldErrorMessage(String fieldName) {
		return driver.findElement(By.id(fieldName + "Error")).getText();
	}
}

