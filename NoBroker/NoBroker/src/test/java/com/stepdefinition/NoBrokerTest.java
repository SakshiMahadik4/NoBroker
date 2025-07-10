package com.stepdefinition;

import java.awt.AWTException;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.pages.HomePage;
import com.pages.LoanPage;
import com.pages.PropertyPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NoBrokerTest {
	WebDriver driver;
	HomePage homePage;
	PropertyPage proPage;
	LoanPage loanPage;
	BaseSteps baseSetup;
	ExcelReader excelReader;
	Properties pro;
	public NoBrokerTest() {
		// Initialize the driver and page objects here
		String browser = System.getProperty("browser", "chrome"); // Default to Chrome if not specified
		driver = BaseSteps.initializeDriver(browser); // Initialize the driver using BaseSteps
		homePage = new HomePage(driver);
		proPage = new PropertyPage(driver);	
		loanPage = new LoanPage(driver);
		excelReader = new ExcelReader();
		baseSetup = new BaseSteps();		
	}
	
	@Given("User is on the homepage")
	public void user_is_on_the_homepage() throws InterruptedException {
		driver.get("https://www.nobroker.in");
	}
	
	//--------------------------------------**location-filters**---------------------------------------------------------//
	
	@When("User navigates to the Rent page")
	public void user_navigates_to_the_rent_page() {
		homePage.clickRent();
	}
	@When("enters a location from excel file")
	public void enters_a_location_from_excel_file(DataTable dataTable) throws InterruptedException {
		String city = ExcelReader.getCityFromDataTable(dataTable);
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
	
	//--------------------------------------**validation**---------------------------------------------------------//
	
	@When("leaves the locality field empty")
	public void leaves_the_locality_field_empty() {
		homePage.clickRent();
	}

	@When("clicks on the search button")
	public void clicks_on_the_search_button() {
	    homePage.clickSearchButton();
	}

	@Then("System should display error message")
	public void system_should_display_error_message() throws InterruptedException {
		homePage.errorMessage();
	}
	
	//--------------------------------------**no-results**---------------------------------------------------------//
	
	@When("User navigates to the Rental Properties page")
	public void user_navigates_to_the_rental_properties_page(DataTable dataTable) throws AWTException, InterruptedException {
		homePage.clickRent();  // Navigate to the Rent page
		homePage.enterLocation();
		String city = ExcelReader.getCityFromDataTable(dataTable);
		homePage.selectLocality(city);
		homePage.clickSearchButton(); 	
	}
	
	@When("applies filters BHK and price")
	public void applies_filters_bhk_and_price() {
		proPage.applyFilters();
		
	}
	@Then("Message should be displayed")
	public void message_should_be_displayed() {
		proPage.errorMessage();  // Call the method to display the error message
	}

	//--------------------------------------**loan**---------------------------------------------------------//
	
	@When("User navigates to a property listing page")
	public void user_navigates_to_a_property_listing_page(DataTable dataTable ) throws InterruptedException {
		homePage.clickRent();  // Navigate to the Rent page
		homePage.enterLocation();
		String city = ExcelReader.getCityFromDataTable(dataTable);
		homePage.selectLocality(city);
		homePage.clickSearchButton(); 
		loanPage.propertyListing(); 
	}
	@When("clicks on Apply Loan")
	public void clicks_on_apply_loan() throws InterruptedException {
		loanPage.clickApplyLoan();
	    loanPage.enterMobileNumber();
	  
	}
	@When("fills the loan form with valid data from {int} and row {int}")
	public void fills_the_loan_form_with_valid_data_from_and_row(Integer int1, Integer int2) throws InterruptedException {
		ExcelReader reader = new ExcelReader();
	    Map<String, String> data = reader.getRowData(int1.intValue(), int2.intValue());
 
	    String amount = data.get("amount");
		loanPage.fillForm(amount);
	    //loanPage.fillLoanFormWithValidData(amount);	 
	}
	@When("submits the form")
	public void submits_the_form() {
	   loanPage.submitForm();
	}
	@Then("A pop-up confirming eligibility should be displayed")
	public void a_pop_up_confirming_eligibility_should_be_displayed() {
	   loanPage.verifyLoanSuccessPopup();
	}
	
	//--------------------------------------**description**---------------------------------------------------------//
	
	@When("User navigates to a property Listing page")
	public void user_navigates_to_a_property_Listing_page(DataTable dataTable) throws InterruptedException {
		homePage.clickRent();  // Navigate to the Rent page
		homePage.enterLocation();
		String city = ExcelReader.getCityFromDataTable(dataTable);
		homePage.selectLocality(city);
		homePage.clickSearchButton(); 
		loanPage.propertyListing();
	}	
	@When("scrolls down in a property card")
	public void scrolls_down_in_a_property_card() throws InterruptedException {		
		loanPage.scrollDown();
	}
	@Then("Property description should be visible with detailed information")
	public void property_description_should_be_visible_with_detailed_information() throws InterruptedException {
		loanPage.propertyDescription();
	}
	
	//--------------------------------------**loan-apply**---------------------------------------------------------//
	
	@When("User navigates to property listing page")
	public void user_navigates_to_property_listing_page(DataTable dataTable) throws InterruptedException {
		homePage.clickRent();  // Navigate to the Rent page
		homePage.enterLocation();
		String city = ExcelReader.getCityFromDataTable(dataTable);
		homePage.selectLocality(city);
		homePage.clickSearchButton(); 
		loanPage.propertyListing();
	   	loanPage.clickApplyLoan();
	   	loanPage.enterMobileNumber();
	}
	@When("submits the loan form with incomplete or invalid inputs")
	public void submits_the_loan_form_with_incomplete_or_invalid_inputs() {
		loanPage.clickSearchButtonError();
		loanPage.submitForm();
	   
	}
	@Then("An error message should be displayed")
	public void an_error_message_should_be_displayed() {
	   loanPage.errorMessageCity();
	   loanPage.errorMessageAmount();
	   loanPage.errorMessageIncome();
	}
	@After
	public void closeDriver(Scenario scenario) // will take screenshots for each and every scenario
	{
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		 scenario.attach(screenshot, "image/png", "Image");
		 BaseSteps.tearDown(); // Close the driver after each scenario
	}
}
