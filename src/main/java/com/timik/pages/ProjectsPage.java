package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {
	
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    
    private By addNewProjectsBtn = By.xpath("");
    private By addProjectsCloseBtn = By.xpath("");
    private By updateIcon = By.xpath("");
    private By deleteIcon = By.xpath("");
    private By showDesignsLink = By.xpath("");
    private By searchBar = By.xpath("");
    private By exportCSVBtn = By.xpath("");
    private By filterBtn = By.xpath("");
    private By listView = By.xpath("");
    private By gridView = By.xpath("");
    
	
    public ProjectsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    public void clickAdddNewProject() {
        driver.findElement(addNewProjectsBtn).click();
    }
    
    public void cickAddNewProjectClose() {
        driver.findElement(addProjectsCloseBtn).click();
    }
    
    public void clickUpdate() {
    	driver.findElement(updateIcon).click();
    }
    
    public void clickDelete() {
    	driver.findElement(deleteIcon).click();
    }
    
    public void clickShowDesigns() {
    	driver.findElement(showDesignsLink).click();
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
        driver.findElement(listView).click();
    }

    public void toggleGridView() {
        driver.findElement(gridView).click();
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
    
}



