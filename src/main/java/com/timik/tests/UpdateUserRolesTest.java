package com.timik.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.UpdateUserRolesPage;

public class UpdateUserRolesTest extends BasePage {
    private WebDriver driver;
    
    private UpdateUserRolesPage updateUserRolesPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        updateUserRolesPage = new UpdateUserRolesPage(driver);
		updateUserRolesPage = PageFactory.initElements(driver, UpdateUserRolesPage.class);
		updateUserRolesPage.login("ruvinyafernando@gmail.com", "Test123$");
		Thread.sleep(5000);
		driver.get("http://195.26.253.234:3000/dashboard/Roles"); 
		Thread.sleep(5000); 
    }
 
    @Test(priority = 1)
    public void verifyUpdatingExistingUserRole() {
        //updateUserRolesPage.clickUpdateButton("Sample Role");
        updateUserRolesPage.clickUpdateButtonByRoleName("Administrator");
        updateUserRolesPage.setRoleName("Updated Administrator");
        updateUserRolesPage.setRoleDescription("Updated Role Description");
        updateUserRolesPage.clickSaveButton();
        Assert.assertTrue(updateUserRolesPage.getSuccessMessage().contains("updated successfully"));
    
    } 

    @Test(priority = 2)
    public void verifySuccessfulRoleNameUpdate() {
        //updateUserRolesPage.clickUpdateButton("Auditor");
        updateUserRolesPage.setRoleName("Updated Auditor");
        updateUserRolesPage.clickSaveButton();
        // Add assertions to verify the role name was updated
        Assert.assertTrue(updateUserRolesPage.getSuccessMessage().contains("Role updated successfully"), "Success message should appear");
    }
    
    @Test(priority = 3)
    public void verifySuccessfulRoleDescriptionUpdate() {
        //updateUserRolesPage.clickUpdateButton("End User");
        updateUserRolesPage.setRoleDescription("Updated Role Description");
        updateUserRolesPage.clickSaveButton();
        // Add assertions to verify the role description was updated
        Assert.assertTrue(updateUserRolesPage.getSuccessMessage().contains("Role updated successfully"), "Success message should appear");
    }

    @Test(priority = 4)
    public void verifyEmptyRoleNameUpdate() {
        //updateUserRolesPage.clickUpdateButton("End User");    
        updateUserRolesPage.clickUpdateButtonByRoleName("User");
        updateUserRolesPage.setRoleName("");
        updateUserRolesPage.clickSaveButton();
        Assert.assertTrue(updateUserRolesPage.isRoleNameErrorDisplayed());
        Assert.assertEquals(updateUserRolesPage.getRoleNameError(), "Required");
    }

    @Test(priority = 5)
    public void verifyDuplicateRoleNameUpdate() {
        //updateUserRolesPage.clickUpdateButton("End User");      
        updateUserRolesPage.clickUpdateButtonByRoleName("Auditor");
        updateUserRolesPage.setRoleName("Administrator"); // Assuming "Administrator" already exists
        updateUserRolesPage.clickSaveButton();
        Assert.assertTrue(updateUserRolesPage.isRoleNameErrorDisplayed());
        Assert.assertEquals(updateUserRolesPage.getRoleNameError(), "Role name already exists");
    } 
    
} 
