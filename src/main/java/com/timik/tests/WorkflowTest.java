package com.timik.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.WorkflowPage;

public class WorkflowTest extends BasePage {

	WorkflowPage workflowPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		workflowPage = new WorkflowPage(driver);
		workflowPage.login("ruvinyafernando@gmail.com", "Test123$");
		Thread.sleep(12000);
		driver.get("http://195.26.253.234:3000/dashboard/workflow");
		Thread.sleep(5000); 
	}

	@Test(priority = 1)
	public void verifyAddNewWorkflow() throws InterruptedException {
		workflowPage.clickAddNewWorkflow();
        Thread.sleep(8000);
        
		// Add assertions to verify the new workflow creation
		WebElement newWorkflowForm = driver.findElement(By.xpath("//h3[normalize-space()='Add New Workflow']"));
		Assert.assertTrue(newWorkflowForm.isDisplayed(), "New workflow form is not displayed.");
		workflowPage.clickCloseBtn();
//        driver.navigate().refresh();
	}

	@Test(priority = 2)
	public void searchWorkflow() throws InterruptedException {
		workflowPage.searchWorkflow("Test Workflow");
		Thread.sleep(10000);
		List<WebElement> items = workflowPage.getWorkflowItems();
		Assert.assertTrue(items.size() > 0, "No workflows found.");
		
		// Additional assertion to verify the search result matches the query
		for (WebElement item : items) {
			Assert.assertTrue(item.getText().contains("Test Workflow"),
					"Workflow item does not match the search query.");
		}
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void searchNoResults() throws InterruptedException {
		workflowPage.searchWorkflow("Non Existent Workflow");
		List<WebElement> items = workflowPage.getWorkflowItems();
		Thread.sleep(10000);

		WebElement message = driver.findElement(By.xpath("//p[@class='text-gray-light']"));
		Assert.assertTrue(message.isDisplayed(), "No data available message is not displayed.");
	}
	
	@Test(priority = 4)
	public void toggleGridView() throws InterruptedException {
		workflowPage.clickGridView();
		Thread.sleep(8000);

		// Add assertions to verify grid view behavior
		WebElement gridViewActive = driver.findElement(By.xpath("//div[@class='grid gap-2 2xl:grid-cols-5 min-[1200px]:grid-cols-4 min-[768px]:grid-cols-3 min-[640px]:grid-cols-2 mb-1 rounded bg-background dark:bg-[#121212]']"));
		Assert.assertTrue(gridViewActive.isDisplayed(), "Grid view is not active.");

		driver.navigate().refresh();
	}

//	@Test(priority = 5)
//	public void toggleListView() {
//		workflowPage.clickListView();
//
//		// Add assertions to verify list view behavior
//		WebElement listViewActive = driver.findElement(By.xpath(""));
//		Assert.assertTrue(listViewActive.isDisplayed(), "List view is not active.");
//
//		driver.navigate().refresh();
//	}

//	@Test(priority = 6)
//	public void verifyListViewDetails() {
//		workflowPage.clickListView();
//		List<WebElement> items = workflowPage.getWorkflowItems();
//		for (WebElement item : items) {
//			WebElement title = item
//					.findElement(By.xpath(""));
//			Assert.assertTrue(title.isDisplayed(), "Title is not displayed.");
//		}
//	}

	@Test(priority = 7)
	public void exportCSV() {
		workflowPage.clickExportCSV();

		// Add code to handle file download and verification
//        String downloadPath = "C:\\Users\\Janodya\\Downloads";
//        File csvFile = new File(downloadPath + "\\workflows.csv");
//        Assert.assertTrue(csvFile.exists(), "CSV file was not downloaded.");
		
	}

//	@Test(priority = 8)
//	public void exportCSVError() {
//		// Simulate unexpected error during CSV download
//		workflowPage.clickExportCSV();
//
//		// Add assertions to verify the error handling
////        WebElement errorMessage = driver.findElement(By.xpath(""));
////        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed.");
//	}
//
//	@Test(priority = 9)
//	public void exportCSVWithoutData() {
//		workflowPage.searchWorkflow("NonExistentWorkflow");
//		workflowPage.clickExportCSV();
//
//		// Add assertions to verify handling of export with no data
//		WebElement noDataMessage = driver.findElement(By.xpath(""));
//		Assert.assertTrue(noDataMessage.isDisplayed(), "No data message is not displayed.");
//
//		driver.navigate().refresh();
//	}

//	@Test(priority = 10)
//	public void verifyResponsiveDesign() {
//
//		// Define different screen dimensions for responsive testing
//		Dimension[] dimensions = { new Dimension(1920, 1080), // Desktop
//				new Dimension(1366, 768), // Laptop
//				new Dimension(768, 1024), // Tablet
//				new Dimension(375, 667) // Mobile
//		};
//
//		for (Dimension dimension : dimensions) {
//			driver.manage().window().setSize(dimension);
//			// Add a wait to allow page to render
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//
//		}
//	}	
	
	@AfterClass
	public void tearDown() {
		super.teardown();
	}
}




