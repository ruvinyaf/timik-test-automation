package com.timik.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.ProjectsPage;


public class ProjectsTest extends BasePage {
    
	ProjectsPage projectsPage;
 
    @BeforeClass
    public void setUp() throws InterruptedException {
    	projectsPage = new ProjectsPage(driver);
    	projectsPage = PageFactory.initElements(driver, ProjectsPage.class);
    	projectsPage.login("ruvinyafernando@gmail.com", "Test123$");
		Thread.sleep(5000);
		driver.get("http://195.26.253.234:3000/dashboard/Roles");
		Thread.sleep(5000); 
    }

    @Test(priority = 1)
    public void testAddNewProjects() throws InterruptedException {
    	projectsPage.clickAdddNewProject();
        Thread.sleep(3000);
        Assert.assertTrue(projectsPage.isElementPresent(By.xpath("")), "Add New Projects button did not work correctly.");
        projectsPage.cickAddNewProjectClose();
        driver.navigate().refresh();
    }
    
    @Test(priority=2)
    public void testUpdateProjects() throws InterruptedException {
    	projectsPage.clickUpdate();
    	Thread.sleep(3000);
    	Assert.assertTrue(projectsPage.isElementPresent(By.xpath("")), "Projects Update button did not work correctly.");
    	projectsPage.cickAddNewProjectClose();
    	driver.navigate().refresh();
    }
    
    @Test(priority = 3)
    public void testDeleteProjects() throws InterruptedException {
    	projectsPage.clickDelete();
    	Thread.sleep(3000);
    	Assert.assertTrue(projectsPage.isElementPresent(By.xpath("")), "Projects Delete button did not work correctly.");
    }
    
    @Test(priority = 4)
    public void testSearchFunctionality() throws InterruptedException {
    	projectsPage.enterSearchQuery("Test Project 01");
        Thread.sleep(3000);
        Assert.assertTrue(projectsPage.isElementPresent(By.xpath("")), "Search functionality did not retrieve the correct projects.");
        driver.navigate().refresh();
    }
    
    @Test(priority = 5)
    public void testPartialSearchFunctionality() throws InterruptedException {
    	projectsPage.enterSearchQuery("Project 01");
        Thread.sleep(3000);
        Assert.assertTrue(projectsPage.isElementPresent(By.xpath("")), "Partial search functionality did not retrieve the correct projects.");
        driver.navigate().refresh();
    }

    @Test(priority = 6)
    public void testSearchNoResults() throws InterruptedException {
        projectsPage.enterSearchQuery("Nonexistent Project");
        Thread.sleep(3000);
        Assert.assertTrue(projectsPage.isElementPresent(By.xpath("")), "Search functionality did not handle no results correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 7)
    public void testExportCSV() throws InterruptedException {
    	projectsPage.clickExportCSV();
        Thread.sleep(3000);
        // Add logic to verify CSV file download if possible
        //Assert.assertTrue(isFileDownloaded("user_roles.csv"), "Export CSV did not work correctly.");      
        driver.navigate().refresh();
    }

//    @Test(priority = 8)
//    public void testExportCSVWithoutPermissions() throws InterruptedException {
//        // Simulate lack of permissions and test export
//        projectsPage.clickExportCSV();
//        Thread.sleep(3000);
//        Assert.assertTrue(projectsPage.isElementPresent(By.xpath("")), "Export CSV without permissions did not handle correctly.");
//        driver.navigate().refresh();
//    }

//    @Test(priority = 9)
//    public void testExportCSVWithError() throws InterruptedException {
//        // Simulate error during export and test handling
//        projectsPage.clickExportCSV();
//        Thread.sleep(3000);
//        Assert.assertTrue(projectsPage.isElementPresent(By.xpath("//div[contains(text(), 'Unexpected error')]")), "Export CSV with an error was not handled correctly."); 
//        driver.navigate().refresh();
//    }

//    @Test(priority = 10)
//    public void testExportCSVWithoutData() throws InterruptedException {
//        // Simulate empty data and test export
//        projectsPage.clickExportCSV();
//        Thread.sleep(3000);
//        Assert.assertTrue(projectsPage.isElementPresent(By.xpath("")), "Export CSV without data was not handled correctly.");
//        driver.navigate().refresh();
//    }

    @Test(priority = 11)
    public void testFilterValidCriteria() throws InterruptedException {
        projectsPage.clickFilterButton();
        Thread.sleep(3000);
        // Add logic to select valid filter criteria
        //Assert.assertTrue(projectsPage.isElementPresent(By.xpath("")), "Filter functionality with valid criteria did not work correctly.");
        driver.navigate().refresh();
    }

//    @Test(priority = 12)
//    public void testFilterInvalidCriteria() throws InterruptedException {
//        projectsPage.clickFilterButton();
//        Thread.sleep(3000);
//        // Add logic to select invalid filter criteria
//        //Assert.assertTrue(projectsPage.isElementPresent(By.xpath("")), "Filter functionality with invalid criteria did not handle correctly.");
//        driver.navigate().refresh();
//    }

//    @Test(priority = 13)
//    public void testFilterNonExistingData() throws InterruptedException {
//        projectsPage.clickFilterButton();
//        Thread.sleep(3000);
//        // Add logic to filter non-existing data
//        //Assert.assertTrue(projectsPage.isElementPresent(By.xpath("")), "Filter functionality with non-existing data did not handle correctly.");
//        driver.navigate().refresh();
//    }

    @Test(priority = 14)
    public void testToggleListView() throws InterruptedException {
        projectsPage.toggleListView();
        Thread.sleep(3000);
        Assert.assertTrue(projectsPage.isElementPresent(By.xpath("")), "List view toggle did not work correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 15)
    public void testToggleGridView() throws InterruptedException {
        projectsPage.toggleGridView();
        Thread.sleep(3000);
        Assert.assertTrue(projectsPage.isElementPresent(By.xpath("")), "Grid view toggle did not work correctly.");
        driver.navigate().refresh();
    }

//    private boolean isFileDownloaded(String fileName) {
//        // Implement file download verification logic
//        return true;
//    }
    
}




