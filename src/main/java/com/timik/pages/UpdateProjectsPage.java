package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateProjectsPage extends BasePage {
	
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");

    private By updateProjectBtn = By.xpath("");
    private By projectNamefield = By.xpath("//input[@id='projectName']");
    private By projectOwnerNameField = By.xpath("//input[@id='projectOwnerName']");
    private By clickCustomerName = By.xpath("");
    private By enterCustomerName = By.xpath("");
    private By addressField = By.xpath("//input[@id='address']");
    private By cityField = By.xpath("//input[@id='city']");
    private By countryField = By.xpath("//input[@id='country']");
    private By postalCodeField = By.xpath("//input[@id='postalCode']");
    private By referenceNumberField = By.xpath("//input[@id='referenceNumber']");
    private By telephoneField = By.xpath("//input[@id='telephone']");
    private By faxField = By.xpath("//input[@id='fax']");
    private By projectEmailField = By.xpath("//input[@id='email']");
    private By descriptionField = By.xpath("//input[@id='description']");
    private By clickAssignees = By.xpath("");
    private By enterAssignees = By.xpath("");
    private By updateBtn = By.xpath("//button[normalize-space()='Update']");

    public UpdateProjectsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password); 
        driver.findElement(signInButton).click();
    }
    
    public void clickUpdateIcon() {
    	driver.findElement(updateProjectBtn).click();
    }

    public void setProjectName(String projectName) {
        driver.findElement(projectNamefield).clear();
        driver.findElement(projectNamefield).sendKeys(projectName);
    }

    public void setProjectOwnerName(String projectOwnerName) {
        driver.findElement(projectOwnerNameField).clear();
        driver.findElement(projectOwnerNameField).sendKeys(projectOwnerName);
    }
    
    public void clickCustomerName() {
    	driver.findElement(clickCustomerName).click();
    }
    
    public void setCustomerName(String customerName) {
    	driver.findElement(enterCustomerName).clear();
    	driver.findElement(enterCustomerName).sendKeys(customerName);
    }
    
    public void setAddress(String address) {
    	driver.findElement(addressField).clear();
    	driver.findElement(addressField).sendKeys(address);
    }

    public void setCity(String city) {
    	driver.findElement(cityField).clear();
    	driver.findElement(cityField).sendKeys(city);
    }
    
    public void setCountry(String country) {
    	driver.findElement(countryField).clear();
    	driver.findElement(countryField).sendKeys(country);
    }
    
    public void setPostalCode(String postalCode) {
    	driver.findElement(postalCodeField).clear();
    	driver.findElement(postalCodeField).sendKeys(postalCode);
    }
    
    public void setReferenceNumber(String referenceNumber) {
    	driver.findElement(referenceNumberField).clear();
    	driver.findElement(referenceNumberField).sendKeys(referenceNumber);
    }
    
    public void setTelephone(String telephone) {
    	driver.findElement(telephoneField).clear();
    	driver.findElement(telephoneField).sendKeys(telephone);
    }
    
    public void setFax(String fax) {
    	driver.findElement(faxField).clear();
    	driver.findElement(faxField).sendKeys(fax);
    }
    
    public void setProjectEmail(String projectEmail) {
    	driver.findElement(projectEmailField).clear();
    	driver.findElement(projectEmailField).sendKeys(projectEmail);
    }
    
    public void setDescription(String description) {
    	driver.findElement(descriptionField).clear();
    	driver.findElement(descriptionField).sendKeys(description);
    }
    
    public void clickAssignees() {
    	driver.findElement(clickAssignees).click();
    }
    
    public void setAssignees(String assignee) {
    	driver.findElement(enterAssignees).clear();
    	driver.findElement(enterAssignees).sendKeys(assignee);
    }
    
    public void clickUpdate() {
    	driver.findElement(updateBtn).click();
    }
    
	public String getRequiredFieldErrorMessage(String fieldName) {
		return driver.findElement(By.id(fieldName + "Error")).getText();
	}

    
}


