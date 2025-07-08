package com.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.BasePage;
import com.pages.PropertyListingPage;
import com.pages.FiltersPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile {

    WebDriver driver;
    BasePage basepage;
    FiltersPage filterpage;
    PropertyListingPage listingpage;

    // ---------------- Scenario 1 ----------------
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
        Assert.assertTrue("No property listings are displayed!", basepage.isListingVisible());
    }

    // --------------------------- Scenario 2 ------------------------------------------------------------------------------
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
        Assert.assertTrue("Filtered listings not found!", filterpage.isFilteredListingVisible());
    }

    // ---------------- Scenario 3 ------------------------------------------------------------------------------------

    
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
        listingpage.clickGetOwnerDetails(0);
    }
    @Then("the owners contact information should be displayed")
    public void the_owners_contact_information_should_be_displayed() {
    	Assert.assertTrue("Mobile field is not displayed", listingpage.isLoginFieldDisplayed());
    }

    //------------------------------Scenario 4-----------------------------------------------------------------------------

    
    @Given("the user is logged in and viewing a property listing page")
    public void the_user_is_logged_in_and_viewing_a_property_listing_page() {
    	driver = BaseSteps.chromedriver();  
    	listingpage = new FiltersPage(driver);
        listingpage.contactLoadUrl();
    }
    @When("the user clicks the Wishlist button")
    public void the_user_clicks_the_wishlist_button() {
    	listingpage.scrollToListings();
    	listingpage.wishlistButton(0);
    	listingpage.login();
    	
    }
    @When("the user opens the wishlist page")
    public void the_user_opens_the_wishlist_page() {
    	listingpage.wishlistBag();
    }
    @Then("the property should be listed in the users wishlist")
    public void the_property_should_be_listed_in_the_users_wishlist() {
        Assert.assertTrue("Property was not added to wishlist", listingpage.isWishlistConfirmed());
    }

}


