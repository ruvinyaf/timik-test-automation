package com.timik.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.AddNewCustomerPage;
import com.timik.pages.BasePage;


public class AddNewCustomerTest extends BasePage {

    AddNewCustomerPage addNewCustomerPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        addNewCustomerPage = new AddNewCustomerPage(driver);
        addNewCustomerPage = PageFactory.initElements(driver, AddNewCustomerPage.class);
        addNewCustomerPage.login("ruvinyafernando@gmail.com", "Test123$");
        Thread.sleep(5000);
        driver.get("http://195.26.253.234:3000/dashboard/customers");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void verifyValidCustomerInformationCanBeSaved() {
    	addNewCustomerPage.clickAddNewCustomer();
    	addNewCustomerPage.enterCustomerName("Test Customer");
    	addNewCustomerPage.enterCustomerComapnyName("Test Customer Company");
    	addNewCustomerPage.enterCustomerContact("0767849032");
    	addNewCustomerPage.enterCustomerContactPerson("0772437893");
    	addNewCustomerPage.enterCustomerEmail("testcustomer@gmail.com");
    	addNewCustomerPage.enterCustomerAddress("No:123,Colombo 05");
    	addNewCustomerPage.clickCreate();
        
        // Assertion to verify successful save
        String successMessage = driver.findElement(By.xpath("")).getText();
        Assert.assertEquals(successMessage, "Customer added successfully!");
    }

    @Test(priority = 2)
    public void verifyCustomerInformationMisssingFieldsBlank() {
    	addNewCustomerPage.clickAddNewCustomer();
    	addNewCustomerPage.clickCreate();
        
		// Assertions for missing required fields
		String customerNameError = addNewCustomerPage.getRequiredFieldErrorMessage("name");
		String customerCompanyError = addNewCustomerPage.getRequiredFieldErrorMessage("companyName");
		String customerContactError = addNewCustomerPage.getRequiredFieldErrorMessage("contact");
		String customerContactPersonError = addNewCustomerPage.getRequiredFieldErrorMessage("contactPerson");
		String customerEmailError = addNewCustomerPage.getRequiredFieldErrorMessage("customerEmail");
		String customerAddressError = addNewCustomerPage.getRequiredFieldErrorMessage("address");

		Assert.assertEquals(customerNameError, "Customer Name is required");
		Assert.assertEquals(customerCompanyError, "Customer Company is required");
		Assert.assertEquals(customerContactError, "Customer Contact is required");
		Assert.assertEquals(customerContactPersonError, "Customer Contact Person is required");
		Assert.assertEquals(customerEmailError, "Customer Email is required");
		Assert.assertEquals(customerAddressError, "Customer Address is required");

    }

    @Test(priority=3)
    public void verifyCustomerMissingSomeRequiredFields() {
    	addNewCustomerPage.clickAddNewCustomer();
    	addNewCustomerPage.enterCustomerName("Test Customer 2");
    	addNewCustomerPage.enterCustomerComapnyName("Test Company");
    	addNewCustomerPage.enterCustomerEmail("test@gmail.com");
    	addNewCustomerPage.clickCreate();
    	
    	// Assertions for missing required fields
		String customerContactError = addNewCustomerPage.getRequiredFieldErrorMessage("contact");
		Assert.assertEquals(customerContactError, "Customer Contact is required");
		String customerContactPersonError = addNewCustomerPage.getRequiredFieldErrorMessage("contactPerson");
		Assert.assertEquals(customerContactPersonError, "Customer Contact Person is required");
		String customerAddressError = addNewCustomerPage.getRequiredFieldErrorMessage("address");
		Assert.assertEquals(customerAddressError, "Customer Address is required");	
		
    }

}


