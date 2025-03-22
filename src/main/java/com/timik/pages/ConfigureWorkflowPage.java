package com.timik.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfigureWorkflowPage {
  
    WebDriver driver;

    public ConfigureWorkflowPage (WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    
    private By configureBtn = By.xpath("");
    private By addNewBtn = By.xpath("");
    private By addWorkflowBtn = By.xpath("");
    private By addConditionBtn = By.xpath("");
    private By addApprovedBtn = By.xpath("");
    private By workflowForm = By.xpath("");
    private By conditionForm = By.xpath("");
    private By approvedForm = By.xpath("");
    private By updateFormUpdateBtn = By.xpath("");
    private By conditionFormSaveBtn = By.xpath("");
    private By approvedBtn = By.xpath("");
    private By conditionApply = By.xpath("");
   
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }
    
    public void clickconfigure() {
    	driver.findElement(configureBtn).click();
    }
    
    public void clickAddNew() {
    	driver.findElement(addNewBtn).click();
    }
    
    public void clickAddWorkflow() {
    	driver.findElement(addWorkflowBtn).click();
    }

    public void clickAddCondition() {
    	driver.findElement(addConditionBtn).click();
    }
    
    public void clickWorkflowForm() {
    	driver.findElement(workflowForm).click();
    }
    
    public void clickConditionForm() {
    	driver.findElement(conditionForm).click();
    }
    
    public void clickWorkflowApprove() {
    	driver.findElement(addApprovedBtn).click();
    }
    
    public void clickApproveForm() {
    	driver.findElement(approvedForm).isDisplayed();
    }
    
    public void clickApproveWorkflow() {
    	driver.findElement(conditionApply).click();
    }
    
    public void clickApprve() {
    	driver.findElement(approvedForm).click();
    }
    
    public void clickUpdateFormUpdate() {
    	driver.findElement(updateFormUpdateBtn).click();
    }
    
    public void clickConditionSave() {
    	driver.findElement(conditionFormSaveBtn).click();
    }
    
    public void clickApprove() {
    	driver.findElement(approvedBtn).click();
    }
    
}
