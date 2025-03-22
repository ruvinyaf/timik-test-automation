package com.timik.tests;

import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.DeleteWorkflowPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DeleteWorkflowTest extends BasePage {
	DeleteWorkflowPage deleteWorkflowPage;

	@BeforeClass
	public void setUpTest() throws InterruptedException {
		deleteWorkflowPage = new DeleteWorkflowPage(driver);
		deleteWorkflowPage.login("ruvinyafernando@gmail.com", "Test123$");
		Thread.sleep(5000);
		driver.get("http://195.26.253.234:3000/dashboard/workflow");
		Thread.sleep(5000);
	}

    @Test(priority = 6)
    public void deleteWorkflowWithCorrectName() throws InterruptedException {
        deleteWorkflowPage.clickDeleteIcon();
        Thread.sleep(3000);
        deleteWorkflowPage.enterWorkflowName("Test Workflow");
        deleteWorkflowPage.clickDeleteButton();
        
//        String successMessage = driver.findElement(By.xpath("")).getText();
//        Assert.assertTrue(successMessage.contains(""));
        
        driver.navigate().refresh();
    }    

	@Test(priority = 1)
	public void deleteWorkflowWithUnmatchedName() throws InterruptedException {
		deleteWorkflowPage.clickDeleteIcon();
		Thread.sleep(3000);
		deleteWorkflowPage.enterWorkflowName("Incorrect Workflow");
		deleteWorkflowPage.clickDeleteButton();

		// Add assertions to verify workflow is not deleted
		String errorMessage = driver.findElement(By.xpath("//div[@class='text-sm text-red-500']")).getText();
		Assert.assertTrue(errorMessage.contains("Value does not match"));

		deleteWorkflowPage.clickCloseButton();
	}

	@Test(priority = 2)
	public void deleteWorkflowWithoutName() throws InterruptedException {
		deleteWorkflowPage.clickDeleteIcon();
		Thread.sleep(3000);
		deleteWorkflowPage.clickDeleteButton();
		deleteWorkflowPage.clickDeleteButton();

		// Add assertions to verify error or workflow is not deleted
		String errorMessage = driver.findElement(By.xpath("//div[@class='text-sm text-red-500']")).getText();
		Assert.assertTrue(errorMessage.contains("Please enter the workflow name"));

		deleteWorkflowPage.clickCloseButton();
	}

	@Test(priority = 3)
	public void deleteWorkflowAndCancel() throws InterruptedException {
		deleteWorkflowPage.clickDeleteIcon();
		Thread.sleep(3000);
		
		// Add assertions to verify workflow is not deleted
        boolean isPopupDisplayed = driver.findElement(By.xpath("//h3[@class='text-lg font-semibold text-gray-light dark:text-white']")).isDisplayed();
        Assert.assertFalse(isPopupDisplayed);

		deleteWorkflowPage.clickCloseButton();

	}

	@Test(priority = 4)
	public void closeDialogAfterCorrectName() throws InterruptedException {
		deleteWorkflowPage.clickDeleteIcon();
		Thread.sleep(3000);
		deleteWorkflowPage.enterWorkflowName("Test Workflow 02");
		deleteWorkflowPage.clickCloseButton();

		// Add assertions to verify dialog behavior
        boolean isPopupDisplayed = driver.findElement(By.xpath("//h3[@class='text-lg font-semibold text-gray-light dark:text-white']")).isDisplayed(); 
        Assert.assertFalse(isPopupDisplayed);  
	}

	@Test(priority = 5)
	public void closeDialogAfterIncorrectName() throws InterruptedException {
		deleteWorkflowPage.clickDeleteIcon();
		Thread.sleep(3000);
		deleteWorkflowPage.enterWorkflowName("Incorrect Workflow");
		deleteWorkflowPage.clickCloseButton();

		Thread.sleep(3000);

		// Add assertions to verify dialog behavior
        boolean isPopupDisplayed = driver.findElement(By.xpath("//h3[@class='text-lg font-semibold text-gray-light dark:text-white']")).isDisplayed(); 
        Assert.assertFalse(isPopupDisplayed);

		Thread.sleep(3000);
	}

	@AfterClass
	public void tearDownTest() {
		driver.navigate().refresh();
		driver.quit();
	}
}

