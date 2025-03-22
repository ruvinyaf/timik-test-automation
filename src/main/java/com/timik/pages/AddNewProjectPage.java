package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewProjectPage extends BasePage {

    public AddNewProjectPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    
    private By addNewProjectBtn = By.xpath("//button[normalize-space()='Add new project']");
    private By projectNamefield = By.xpath("//input[@id='projectName']");
    private By projectOwnerNameField = By.xpath("//input[@id='projectOwnerName']");
    private By clickCustomerName = By.xpath("//div[@class='select__value-container css-hlgwow']//div[@class='select__input-container css-19bb58m']");
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
    private By clickAssignees = By.xpath("//div[@id='assignees']//div[@class='select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer']");
    private By enterAssignees = By.xpath("");
    private By createBtn = By.xpath("//button[normalize-space()='Create']");
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }
    
    public void clickAddNewProject() {
        driver.findElement(addNewProjectBtn).click();
    }
    
    public void enterProjectName(String projectName) {
    	driver.findElement(projectNamefield).sendKeys(projectName);
    }
    
    public void enterProjectOwnerName(String ownerName) {
    	driver.findElement(projectOwnerNameField).sendKeys(ownerName);
    }
    
    public void clickCustomerName() {
    	driver.findElement(clickCustomerName).click();
    }
    
    public void selectCustomerName(String selectCusName) {
    	driver.findElement(enterCustomerName).sendKeys(selectCusName);
    }
    
    public void enterAddress(String address) {
    	driver.findElement(addressField).sendKeys(address);
    }
    
    public void enterCity(String city) {
    	driver.findElement(cityField).sendKeys(city);
    }
    
    public void enterCountry(String country) {
    	driver.findElement(countryField).sendKeys(country);
    }
    
    public void enterPostalCode(String postalCode) {
    	driver.findElement(postalCodeField).sendKeys(postalCode);
    }
    
    public void enterReferenceNumber(String referenceNumber) {
    	driver.findElement(referenceNumberField).sendKeys(referenceNumber);
    }
    
    public void enterTelephone(String telephone) {
    	driver.findElement(telephoneField).sendKeys(telephone);
    }
    
    public void enterFax(String fax) {
    	driver.findElement(faxField).sendKeys(fax);
    }
    
    public void enterProjectEmail(String projectEmail) {
    	driver.findElement(projectEmailField).sendKeys(projectEmail);
    }
    
    public void enterDescription(String description) {
    	driver.findElement(descriptionField).sendKeys(description);
    }
    
    public void clickAssignees() {
    	driver.findElement(clickAssignees).click();
    }
    
    public void selectAsiignees(String assignees) {
    	driver.findElement(enterAssignees).sendKeys(assignees);
    }
    
    public void clickCreate() {
    	driver.findElement(createBtn).click();
    }
    
	public String getRequiredFieldErrorMessage(String fieldName) {
		return driver.findElement(By.id(fieldName + "Error")).getText();
	}

}


