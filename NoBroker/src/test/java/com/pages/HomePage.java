package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	@FindBy(xpath = "//div[@class='cursor-pointer text-primary-color border-0 border-b-4 border-solid border-primary-color font-bold']")
		WebElement Rent;
	
	@FindBy(xpath = "//div[@class='css-1hwfws3 nb-select__value-container nb-select__value-container--has-value']")
		WebElement locationDropdown;
	
	@FindBy(xpath = "//div[contains(text(),'Pune')]")
		WebElement locationValue;
	
	@FindBy(xpath = "//div[contains(text() , 'Availability')]")
		WebElement availabilityFilter;
	
	@FindBy(xpath = "//div[contains(text() , 'After 30 Days')]")
		WebElement availabilityFilterValue;
	
//	@FindBy(xpath = "//div[contains(text(),'BHK Type')]")
//	WebElement bhkTypeFilter;
	
	@FindBy(xpath = " //div[@class='nb-select__placeholder' and text()='BHK Type']")
	WebElement bhkDropdown;
	
	@FindBy(xpath = "//*[@id='searchCity']/div/div[1]/div")
	List<WebElement> bhkTypeFilter;
	
	@FindBy(xpath = "//input[@id='listPageSearchLocality']")
	WebElement SearchLocality;
	
	@FindBy(xpath = "//div[@class='nb-google-autocomplete nb-google-autocomplete-lg']//div[1]//div[1]//div[2]//div[1]")
	WebElement hinjawadiLocation;
	
	
	@FindBy(xpath ="//button[@class='prop-search-button flex items-center justify-center btn btn-primary btn-lg']")
	WebElement searchButton;
	
	@FindBy(id = "PremiumFilterTab")
	WebElement PremiumFilter;
	
	@FindBy(xpath = "//div[@id='alertMessageBox']")
	WebElement alertMessageBox;
		
	public HomePage(WebDriver driver) {
		 super(driver);  // Calling BasePage constructor
    }
	 public void clickRent() {
		 waitUntilWebElementIsVisible(Rent);  // Using wait method before clicking
		 Rent.click();
	 }
	 //to enter location
	 public void enterLocation()  {
		 waitUntilWebElementIsVisible(locationDropdown);  // Wait for the dropdown to be visible
		 locationDropdown.click(); 
		 locationValue.click(); // Click on the location value in the dropdown
	 }
	 public void selectLocality(String city) { 
		 waitUntilWebElementIsVisible(SearchLocality);  // Wait for the search locality input to be visible
		 SearchLocality.sendKeys(city);
		 waitUntilWebElementIsVisible(hinjawadiLocation);  
		 hinjawadiLocation.click();// Click on the Hinjawadi location
	 }
	 
	 
	 
	 // Method to apply availability filter
	 public void applyAvailabilityFilter() {
		 waitUntilWebElementIsVisible(bhkDropdown);
		 bhkDropdown.click();
		 int index = 4;
		 bhkTypeFilter.get(index).click();
		  
		 waitUntilWebElementIsVisible(availabilityFilter);  // Wait for the filter to be visible
		 availabilityFilter.click(); 
		 waitUntilWebElementIsVisible(availabilityFilterValue);  
		 availabilityFilterValue.click();  // Select the filter value	 
	 }
	 public void clickSearchButton() {
		 waitUntilWebElementIsVisible(searchButton);  // Wait for the search button to be visible
		 searchButton.click();  
	 }
	 public void premiumFilter() {	
		 waitUntilWebElementIsVisible(PremiumFilter);  // Wait for the Premium Filter tab to be visible
		 PremiumFilter.click();  // Click on the Premium Filter tab
		 Assert.assertTrue("Premium Filter is not displayed", PremiumFilter.isDisplayed());  // Verify if the Premium Filter is displayed
	 }
	 
	 public void errorMessage() throws InterruptedException {
		 // This method is to handle the error message when the locality field is empty
		 	waitUntilWebElementIsVisible(alertMessageBox);
		 	Thread.sleep(1500);// Wait for the alert message box to be visible
			String errorMessage = alertMessageBox.getText().trim(); 
			System.out.println(errorMessage);
			String expectedMessage = "PLEASE SELECT A LOCALITY WITHIN PUNE";
			Assert.assertEquals("PLEASE SELECT A LOCALITY WITHIN PUNE", errorMessage , expectedMessage);
	 }
}
