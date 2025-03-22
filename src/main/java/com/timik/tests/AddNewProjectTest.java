package com.timik.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.AddNewProjectPage;
import com.timik.pages.BasePage;

public class AddNewProjectTest extends BasePage {

    AddNewProjectPage addNewProjectPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
    	addNewProjectPage = new AddNewProjectPage(driver);
    	addNewProjectPage = PageFactory.initElements(driver, AddNewProjectPage.class);
    	addNewProjectPage.login("ruvinyafernando@gmail.com", "Test123$");
        Thread.sleep(5000);
        driver.get("http://195.26.253.234:3000/dashboard/projects");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void testProjectCanbeSaveWithValidInformation() {
    	addNewProjectPage.clickAddNewProject();
    	addNewProjectPage.enterProjectName("Test Project");
    	addNewProjectPage.enterProjectOwnerName("Test Project Owner");
    	addNewProjectPage.clickCustomerName();
    	addNewProjectPage.selectCustomerName("John Smith");
    	addNewProjectPage.enterAddress("No:123, Colombo");
    	addNewProjectPage.enterCity("Colombo");
    	addNewProjectPage.enterCountry("Sri Lanka");
    	addNewProjectPage.enterPostalCode("11100");
    	addNewProjectPage.enterReferenceNumber("123456");
    	addNewProjectPage.enterTelephone("0117858903");
    	addNewProjectPage.enterFax("01116478989");
    	addNewProjectPage.enterProjectEmail("testproject@gmail.com");
    	addNewProjectPage.enterDescription("Test Description");
    	addNewProjectPage.clickAssignees();
    	addNewProjectPage.selectAsiignees("David");
    	addNewProjectPage.clickCreate();
        
        // Assertion to verify successful create
        String successMessage = driver.findElement(By.xpath("")).getText();
        Assert.assertEquals(successMessage, "User information saved successfully");
    }

    @Test(priority = 2)
    public void verifyProjectInformationMisssingFieldsBlank() {

    	addNewProjectPage.clickAddNewProject();
    	addNewProjectPage.clickCreate();
        
		// Assertions for missing required fields
		String projectNameError = addNewProjectPage.getRequiredFieldErrorMessage("projectName");
		Assert.assertEquals(projectNameError, "Project Name is required");
		
		String projectOwnerNameError = addNewProjectPage.getRequiredFieldErrorMessage("ownerName");
		Assert.assertEquals(projectOwnerNameError, "Project Owner Name is required");
		
		String countryError = addNewProjectPage.getRequiredFieldErrorMessage("country");
		Assert.assertEquals(countryError, "Country is required");
		
		String telephoneError= addNewProjectPage.getRequiredFieldErrorMessage("telephone");
		Assert.assertEquals(telephoneError, "Telephone is required");
		
//		String customerNameError = addNewProjectPage.getRequiredFieldErrorMessage("");
//		Assert.assertEquals(customerNameError, "");
//		
//		String assigneeError = addNewProjectPage.getRequiredFieldErrorMessage("");
//		Assert.assertEquals(assigneeError, "");


    }

    @Test(priority = 3)
    public void verifyRolesCanBeAddedToTheUser() {
    	addNewProjectPage.clickAddNewProject();
    	addNewProjectPage.enterProjectName("Test Project 02");
    	addNewProjectPage.enterProjectOwnerName("Test Project Owner 02");
    	addNewProjectPage.clickCustomerName();
    	addNewProjectPage.selectCustomerName("Jack Ellis");
    	addNewProjectPage.clickAssignees();
    	addNewProjectPage.selectAsiignees("James");

        // Assertion to verify role assignment
        String successMessage = driver.findElement(By.xpath("")).getText();
        Assert.assertEquals(successMessage, "Project information saved successfully");
        
        String errorMessage = driver.findElement(By.xpath("")).getText();
        Assert.assertEquals(errorMessage, "");
    }
    
    @Test(priority = 4)
    public void testProjectMissingRequiredField() {
    	addNewProjectPage.clickAddNewProject();
    	addNewProjectPage.enterProjectName("Test Project 03");
    	addNewProjectPage.enterProjectOwnerName("Test Project Owner 03");
    	addNewProjectPage.clickCustomerName();
    	addNewProjectPage.selectCustomerName("Jack Ellis");
    	addNewProjectPage.clickAssignees();
    	addNewProjectPage.selectAsiignees("David");
    	addNewProjectPage.clickCreate();
    	
    	// address, telephone, email
        
        String actualValue = addNewProjectPage.getRequiredFieldErrorMessage("address");   
        String expectedValue = "EXPECTED_VALUE";  
        Assert.assertEquals(actualValue, expectedValue, "The auto-generated value did not match the expected value.");
    	
    }

}


