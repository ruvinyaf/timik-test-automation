package com.timik.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.AddUsersPage;
import com.timik.pages.BasePage;

public class AddUsersTest extends BasePage {

    AddUsersPage addUsersPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        addUsersPage = new AddUsersPage(driver);
        addUsersPage = PageFactory.initElements(driver, AddUsersPage.class);
        addUsersPage.login("ruvinyafernando@gmail.com", "Test123$");
        Thread.sleep(5000);
        driver.get("http://195.26.253.234:3000/dashboard/users");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void verifyValidUserInformationCanBeSaved() {
        addUsersPage.clickAddNewUser();
        addUsersPage.enterUserName("testuser");
        addUsersPage.enterEmail("testuser@example.com");
        addUsersPage.enterFullName("Test User");
        addUsersPage.enterPhoneNumber("1234567890");
        addUsersPage.enterAddress("123 Test St");
        addUsersPage.enterDescription("Test Description");
        addUsersPage.selectRole("new admin");
        addUsersPage.uploadImage("C:\\path\\to\\image.png");
        addUsersPage.clickSave();
        
        // Assertion to verify successful save
        String successMessage = driver.findElement(By.id("successMessage")).getText();
        Assert.assertEquals(successMessage, "User information saved successfully");
    }

    @Test(priority = 2)
    public void verifyUserInformationCanBeSavedWithOptionalFieldsBlank() {
        addUsersPage.clickAddNewUser();
        addUsersPage.enterUserName("testuser2");
        addUsersPage.enterEmail("testuser2@example.com");
        addUsersPage.enterFullName("Test User 2");
        // Leaving optional fields blank
        addUsersPage.clickSave();

        // Assertion to verify successful save
        String successMessage = driver.findElement(By.id("successMessage")).getText();
        Assert.assertEquals(successMessage, "User information saved successfully");
    }

    @Test(priority = 3)
    public void verifyRolesCanBeAddedToTheUser() {
        addUsersPage.clickAddNewUser();
        addUsersPage.enterUserName("testuser3");
        addUsersPage.enterEmail("testuser3@example.com");
        addUsersPage.enterFullName("Test User 3");
        addUsersPage.selectRole("super admin");
        addUsersPage.clickSave();

        // Assertion to verify role assignment
        String successMessage = driver.findElement(By.id("successMessage")).getText();
        Assert.assertEquals(successMessage, "User information saved successfully");
    }

    @Test(priority = 4)
    public void verifyImageCanBeUploaded() {
        addUsersPage.clickAddNewUser();
        addUsersPage.enterUserName("testuser4");
        addUsersPage.enterEmail("testuser4@example.com");
        addUsersPage.enterFullName("Test User 4");
        addUsersPage.uploadImage("C:\\path\\to\\image.png");
        addUsersPage.clickSave();

        // Assertion to verify image upload
        String successMessage = driver.findElement(By.id("successMessage")).getText();
        Assert.assertEquals(successMessage, "User information saved successfully");
    }

    @Test(priority = 5)
    public void verifyOnlySupportedFileTypesCanBeUploaded() {
        addUsersPage.clickAddNewUser();
        addUsersPage.enterUserName("testuser5");
        addUsersPage.enterEmail("testuser5@example.com");
        addUsersPage.enterFullName("Test User 5");
        addUsersPage.uploadImage("C:\\path\\to\\unsupported_file.txt");
        
        // Assertion to verify error message for unsupported file type
        String errorMessage = driver.findElement(By.id("errorMessage")).getText();
        Assert.assertEquals(errorMessage, "Unsupported file type");
    }

    @Test(priority = 6)
    public void verifyImageResolutionIsRestricted() {
        addUsersPage.clickAddNewUser();
        addUsersPage.enterUserName("testuser6");
        addUsersPage.enterEmail("testuser6@example.com");
        addUsersPage.enterFullName("Test User 6");
        addUsersPage.uploadImage("C:\\path\\to\\large_image.png");
        
        // Assertion to verify error message for image resolution
        String errorMessage = driver.findElement(By.id("errorMessage")).getText();
        Assert.assertEquals(errorMessage, "Image resolution exceeds the allowed limit");
    }

    @Test(priority = 7)
    public void verifyErrorWhenAssigningAlreadyAssignedRole() {
        addUsersPage.clickAddNewUser();
        addUsersPage.enterUserName("testuser7");
        addUsersPage.enterEmail("testuser7@example.com");
        addUsersPage.enterFullName("Test User 7");
        addUsersPage.selectRole("existing role");
        addUsersPage.clickSave();

        // Assertion to verify error message for already assigned role
        String errorMessage = driver.findElement(By.id("errorMessage")).getText();
        Assert.assertEquals(errorMessage, "Role already assigned to another user");
    }

    @Test(priority = 8)
    public void verifyErrorForInvalidCharacters() {
        addUsersPage.clickAddNewUser();
        addUsersPage.enterUserName("testuser8");
        addUsersPage.enterEmail("testuser8@ex%ample.com");
        addUsersPage.enterFullName("Test User 8");
        addUsersPage.clickSave();

        // Assertion to verify error message for invalid characters
        String errorMessage = driver.findElement(By.id("errorMessage")).getText();
        Assert.assertEquals(errorMessage, "Invalid characters in email");
    }

    @Test(priority = 9)
    public void verifyErrorForDuplicateEmail() {
        addUsersPage.clickAddNewUser();
        addUsersPage.enterUserName("testuser9");
        addUsersPage.enterEmail("duplicate@example.com");
        addUsersPage.enterFullName("Test User 9");
        addUsersPage.clickSave();

        // Assertion to verify error message for duplicate email
        String errorMessage = driver.findElement(By.id("errorMessage")).getText();
        Assert.assertEquals(errorMessage, "Email already exists");
    }

    @Test(priority = 10)
    public void verifyErrorForInvalidPhoneNumberFormat() {
        addUsersPage.clickAddNewUser();
        addUsersPage.enterUserName("testuser10");
        addUsersPage.enterEmail("testuser10@example.com");
        addUsersPage.enterFullName("Test User 10");
        addUsersPage.enterPhoneNumber("invalidphone");
        addUsersPage.clickSave();

        // Assertion to verify error message for invalid phone number format
        String errorMessage = driver.findElement(By.id("errorMessage")).getText();
        Assert.assertEquals(errorMessage, "Invalid phone number format");
    }
}


