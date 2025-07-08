package com.pages;

import java.io.File;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	WebDriver driver;
   
	
	@FindBy(xpath = "//input[@placeholder='Search a service']")
	WebElement searchBox;

	@FindBy(xpath = "//div[contains(text(), 'AC Services')]")
	WebElement acServicesDiv;
	
	@FindBy(xpath ="/html/body/div[4]/div/div[2]/div[2]/div[2]/div/img")
	WebElement img;
	
	@FindBy(xpath ="//div[@class='h-2 bg-category-sprite w-1p']")
	WebElement Selectcity;
	
	@FindBy(xpath ="//img[@alt='Mumbai']")
	WebElement imgcity;
	

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickSearch() {
		searchBox.click();
	}

	public void enterData() {
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(searchBox));
    action.sendKeys(searchBox, "AC Services").build().perform();
    wait.until(ExpectedConditions.visibilityOf(img));
    action.click(img).build().perform();

	}
 
     public void clickCity() {
    	 waitUntilWebElementIsClickable(Selectcity);
    	 Selectcity.click(); 
 	 }
     
     public void displayCity() {
    	 waitUntilWebElementIsClickable(imgcity);
    	 imgcity.click();
     }
     
     public void takesScreen() throws IOException
		{
			TakesScreenshot screen1=(TakesScreenshot)driver;
			File src1= screen1.getScreenshotAs(OutputType.FILE);
			String filename = "View_Report"+System.currentTimeMillis()+".png";
			String destination ="C:\\Windows\\System32\\config\\systemprofile\\SprintWorkspace\\NoBroker\\src\\test\\resource\\Screenshot\\"
			+filename;
			
			File dest = new File(destination);
		   FileUtils.copyFile(src1, dest);
		   
		
					
		}
}
