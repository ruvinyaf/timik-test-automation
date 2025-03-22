package com.timik.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.SignInPage;

public class SignInTest extends BasePage {

	@Test(priority = 13)
	public void validEmailAndPassword() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signIn("ruvinyafernando@gmail.com", "Test123$", false);
		Thread.sleep(12000);
		Assert.assertTrue(signInPage.isPageLoaded(), "The dashboard page did not load successfully.");
	}

	@Test(priority = 1)
	public void testCorrectEmailIncorrectPassword() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signIn("ruvinyafernando@gmail.com", "Incorrect123", false);
		Thread.sleep(5000);

		// Assert error message or failure
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='text-red-500 text-center mb-4']"));
		Assert.assertTrue(errorMessage.isDisplayed());

		driver.navigate().refresh();
	}

	@Test(priority = 2)
	public void testIncorrectEmailCorrectPassword() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signIn("invalid.email@domain.com", "Test123$", false);
		Thread.sleep(3000);

		// Assert error message or failure
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='text-red-500 text-center mb-4']"));
		Assert.assertTrue(errorMessage.isDisplayed());

		driver.navigate().refresh();
	}

	@Test(priority = 3)
	public void testCorrectEmailEmptyPassword() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signIn("ruvinyafernando@gmail.com", "", false);
		Thread.sleep(3000);

		// Assert error message or failure
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='text-red-500 text-sm mt-1']"));
		Assert.assertTrue(errorMessage.isDisplayed());

		driver.navigate().refresh();
	}

	@Test(priority = 4)
	public void testCorrectPasswordEmptyEmail() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signIn("", "Test123$", false);
		Thread.sleep(3000);

		// Assert error message or failure
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='text-red-500 text-sm mt-1']"));
		Assert.assertTrue(errorMessage.isDisplayed());

		driver.navigate().refresh();
	}

	@Test(priority = 5)
	public void testEmptyEmailEmptyPassword() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signIn("", "", false);
		Thread.sleep(3000);

		// Add assertions for error message or failure
		WebElement emailErrorMessage = driver
				.findElement(By.xpath("//div[normalize-space()='Please enter your username.']"));
		WebElement passwordErrorMessage = driver
				.findElement(By.xpath("//div[normalize-space()='Please enter your password.']"));
		Assert.assertTrue(emailErrorMessage.isDisplayed());
		Assert.assertTrue(passwordErrorMessage.isDisplayed());

		driver.navigate().refresh();
	}

	@Test(priority = 6)
	public void testInvalidEmailFormat() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signIn("invalidemail", "Test123$", false);
		Thread.sleep(3000);

		// Add assertions for error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());

		driver.navigate().refresh();
	}

	@Test(priority = 7)
	public void testUnregisteredEmail() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signIn("ruvinyafernando34@gmail.com", "Test123$", false);
		Thread.sleep(3000);

		// Add assertions for error message or failure
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='text-red-500 text-center mb-4']"));
		Assert.assertTrue(errorMessage.isDisplayed());

		driver.navigate().refresh();
	}

	@Test(priority = 8)
	public void testSpecialCharactersInEmail() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signIn("special!char@domain.com", "Test123$", false);
		Thread.sleep(3000);

		// Add assertions for error message or failure
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='text-red-500 text-center mb-4']"));
		Assert.assertTrue(errorMessage.isDisplayed());

		driver.navigate().refresh();
	}

	@Test(priority = 9)
	public void testInvalidCharactersInEmail() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signIn("invalid@chars*domain.com", "Test123$", false);
		Thread.sleep(3000);
		
		// Add assertions for error message or failure
//        WebElement errorMessage = driver.findElement(By.xpath(""));
//        Assert.assertTrue(errorMessage.isDisplayed());

		driver.navigate().refresh();
	}

	@Test(priority = 10)
	public void testExceedingMaxLengthInEmail() throws InterruptedException {
		// Generate a long email string
		String longEmail = "longemail".repeat(30) + "@domain.com";
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signIn(longEmail, "Test123$", false);
		Thread.sleep(3000);

		// Add assertions for error message or failure
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='text-red-500 text-center mb-4']"));
		Assert.assertTrue(errorMessage.isDisplayed());

		driver.navigate().refresh();
	}

	@Test(priority = 11)
	public void testExceedingMaxLengthInPassword() throws InterruptedException {
		// Generate a long password string
		String longPassword = "Test123*".repeat(20);
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signIn("ruvinyafernando@gmail.com", longPassword, false);
		Thread.sleep(3000);
		
		// Add assertions for error message or failure
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='text-red-500 text-center mb-4']"));
		Assert.assertTrue(errorMessage.isDisplayed());

		driver.navigate().refresh();
	}

	@Test(priority = 12)
	public void testLeadingTrailingSpacesInPassword() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signIn("ruvinyafernando@gmail.com", "  Test123$  ", false);
		Thread.sleep(3000);
		
		// Add assertions for error message or failure
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='text-red-500 text-center mb-4']"));
		Assert.assertTrue(errorMessage.isDisplayed());

		driver.navigate().refresh();
	}
	
}