package com.timik.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.UsersPage;

public class UsersTest extends BasePage {
    
	UsersPage usersPage;
 
    @BeforeClass
    public void setUp() throws InterruptedException {
        usersPage = new UsersPage(driver);
		usersPage = PageFactory.initElements(driver, UsersPage.class);
		usersPage.login("ruvinyafernando@gmail.com", "Test123$");
		Thread.sleep(12000);
		driver.get("http://195.26.253.234:3000/dashboard/users");
		Thread.sleep(5000); 
    }

    @Test(priority = 1)
    public void testAddNewUsersButton() throws InterruptedException {
        usersPage.clickAddNewUsers();
        Thread.sleep(8000);
        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//h3[normalize-space()='Add New User']")), "Add New Users button did not work correctly.");
        usersPage.clickAddNewUsersClose();
    }

    @Test(priority = 2)
    public void testSearchFunctionality() throws InterruptedException {
        usersPage.enterSearchQuery("Test");
        Thread.sleep(8000);
        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//h5[normalize-space()='Test User']")), "Search functionality did not retrieve the correct users.");
        driver.navigate().refresh();
    }
    
    @Test(priority = 3)
    public void testPartialSearchFunctionality() throws InterruptedException {
    	usersPage.enterSearchQuery("James");
        Thread.sleep(8000);
        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//h5[normalize-space()='James']")), "Partial search functionality did not retrieve the correct users.");
        driver.navigate().refresh();
    }

    @Test(priority = 4)
    public void testSearchNoResults() throws InterruptedException {
        usersPage.enterSearchQuery("Nonexistent User");
        Thread.sleep(8000);
        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Search functionality did not handle no results correctly.");
        driver.navigate().refresh();
    }
    
//    @Test(priority = 5)
//    public void testToggleListView() throws InterruptedException {
//        usersPage.toggleListView();
//        Thread.sleep(8000);
//        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//table[contains(@class,'w-full text-sm text-left text-gray-medium0 rtl:text-right dark:text-gray-400')]")), "List view toggle did not work correctly.");
//        driver.navigate().refresh();
//    }

    @Test(priority = 6)
    public void testToggleGridView() throws InterruptedException {
        usersPage.toggleGridView();
        Thread.sleep(8000);
        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[@class='grid gap-2 2xl:grid-cols-5 min-[1200px]:grid-cols-4 min-[768px]:grid-cols-3 min-[640px]:grid-cols-2 mb-1 rounded bg-background dark:bg-[#121212]']")), "Grid view toggle did not work correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 7)
    public void testExportCSV() throws InterruptedException {
        usersPage.clickExportCSV();
        Thread.sleep(6000);
        // Add logic to verify CSV file download if possible
        //Assert.assertTrue(isFileDownloaded("user_roles.csv"), "Export CSV did not work correctly.");      
        driver.navigate().refresh();
    }

//    @Test(priority = 8)
//    public void testExportCSVWithoutPermissions() throws InterruptedException {
//        // Simulate lack of permissions and test export
//        usersPage.clickExportCSV();
//        Thread.sleep(3000);
//        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'Permission denied')]")), "Export CSV without permissions did not handle correctly.");
//        driver.navigate().refresh();
//    }

//    @Test(priority = 9)
//    public void testExportCSVWithError() throws InterruptedException {
//        // Simulate error during export and test handling
//        usersPage.clickExportCSV();
//        Thread.sleep(3000);
//        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'Unexpected error')]")), "Export CSV with an error was not handled correctly."); 
//        driver.navigate().refresh();
//    }

//    @Test(priority = 10)
//    public void testExportCSVWithoutData() throws InterruptedException {
//        // Simulate empty data and test export
//        usersPage.clickExportCSV();
//        Thread.sleep(3000);
//        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'No data to export')]")), "Export CSV without data was not handled correctly.");
//        driver.navigate().refresh();
//    }

    @Test(priority = 11)
    public void testFilterValidCriteria() throws InterruptedException {
        usersPage.clickFilterButton();
        Thread.sleep(6000);
        // Add logic to select valid filter criteria
        //Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'Filtered Result')]")), "Filter functionality with valid criteria did not work correctly.");
        driver.navigate().refresh();
    }

//    @Test(priority = 12)
//    public void testFilterInvalidCriteria() throws InterruptedException {
//        usersPage.clickFilterButton();
//        Thread.sleep(3000);
//        // Add logic to select invalid filter criteria
//        //Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Filter functionality with invalid criteria did not handle correctly.");
//        driver.navigate().refresh();
//    }
//
//    @Test(priority = 13)
//    public void testFilterNonExistingData() throws InterruptedException {
//        usersPage.clickFilterButton();
//        Thread.sleep(3000);
//        // Add logic to filter non-existing data
//        //Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Filter functionality with non-existing data did not handle correctly.");
//        driver.navigate().refresh();
//    }
    
}






