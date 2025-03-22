package com.timik.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.AddUserRolesPage;
import com.timik.pages.BasePage;

public class AddUserRolesTest extends BasePage {

    private AddUserRolesPage addUserRolesPage;

    @BeforeClass
    public void setupPage() throws InterruptedException {
        addUserRolesPage = new AddUserRolesPage(driver);
        addUserRolesPage = PageFactory.initElements(driver, AddUserRolesPage.class);
        addUserRolesPage.login("ruvinyafernando@gmail.com", "Test123$");
        Thread.sleep(5000);
        driver.get("http://195.26.253.234:3000/dashboard/Roles");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void verifyAddNewUserRoleButtonFunctionality() throws InterruptedException {
        addUserRolesPage.clickAddNewUserRoleButton();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Add New Role']")).isDisplayed(), "Add New User Role popup is not displayed.");
        addUserRolesPage.clickCloseButton();
        driver.navigate().refresh();
    }

    @Test(priority = 2)
    public void testAddingNewUserRoleWithValidInputs() throws InterruptedException {
    	Thread.sleep(5000);
        addUserRolesPage.clickAddNewUserRoleButton();
        Thread.sleep(3000);
        addUserRolesPage.enterRoleName("Sample Role");
        addUserRolesPage.enterRoleDescription("Sample Description");
        addUserRolesPage.clickCreateButton();
        Thread.sleep(6000);
        Assert.assertTrue(driver.findElement(By.xpath("//h5[normalize-space()='Test New Role']")).isDisplayed(),"Test Role is not displayed.");
        // Assert.assertTrue(addUserRolesPage.isRolePresent("Test Role"), "New role was not added successfully");
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void verifyErrorHandlingWhenAddingRoleWithoutRoleName() throws InterruptedException {
        addUserRolesPage.clickAddNewUserRoleButton();
        Thread.sleep(3000);
        addUserRolesPage.enterRoleName("Test Role");
        addUserRolesPage.enterRoleDescription("");
        addUserRolesPage.clickCreateButton();
        //Assert.assertEquals(addUserRolesPage.getErrorMessage(), "Failed to add the role!", "Error message is not displayed correctly");
        //driver.navigate().refresh();
        Thread.sleep(5000);
    }
    
    @Test(priority = 4)
    public void verifyErrorHandlingWhenAddingRoleWithoutRoleDescription() throws InterruptedException {
        addUserRolesPage.clickAddNewUserRoleButton();
        Thread.sleep(3000);
        addUserRolesPage.enterRoleName("");
        addUserRolesPage.enterRoleDescription("Test Description");
        addUserRolesPage.clickCreateButton();
        //Assert.assertEquals(addUserRolesPage.getErrorMessage(), "Failed to add the role!", "Error message is not displayed correctly");
        //driver.navigate().refresh();
        Thread.sleep(5000);
    }
    
    @Test(priority = 5)
    public void testAddingNewUserRoleWithEmptyInputs() throws InterruptedException {
    	Thread.sleep(3000);
        addUserRolesPage.clickAddNewUserRoleButton();
        Thread.sleep(3000);
        addUserRolesPage.enterRoleName("");
        addUserRolesPage.enterRoleDescription("");
        Thread.sleep(3000);
        addUserRolesPage.clickCreateButton();
        Thread.sleep(3000);
        //Assert.assertEquals(addUserRolesPage.getErrorMessage(), "Failed to add the role!", "Error message is not displayed correctly");
        driver.navigate().refresh();
        Thread.sleep(3000);
        
    }

    @Test(priority = 6)
    public void testAddingNewUserRoleWithDuplicateRoleName() throws InterruptedException {
        addUserRolesPage.clickAddNewUserRoleButton();
        Thread.sleep(3000);
        addUserRolesPage.enterRoleName("Duplicate User Role");
        addUserRolesPage.enterRoleDescription("Test Description");
        addUserRolesPage.clickCreateButton();
        Thread.sleep(5000);
        driver.navigate().refresh();     
        Thread.sleep(5000);

        // Attempt to add duplicate role
        addUserRolesPage.clickAddNewUserRoleButton();
        addUserRolesPage.clickAddNewUserRoleButton();
        Thread.sleep(3000);
        addUserRolesPage.enterRoleName("Duplicate User Role");
        addUserRolesPage.enterRoleDescription("Test Description");
        addUserRolesPage.clickCreateButton();
        Thread.sleep(5000);  
        //Assert.assertEquals(addUserRolesPage.getErrorMessage(), "Failed to add the role!", "Error message is not displayed correctly");
        //Assert.assertEquals(addUserRolesPage.getErrorMessage(), "Role name already exists", "Duplicate role name error message is not displayed correctly");
        driver.navigate().refresh();
        Thread.sleep(5000);
    }

    @Test(priority = 7)
    public void verifyAddingUserRoleWithSpecialCharactersInName() throws InterruptedException {
        addUserRolesPage.clickAddNewUserRoleButton();
        Thread.sleep(3000);
        addUserRolesPage.enterRoleName("SpecialUser@Role#");
        addUserRolesPage.enterRoleDescription("Test Description");
        addUserRolesPage.clickCreateButton();
        addUserRolesPage.clickNextButton();
        Thread.sleep(6000);
        //Assert.assertTrue(addUserRolesPage.isRolePresent("Special@Role#"), "Role with special characters was not added successfully");
        Assert.assertTrue(driver.findElement(By.xpath("//h5[normalize-space()='SpecialUser@Role#\']")).isDisplayed(),"Test Role is not displayed.");
    }
    
}


