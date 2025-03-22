package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateDesignPage extends BasePage {
	
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");

	private By updateDesignBtn = By.xpath("");
	private By addNewDesignClose = By.xpath("");
	private By designNameField = By.xpath("//input[@id='designName']");
	private By descriptionField = By.xpath("//textarea[@id='designDescription']");
	private By materialColorField = By.xpath("//div[@class='select__input-container css-19bb58m']");
	private By assigneeField = By.xpath("//div[@class='select__input-container css-19bb58m']");
	private By updateBtn = By.xpath("");

    public UpdateDesignPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password); 
        driver.findElement(signInButton).click();
    }
    
    public void clickUpdateDesignIcon() {
    	driver.findElement(updateDesignBtn).click();
    }
    
    public void clickUpdateClose() {
    	driver.findElement(addNewDesignClose).click();
    }

    public void setDesignName(String designName) {
        driver.findElement(designNameField).clear();
        driver.findElement(designNameField).sendKeys(designName);
    }

    public void setDesignDescription(String designDescription) {
        driver.findElement(descriptionField).clear();
        driver.findElement(descriptionField).sendKeys(designDescription);
    }
    
    public void clickMatreialColor() {
    	driver.findElement(materialColorField).click();
    }
    
    public void setMaterialColor(String meterialColor) {
    	driver.findElement(materialColorField).clear();
    	driver.findElement(materialColorField).sendKeys(meterialColor);
    }

    public void clickAssignee() {
    	driver.findElement(assigneeField).click();
    }
    
    public void setAssignee(String assignee) {
    	driver.findElement(assigneeField).clear();
    	driver.findElement(assigneeField).sendKeys(assignee);
    }
    
    public void clickUpdate() {
    	driver.findElement(updateBtn).click();
    }
    
	public String getRequiredFieldErrorMessage(String fieldName) {
		return driver.findElement(By.id(fieldName + "Error")).getText();
	}

    
}



