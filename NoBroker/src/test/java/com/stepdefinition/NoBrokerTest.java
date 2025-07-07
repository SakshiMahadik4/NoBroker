package com.stepdefinition;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import com.pages.HomePage;
import com.pages.LoanPage;
import com.pages.PropertyPage;
import com.setup.BaseSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NoBrokerTest {
	// This class is used to define the step definitions for the NoBroker feature file.
	WebDriver driver;
	HomePage homePage;
	PropertyPage proPage;
	LoanPage loanPage;
	BaseSetup baseSetup;
	
	public NoBrokerTest() {
		// Initialize the driver and page objects here
		String browser = System.getProperty("browser", "chrome"); // Default to Chrome if not specified
		driver = BaseSetup.initializeDriver("edge"); // or any other browser
		homePage = new HomePage(driver);
		proPage = new PropertyPage(driver);	
		loanPage = new LoanPage(driver);
		baseSetup = new BaseSetup();		
	}
	
	@Given("User is on the homepage")
	public void user_is_on_the_homepage() {
	  	
	}
	@When("User navigates to the Rent page")
	public void user_navigates_to_the_rent_page() {
		homePage.clickRent();
	}
	@When("enters a location")
	public void enters_a_location() throws InterruptedException {
	    homePage.enterLocation();
	    homePage.selectLocality();
	}
	@When("apply all filters given below")
	public void apply_all_filters_given_below() {
		homePage.applyAvailabilityFilter();
			    
	}
	@Then("Relevant rental listings should be displayed")
	public void relevant_rental_listings_should_be_displayed() {
	    homePage.clickSearchButton();
	    homePage.premiumFilter();
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@When("leaves the locality field empty")
	public void leaves_the_locality_field_empty() {
	    // This step is to simulate leaving the locality field empty
	    // No action needed as we are not entering any location
	}

	@When("clicks on the search button")
	public void clicks_on_the_search_button() {
	    homePage.clickSearchButton();
	}

	@Then("System should display error message")
	public void system_should_display_error_message() {
		homePage.errorMessage();
	}
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
	@When("User navigates to the Rental Properties page")
	public void user_navigates_to_the_rental_properties_page() throws AWTException, InterruptedException {
		proPage.RentalPage();  // Navigate to the Rental Properties page
		proPage.enterLocation();  // Enter the location in the search field
		proPage.clickSearchButton(); 
		
	}
	
	@When("applies filters BHK and price")
	public void applies_filters_bhk_and_price() {
		proPage.applyFilters();
		
	}
	@Then("Message should be displayed")
	public void message_should_be_displayed() {
		proPage.errorMessage();  // Call the method to display the error message
		System.out.println("No results found for the applied filters.");
		driver.quit();  // Close the browser after the test

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@When("User navigates to a property listing page")
	public void user_navigates_to_a_property_listing_page() throws InterruptedException {
		loanPage.propertyListing(); 
		// Navigate to the property listing page
	}
	@When("clicks on Apply Loan")
	public void clicks_on_apply_loan() {
	    
	}
	@When("fills the loan form with valid data")
	public void fills_the_loan_form_with_valid_data() {
	
	}
	@When("submits the form")
	public void submits_the_form() {
	   
	}
	@Then("A pop-up confirming eligibility should be displayed")
	public void a_pop_up_confirming_eligibility_should_be_displayed() {
	   
	}

}
