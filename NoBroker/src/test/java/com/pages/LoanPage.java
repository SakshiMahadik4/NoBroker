package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoanPage extends BasePage{
	
	//@FindBy(xpath = "//h2[@class='flex items-center m-0 heading-6 font-semi-bold']")
	//@FindBy(xpath = "//section[@style='background: rgb(248, 248, 248);']")
	@FindBy(xpath = "//article[@id=\"article_0\"]/child::div/child::div/child::section")
	//@FindBy(xpath = "//div[@value = 'BHK4PLUS']")
	WebElement propertyPage;
	
	@FindBy(xpath = "//input[@id='listPageSearchLocality']")
	WebElement SearchLocality;
	

	@FindBy(xpath = "//div[@class='cursor-pointer text-primary-color border-0 border-b-4 border-solid border-primary-color font-bold']")
	WebElement Rent;

	@FindBy(xpath = "//div[@class='css-1hwfws3 nb-select__value-container nb-select__value-container--has-value']")
	WebElement locationDropdown;

	@FindBy(xpath = "//div[contains(text(),'Pune')]")
	WebElement locationValue;
	
	PropertyPage property;
	Actions actions;
	
	
	public LoanPage(WebDriver driver) {
		super(driver); // Calling BasePage constructor
	}
	
	public void propertyListing() {
		property = new PropertyPage(driver);
		property.RentalPage();
		property.enterLocation();
		property.clickSearchButton();
		waitUntilWebElementIsVisible(propertyPage);
		propertyPage.click();
	}
	
}
