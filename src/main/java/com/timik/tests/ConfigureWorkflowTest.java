package com.timik.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.ConfigureWorkflowPage;

public class ConfigureWorkflowTest extends BasePage {
 
	ConfigureWorkflowPage configureWorkflowPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		configureWorkflowPage = new ConfigureWorkflowPage(driver);
		configureWorkflowPage = PageFactory.initElements(driver, ConfigureWorkflowPage.class);
		configureWorkflowPage.login("ruvinyafernando@gmail.com", "Test123$");
		Thread.sleep(5000);
		driver.get("http://195.26.253.234:3000/dashboard/workflow");
		Thread.sleep(5000); 
	}

	@Test(priority = 1)
	public void verifyAddNewWorkflow() throws InterruptedException {
		configureWorkflowPage.clickAddWorkflow();

		// Add assertions to verify the new workflow creation
		WebElement newWorkflowForm = driver
				.findElement(By.xpath(""));
		Assert.assertTrue(newWorkflowForm.isDisplayed(), "New workflow form is not displayed.");

		Thread.sleep(3000);
	}
	
	@Test(priority = 2)
	public void verifyAddNewWorkflowAdd() {
		configureWorkflowPage.clickAddWorkflow();
		configureWorkflowPage.clickAddNew();
		
		// Add assertions to verify the new workflow form 
		WebElement newWorkflowForm = driver.findElement(By.xpath(""));
		Assert.assertTrue(newWorkflowForm.isDisplayed(), "New Workflow form is not displayed.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test(priority = 3)
	public void verifyWorkflowForm() {
		configureWorkflowPage.clickAddWorkflow();
		configureWorkflowPage.clickApproveForm();
		
		// Add assertions to verify the new workflow
		WebElement newWorkflowForm = driver.findElement(By.xpath(""));
		Assert.assertTrue(newWorkflowForm.isDisplayed(), "New Workflow form is not displayed.");
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 4)
	public void verifyWorkflowfunctionality() {
		configureWorkflowPage.clickAddCondition();
		configureWorkflowPage.clickApproveForm();
		
		// Add assertions to verify workflow condition
		WebElement newWorkflowForm = driver.findElement(By.xpath(""));
		Assert.assertTrue(newWorkflowForm.isDisplayed(), "Workflow condition is not displayed");
		
	}
	
}

