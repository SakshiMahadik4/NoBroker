package com.pages;

import java.util.List;
import org.junit.Assert;
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
	
	@FindBy(xpath = " //div[@class='nb-select__placeholder' and text()='BHK Type']")
	WebElement bhkDropdown;
	
	@FindBy(xpath = "//input[@value='BHK2']")
	WebElement bhk2Filter;
	
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
	
	@FindBy(xpath = "//img")
	List<WebElement> images;
	
	public void getImages() {
		System.out.println("Number of images on the page: " + images.size());
	}
	
	public HomePage(WebDriver driver) {
		 super(driver);  // Calling BasePage constructor
		
    }
	 public void clickRent() {
		 waitUntilWebElementIsVisible(Rent); 
		 Rent.click();
	 }
	 //to enter location
	 public void enterLocation()  {
		 waitUntilWebElementIsVisible(locationDropdown);  // Wait for the dropdown to be visible
		 locationDropdown.click(); 
		 locationValue.click(); 
		 }
	 public void selectLocality(String city) { 
		 waitUntilWebElementIsVisible(SearchLocality);  // Wait for the search locality input to be visible
		 SearchLocality.sendKeys(city);
		 waitUntilWebElementIsVisible(hinjawadiLocation);  
		 hinjawadiLocation.click();
	 }
	 
	 public void applyAvailabilityFilter() {
		 waitUntilWebElementIsVisible(bhkDropdown);
		 bhkDropdown.click();
		 bhk2Filter.click(); 
		 waitUntilWebElementIsVisible(availabilityFilter);  
		 availabilityFilter.click(); 
		 waitUntilWebElementIsVisible(availabilityFilterValue);  
		 availabilityFilterValue.click();  	 
	 }
	 public void clickSearchButton() {
		 waitUntilWebElementIsVisible(searchButton);  
		 searchButton.click();  
	 }
	 public void premiumFilter() {	
		 waitUntilWebElementIsVisible(PremiumFilter);  
		 PremiumFilter.click();  
		 Assert.assertTrue("Premium Filter is not displayed", PremiumFilter.isDisplayed()); 
	 }
	 
	 public void errorMessage() {
		 try {
		 		waitUntilWebElementIsVisible(alertMessageBox);
			 	Thread.sleep(1500);
				String errorMessage = alertMessageBox.getText().trim(); 
				System.out.println(errorMessage);
				String expectedMessage = "PLEASE SELECT A LOCALITY WITHIN BANGALORE";
				Assert.assertEquals("PLEASE SELECT A LOCALITY WITHIN BANGALORE", errorMessage , expectedMessage);
		 	} catch (Exception e) {
		 		e.printStackTrace();	
		 	}
	 }
}
