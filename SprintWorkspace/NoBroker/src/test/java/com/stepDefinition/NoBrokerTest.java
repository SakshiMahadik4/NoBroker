package com.stepDefinition;

import java.io.IOException;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.pages.CleaningservicePage;
import com.pages.HomePage;
import com.pages.PaintingServicePage;
import com.pages.PostPropertyPage;
import com.pages.SalesAgreementPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class NoBrokerTest {
	WebDriver driver;
	HomePage home;
	PaintingServicePage PaintingService;
	SalesAgreementPage SalesAgreement;
	CleaningservicePage Cleaningservice;
	PostPropertyPage PostProperty;
	ExcelReader excel;

	// ---------------------------------Seanario 1------------------------------------------------------------
	/*
	 * Created by:Pranali Chougule
	 * Reviewed by:Priti Wadpalli 
	 * Motive:To validate search funcionality
	 *  /
	 */
	@Given("The user is on home services page")
	public void the_user_is_on_home_services_page() {
	   driver=BaseSteps.chromedriver();
	}

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
	public void user_should_see_relevant_services_for_my_data() throws IOException {
		Assert.assertTrue(driver.getTitle().equals("Get Expert Professional Home Services Upto 50% OFF - NoBroker"));
	}

	// ------------------------------------Seanario 2----------------------------------------------------------
	/*
	 * Created by:Pranali Chougule 
	 * Reviewed by:Priti Wadpalli
	 * Motive: Validate city dropdown visibility and selection
	 *  /
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
	public void user_should_see_services_available_in_that_city() throws IOException {
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.nobroker.in/home-services-in-mumbai?nbFr=Home_page"));
	}

	// ---------------------------------Seanario 3------------------------------------------------------------
		/*
		 * Created by:Pranali Chougule
		 * Reviewed by:Priti Wadpalli 
		 * Motive:Validate that the user can request an estimate for a selected painting service
		 *  /
		 */
	@Given("the user is on the home services page")
	public void the_user_is_on_the_home_services_page() {
		driver = BaseSteps.chromedriver();
	}
	@When("the user clicks on the Painting Services option")
	public void the_user_clicks_on_the_painting_services_option() {
		PaintingService = new PaintingServicePage(driver);
		PaintingService.ClickPaintingService();
	}
	@When("the user clicks on the painting services list")
	public void the_user_clicks_on_the_painting_services_list() {
		PaintingService.SeeAllService();
	}
	@When("the user requests an estimate for the selected painting service")
	public void the_user_requests_an_estimate_for_the_selected_painting_service() {
		PaintingService.GetEstimate();
	}
	@When("user logged in")
	public void user_logged_in() {
		PaintingService.userlogin();
	}
	@Then("the user should be navigated to the confirm loaction page")
	public void the_user_should_be_navigated_to_the_confirm_loaction_page() {
		Assert.assertTrue(driver.getTitle().equals("Get Expert Professional Home Services Upto 50% OFF - NoBroker"));
	}

	// ---------------------------------Seanario 4------------------------------------------------------------
			/*
			 * Created by:Pranali Chougule
			 * Reviewed by:Priti Wadpalli 
			 * Motive:Validate the corporate form
			 *  /
			 */
	@Given("User is on services page")
	public void user_is_on_services_page() {
		driver = BaseSteps.chromedriver();
	}
	@When("the user clicks sales agreement option")
	public void the_user_clicks_sales_agreement_option() {
		SalesAgreement = new SalesAgreementPage(driver);
		SalesAgreement.clickSalesAgreement();
	}
	@When("the user clicks menu and selects corporate enquiry")
	public void the_user_clicks_menu_and_selects_corporate_enquiry() throws InterruptedException {
		SalesAgreement.clickMenuAndselectCorporatEnquiry();
	}
	@When("the user clicks know more button")
	public void the_user_clicks_know_more_button() {
		SalesAgreement.clickKnowMore();
	}
	@When("the user fills the form with {string}")
	public void the_user_fills_the_form_with(String rowIndexStr) {
	    int rowIndex=Integer.parseInt(rowIndexStr);
	    String name=ExcelReader.getCred("Sheet1", rowIndex, 0);
	    String company=ExcelReader.getCred("Sheet1", rowIndex, 1);
	    String email=ExcelReader.getCred("Sheet1", rowIndex, 2);
	    String phone=ExcelReader.getCred("Sheet1", rowIndex, 3);
	    String city=ExcelReader.getCred("Sheet1", rowIndex, 4);
	    String  employees=ExcelReader.getCred("Sheet1", rowIndex, 5);
	    
		SalesAgreement.fillForm(name,company,email, phone, city, employees);
	}
	@When("user submit the form")
	public void user_submit_the_form() throws InterruptedException {
		SalesAgreement.clickConnect();
	}
	@Then("Form should be submittted successfully")
	public void form_should_be_submittted_successfully() {
	   Assert.assertTrue(driver.getCurrentUrl().equals("https://www.nobroker.in/prophub/corporate-partnership/comprehensive-corporate-solutions/?isHybrid=false"));
		//Assert.assertEquals(driver.getCurrentUrl(), driver.getCurrentUrl().contains("https://www.nobroker.in/prophub"));
	}
	
	// ---------------------------------Seanario 5------------------------------------------------------------
				/*
				 * Created by:Pranali Chougule
				 * Reviewed by:Priti Wadpalli
				 * Motive: Validate the post property form with invalid data
				 *  /
				 */
	@When("the user clicks on the Book option")
	public void the_user_clicks_on_the_book_option() {
		Cleaningservice=new CleaningservicePage(driver);
		Cleaningservice.clickBook();
	}
	@When("the user adds the cleaning service to the cart")
	public void the_user_adds_the_cleaning_service_to_the_cart() {
		Cleaningservice.addToCart();;
	}
	@When("the user logged in")
	public void the_user_logged_in() {
		Cleaningservice.userLogin();
	}
	@When("the user proceeds to checkout")
	public void the_user_proceeds_to_checkout() {
		Cleaningservice.clickProceed();
	}
	@Then("it should be navigated to schedule to your service page")
	public void it_should_be_navigated_to_schedule_to_your_service_page() {
		Assert.assertTrue(Cleaningservice.assertSchedulepage());
	}

	
	// ---------------------------------Seanario 6------------------------------------------------------------
	/*
	 * Created by:Pranali Chougule
	 * Reviewed by:Priti Wadpalli
	 * Motive:Validate the cleaning services checkout process
	 *  /
	 */
	
	@When("the user clicks Rental Agreement option")
	public void the_user_clicks_rental_agreement_option() {
		PostProperty=new PostPropertyPage(driver);
		PostProperty.clickRentalAgreement();
	}
	@When("the user clicks menu and selects post your property")
	public void the_user_clicks_menu_and_selects_post_your_property() {
		PostProperty.clickMenuAndselectpostproperty();
	}
	@When("the user fills form")
	public void the_user_fills_form(io.cucumber.datatable.DataTable dataTable) throws IOException {
		excel=new ExcelReader();
		List<String> list=dataTable.asList(String.class);
		String cred[]=excel.propertyFormReader(list.get(0));
		PostProperty.propertyFormData(cred[0], cred[1]);
	}
	@When("the user clicks on start posting")
	public void the_user_clicks_on_start_posting() {
	   PostProperty.startPosting();
	}
	
	@Then("it should be displayed error message")
	public void it_should_be_displayed_error_message() {
		Assert.assertTrue(PostProperty.diplayError());
	}

	@After
	public void tearDown(Scenario scenario) // will take screenshots for each and every scenario
	{
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		 scenario.attach(screenshot, "image/png", "Image");
	}
	
}
