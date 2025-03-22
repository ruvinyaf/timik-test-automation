package com.timik.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.RemoveProjectPage;

public class RemoveProjectTest extends BasePage {

	RemoveProjectPage removeProjectPage;

	@BeforeClass
	public void setUpPage() throws InterruptedException {
		removeProjectPage = new RemoveProjectPage(driver);
		removeProjectPage.login("ruvinyafernando@gmail.com", "Test123$");
		Thread.sleep(5000);
		driver.get("http://195.26.253.234:3000/dashboard/projects");
		Thread.sleep(5000);
	}

	@Test(priority = 6)
	public void deleteProjectWithCorrectProjectName() throws InterruptedException {
		removeProjectPage.clickDeleteIcon();
		Thread.sleep(3000);
		removeProjectPage.enterProjectName("Test Project 02");
		removeProjectPage.clickDeleteButton();

		// Add assertions to verify project deletion
		String successMessage = driver.findElement(By.xpath("")).getText();
		Assert.assertTrue(successMessage.contains(""));

		driver.navigate().refresh();
	}

	@Test(priority = 1)
	public void deleteProjectWithUnmatchedProjectName() throws InterruptedException {
		removeProjectPage.clickDeleteIcon();
		Thread.sleep(3000);
		removeProjectPage.enterProjectName("Unmatched Project Name");
		removeProjectPage.clickDeleteButton();

		// Add assertions to verify project is not deleted
		String errorMessage = driver.findElement(By.xpath("//div[@class='text-sm text-red-500']")).getText();
		Assert.assertTrue(errorMessage.contains("Value does not match"));

		removeProjectPage.clickCloseButton();
	}

	@Test(priority = 2)
	public void deleteProjectWithoutProjectName() throws InterruptedException {

		removeProjectPage.clickDeleteIcon();
		Thread.sleep(3000);
		removeProjectPage.clickDeleteButton();
		removeProjectPage.clickDeleteButton();

		// Add assertions to verify error
		String errorMessage = driver.findElement(By.xpath("//div[@class='text-sm text-red-500']")).getText();
		Assert.assertTrue(errorMessage.contains("Please enter the project name"));

		removeProjectPage.clickCloseButton();
	}

	@Test(priority = 3)
	public void deleteProjectAndCancel() throws InterruptedException {
		removeProjectPage.clickDeleteIcon();
		removeProjectPage.clickCloseButton();
		Thread.sleep(3000);

		// Add assertions to verify project is not deleted
		boolean isPopupDisplayed = driver.findElement(By.xpath("//div[@class='w-1/2 bg-background p-4 rounded-lg z-50 dark:bg-[#1e1e1e]']")).isDisplayed();
		Assert.assertFalse(isPopupDisplayed);

		removeProjectPage.clickCloseButton();
	}

	@Test(priority = 4)
	public void closeDialogAfterCorrectProjectName() throws InterruptedException {
		removeProjectPage.clickDeleteIcon();
		Thread.sleep(3000);
		removeProjectPage.enterProjectName("Test Project 01");
		Thread.sleep(3000);
		removeProjectPage.clickCloseButton();

		// Add assertions to verify dialog behavior
		boolean isPopupDisplayed = driver.findElement(By.xpath("//div[@class='w-1/2 bg-background p-4 rounded-lg z-50 dark:bg-[#1e1e1e]']")).isDisplayed();
		Assert.assertFalse(isPopupDisplayed);
	}

	@Test(priority = 5)
	public void closeDialogAfterIncorrectUserName() throws InterruptedException {
		removeProjectPage.clickDeleteIcon();
		Thread.sleep(3000);
		removeProjectPage.enterProjectName("Unmatched Project Name");
		removeProjectPage.clickCloseButton();

		// Add assertions to verify dialog behavior
		boolean isPopupDisplayed = driver.findElement(By.xpath("//div[@class='w-1/2 bg-background p-4 rounded-lg z-50 dark:bg-[#1e1e1e]']")).isDisplayed();
		Assert.assertFalse(isPopupDisplayed);

	}

	@AfterClass
	public void tearDownTest() {
		driver.navigate().refresh();
		driver.quit();
	}

}
