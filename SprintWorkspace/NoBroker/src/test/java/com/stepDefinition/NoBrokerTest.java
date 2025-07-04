package com.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.HomePage;
import com.setup.BaseSteps;

import io.cucumber.java.en.*;

public class NoBrokerTest {
	WebDriver driver;
	HomePage home;

	// ---------------------------------Seanario 1------------------------------------------------------------
	/*
	 * Created by: Reviewed by: Motive: /
	 */
//	@Given("user is on home services page")
//	public void user_is_on_home_services_page() {
//		driver = BaseSteps.chromedriver();
//	}
	@When("user click the search button")
	public void user_click_the_search_button() {
		home = new HomePage(driver);
		home.clickSearch();
	}

	@When("user enter data in the search bar")
	public void user_enter_data_in_the_search_bar() {
		home.enterData();

	}

	@Then("user should see relevant services for my data")
	public void user_should_see_relevant_services_for_my_data() {
		Assert.assertTrue(driver.getTitle().equals("Get Expert Professional Home Services Upto 50% OFF - NoBroker"));
	}

	// ------------------------------------Seanario 2----------------------------------------------------------
	/*
	 * Created by: Reviewed by: Motive: /
	 */

	@Given("user is on home Services page")
	public void user_is_on_home_services_page() {
		driver = BaseSteps.chromedriver();
	}

	@When("user click on the city dropdown")
	public void user_click_on_the_city_dropdown() {
		home = new HomePage(driver);
		home.clickCity();
	}

	@When("user select the city")
	public void user_select_the_city() {
		home.displayCity();
	}

	@Then("user should see services available in that city")
	public void user_should_see_services_available_in_that_city() {
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.nobroker.in/home-services-in-mumbai?nbFr=Home_page"));
	}

}
