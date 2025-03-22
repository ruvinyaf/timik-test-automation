package com.timik.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.UpdateProjectsPage;

public class UpdateProjectsTest extends BasePage {

    private UpdateProjectsPage updateProjectsPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
    	updateProjectsPage = new UpdateProjectsPage(driver);
    	updateProjectsPage = PageFactory.initElements(driver, UpdateProjectsPage.class);
    	updateProjectsPage.login("ruvinyafernando@gmail.com", "Test123$");
        Thread.sleep(5000);
        driver.get("http://195.26.253.234:3000/dashboard/projects");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void verifyProjectsInfoCanBeUpdated() throws InterruptedException {
    	updateProjectsPage.clickUpdateIcon();
    	updateProjectsPage.setProjectName("");
    	updateProjectsPage.setProjectOwnerName("");
    	updateProjectsPage.clickCustomerName();
    	updateProjectsPage.setCustomerName("");
    	updateProjectsPage.setAddress("");
    	updateProjectsPage.setCity("");
    	updateProjectsPage.setCountry("");
    	updateProjectsPage.setPostalCode("");
    	updateProjectsPage.setReferenceNumber("");
    	updateProjectsPage.setTelephone("");
    	updateProjectsPage.setFax("");
    	updateProjectsPage.setProjectEmail("");
    	updateProjectsPage.setDescription("");
    	updateProjectsPage.clickAssignees();
    	updateProjectsPage.setAssignees("");
    	updateProjectsPage.clickUpdate();
    	Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains("User updated successfully"));
    }

    @Test(priority = 2)
    public void testMissingRequiredFields() {
    	updateProjectsPage.clickUpdateIcon();
    	updateProjectsPage.setProjectName("");
    	updateProjectsPage.setProjectOwnerName("");
    	updateProjectsPage.setCustomerName("");
    	updateProjectsPage.setCountry("");
    	updateProjectsPage.setTelephone("");
    	updateProjectsPage.setAssignees("");
    	updateProjectsPage.clickUpdate();
        
		// Assertions for missing required fields
		String projectNameError = updateProjectsPage.getRequiredFieldErrorMessage("projectName");
		Assert.assertEquals(projectNameError, "Project Name is required");
		
		String projectOwnerNameError = updateProjectsPage.getRequiredFieldErrorMessage("projectOwnerName");
		Assert.assertEquals(projectOwnerNameError, "Project Owner Name is required");
		
		String countryError = updateProjectsPage.getRequiredFieldErrorMessage("country");
		Assert.assertEquals(countryError, "Country is required");
		
		String telephoneError= updateProjectsPage.getRequiredFieldErrorMessage("telephone");
		Assert.assertEquals(telephoneError, "Telephone is required");
    	
    }
    
   @Test(priority = 3)
   public void testInvalidEmail() throws InterruptedException {
	   updateProjectsPage.clickUpdateIcon();
	   updateProjectsPage.setProjectEmail("test");
	   Thread.sleep(3000);
	   
	   // Assert email 
	   String emailValidation = updateProjectsPage.getRequiredFieldErrorMessage("email");
	   Assert.assertEquals(emailValidation, "Invalid email");
	   
   }
   
   @Test(priority = 4)
   public void testAddMultipleAssignees() throws InterruptedException {
	   updateProjectsPage.clickAssignees();
	   updateProjectsPage.setAssignees("David");
	   updateProjectsPage.clickAssignees();
	   updateProjectsPage.setAssignees("James");
	   Thread.sleep(3000);
	   
	   // Assert multiple assignees when updating
	   Assert.assertTrue(driver.getPageSource().contains("David"));
	   Assert.assertTrue(driver.getPageSource().contains("James"));
   }

   @Test(priority = 5)
   public void testspecialCharactersInTelephone() {
	   updateProjectsPage.clickUpdateIcon();
	   updateProjectsPage.setTelephone("");
	   updateProjectsPage.clickUpdate();
	   
	   // Assert error message for invalid characters
//	   String errorforCharacters = updateProjectsPage.getRequiredFieldErrorMessage("telephone");
//	   Assert.assertEquals(errorforCharacters, "");
			   
   }
   
   @Test(priority = 6)
   public void testLongInputInDescription() {
	   updateProjectsPage.clickUpdateIcon();
	   String longDescription = new String(new char[501]).replace('\0','a');
	   updateProjectsPage.setDescription(longDescription);
	   updateProjectsPage.clickUpdate();
   }

    @Test(priority = 7)
    public void attemptToInputLongDescription() {
        String longDescription = new String(new char[501]).replace('\0', 'a'); 
        updateProjectsPage.setDescription(longDescription);
        updateProjectsPage.clickUpdate();
        Assert.assertTrue(driver.getPageSource().contains("Description too long"));
    }

}
