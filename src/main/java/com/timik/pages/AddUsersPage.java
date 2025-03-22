package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddUsersPage extends BasePage {

    public AddUsersPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    
    private By addNewUserBtn = By.xpath("");
    private By userNameField = By.xpath("//input[@id='user_name']");
    private By emailsField = By.xpath("//input[@id='email']");
    private By nameField = By.xpath("//input[@id='name']");
    private By phoneNumberField = By.xpath("//input[@id='contact_no']");
    private By addressField = By.xpath("//input[@id='address']");
    private By descriptionField = By.xpath("//textarea[@id='user_description']");
    private By contactPersonField = By.xpath("//input[@id='contact_person']");
    private By roleDropdown = By.xpath("//button[@id='dropdownSearchButton']");
    private By uploadImgBtn = By.xpath("//label[@for='dropzone-file']");
    private By saveBtn = By.xpath("//button[normalize-space()='Save']");	
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    public void clickAddNewUser() {
        driver.findElement(addNewUserBtn).click();
    }

    public void enterUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
    }

    public void enterEmail(String email) {
        driver.findElement(emailsField).sendKeys(email);
    }

    public void enterFullName(String fullName) {
        driver.findElement(nameField).sendKeys(fullName);
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void enterDescription(String description) {
        driver.findElement(descriptionField).sendKeys(description);
    }
    
    public void enterContactPerson(String contactPerson) {
    	driver.findElement(contactPersonField).sendKeys(contactPerson);
    }

    public void selectRole(String role) {
        Select select = new Select(driver.findElement(roleDropdown));
        select.selectByVisibleText(role);
    }

    public void uploadImage(String imagePath) {
        driver.findElement(uploadImgBtn).sendKeys(imagePath);
    }

    public void clickSave() {
        driver.findElement(saveBtn).click();
    }
    
}


