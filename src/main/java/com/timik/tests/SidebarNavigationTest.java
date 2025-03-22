package com.timik.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.BasePage;
import com.timik.pages.SidebarNavigationPage;


public class SidebarNavigationTest extends BasePage {

    SidebarNavigationPage sidebarNavigationPage;
    
    @BeforeClass
    public void setUp() throws InterruptedException {
        sidebarNavigationPage = new SidebarNavigationPage(driver);
        sidebarNavigationPage.login("ruvinyafernando@gmail.com", "Test123$");
		Thread.sleep(12000);	
		sidebarNavigationPage.clickExpand();
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void testClickUserManagement() throws InterruptedException {
        sidebarNavigationPage.clickUserManagement();
        Thread.sleep(3000);
    }
    
    @Test(priority = 2)
    public void testClickRole() throws InterruptedException {
        sidebarNavigationPage.clickRole();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("Roles"), "Role URL validation failed");
        Thread.sleep(3000);   
    }
    
    @Test(priority = 3)
    public void testClickUsers() throws InterruptedException {
        sidebarNavigationPage.clickUsers();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("users"), "Users URL validation failed");
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void testClickConfig() throws InterruptedException {
        sidebarNavigationPage.clickConfig();
        Thread.sleep(3000);
    }
    
    @Test(priority = 5)
    public void testClickWorkflow() throws InterruptedException {
        sidebarNavigationPage.clickWorkflow();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("workflow"), "Workflow URL validation failed");
        Thread.sleep(3000);
    }

    @Test(priority = 6)
    public void testClickCustomers() throws InterruptedException {
    	sidebarNavigationPage.clickCustomers();
    	Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("customers"), "Customers URL validation failed");
        Thread.sleep(3000);
    }
    
    @Test(priority=7)
    public void testClickProjects() throws InterruptedException {
    	sidebarNavigationPage.clickProjects();
    	Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("projects"), "Projects URL validation failed");
        Thread.sleep(3000);
    }
    
    @Test(priority=8)
    public void testClickConfiguration() throws InterruptedException {
    	sidebarNavigationPage.clickConfiguration();
    	Thread.sleep(3000);
    }
    
    @Test(priority=9)
    public void testClickPriceList() throws InterruptedException {
    	sidebarNavigationPage.clickPriceList();
    	Thread.sleep(3000);
    	Assert.assertTrue(driver.getCurrentUrl().contains("Component"), "Price List URL validation failed");
    	Thread.sleep(3000); 	
    }
  
}

