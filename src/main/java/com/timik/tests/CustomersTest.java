package com.timik.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.CustomersPage;


public class CustomersTest extends BasePage {
    
	CustomersPage customersPage;
	
    @BeforeClass
    public void setUp() throws InterruptedException {
    	customersPage = new CustomersPage(driver);
    	customersPage = PageFactory.initElements(driver, CustomersPage.class);
    	customersPage.login("ruvinyafernando@gmail.com", "Test123$");
		Thread.sleep(5000);
		driver.get("http://195.26.253.234:3000/dashboard/customers");
		Thread.sleep(5000); 
    }

    @Test(priority = 1)
    public void testAddNewCustomers() throws InterruptedException {
    	customersPage.clickAddNewCustomer();
        Thread.sleep(3000);
        Assert.assertTrue(customersPage.isElementPresent(By.xpath("//h3[normalize-space()='Add a Customer']")), "Add New Customers button did not work correctly.");
        customersPage.clickAddNewCutomerClose();
        driver.navigate().refresh();
    }

    @Test(priority = 2)
    public void testSearchFunctionality() throws InterruptedException {
    	customersPage.enterSearchQuery("Test Customer");
        Thread.sleep(3000);
        Assert.assertTrue(customersPage.isElementPresent(By.xpath("//h5[normalize-space()='Test Customer']")), "Search functionality did not retrieve the correct customers.");
        driver.navigate().refresh();
    }
    
    @Test(priority = 3)
    public void testPartialSearchFunctionality() throws InterruptedException {
    	customersPage.enterSearchQuery("Test");
        Thread.sleep(3000);
        Assert.assertTrue(customersPage.isElementPresent(By.xpath("//h5[normalize-space()='Test Customer']")), "Partial search functionality did not retrieve the correct customers.");
        driver.navigate().refresh();
    }

    @Test(priority = 4)
    public void testSearchNoResults() throws InterruptedException {
    	customersPage.enterSearchQuery("Nonexistent Customer");
        Thread.sleep(3000);
        Assert.assertTrue(customersPage.isElementPresent(By.xpath("//p[normalize-space()='No data available']")), "Search functionality did not handle no results correctly.");
        driver.navigate().refresh();
    }
    
//    @Test(priority = 5)
//    public void testToggleListView() throws InterruptedException {
//    	customersPage.toggleListView();
//        Thread.sleep(3000);
//        Assert.assertTrue(customersPage.isElementPresent(By.xpath("")), "List view toggle did not work correctly.");
//        driver.navigate().refresh();
//    }

    @Test(priority = 6)
    public void testToggleGridView() throws InterruptedException {
    	customersPage.toggleGridView();
        Thread.sleep(3000);
        Assert.assertTrue(customersPage.isElementPresent(By.xpath("div[class='grid gap-2 2xl:grid-cols-5 min-[1200px]:grid-cols-4 min-[768px]:grid-cols-3 min-[640px]:grid-cols-2 mb-1 rounded bg-background dark:bg-[#121212]']")), "Grid view toggle did not work correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 7)
    public void testExportCSV() throws InterruptedException {
    	customersPage.clickExportCSV();
        Thread.sleep(3000);
        // Add logic to verify CSV file download if possible
        //Assert.assertTrue(isFileDownloaded("user_roles.csv"), "Export CSV did not work correctly.");      
        driver.navigate().refresh();
    }

    @Test(priority = 8)
    public void testExportCSVWithoutPermissions() throws InterruptedException {
        // Simulate lack of permissions and test export
    	customersPage.clickExportCSV();
        Thread.sleep(3000);
        //Assert.assertTrue(customersPage.isElementPresent(By.xpath("")), "Export CSV without permissions did not handle correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 9)
    public void testExportCSVWithError() throws InterruptedException {
        // Simulate error during export and test handling
    	customersPage.clickExportCSV();
        Thread.sleep(3000);
        //Assert.assertTrue(customersPage.isElementPresent(By.xpath("//div[contains(text(), 'Unexpected error')]")), "Export CSV with an error was not handled correctly."); 
        driver.navigate().refresh();
    }

    @Test(priority = 10)
    public void testExportCSVWithoutData() throws InterruptedException {
        // Simulate empty data and test export
    	customersPage.clickExportCSV();
        Thread.sleep(3000);
        //Assert.assertTrue(customersPage.isElementPresent(By.xpath("//div[contains(text(), 'No data to export')]")), "Export CSV without data was not handled correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 11)
    public void testFilterValidCriteria() throws InterruptedException {
    	customersPage.clickFilterButton();
        Thread.sleep(3000);
        // Add logic to select valid filter criteria
        //Assert.assertTrue(customersPage.isElementPresent(By.xpath("//div[contains(text(), 'Filtered Result')]")), "Filter functionality with valid criteria did not work correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 12)
    public void testFilterInvalidCriteria() throws InterruptedException {
    	customersPage.clickFilterButton();
        Thread.sleep(3000);
        // Add logic to select invalid filter criteria
        //Assert.assertTrue(customersPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Filter functionality with invalid criteria did not handle correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 13)
    public void testFilterNonExistingData() throws InterruptedException {
    	customersPage.clickFilterButton();
        Thread.sleep(3000);
        // Add logic to filter non-existing data
        // Assert.assertTrue(customersPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Filter functionality with non-existing data did not handle correctly.");
        driver.navigate().refresh();
    }
    
}



