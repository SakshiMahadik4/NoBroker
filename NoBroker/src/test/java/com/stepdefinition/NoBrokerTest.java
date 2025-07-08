package com.stepdefinition;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.pages.HomePage;
import com.pages.LoanPage;
import com.pages.PropertyPage;
import com.parameters.ExcelReader;
import com.setup.BaseSetup;

import io.cucumber.datatable.DataTable;
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
		driver = BaseSetup.initializeDriver("chrome"); // or any other browser
		homePage = new HomePage(driver);
		proPage = new PropertyPage(driver);	
		loanPage = new LoanPage(driver);
		baseSetup = new BaseSetup();		
	}
	
	@Given("User is on the homepage")
	public void user_is_on_the_homepage() {
		System.out.println("User is on the homepage");
		driver.get("https://www.nobroker.in");
	  	
	}
	@When("User navigates to the Rent page")
	public void user_navigates_to_the_rent_page() {
		homePage.clickRent();
	}
	@When("enters a location from excel file")
	public void enters_a_location_from_excel_file(DataTable dataTable) throws InterruptedException {
		List<List<String>> data = dataTable.asLists(String.class);
        String fileName = data.get(0).get(0); // First row, first column = file name
 
        ExcelReader reader = new ExcelReader();
        String city = reader.readCityFromSheet(fileName, "CityData"); // Sheet name is hardcoded
        //tipsPag.enterCity(city);
		
		homePage.enterLocation();
	    homePage.selectLocality(city);
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
		homePage.clickRent();  // Navigate to the Rent page
	    // This step is to simulate leaving the locality field empty
	    // No action needed as we are not entering any location
	}

	@When("clicks on the search button")
	public void clicks_on_the_search_button() {
	    homePage.clickSearchButton();
	}

	@Then("System should display error message")
	public void system_should_display_error_message() throws InterruptedException {
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

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@When("User navigates to a property listing page")
	public void user_navigates_to_a_property_listing_page() throws InterruptedException {
		loanPage.propertyListing(); 
		// Navigate to the property listing page
	}
	@When("clicks on Apply Loan")
	public void clicks_on_apply_loan() throws InterruptedException {
		loanPage.clickApplyLoan();
	    loanPage.enterMobileNumber("8630781175");
	  
	}
	@When("fills the loan form with valid data from {int} and row {int}")
	public void fills_the_loan_form_with_valid_data_from_and_row(Integer int1, Integer int2) throws InterruptedException {
		ExcelReader reader = new ExcelReader();
	    Map<String, String> data = reader.getRowData(int1.intValue(), int2.intValue());
 
	    String amount = data.get("amount");
		loanPage.fillLoanFormWithValidData(amount);	 
	}
	@When("submits the form")
	public void submits_the_form() {
	   loanPage.submitForm();
	}
	@Then("A pop-up confirming eligibility should be displayed")
	public void a_pop_up_confirming_eligibility_should_be_displayed() {
	   loanPage.verifyLoanSuccessPopup();
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@When("User navigates to a property Listing page")
	public void user_navigates_to_a_property_Listing_page() {
	    loanPage.propertyListing();
	}	
	@When("scrolls down in a property card")
	public void scrolls_down_in_a_property_card() {		
		loanPage.scrollDownInProperty(1);
	}
	@Then("Property description should be visible with detailed information")
	public void property_description_should_be_visible_with_detailed_information() {
		//loanPage.propertyDescription();
	}
}
