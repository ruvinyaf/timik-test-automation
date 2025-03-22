package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddComponentPage extends BasePage {

	public AddComponentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    
    private By addNewComponentBtn = By.xpath("//button[normalize-space()='Add new component']");
    private By addComponenetCloseBtn = By.xpath("//a[@type='button']");
    private By orderNumberField = By.xpath("//input[@id='order_number']");
    private By componentNameField = By.xpath("//input[@id='componentName']");
    private By componenetCodeField = By.xpath("//input[@id='componentCode']");
    private By sizeField = By.xpath("//input[@id='size']");
    private By widthField = By.xpath("//input[@id='width']");
    private By heightField = By.xpath("//input[@id='height']");
    private By depthField = By.xpath("//input[@id='depth']");
    private By dimensionField = By.xpath("//input[@id='dimension']");
    private By thicknessField = By.xpath("//input[@id='thickness']");
    private By quantityPerSetField = By.xpath("//input[@id='qtyperset']");
    private By priceField = By.xpath("//input[@id='price']");
    private By weightField = By.xpath("//input[@id='weight']");
    private By addBtn = By.xpath("//button[normalize-space()='Add']");
    private By saveAllBtn = By.xpath("//button[normalize-space()='Save All']");
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }
    
    public void addNewComponent() {
    	driver.findElement(addNewComponentBtn).click();
    }
    
    public void addNewComponentClose() {
    	driver.findElement(addComponenetCloseBtn).click();
    }
    
    public void enterOrderNumber(String orderNumber) {
    	driver.findElement(orderNumberField).sendKeys(orderNumber);
    }
    
    public void enterComponenentName(String componentName) {
    	driver.findElement(componentNameField).sendKeys(componentName);
    }
    
    public void enterComponenetCode(String componentCode) {
    	driver.findElement(componenetCodeField).sendKeys(componentCode);
    }
    
    public void enterSize(String size) {
    	driver.findElement(sizeField).sendKeys(size);
    }
    
    public void enterWidth(String width) {
    	driver.findElement(widthField).sendKeys(width);
    }
    
    public void enterHeight(String height) {
    	driver.findElement(heightField).sendKeys(height);
    }
    
    public void enterDepth(String depth) {
    	driver.findElement(depthField).sendKeys(depth);
    }
    
    public void enterDimension(String dimension) {
    	driver.findElement(dimensionField).sendKeys(dimension);
    }
    
    public void enterThickness(String thickness) {
    	driver.findElement(thicknessField).sendKeys(thickness);
    }
    
    public void enterQuantityPerSet(String qtyPerSet) {
    	driver.findElement(quantityPerSetField).sendKeys(qtyPerSet);
    }
    
    public void enterPrice(String price) {
    	driver.findElement(priceField).sendKeys(price);
    }
    
    public void enterWeight(String weight) {
    	driver.findElement(weightField).sendKeys(weight);
    }
    
    public void clickAdd() {
    	driver.findElement(addBtn).click();
    }
    
    public void clickSaveAll() {
    	driver.findElement(saveAllBtn).click();
    }
    
	public String getRequiredFieldErrorMessage(String fieldName) {
		return driver.findElement(By.id(fieldName + "Error")).getText();
	}
	
	public String getIntegerRequiredErrorMessage(String fieldName) {
		return driver.findElement(By.id(fieldName + "Error")).getText();
	}
	

}
