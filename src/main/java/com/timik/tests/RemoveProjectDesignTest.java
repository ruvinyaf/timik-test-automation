package com.timik.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.RemoveProjectDesignPage;

public class RemoveProjectDesignTest extends BasePage {

	RemoveProjectDesignPage removeProjectDesignPage;

	@BeforeClass
	public void setUpPage() throws InterruptedException {
		removeProjectDesignPage = new RemoveProjectDesignPage(driver);
		removeProjectDesignPage.login("ruvinyafernando@gmail.com", "Test123$");
		Thread.sleep(5000);
		driver.get("");
		Thread.sleep(5000);
	}

	@Test(priority = 6)
	public void removeDesignWithCorrectDesignName() throws InterruptedException {
		removeProjectDesignPage.clickDeleteIcon();
		Thread.sleep(3000);
		removeProjectDesignPage.enterProjectDesignName("Test Design 2");
		removeProjectDesignPage.clickDeleteButton();

		// Add assertions to verify project design deletion
		String successMessage = driver.findElement(By.xpath("")).getText(); // need to add
		Assert.assertTrue(successMessage.contains(""));// need to add

		driver.navigate().refresh();
	}

	@Test(priority = 1)
	public void removeDesignWithUnmatchedDesignName() throws InterruptedException {
		removeProjectDesignPage.clickDeleteIcon();
		Thread.sleep(3000);
		removeProjectDesignPage.enterProjectDesignName("Unmatched Project Design Name");
		removeProjectDesignPage.clickDeleteButton();

		// Add assertions to verify project design is not deleted
		String errorMessage = driver.findElement(By.xpath("//div[@class='text-sm text-red-500']")).getText();
		Assert.assertTrue(errorMessage.contains("Value does not match"));

		removeProjectDesignPage.clickCloseButton();
	}

	@Test(priority = 2)
	public void removeDesignWithoutDesignName() throws InterruptedException {
		removeProjectDesignPage.clickDeleteIcon();
		Thread.sleep(3000);
		removeProjectDesignPage.clickDeleteButton();

		// Add assertions to verify error or project design is not deleted
		String errorMessage = driver.findElement(By.xpath("//div[@class='text-sm text-red-500']")).getText();
		Assert.assertTrue(errorMessage.contains("Please enter the design name"));

		removeProjectDesignPage.clickCloseButton();
	}

	@Test(priority = 3)
	public void removeDesignAndCancel() throws InterruptedException {
		removeProjectDesignPage.clickDeleteIcon();
		Thread.sleep(3000);

		// Add assertions to verify project design is not deleted
        boolean isPopupDisplayed = driver.findElement(By.xpath("//div[@class='w-1/2 bg-background p-4 rounded-lg z-50 dark:bg-[#1e1e1e]']")).isDisplayed();
        Assert.assertFalse(isPopupDisplayed);

		removeProjectDesignPage.clickCloseButton();
	}

	@Test(priority = 4)
	public void closeDialogAfterCorrectDesignName() throws InterruptedException {
		removeProjectDesignPage.clickDeleteIcon();
		Thread.sleep(3000);
		removeProjectDesignPage.enterProjectDesignName("Test Project design 01");
		Thread.sleep(3000);
		removeProjectDesignPage.clickCloseButton();

		// Add assertions to verify dialog behavior
		boolean isPopupDisplayed = driver.findElement(By.xpath("//div[@class='w-1/2 bg-background p-4 rounded-lg z-50 dark:bg-[#1e1e1e]']")).isDisplayed();
		Assert.assertFalse(isPopupDisplayed);
	}

	@Test(priority = 5)
	public void closeDialogAfterIncorrectDesignNames() throws InterruptedException {
		removeProjectDesignPage.clickDeleteIcon();
		Thread.sleep(3000);
		removeProjectDesignPage.enterProjectDesignName("Unmatched Design Name");
		removeProjectDesignPage.clickCloseButton();

		// Add assertions to verify dialog behavior
		boolean isPopupDisplayed = driver.findElement(By.xpath("//div[@class='text-sm text-red-500']")).isDisplayed();
		Assert.assertFalse(isPopupDisplayed);

	}

	@AfterClass
	public void tearDownTest() {
		driver.navigate().refresh();
		driver.quit();
	}

}
