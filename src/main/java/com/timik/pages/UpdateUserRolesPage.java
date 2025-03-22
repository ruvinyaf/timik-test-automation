package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateUserRolesPage extends BasePage {
    private WebDriver driver;

    public UpdateUserRolesPage(WebDriver driver) {
        this.driver = driver;
    }
 
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    
    private String updateIconXPath = "//div[.//h2[text()='%s']]//button[contains(@class, 'edit-button')]"; // XPath with placeholder
    private By updateIcon = By.xpath("");
    private By roleNameInput = By.xpath("//input[@id='name']");
    private By roleDescriptionInput = By.xpath("//textarea[@id='role_description']");
    private By updateBtn = By.xpath("//button[normalize-space()='Update']");
    private By roleNameError = By.xpath("//div[@class='text-red-600 text-sm mt-1']");
    private By roledescriptionError = By.xpath("//div[@class='text-red-600 text-sm mt-1']");
    private By successMsg = By.xpath("");
    private By errorMsg = By.xpath("");
  //div[contains(@class,'grid gap-2 2xl:grid-cols-5 min-[1200px]:grid-cols-4 min-[768px]:grid-cols-3 min-[640px]:grid-cols-2 mb-1 rounded bg-background dark:bg-[#121212]')]
       
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    } 
    
 // Method to dynamically find a user role card by role name and click its update icon
    public void clickUpdateButtonByRoleName(String roleName) {
        By roleCardLocator = By.xpath("//div[contains(@class, 'role-card') and .//div[text()='" + roleName + "']]");
        WebElement roleCard = driver.findElement(roleCardLocator);
        WebElement updateIcon = roleCard.findElement(By.xpath(".//button[@class='edit-icon']")); // Adjust class as needed
        updateIcon.click();
    }

//    public void clickUpdateButton(String roleName) {
//    	driver.findElement(updateIcon).click();
//    }
    
//    public void clickUpdateButton(String roleName) {
//        By updateIcon = By.xpath(String.format(updateIconXPath, roleName));
//        driver.findElement(updateIcon).click();
//    }

    public void setRoleName(String roleName) {
        driver.findElement(roleNameInput).clear();
        driver.findElement(roleNameInput).sendKeys(roleName);
    }
    
    public void setRoleDescription(String roleDescription) {
        driver.findElement(roleDescriptionInput).clear();
        driver.findElement(roleDescriptionInput).sendKeys(roleDescription);
    }
 
    public void clickSaveButton() {
        driver.findElement(updateBtn).click();
    }

    public boolean isRoleNameErrorDisplayed() {
        return driver.findElement(roleNameError).isDisplayed();
    }

    public String getRoleNameError() {
        return driver.findElement(roleNameError).getText();
    }
    
    public boolean isRoleDescriptionErrorDisplayed() {
    	return driver.findElement(roledescriptionError).isDisplayed();
    }
    
    public String getRoleDescriptionError() {
    	return driver.findElement(roledescriptionError).getText();
    }
    
    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
     
    public String getSuccessMessage() {
    	return driver.findElement(successMsg).getText();
    }
    
} 
