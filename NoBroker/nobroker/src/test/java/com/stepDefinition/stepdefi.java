package com.stepDefinition;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;

import com.pages.CommercialPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.*;

public class stepdefi {

    WebDriver driver;
    CommercialPage commercialPage;

    @Given("the user is on the NoBroker website homepage")
    public void the_user_is_on_the_nobroker_homepage() {
        driver = BaseSteps.initializeDriver("chrome");
        commercialPage = new CommercialPage(driver);
    }
/*
    @When("the user clicks on the {string} tab")
    public void the_user_clicks_on_tab(String tabName) {
        if (tabName.equalsIgnoreCase("Commercial")) {
            commercialPage.clickCommercialTab();
        }
    }

    @Then("the user should be navigated to the commercial properties section")
    public void user_should_be_on_commercial_section() {
        Assert.assertTrue("Navigation failed: Not on commercial page",
                commercialPage.isOnCommercialPage());
    }

    @When("the user enters {string} in the location field")
    public void the_user_enters_location(String location) {
        commercialPage.enterSearchLocation(location);
    }

    @When("the user clicks the search button")
    public void the_user_clicks_search() {
        commercialPage.clickSearchButton();
    }

    @Then("the user should see search results for {string}")
    public void the_user_should_see_search_results(String expectedLocation) {
        Assert.assertTrue("Search URL does not reflect location",
                driver.getCurrentUrl().toLowerCase().contains(expectedLocation.toLowerCase()));
    }
*/
 

    @When("the user clicks on the {string} tab")
    public void the_user_clicks_on_tab(String tabName) {
        if (tabName.equalsIgnoreCase("Commercial")) {
            commercialPage.clickCommercialTab();
        }
    }

    @And("the user switches city to Pune from the dropdown")
    public void switchCityToPune() {
        commercialPage.searchCommercialPropertyInHinjewadi() ;
    }

    @And("the user enters {string} in the location field")
    public void the_user_enters_location(String location) {
        commercialPage.enterSearchLocation(location);
    }

    @And("the user clicks the search button")
    public void the_user_clicks_search() {
        commercialPage.clickSearchButton();
    }

    @Then("the user should see search results for {string}")
    public void the_user_should_see_search_results(String expectedLocation) {
        Assert.assertTrue("Search did not redirect to expected location → " + expectedLocation,
                commercialPage.isSearchRedirected(expectedLocation));
        BaseSteps.quitDriver();
    }

}