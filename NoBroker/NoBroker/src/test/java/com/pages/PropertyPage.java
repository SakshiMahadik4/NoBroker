package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class PropertyPage extends BasePage{
	
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
		public void applyFilters() {
			waitUntilWebElementIsVisible(bhk4PlusFilter); 
			bhk4PlusFilter.click(); 
	       
			//  Drag left handle slightly right 
			actions = new Actions(driver);
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
		 public void reloadPage() {
		        driver.navigate().refresh();
		    }
}
