package com.timik.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.DeleteUsersPage;

public class DeleteUsersTest extends BasePage {

    DeleteUsersPage deleteUsersPage;

    @BeforeClass
    public void setUpPage() throws InterruptedException {
        deleteUsersPage = new DeleteUsersPage(driver);
        deleteUsersPage.login("ruvinyafernando@gmail.com", "Test123$");
        Thread.sleep(5000);
        driver.get("http://195.26.253.234:3000/dashboard/users");
        Thread.sleep(5000);     
    }
    
    @Test(priority = 6)
    public void deleteUserWithCorrectUserName() throws InterruptedException {
    	deleteUsersPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	deleteUsersPage.enterUserName("Test User");
    	deleteUsersPage.clickDeleteButton();
        
        // Add assertions to verify asset deletion       
//        String successMessage = driver.findElement(By.xpath("")).getText();
//        Assert.assertTrue(successMessage.contains(""));
        
        driver.navigate().refresh();
    }    

    @Test(priority = 1)
    public void deleteUserWithUnmatchedUserName() throws InterruptedException {
    	deleteUsersPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	deleteUsersPage.enterUserName("Unmatched User Name");
    	deleteUsersPage.clickDeleteButton();
        
        // Add assertions to verify workflow is not deleted
        String errorMessage = driver.findElement(By.xpath("//span[@class='block sm:inline']")).getText(); 
        Assert.assertTrue(errorMessage.contains("Input does not match the name of the User's Name"));
     
        deleteUsersPage.clickCloseButton();
    }

    @Test(priority = 2)
    public void deleteUserWithoutUserName() throws InterruptedException {
    	
    	deleteUsersPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	deleteUsersPage.clickDeleteButton();
//    	deleteAssetManagementPage.clickDeleteButton();
    
        // Add assertions to verify error or workflow is not deleted
        String errorMessage = driver.findElement(By.xpath("//span[@class='block sm:inline']")).getText(); 
        Assert.assertTrue(errorMessage.contains("Input does not match the name of the User's Name"));
        
        deleteUsersPage.clickCloseButton();     
    }

    @Test(priority = 3)
    public void deleteUserAndCancel() throws InterruptedException {
    	deleteUsersPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	
        // Add assertions to verify workflow is not deleted
//        boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed();
//        Assert.assertFalse(isPopupDisplayed);
        
    	deleteUsersPage.clickCloseButton(); 
    } 

    @Test(priority = 4)
    public void closeDialogAfterCorrectUserName() throws InterruptedException {
    	deleteUsersPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	deleteUsersPage.enterUserName("Charles Brown");
    	Thread.sleep(3000);
    	deleteUsersPage.clickCloseButton();
        
        // Add assertions to verify dialog behavior
//        boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed(); 
//        Assert.assertFalse(isPopupDisplayed);  
    }

    @Test(priority = 5)
    public void closeDialogAfterIncorrectUserName() throws InterruptedException {
    	deleteUsersPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	deleteUsersPage.enterUserName("Unmatched User Name");
    	deleteUsersPage.clickCloseButton();
        
        // Add assertions to verify dialog behavior
//      boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed(); 
//      Assert.assertFalse(isPopupDisplayed);  

    }  
                
    @AfterClass
    public void tearDownTest() {
        driver.navigate().refresh();
        driver.quit();
    }
    
}

