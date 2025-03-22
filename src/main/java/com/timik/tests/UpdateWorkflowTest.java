package com.timik.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.UpdateWorkflowPage;


public class UpdateWorkflowTest extends BasePage {

	UpdateWorkflowPage updateWorkflowPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		super.setup();
		updateWorkflowPage = new UpdateWorkflowPage(driver);

		updateWorkflowPage = PageFactory.initElements(driver, UpdateWorkflowPage.class);
		updateWorkflowPage.login("ruvinyafernando@gmail.com", "Test123$");
		Thread.sleep(5000);
		driver.get("http://195.26.253.234:3000/dashboard/workflow");
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void updateWorkflowWithValidData() throws InterruptedException {
		updateWorkflowPage.clickUpdateIcon();
		updateWorkflowPage.setWorkflowName("New Workflow");
		updateWorkflowPage.setWorkflowDescription("New Workflow Description");
		updateWorkflowPage.toggleWorkflowStatus();
		Thread.sleep(5000);
		updateWorkflowPage.clickUpdateButton();
		Thread.sleep(5000);
		
		
		 Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed(), "Add New User Role popup is not displayed.");
		 updateWorkflowPage.clickUpdateButton();
		//Assert.assertTrue(updateWorkflowPage.isWorkflowPresent("New Workflow"),"The workflow should be present in the list.");
		//updateWorkflowPage.clickCloseButton();
	}

    @Test(priority = 2)
    public void updateWorkflowName() throws InterruptedException {

    	updateWorkflowPage.clickUpdateIcon();
        updateWorkflowPage.setWorkflowName("Updated Workflow Name");
        updateWorkflowPage.clickUpdateButton();
        // Add assertion here to verify workflow name update
        
        updateWorkflowPage.clickCloseButton();
    }

    @Test(priority = 3)
    public void updateWorkflowDescription() {
    	updateWorkflowPage.clickUpdateIcon();
        updateWorkflowPage.setWorkflowDescription("Updated Workflow Description");
        updateWorkflowPage.clickUpdateButton();
        // Add assertion here to verify workflow description update
        
        updateWorkflowPage.clickCloseButton();
    }

    @Test(priority = 4)
    public void updateWorkflowStatusToggle() {
    	updateWorkflowPage.clickUpdateIcon();
        updateWorkflowPage.toggleWorkflowStatus();
        updateWorkflowPage.clickUpdateButton();
        // Add assertion here to verify workflow status toggle
        
        updateWorkflowPage.clickCloseButton();
    }

    @Test(priority = 5)
    public void emptyWorkflowNameValidation() throws InterruptedException {
    	updateWorkflowPage.clickUpdateIcon();
        updateWorkflowPage.setWorkflowName("");
        updateWorkflowPage.clickUpdateButton();
//        String errorMessage = updateWorkflowPage.getErrorMessage();
//        Thread.sleep(3000);
//        Assert.assertEquals(errorMessage, "Workflow name cannot be empty");    
    }

    @Test(priority = 6)
    public void duplicateWorkflowNameValidation() {
    	updateWorkflowPage.clickUpdateIcon();
        updateWorkflowPage.setWorkflowName("Workflow"); 
        updateWorkflowPage.clickUpdateButton();
        //String errorMessage = updateWorkflowPage.getErrorMessage();
        //Assert.assertEquals(errorMessage, "Workflow name already exists");
        updateWorkflowPage.clickCloseButton();
    } 
    
    @Test(priority = 7)
    public void duplicateWorkflowDescription() throws InterruptedException {
    	updateWorkflowPage.clickUpdateIcon();
    	updateWorkflowPage.setWorkflowDescription("Description");
    	updateWorkflowPage.clickUpdateButton();
    	
//    	String descErrorMessage = updateWorkflowPage.getErrorMessage();
//    	Assert.assertEquals(descErrorMessage, "Workflow description already exists");
    	
    	updateWorkflowPage.clickCloseButton();
    	Thread.sleep(3000);
    }
  
    
	@AfterClass
	public void tearDown() {
		super.teardown();
	}
}
