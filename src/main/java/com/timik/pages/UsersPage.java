package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsersPage extends BasePage {
	
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    
    private By addNewUsersBtn = By.xpath("//button[normalize-space()='Add New Users']");
    private By addNewUsersCloseBtn = By.xpath("//a[@type='button']");
    private By searchBar = By.xpath("//input[@id='simple-search']");
    private By exportCSVBtn = By.xpath("//button[normalize-space()='Export CSV']");
    private By filterBtn = By.xpath("//button[@id='filterDropdownButton']");
    private By listViewToggle = By.xpath("//div[contains(@role,'group')]//button[1]");
    private By gridViewToggle = By.xpath("//div[contains(@role,'group')]//button[2]");

    public UsersPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    public void clickAddNewUsers() {
        driver.findElement(addNewUsersBtn).click();
    }
    
    public void clickAddNewUsersClose() {
        driver.findElement(addNewUsersCloseBtn).click();
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


