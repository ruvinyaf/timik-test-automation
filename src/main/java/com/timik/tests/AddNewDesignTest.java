package com.timik.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.AddNewDesignPage;
import com.timik.pages.BasePage;

public class AddNewDesignTest extends BasePage {

	private AddNewDesignPage addNewDesignPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		addNewDesignPage = new AddNewDesignPage(driver);
		addNewDesignPage = PageFactory.initElements(driver, AddNewDesignPage.class);
		addNewDesignPage.login("ruvinyafernando@gmail.com", "Test123$");
		Thread.sleep(5000);
		driver.get("http://195.26.253.234:3000/dashboard/projects");
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void testAddNewDesign() throws InterruptedException {
		addNewDesignPage.clickAddNewDesign();
		addNewDesignPage.enterDesignName("Test design 001");
		addNewDesignPage.enterDescription("Test Description");
		addNewDesignPage.clickMaterialColor();
		addNewDesignPage.enetrMaterialColor("");
		addNewDesignPage.clickAssignee();
		addNewDesignPage.enterAssignee("");
		addNewDesignPage.clickCreate();
		Thread.sleep(3000);

		// Assertion to verify successful save
		String successMessage = driver.findElement(By.xpath("")).getText();
		Assert.assertEquals(successMessage, "");
	}

	@Test(priority = 2)
	public void testAddNewDesignWithMandotoryFields() throws InterruptedException {
		addNewDesignPage.clickAddNewDesign();
		addNewDesignPage.enterDesignName("");
		addNewDesignPage.enterDescription("");
		addNewDesignPage.clickMaterialColor();
		addNewDesignPage.clickCreate();
		Thread.sleep(3000);

		// Assertion to verify successful save
		String successMessage = driver.findElement(By.id("successMessage")).getText();
		Assert.assertEquals(successMessage, "User information saved successfully");
	}

	@Test(priority = 3)
	public void verifyAddAssignees() throws InterruptedException {
		addNewDesignPage.clickAddNewDesign();
		addNewDesignPage.clickAssignee();
		addNewDesignPage.enterAssignee("Tammy");
		Thread.sleep(3000);
		addNewDesignPage.clickAssignee();
		addNewDesignPage.enterAssignee("James");

		// Assertion to verify role assignment
		String successMessage = driver.findElement(By.id("successMessage")).getText();
		Assert.assertEquals(successMessage, "User information saved successfully");
	}

	@Test(priority = 4)
	public void verifyAddAssign() {
		addNewDesignPage.clickAddNewDesign();
		addNewDesignPage.clickAssignee();
		addNewDesignPage.enterAssignee("");

		// Assertion to verify error message
		String errorMsg = driver.findElement(By.xpath("")).getText();
		Assert.assertEquals(errorMsg, "");
	}

}
