package com.timik.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.UpdateCustomerPage;


public class UpdateCustomerTest extends BasePage {

    private UpdateCustomerPage updateCustomerPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
    	updateCustomerPage = new UpdateCustomerPage(driver);
    	updateCustomerPage = PageFactory.initElements(driver, UpdateCustomerPage.class);
    	updateCustomerPage.login("ruvinyafernando@gmail.com", "Test123$");
        Thread.sleep(5000);
        driver.get("http://195.26.253.234:3000/dashboard/customers");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void verifyCustomerInfoCanBeUpdated() throws InterruptedException {
    	updateCustomerPage.clickUpdate();
    	updateCustomerPage.setCustomerName("Test Customer Name");
    	updateCustomerPage.setCustomerCompany("Test Company");
    	updateCustomerPage.setCustomerContact("0775467834");
    	updateCustomerPage.setCustomerContactPerson("0776458932");
    	updateCustomerPage.setCustomerEmail("testcompany@gmail.com");
    	updateCustomerPage.setCustomerAddress("No:12, Colombo");
    	updateCustomerPage.clickUpdate();
    	Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains("Customer updated successfully"));
    }
    
    @Test(priority = 2)
    public void verifyCustomerSomeFieldsCanbeUpdated() {
    	updateCustomerPage.clickUpdate();
    	updateCustomerPage.setCustomerName("Test Customer 2");
    	updateCustomerPage.setCustomerContactPerson("");
    }

    @Test(priority = 3)
    public void testSubmittingEmptyFields() throws InterruptedException {
    	updateCustomerPage.clickUpdate();
    	updateCustomerPage.setCustomerName("");
    	updateCustomerPage.setCustomerCompany("");
    	updateCustomerPage.setCustomerContact("");
    	updateCustomerPage.setCustomerContactPerson("");
    	updateCustomerPage.setCustomerEmail("");
    	updateCustomerPage.setCustomerAddress("");
    	updateCustomerPage.clickUpdate();
        Thread.sleep(3000);
        
		// Assertions for missing required fields
		String customerNameError = updateCustomerPage.getRequiredFieldErrorMessage("customerName");
		String customerCompanyError = updateCustomerPage.getRequiredFieldErrorMessage("customerCompany");
		String customerContactError = updateCustomerPage.getRequiredFieldErrorMessage("customerContact");
		String customerContactPersonError = updateCustomerPage.getRequiredFieldErrorMessage("customerContactPerson");
		String customerEmailError = updateCustomerPage.getRequiredFieldErrorMessage("customerEmail");
		String customerAddressError = updateCustomerPage.getRequiredFieldErrorMessage("customerAddresss");

		Assert.assertEquals(customerNameError, "Customer Name is required");
		Assert.assertEquals(customerCompanyError, "Customer Company is required");
		Assert.assertEquals(customerContactError, "Customer Contact is required");
		Assert.assertEquals(customerContactPersonError, "Customer Contact Person is required");
		Assert.assertEquals(customerEmailError, "Customer Email is required");
		Assert.assertEquals(customerAddressError, "Customer Address is required");
    }
    


}

