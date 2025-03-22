package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUserRolesPage extends BasePage {

    public AddUserRolesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    
    private By addNewUserRoleBtn = By.xpath("//button[normalize-space()='Add New User Role']");
    private By roleNameInput = By.xpath("//input[@id='name']");
    private By roleDescriptionInput = By.xpath("//textarea[@id='role_description']");
    private By createBtn = By.xpath("//button[normalize-space()='Create']");
    private By closeBtn = By.xpath("//a[@type='button']");
    private By successMsg = By.xpath("");
    private By errorMsg = By.xpath("");
    private By nextBtn = By.xpath("");

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }
    
    public void clickAddNewUserRoleButton() {
        driver.findElement(addNewUserRoleBtn).click();
    }

    public void enterRoleName(String roleName) {
        driver.findElement(roleNameInput).sendKeys(roleName);
    }

    public void enterRoleDescription(String roleDescription) {
        driver.findElement(roleDescriptionInput).sendKeys(roleDescription);
    }

    public void clickCreateButton() {
        driver.findElement(createBtn).click();
    }
    
    public void clickCloseButton() {
    	driver.findElement(closeBtn).click();
    }
    
    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
     
    public String getSuccessMessage() {
    	return driver.findElement(successMsg).getText();
    }
    
    public void clickNextButton() {
    	driver.findElement(nextBtn).click();
    }

    public boolean isRolePresent(String roleName) {
        return driver.findElements(By.xpath("//div[contains(text(),'" + roleName + "')]")).size() > 0;
    }
}


