package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage{
    
	@FindBy(xpath = "//div[text()='Buy']")
	public WebElement buyButton;
	
	@FindBy(xpath = "//div[@id='searchCity']//div[contains(@class,'nb-select__control')]")
	public WebElement cityBox;
	
	@FindBy(xpath = "//div[contains(text(),'Pune')]")
	public WebElement puneOption;
	
	@FindBy(xpath="//input[@id=\"listPageSearchLocality\"]")
	WebElement localityBox;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	public WebElement searchButton;
	 
	@FindBy(xpath = "//div[contains(text(),'Please select a locality within pune')]")
	private WebElement invalidLocalityMessage;
	
	@FindBy(xpath = "//div[contains(text(),\"Please select a locality within pune\")]")
	 WebElement errorMsg;
	
	public HomePage(WebDriver driver) {
		super(driver);
        PageFactory.initElements(driver, this);   
	}
	
	public void goToBuyPage() {
	       
        buyButton.click();
    }

	public void enterLocality() throws AWTException {
        try {
           wait.until(ExpectedConditions.elementToBeClickable(localityBox)).click();
            localityBox.sendKeys("Borivali");
            Thread.sleep(2000);
       } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	 public void clickSearch() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }
	 
	 public void invalidData()
		{
		 System.out.println("Invalid Data");
			
		}
	 
}
