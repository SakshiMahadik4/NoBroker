package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PropertyPage extends BasePage{
	
	@FindBy(xpath = "//div[@class='cursor-pointer text-primary-color border-0 border-b-4 border-solid border-primary-color font-bold']")
	WebElement Rent;

	@FindBy(xpath = "//div[@class='css-1hwfws3 nb-select__value-container nb-select__value-container--has-value']")
	WebElement locationDropdown;

	@FindBy(xpath = "//div[contains(text(),'Pune')]")
	WebElement locationValue;
	
	@FindBy(xpath = "//input[@id='listPageSearchLocality']")
	WebElement SearchLocality;
	
	@FindBy(xpath ="//button[@class='prop-search-button flex items-center justify-center btn btn-primary btn-lg']")
	WebElement searchButton;
	
	@FindBy(xpath = "//div[@value = 'BHK4PLUS']")
	WebElement bhk4PlusFilter;
	
	@FindBy(xpath = "//div[@class='rc-slider-handle rc-slider-handle-2']")
	WebElement rightHandle;

	@FindBy(xpath = "//div[@class='rc-slider-handle rc-slider-handle-1']")
	WebElement leftHandle;
	
	@FindBy(className = "nb__2n4T5")
	WebElement noResultsMessage;
		
	Actions actions;
	
		public PropertyPage(WebDriver driver) {
		super(driver);  // Calling BasePage constructor
	}
		
		// Add methods specific to the PropertyPage here
		public void RentalPage() {
			 Rent.click(); 
			 waitUntilWebElementIsVisible(locationDropdown); 
			 locationDropdown.click(); 
			 locationValue.click();
		}
		public void enterLocation() {
			try {
				waitUntilWebElementIsVisible(SearchLocality);  // Wait for the search locality input to be visible
				SearchLocality.sendKeys("Hinjawadi");  // Enter the location in the search input
				Thread.sleep(2000);  
				SearchLocality.sendKeys(Keys.ARROW_DOWN);  // Navigate through suggestions
				SearchLocality.sendKeys(Keys.ENTER); // Wait for suggestions to load
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		public void clickSearchButton() {
			 waitUntilWebElementIsVisible(searchButton);  // Wait for the search button to be visible
			 searchButton.click();  
			
		 }
		
		public void applyFilters() {
			waitUntilWebElementIsVisible(bhk4PlusFilter);  // Wait for the filter to be visible
			bhk4PlusFilter.click();  // Click on the BHK4PLUS filter
	        //  Drag left handle slightly right 
			Actions actions = new Actions(driver);
	        actions.clickAndHold(leftHandle).moveByOffset(80, 0).release().perform();
	 
	        //  Drag right handle slightly left
	        actions.clickAndHold(rightHandle).moveByOffset(-180, 0).release().perform();	
        
		}
		public void errorMessage() {
			waitUntilWebElementIsVisible(noResultsMessage);  // Wait for the no results message to be visible
			String errorText = noResultsMessage.getText(); 
			String expectedMessage = "Didn't find what you are looking for?";
			Assert.assertEquals("Didn't find what you are looking for?", errorText , expectedMessage);
		}

}
