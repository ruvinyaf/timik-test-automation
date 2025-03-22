package com.timik.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.UpdateDesignPage;


public class UpdateDesignTest extends BasePage {

    private UpdateDesignPage updateDesignPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
    	updateDesignPage = new UpdateDesignPage(driver);
    	updateDesignPage = PageFactory.initElements(driver, UpdateDesignPage.class);
    	updateDesignPage.login("ruvinyafernando@gmail.com", "Test123$");
        Thread.sleep(5000);
        driver.get("http://195.26.253.234:3000/dashboard/projects");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void testUpdateDesignName() throws InterruptedException {
    	updateDesignPage.clickUpdateDesignIcon();
    	updateDesignPage.setDesignName("New Design");
    	updateDesignPage.clickUpdate();
    	Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains(""));
    }

    @Test(priority=2)
    public void testUpdateDescription() throws InterruptedException {
    	updateDesignPage.clickUpdateDesignIcon();
    	updateDesignPage.setDesignDescription("Upadted Design Description");
    	updateDesignPage.clickUpdate();
    	Thread.sleep(3000);
    	Assert.assertTrue(driver.getPageSource().contains(""));
    }
    
    @Test(priority=3)
    public void testUpdateMaterialColor() throws InterruptedException {
    	updateDesignPage.clickUpdateDesignIcon();
    	updateDesignPage.clickMatreialColor();
    	updateDesignPage.setMaterialColor("RAL2008");
    	updateDesignPage.clickUpdate();
    	Thread.sleep(3000);
    	Assert.assertTrue(driver.getPageSource().contains(""));
    }
    
    @Test(priority=4)
    public void testUpdateAssignees() throws InterruptedException {
    	updateDesignPage.clickUpdateDesignIcon();
    	updateDesignPage.clickAssignee();
    	updateDesignPage.setAssignee("");
    	updateDesignPage.clickUpdate();
    	Thread.sleep(3000);
    	Assert.assertTrue(driver.getPageSource().contains(""));
    }
 
   
    @Test(priority=5)
    public void testClearAndUpdate() throws InterruptedException {
    	updateDesignPage.clickUpdateDesignIcon();
    	updateDesignPage.setDesignName("");
    	updateDesignPage.setDesignDescription("");
    	updateDesignPage.clickMatreialColor();
    	updateDesignPage.setMaterialColor("");
    	updateDesignPage.clickAssignee();
    	updateDesignPage.setAssignee("");
    	updateDesignPage.clickUpdate();
    	Thread.sleep(3000);
        
		// Assertions for missing required fields
		String designNameError = updateDesignPage.getRequiredFieldErrorMessage("projectName");
		Assert.assertEquals(designNameError, "Design Name is required");
		
		String designDescriptionError = updateDesignPage.getRequiredFieldErrorMessage("");
		Assert.assertEquals(designDescriptionError, "Design Description is required");
		
		String materialColorError = updateDesignPage.getRequiredFieldErrorMessage("");
		Assert.assertEquals(materialColorError, "Material Color is required");
		
		String assigneeError = updateDesignPage.getRequiredFieldErrorMessage("");
		Assert.assertEquals(assigneeError, "Assigne is required.");
    	
    }
    
    @Test(priority=6)
    public void testUpdateSomeFields() throws InterruptedException {
    	updateDesignPage.clickUpdateDesignIcon();
    	updateDesignPage.setDesignName("");
    	updateDesignPage.setDesignDescription("");
    	updateDesignPage.clickUpdate();
    	Thread.sleep(3000);
    	
    	String successMessage = driver.findElement(By.xpath("")).getText();
    	Assert.assertEquals(successMessage, "");
    }
    
    
 
   

}

