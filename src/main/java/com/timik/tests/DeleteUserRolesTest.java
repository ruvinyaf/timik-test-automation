package com.timik.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.DeleteUserRolesPage;

public class DeleteUserRolesTest extends BasePage {
    DeleteUserRolesPage deleteUserRolesPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
		deleteUserRolesPage = new DeleteUserRolesPage(driver);
		deleteUserRolesPage.login("ruvinyafernando@gmail.com", "Test123$");
		Thread.sleep(5000);
		driver.get("http://207.180.232.61:3000/dashboard/Roles"); 
		Thread.sleep(6000);  
    }
    
    @Test(priority = 6)
    public void verifySuccessfulDeletion() throws InterruptedException {
    	deleteUserRolesPage.clickDeleteIcon();
    	Thread.sleep(3000);
        deleteUserRolesPage.enterText("End User");
        deleteUserRolesPage.clickDeleteButton();
    	Thread.sleep(3000);
        
        // Add assertions to verify asset deletion       
      String successMessage = driver.findElement(By.xpath("")).getText();
      Assert.assertTrue(successMessage.contains("Role deleted successfully!"));

    }

    @Test(priority = 1)
    public void verifyDeletionFailureWithIncorrectInput() throws InterruptedException {
    	deleteUserRolesPage.clickDeleteIcon();
    	Thread.sleep(3000);
        deleteUserRolesPage.enterText("Incorrect Role Name");
        deleteUserRolesPage.clickDeleteButton();

        // Add assertions to verify workflow is not deleted
        String errorMessage = driver.findElement(By.xpath("//span[@class='block sm:inline']")).getText(); 
        Assert.assertTrue(errorMessage.contains("Input does not match the name of the Role Name"));
        
        deleteUserRolesPage.clickCloseButton();
    }

    @Test(priority = 2)
    public void verifyDeletionFailureWithNoInput() throws InterruptedException {
    	deleteUserRolesPage.clickDeleteIcon();
    	Thread.sleep(3000);
        deleteUserRolesPage.enterText("");
        deleteUserRolesPage.clickDeleteButton();
        
        // Add assertions to verify error or workflow is not deleted
        String errorMessage = driver.findElement(By.xpath("//span[@class='block sm:inline']")).getText(); 
        Assert.assertTrue(errorMessage.contains("Input does not match the name of the Role Name"));
        
        deleteUserRolesPage.clickCloseButton();
        
    }
    
    @Test(priority = 3)
    public void verifyCloseButtonFunctionality() throws InterruptedException {
    	deleteUserRolesPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	
        // Add assertions to verify workflow is not deleted
	    boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed();
	    Assert.assertFalse(isPopupDisplayed);
    	
        deleteUserRolesPage.clickCloseButton();
        
    }

    @Test(priority = 4)
    public void verifyCloseAfterCorrectInput() throws InterruptedException {
    	deleteUserRolesPage.clickDeleteIcon();
    	Thread.sleep(3000);
        deleteUserRolesPage.enterText("End User");
        deleteUserRolesPage.clickCloseButton();
        
        // Add assertions to verify dialog behavior
      boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed(); 
      Assert.assertFalse(isPopupDisplayed); 
        
    }

    @Test(priority = 5)
    public void verifyCloseAfterIncorrectInput() throws InterruptedException {
    	deleteUserRolesPage.clickDeleteIcon();
    	Thread.sleep(3000);
        deleteUserRolesPage.enterText("Incorrect User Role Names");
        deleteUserRolesPage.clickCloseButton();
        
        // Add assertions to verify dialog behavior
//      boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed(); 
//      Assert.assertFalse(isPopupDisplayed); 
        
    }
    
}

