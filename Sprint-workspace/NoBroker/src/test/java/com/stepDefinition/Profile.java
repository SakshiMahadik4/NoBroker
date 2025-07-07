package com.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.BasePage;
import com.pages.ContactOwnerPage;
import com.pages.FiltersPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile  {
	
	WebDriver driver;
	BasePage basepage;
	FiltersPage filterpage;
	ContactOwnerPage ownerpage;
	
	
	
///----------------scenario1
	@Given("the user is on the Buy page")
	public void the_user_is_on_the_buy_page() {
		driver = BaseSteps.chromedriver();
		basepage = new BasePage(driver);
		basepage.goToBuyPage();
	}
	@When("the user searches for properties with a valid city")
	public void the_user_searches_for_properties_with_a_valid_city() {
		basepage.selectCity();

	}
	@When("user searches for locality in selected city")
	public void user_searches_for_locality_in_selected_city() {
		basepage.enterLocality("Hinjewadi");

	}
	@When("the user applies BHK type")
	public void the_user_applies_bhk_type() {
		basepage.selectBHK(4);
	}
	@When("the user applies property status filter")
	public void the_user_applies_property_status_filter() {
		basepage.applyPropertyStatus();
		basepage.clickSearch();

	}
	@Then("matching property listings should be displayed")
	public void matching_property_listings_should_be_displayed() {
	    boolean listingsPresent = basepage.isListingVisible();
	    Assert.assertTrue("No property listings are displayed!", listingsPresent);
	}
	
	//---------------------------------------Scenario 2----------------------------------------------------------------------
	
	@Given("the user is on the Buy page and viewing listings")
	public void the_user_is_on_the_buy_page_and_viewing_listings() {
		//driver = BaseSteps.chromedriver();
		filterpage = new FiltersPage(driver);
		filterpage.loadUrl();
		
	}
	@When("the user applies filters for a price filter")
	public void the_user_applies_filters_for_a_price_filter() {
		filterpage.applyPriceFilter();
	}
	@When("the user applies Property type filter")
	public void the_user_applies_property_type_filter() {
		filterpage.applyFurnishingFilter();
	}
	@When("the user applies Furnishing filter")
	public void the_user_applies_furnishing_filter() {
		filterpage.applyPropertyTypeFilter();
	}
	@When("the user applies Parking filter")
	public void the_user_applies_parking_filter() {
		filterpage.applyParkingFilter();
	}
	@Then("the listings should update to reflect the applied filters")
	public void the_listings_should_update_to_reflect_the_applied_filters() {
		boolean isFiltered = filterpage.isFilteredListingVisible();
	    Assert.assertTrue("No property listings are displayed!", isFiltered);
	}
	
	//------------------------------Scenario 3-----------------------------------------------------------------
	
	@Given("user is on Nobroker Webpage")
	public void user_is_on_nobroker_webpage() {
		ownerpage = new ContactOwnerPage(driver);
	}
	@Given("the user is logged in and viewing a property listing")
	public void the_user_is_logged_in_and_viewing_a_property_listing() {
	    ownerpage.handlePopup();
	    ownerpage.scrollToListings(2);
	    
	}
	@When("the user clicks the Get owner details button")
	public void the_user_clicks_the_button() {
		ownerpage.clickGetOwnerDetails();

	}
	@When("the login Page will be display enter details")
	public void the_login_page_will_be_display_enter_details() {
	    ownerpage.login();
	}
	@Then("the owner's contact information should be displayed")
	public void the_owner_s_contact_information_should_be_displayed() {
	    Assert.assertTrue("Mobile field is not displayed",ownerpage.isLoginFieldDisplayed());
	}









}


