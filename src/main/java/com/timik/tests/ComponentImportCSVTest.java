package com.timik.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.ComponentImportCSVPage;

public class ComponentImportCSVTest extends BasePage {

    ComponentImportCSVPage componentImportCSVPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
    	componentImportCSVPage = new ComponentImportCSVPage(driver);
    	componentImportCSVPage = PageFactory.initElements(driver,ComponentImportCSVPage.class);
    	componentImportCSVPage.login("ruvinyafernando@gmail.com", "Test123$");
        Thread.sleep(5000);
        driver.get("http://195.26.253.234:3000/dashboard/Component");
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void verifyAddComponenetWithValidInfo() throws InterruptedException {
    	componentImportCSVPage.clickImportCSV();
      	componentImportCSVPage.clickUploadCSVSection();
      	componentImportCSVPage.clickUploadCSV();
      	Thread.sleep(3000);
       
        // Assertion to verify successful save the component
        String successMessage = driver.findElement(By.xpath("successMessage")).getText();
        Assert.assertEquals(successMessage, "");
    }    

}




