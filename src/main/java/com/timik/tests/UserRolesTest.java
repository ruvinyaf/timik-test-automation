package com.timik.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.UserRolesPage;

public class UserRolesTest extends BasePage {
    
	UserRolesPage userRolesPage;
 
    @BeforeClass
    public void setUp() throws InterruptedException {
        userRolesPage = new UserRolesPage(driver);
		userRolesPage = PageFactory.initElements(driver, UserRolesPage.class);
		userRolesPage.login("ruvinyafernando@gmail.com", "Test123$");
		Thread.sleep(12000);
		driver.get("http://195.26.253.234:3000/dashboard/Roles");
		Thread.sleep(6000); 
    }

    @Test(priority = 1)
    public void testAddNewUserRoleButton() throws InterruptedException {
        userRolesPage.clickAddNewUserRole();
        Thread.sleep(8000);
        Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//h3[normalize-space()='Add New Role']")), "Add New User Role button did not work correctly.");
        userRolesPage.clickAddNewUserRoleClose();
    }

    @Test(priority = 2)
    public void testSearchFunctionality() throws InterruptedException {
        userRolesPage.enterSearchQuery("Super Admin");
        Thread.sleep(12000);
        Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//h5[normalize-space()='Super Admin']")), "Search functionality did not retrieve the correct user role.");
        driver.navigate().refresh();
    }
    
    @Test(priority = 3)
    public void testPartialSearchFunctionality() throws InterruptedException {
        userRolesPage.enterSearchQuery("Admin");
        Thread.sleep(12000);
        Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//h5[normalize-space()='Super Admin' or normalize-space()='Administrator']")), "Partial search functionality did not retrieve the correct user role.");
        driver.navigate().refresh();
    }

    @Test(priority = 4)
    public void testSearchNoResults() throws InterruptedException {
        userRolesPage.enterSearchQuery("Nonexistent User Role");
        Thread.sleep(12000);
        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Search functionality did not handle no results correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 5)
    public void testToggleListView() throws InterruptedException {
        userRolesPage.toggleListView();
        Thread.sleep(8000);
        Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//table[contains(@class,'w-full text-sm text-left text-gray-medium0 rtl:text-right dark:text-gray-400')]")), "List view toggle did not work correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 6)
    public void testToggleGridView() throws InterruptedException {
        userRolesPage.toggleGridView();
        Thread.sleep(8000);
        Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[@class='grid gap-2 2xl:grid-cols-5 min-[1200px]:grid-cols-4 min-[768px]:grid-cols-3 min-[640px]:grid-cols-2 mb-1 rounded bg-background dark:bg-[#121212]']")), "Grid view toggle did not work correctly.");
        driver.navigate().refresh();
    }
    
    
    @Test(priority = 7)
    public void testExportCSV() throws InterruptedException {
        userRolesPage.clickExportCSV();
        Thread.sleep(8000);
        // Add logic to verify CSV file download
        //Assert.assertTrue(isFileDownloaded("user_roles.csv"), "Export CSV did not work correctly.");      
        driver.navigate().refresh();
    }

//    @Test(priority = 8)
//    public void testExportCSVWithoutPermissions() throws InterruptedException {
//        // Simulate lack of permissions and test export
//        userRolesPage.clickExportCSV();
//        Thread.sleep(3000);
//        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'Permission denied')]")), "Export CSV without permissions did not handle correctly.");
//        driver.navigate().refresh();
//    }

//    @Test(priority = 9)
//    public void testExportCSVWithError() throws InterruptedException {
//        // Simulate error during export and test handling
//        userRolesPage.clickExportCSV();
//        Thread.sleep(3000);
//        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'Unexpected error')]")), "Export CSV with an error was not handled correctly.");
//        driver.navigate().refresh();
//    }

//    @Test(priority = 10)
//    public void testExportCSVWithoutData() throws InterruptedException {
//        // Simulate empty data and test export
//        userRolesPage.clickExportCSV();
//        Thread.sleep(3000);
//        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'No data to export')]")), "Export CSV without data was not handled correctly.");
//        driver.navigate().refresh();
//    }

    @Test(priority = 11)
    public void testFilterValidCriteria() throws InterruptedException {
        userRolesPage.clickFilterButton();
        Thread.sleep(10000);
        // Add logic to select valid filter criteria
        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'Filtered Result')]")), "Filter functionality with valid criteria did not work correctly.");
        driver.navigate().refresh();
    }

//    @Test(priority = 12)
//    public void testFilterInvalidCriteria() throws InterruptedException {
//        userRolesPage.clickFilterButton();
//        Thread.sleep(3000);
//        // Add logic to select invalid filter criteria
//        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Filter functionality with invalid criteria did not handle correctly.");
//        driver.navigate().refresh();
//    }

//    @Test(priority = 13)
//    public void testFilterNonExistingData() throws InterruptedException {
//        userRolesPage.clickFilterButton();
//        Thread.sleep(3000);
//        // Add logic to filter non-existing data
//        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Filter functionality with non-existing data did not handle correctly.");
//        driver.navigate().refresh();
//    }

//    @Test(priority = 14)
//    public void testNextPageButton() throws InterruptedException {
//    	Thread.sleep(3000);
//        userRolesPage.clickNextPage();
//        Thread.sleep(3000);
//        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("")), "Next page button did not work correctly.");
//        driver.navigate().refresh();
//    }
//
//    @Test(priority = 15)
//    public void testPreviousPageButton() throws InterruptedException {
//        userRolesPage.clickPreviousPage();
//        Thread.sleep(3000);
//        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("")), "Previous page button did not work correctly.");
//        driver.navigate().refresh();
//    }
    
//    private boolean isFileDownloaded(String fileName) {
//        // Implement file download verification logic
//        return true;
//    }
    
}


