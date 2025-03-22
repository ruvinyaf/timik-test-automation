package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class WorkflowPage {

    WebDriver driver;

    public WorkflowPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    
    private By addNewWorkflowBtn = By.xpath("//button[normalize-space()='Add new workflow']");
    private By updateWorkflowBtn = By.xpath("");
    private By deleteWorkflowBtn = By.xpath("");
    private By searchInput = By.xpath("//input[@id='simple-search']");
    private By workflowItems = By.xpath("");
    private By exportCSVBtn = By.xpath("//button[normalize-space()='Export CSV']");
    private By filterBtn = By.xpath("//button[@id='filterDropdownButton']");
    private By gridViewToggle = By.xpath("//div[contains(@role,'group')]//button[1]");
    private By listViewToggle = By.xpath("//div[contains(@role,'group')]//button[2]");
    private By closeBtn = By.xpath("//a[@type='button']");
  
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    public void clickAddNewWorkflow() {
        driver.findElement(addNewWorkflowBtn).click();
    }

    public void clickUpdateWorkflow() {
        driver.findElement(updateWorkflowBtn).click();
    }

    public void clickDeleteWorkflow() {
        driver.findElement(deleteWorkflowBtn).click();
    }

    public void searchWorkflow(String name) {
        WebElement searchBox = driver.findElement(searchInput);
        searchBox.clear();
        searchBox.sendKeys(name);
    }

    public void clickExportCSV() {
        driver.findElement(exportCSVBtn).click();
    }

    public void clickFilter() {
        driver.findElement(filterBtn).click();
    }

    public void clickGridView() {
        driver.findElement(gridViewToggle).click();
    }

    public void clickListView() {
        driver.findElement(listViewToggle).click();
    }

    public List<WebElement> getWorkflowItems() {
        return driver.findElements(workflowItems);
    }
    
    public void clickCloseBtn() {
    	driver.findElement(closeBtn).click();
    }
    
//    public void clickAddNewWorkflowCloseBtn() {
//    	driver.findElement(addNewWorkflowCloseBtn).click();
//    }
//    
//    public void clickUpdateWorkflowCloseBtn() {
//        driver.findElement(updateWorkflowCloseBtn).click();
//    }
//    
//    public void clickDeleteWorkflowCloseBtn() {
//    	driver.findElement(deleteWorkflowCloseBtn).click();
//    }
      
}


