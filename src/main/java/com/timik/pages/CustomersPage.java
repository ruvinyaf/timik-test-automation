package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomersPage extends BasePage {
	
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    
    private By addNewCustomerBtn = By.xpath("");
    private By addNewCustomerClose = By.xpath("");
    private By editBtn = By.xpath("");
    private By deleteBtn = By.xpath("");
    private By searchBar = By.xpath("");
    private By exportCSVBtn = By.xpath("");
    private By filterBtn = By.xpath("");
    private By gridViewToggle = By.xpath("");
    private By listViewToggle = By.xpath("");


    public CustomersPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    public void clickAddNewCustomer() {
        driver.findElement(addNewCustomerBtn).click();
    }
    
    public void clickAddNewCutomerClose() {
        driver.findElement(addNewCustomerClose).click();
    }
    
    public void clickEdit() {
    	driver.findElement(editBtn).click();
    }
    
    public void clickDelete() {
    	driver.findElement(deleteBtn).click();
    }

    public void enterSearchQuery(String query) {
        WebElement searchInput = driver.findElement(searchBar);
        searchInput.clear();
        searchInput.sendKeys(query);
    }

    public void clickExportCSV() {
        driver.findElement(exportCSVBtn).click();
    }

    public void clickFilterButton() {
        driver.findElement(filterBtn).click();
    }

    public void toggleListView() {
        driver.findElement(listViewToggle).click();
    }

    public void toggleGridView() {
        driver.findElement(gridViewToggle).click();
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
    
}



