package com.stepDefinition;

import java.awt.AWTException;


import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.pages.BasePage;
import com.pages.PropertyListingPage;
import com.parameters.ExcelReader;
import com.pages.FiltersPage;
import com.pages.HomePage;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuyTest {

    WebDriver driver;
    BasePage basepage;
    FiltersPage filterpage;
    PropertyListingPage listingpage;
    HomePage homepage;

    // ---------------- Scenario 1 ----------------
    /*created by:Jhalak Maheshwari
     * Reviewed by:
     * Motive:Verify property search by valid city, locality, BHK type, and property status
     */
    
    
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

    @When("user searches for locality in selected city from excel with {string}")
    public void user_searches_for_locality_in_selected_city_from_excel_with(String rowIndexStr) {
    	basepage.selectLocalityBox();
    	int rowIndex=Integer.parseInt(rowIndexStr);
    	String locality=ExcelReader.locality("Sheet1", rowIndex, 0);
        basepage.enterLocality(locality);
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
        basepage.isListingVisible();
    }

    // --------------------------- Scenario 2 ------------------------------------------------------------------------------
    /*created by:Jhalak Maheshwari
     * Reviewed by:
     * Motive:Verify filters like price, property type, furnishing, and parking work correctly
     */
    
    @Given("the user is on the Buy page and viewing listings")
    public void the_user_is_on_the_buy_page_and_viewing_listings() {
        driver = BaseSteps.chromedriver();  
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
        filterpage.isListingVisible();
    }

    // ---------------- Scenario 3 ------------------------------------------------------------------------------------
    /*created by:Jhalak Maheshwari
     * Reviewed by:
     * Motive:Verify user can contact owner using Get Owner Details button
     */
    
    @Given("the user is logged in and viewing a property listing")
    public void the_user_is_logged_in_and_viewing_a_property_listing() {
    	driver = BaseSteps.chromedriver();  
        listingpage = new PropertyListingPage(driver);
        listingpage.contactLoadUrl();
        listingpage.login();
    	//listingpage.handlePopup();
    }
    @When("the user clicks the Get Owner Details button")
    public void the_user_clicks_the_get_owner_details_button() {
    	listingpage.scrollToListings();
        listingpage.clickGetOwnerDetails(1);
    }
    @Then("the owners contact information should be displayed")
    public void the_owners_contact_information_should_be_displayed() {
    	listingpage.ownerDetailsSent();
    }

    //------------------------------Scenario 4-----------------------------------------------------------------------------
    /*created by:Jhalak Maheshwari
     * Reviewed by:
     * Motive:Verify user can wishlist a property
     */
    
    @Given("the user is logged in and viewing a property listing page")
    public void the_user_is_logged_in_and_viewing_a_property_listing_page() {
    	driver = BaseSteps.chromedriver();  
    	listingpage = new PropertyListingPage(driver);
        listingpage.contactLoadUrl();
    }
    @When("the user clicks the Wishlist button")
    public void the_user_clicks_the_wishlist_button() {
    	listingpage.scrollToListings();
    	listingpage.login();
    	listingpage.wishlistButton();
    	
    }
    @When("the user opens the wishlist page")
    public void the_user_opens_the_wishlist_page() {
    	listingpage.wishlistBag();
    }
    @Then("the property should be listed in the users wishlist")
    public void the_property_should_be_listed_in_the_users_wishlist() {
        listingpage.isWishlistConfirmed();
    }


    
    //--------------------Scenario 5----------------------------------------------------------------------------------
    /*created by:Jhalak Maheshwari
     * Reviewed by:
     * Motive:Validate response for invalid locality search
     */
    @Given("the user is on the NoBroker Buy page")
    public void the_user_is_on_the_no_broker_buy_page() {
    	driver = BaseSteps.chromedriver();
        homepage = new HomePage(driver);
        homepage.goToBuyPage();
    }
    @When("the user selects a valid city")
    public void the_user_selects_a_valid_city() {
    	homepage.goToBuyPage();
    }
    @When("the user enters invalid locality")
    public void the_user_enters_invalid_locality() throws AWTException {
    	homepage.enterLocality();
    }
    @When("clicks the search button")
    public void clicks_the_search_button() {
    	homepage.clickSearch();
    }
    @Then("the system should display an appropriate message Please select a locality within pune")
    public void the_system_should_display_an_appropriate_message_please_select_a_locality_within_pune() {
    	homepage.invalidData();
    }
    @AfterStep
	public void tearDown(Scenario scenario) // will take screenshots for each and every scenario
	{
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "Image");
		
	}

}


