package com.timik.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.timik.pages.AddComponentPage;
import com.timik.pages.BasePage;

public class AddComponentTest extends BasePage {

    AddComponentPage addComponentPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        addComponentPage = new AddComponentPage(driver);
        addComponentPage = PageFactory.initElements(driver, AddComponentPage.class);
        addComponentPage.login("ruvinyafernando@gmail.com", "Test123$");
        Thread.sleep(5000);
        driver.get("http://195.26.253.234:3000/dashboard/Component");
        Thread.sleep(20000);
    }

    @Test(priority = 1)
    public void verifyAddComponenetWithValidInfo() throws InterruptedException {
    	addComponentPage.addNewComponent();
    	addComponentPage.enterOrderNumber("");
    	addComponentPage.enterComponenentName("");
    	addComponentPage.enterComponenetCode("");
    	addComponentPage.enterSize("");
    	addComponentPage.enterWidth("");
    	addComponentPage.enterHeight("");
    	addComponentPage.enterDepth("");
    	addComponentPage.enterDimension("");
    	addComponentPage.enterThickness("");
    	addComponentPage.enterQuantityPerSet("");
    	addComponentPage.enterPrice("");
    	addComponentPage.enterWeight("");
    	addComponentPage.clickAdd();
    	addComponentPage.clickSaveAll();
    	Thread.sleep(3000);
       
        // Assertion to verify successful save the component
        String successMessage = driver.findElement(By.xpath("successMessage")).getText();
        Assert.assertEquals(successMessage, "");
    }

    @Test(priority = 2)
    public void verifyAddComponentWithOptionalFields() throws InterruptedException {
    	addComponentPage.addNewComponent();
    	addComponentPage.enterComponenentName("");
    	addComponentPage.enterComponenetCode("");
    	addComponentPage.enterSize("");
    	addComponentPage.enterWidth("");
    	addComponentPage.enterHeight("");
    	addComponentPage.enterDepth("");
    	addComponentPage.enterDimension("");
    	addComponentPage.enterThickness("");
    	addComponentPage.enterQuantityPerSet("");
    	addComponentPage.enterPrice("");
    	addComponentPage.enterWeight("");
    	addComponentPage.clickAdd();
    	addComponentPage.clickSaveAll();
    	Thread.sleep(3000);

        // Assertion to verify successful save the component with optional fields
        String successMessage = driver.findElement(By.xpath("")).getText();
        Assert.assertEquals(successMessage, "");
    }

    @Test(priority = 3)
    public void verifyOptionalFieldsRequiredMessages() throws InterruptedException {
    	addComponentPage.addNewComponent();
    	addComponentPage.clickAdd();
    	Thread.sleep(3000);
    	
    	String componentNameError = addComponentPage.getRequiredFieldErrorMessage("componentName");
    	Assert.assertEquals(componentNameError, "Component Name is required");
    	
    	String componentCodeError = addComponentPage.getRequiredFieldErrorMessage("componentCode");
    	Assert.assertEquals(componentCodeError, "Component Code is required");
    	
    	String sizeError = addComponentPage.getRequiredFieldErrorMessage("size");
    	Assert.assertEquals(sizeError, "Size is required");
    	
    	String widthError = addComponentPage.getRequiredFieldErrorMessage("width");
    	Assert.assertEquals(widthError, "Width is required");
    	
    	String heightError = addComponentPage.getRequiredFieldErrorMessage("height");
    	Assert.assertEquals(heightError, "Height is required");
    	
    	String depthError = addComponentPage.getRequiredFieldErrorMessage("depth");
    	Assert.assertEquals(depthError, "Depth is required");
    	
    	String dimensionError = addComponentPage.getRequiredFieldErrorMessage("dimension");
    	Assert.assertEquals(dimensionError, "Dimension is required");
    	
    	String thicknessError = addComponentPage.getRequiredFieldErrorMessage("thickness");
    	Assert.assertEquals(thicknessError, "Thickness is required");
    	
    	String qtyPerSetError = addComponentPage.getRequiredFieldErrorMessage("qtyPerSet");
    	Assert.assertEquals(qtyPerSetError, "Quantity Per Set is required");
    	
    	String priceError = addComponentPage.getRequiredFieldErrorMessage("price");
    	Assert.assertEquals(priceError, "Price is required");
    	
    	String weightError = addComponentPage.getRequiredFieldErrorMessage("weight");
    	Assert.assertEquals(weightError, "Weight is required");
    	
    }
    
    @Test(priority=4)
    public void verifyAddcomponentWithMissingFields() throws InterruptedException {
    	addComponentPage.addNewComponent();
    	addComponentPage.enterComponenentName("");
    	addComponentPage.enterComponenetCode("");
    	addComponentPage.enterHeight("");
    	addComponentPage.enterDepth("");
    	addComponentPage.enterQuantityPerSet("");
    	addComponentPage.enterWeight("");
    	addComponentPage.clickAdd();
    	addComponentPage.clickSaveAll();
    	Thread.sleep(3000);
    	
    	String sizeError = addComponentPage.getRequiredFieldErrorMessage("size");
    	Assert.assertEquals(sizeError, "Size is required");
    	
    	String widthError = addComponentPage.getRequiredFieldErrorMessage("width");
    	Assert.assertEquals(widthError, "Width is required");
    	
    	String dimensionError = addComponentPage.getRequiredFieldErrorMessage("dimension");
    	Assert.assertEquals(dimensionError, "Dimension is required");
    	
    	String thicknessError = addComponentPage.getRequiredFieldErrorMessage("thickness");
    	Assert.assertEquals(thicknessError, "Thickness is required");
    	
    	String priceError = addComponentPage.getRequiredFieldErrorMessage("price");
    	Assert.assertEquals(priceError, "Price is required");
    	
    }
    
    @Test(priority=5)
    public void verifyFieldsIntegerRequired() throws InterruptedException {
    	addComponentPage.addNewComponent();
    	addComponentPage.enterOrderNumber("");
    	addComponentPage.enterComponenentName("Framebar");
    	addComponentPage.enterComponenetCode("FB");
    	addComponentPage.enterSize("6");
    	addComponentPage.enterWidth("3.4");
    	addComponentPage.enterHeight("5.2");
    	addComponentPage.enterDepth("2.7");
    	addComponentPage.enterDimension("1980");
    	addComponentPage.enterThickness("1.5");
    	addComponentPage.enterQuantityPerSet("Set of 04 Nos");
    	addComponentPage.enterPrice("44.22");
    	addComponentPage.enterWeight("9.61");
    	addComponentPage.clickAdd();
    	Thread.sleep(3000);
    	
    	String widthIntegerRequired = addComponentPage.getIntegerRequiredErrorMessage("width");
    	Assert.assertEquals(widthIntegerRequired, "width must be an integer");
    	
    	String heightIntegerRequired = addComponentPage.getIntegerRequiredErrorMessage("height");
    	Assert.assertEquals(heightIntegerRequired, "height must be an integer");
    	
    	String depthIntegerRequired = addComponentPage.getIntegerRequiredErrorMessage("depth");
    	Assert.assertEquals(depthIntegerRequired, "depth must be an integer");
    	
    	String thicknessIntegerRequired = addComponentPage.getIntegerRequiredErrorMessage("thickness");
    	Assert.assertEquals(thicknessIntegerRequired, "thickness must be an integer");
    
    }
    
    @Test(priority =6)
    public void verifyDuplicateComponenet() throws InterruptedException {
    	addComponentPage.addNewComponent();
    	addComponentPage.enterComponenentName("Framebar");
    	addComponentPage.enterComponenetCode("FB");
    	addComponentPage.enterSize("4");
    	addComponentPage.enterWidth("3");
    	addComponentPage.enterHeight("6");
    	addComponentPage.enterDepth("2");
    	addComponentPage.enterDimension("440");
    	addComponentPage.enterThickness("2");
    	addComponentPage.enterQuantityPerSet("Set of 04 Nos");
    	addComponentPage.enterPrice("25.78");
    	addComponentPage.enterWeight("3");
    	addComponentPage.clickAdd();
    	addComponentPage.clickSaveAll();
    	Thread.sleep(3000);
    	
    	addComponentPage.addNewComponent();
      	addComponentPage.enterComponenentName("Framebar");
    	addComponentPage.enterComponenetCode("FB");
    	addComponentPage.enterSize("4");
    	addComponentPage.enterWidth("3");
    	addComponentPage.enterHeight("6");
    	addComponentPage.enterDepth("2");
    	addComponentPage.enterDimension("440");
    	addComponentPage.enterThickness("2");
    	addComponentPage.enterQuantityPerSet("Set of 04 Nos");
    	addComponentPage.enterPrice("25.78");
    	addComponentPage.enterWeight("3");
    	addComponentPage.clickAdd();
    	addComponentPage.clickSaveAll();
    	Thread.sleep(3000);
    	
    	String duplicateError = addComponentPage.getRequiredFieldErrorMessage("componentName");
    	Assert.assertEquals(duplicateError, "The componenet already exist.");
    	
    }
    

}



