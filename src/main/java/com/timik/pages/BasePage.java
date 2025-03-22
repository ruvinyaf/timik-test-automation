package com.timik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasePage {

    protected WebDriver driver; 

    @BeforeClass
    public void setup() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/home/breadscrums/Documents/chromedriver-linux64/chromedriver");

        // Initialize browser
        driver = new ChromeDriver();

        // Open the timik application
        driver.get("http://195.26.253.234:3000/");

        // Maximize browser
        driver.manage().window().maximize();               
    } 
 
    @AfterClass
    public void teardown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
