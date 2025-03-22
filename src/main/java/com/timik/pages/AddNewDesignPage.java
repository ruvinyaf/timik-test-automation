package com.timik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewDesignPage extends BasePage {

	public AddNewDesignPage(WebDriver driver) {
		this.driver = driver;
	}

	private By emailField = By.id("email");
	private By passwordField = By.id("password");
	private By signInButton = By.xpath("//button[normalize-space()='Sign In']");

	private By addNewDesignBtn = By.xpath("//button[normalize-space()='Add new design']");
	private By addNewDesignClose = By.xpath("//a[@type='button']");
	private By designNameField = By.xpath("//input[@id='designName']");
	private By descriptionField = By.xpath("//textarea[@id='designDescription']");
	private By materialColorField = By.xpath("//div[@class='select__input-container css-19bb58m']");
	private By assigneeField = By.xpath("//div[@class='select__input-container css-19bb58m']");
	private By createBtn = By.xpath("//button[@type='submit']");

	public void login(String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(signInButton).click();
	}

	public void clickAddNewDesign() {
		driver.findElement(addNewDesignBtn).click();
	}

	public void enterDesignName(String designName) {
		driver.findElement(designNameField).sendKeys(designName);
	}
	
	public void enterDescription(String description) {
		driver.findElement(descriptionField).sendKeys(description);
	}

	public void clickMaterialColor() {
		driver.findElement(materialColorField).click();
	}

	public void enetrMaterialColor(String materialColor) {
		driver.findElement(materialColorField).sendKeys(materialColor);
	}

	public void clickAssignee() {
		driver.findElement(assigneeField).click();
	}

	public void enterAssignee(String assignee) {
		driver.findElement(assigneeField).sendKeys(assignee);
	}

	public void clickCreate() {
		driver.findElement(createBtn).click();
	}
	
	public void clickDesignClose() {
		driver.findElement(addNewDesignClose).click();
	}

	public boolean isRolePresent(String roleName) {
		return driver.findElements(By.xpath("//div[contains(text(),'" + roleName + "')]")).size() > 0;
	}

}

