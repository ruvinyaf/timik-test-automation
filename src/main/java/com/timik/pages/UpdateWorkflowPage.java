package com.timik.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateWorkflowPage {

    WebDriver driver;
    
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");

    private By updateIcon = By.xpath("");
    private By workflowNameField = By.xpath("");
    private By workflowDescriptionField = By.xpath("");
    private By workflowStatusToggle = By.xpath("");
    private By updateBtn = By.xpath("");
    private By closeBtn = By.xpath("");
    private By workflowList = By.xpath("");


    public UpdateWorkflowPage(WebDriver driver) {
        this.driver = driver;
    }
 
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }
    
    public void clickUpdateIcon() {
    	driver.findElement(updateIcon).click();
    }

    public void setWorkflowName(String workflowName) {
    	driver.findElement(workflowNameField).click();
        driver.findElement(workflowNameField).clear();
        driver.findElement(workflowNameField).sendKeys(workflowName);
    }

    public void setWorkflowDescription(String workflowDescription) {
    	driver.findElement(workflowDescriptionField).click();
        driver.findElement(workflowDescriptionField).clear();
        driver.findElement(workflowDescriptionField).sendKeys(workflowDescription);
    }

    public void toggleWorkflowStatus() {
        driver.findElement(workflowStatusToggle).click();
    }

    public void clickUpdateButton() {
        driver.findElement(updateBtn).click();
    }
    
    public void clickCloseButton() {
    	driver.findElement(closeBtn).click();
    }

    public String getWorkflowName() {
        return driver.findElement(workflowNameField).getAttribute("value"); 
    }

    public String getErrorMessage() {
        return driver.findElement(By.xpath("")).getText();
    }
    
    public String getValidation() {
    	return driver.findElement(By.xpath("")).getText();
    }
    
    public boolean isWorkflowPresent(String name) {
        List<WebElement> workflows = driver.findElements(workflowList);
        for (WebElement workflow : workflows) {
            if (workflow.getText().contains(name)) {
                return true;
            }
        }
        return false;
    }
	
}
    
    



