package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SidebarNavigationPage {

    WebDriver driver;
    
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");

    private By dashboard = By.xpath("//a[normalize-space()='Dashboard']");
    private By expand = By.xpath("//button[@class='sidbar-hamburg hover:bg-accent-hover hover:duration-500 hover:text-foreground border-5']");
    private By userManagement = By.xpath("//a[normalize-space()='User Management']");
    private By roles = By.xpath("//a[normalize-space()='Role']");
    private By users = By.xpath("//a[normalize-space()='Users']");
    private By config = By.xpath("//a[normalize-space()='Config']");
    private By workflow = By.xpath("//a[normalize-space()='Workflow']");
    private By customers = By.xpath("//a[normalize-space()='Customers']");
    private By projects = By.xpath("//a[normalize-space()='Projects']");
    private By configuration = By.xpath("//a[normalize-space()='Configuration']");
    private By priceList = By.xpath("//a[normalize-space()='Price List']");
    
    
    public SidebarNavigationPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }
    
    public void clickDashboard() {
    	driver.findElement(dashboard).click();
    }
    
    public void clickExpand() {
    	driver.findElement(expand).click();
    }
    
    public void clickUserManagement() {
        driver.findElement(userManagement).click();
    }
    
    public void clickRole() {
    	driver.findElement(roles).click();
    }
    
    public void clickUsers() {
    	driver.findElement(users).click();
    }

    public void clickConfig() {
        driver.findElement(config).click();
    }
    
    public void clickWorkflow() {
        driver.findElement(workflow).click();
    }
    
    public void clickCustomers() {
    	driver.findElement(customers).click();
    }
    
    public void clickProjects() {
    	driver.findElement(projects).click();
    }
    
    public void clickConfiguration() {
    	driver.findElement(configuration).click();
    }
    
    public void clickPriceList() {
    	driver.findElement(priceList).click();
    }
    
}

