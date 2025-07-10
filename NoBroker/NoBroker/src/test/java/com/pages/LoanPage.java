package com.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.parameters.ConfigReader;

public class LoanPage extends BasePage{
	
	@FindBy(xpath = "//h2[@class='flex items-center m-0 heading-6 font-semi-bold']")
	WebElement propertyPage;
	
	@FindBy(xpath = "//div[@class='nb__2bdjR']")
	WebElement ApplyLoan;
	
	@FindBy(xpath = "//input[@placeholder='Enter Mobile Number']")
	WebElement mobileNumberInput;
	
	@FindBy(xpath = "//button[@id='signUpSubmit']")
	WebElement signUpSubmitButton;
	
	@FindBy(xpath = "//div[text()=\"Pune\"]")
	WebElement SelectCity;
	
	@FindBy(xpath = "//div[text()=\"30,000 - 50,000\"]")
	WebElement SelectIncome;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButtonError;
	
	@FindBy(xpath = "//div[@id='applyLoanForm-city-nbInput']")
	WebElement SelectCityDropdown;
	
	@FindBy(xpath = "//div[@id='applyLoanForm-income-nbInput']")
	WebElement SelectIncomeDropdown;
	
	@FindBy(xpath = "//*[@id=\"applyLoanForm-city-nbInput-container\"]/div/div[2]")
	WebElement SelectCityError;
	
	@FindBy(xpath = "//input[@placeholder = 'Enter Loan Ammount']")
	WebElement EnterLoanAmount;
	
	@FindBy(xpath = "//*[@id=\"applyLoanForm-loanAmount-nbInput-container\"]/div/div")
	WebElement EnterLoanError;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//*[@id=\"applyLoanForm-income-nbInput-container\"]/div/div[2]")
	WebElement SelectIncomeError;
	
	@FindBy(xpath = "//*[@id=\"alertMessageBox\"]/div")
	WebElement loanSuccessMessage;
	
	@FindBy(xpath = "//div[@class='nb__TSdqt']/div[1]")
	WebElement description;
	
	@FindBy(xpath = "//input[@placeholder='Enter Loan Ammount']")
	WebElement loan;

	JavascriptExecutor js;
	ConfigReader config;
	
	public LoanPage(WebDriver driver) {
		super(driver); // Calling BasePage constructor
		
		
	}
	
	public void propertyListing() {
		waitUntilWebElementIsVisible(propertyPage);
		propertyPage.click();
		SwitchWindow();        //Switch to the new window that opens
	}
	public void clickApplyLoan() {
		waitUntilWebElementIsVisible(ApplyLoan);
		ApplyLoan.click();
	}
	public void enterMobileNumber() throws InterruptedException {
		waitUntilWebElementIsVisible(mobileNumberInput);
		mobileNumberInput.sendKeys(config.propertyReaderMethod().getProperty("phoneNumber"));
		Thread.sleep(15000); 
		signUpSubmitButton.click();
	}
	
	public void fillForm(String amount) {
		waitUntilWebElementIsVisible(SelectCityDropdown);
		SelectCityDropdown.click(); 
		waitUntilWebElementIsVisible(SelectCity); 
		SelectCity.click(); 
		EnterLoanAmount.sendKeys(amount);
		waitUntilWebElementIsVisible(SelectIncomeDropdown);
		SelectIncomeDropdown.click();
		waitUntilWebElementIsVisible(SelectIncome);
		SelectIncome.click();
	}
	public void submitForm() {
		waitUntilWebElementIsVisible(submitButton);
		submitButton.click(); // Click the submit button
	}
	public void verifyLoanSuccessPopup() {
	   waitUntilWebElementIsVisible(loanSuccessMessage);
	    String actualMessage = loanSuccessMessage.getText().trim();
	    String expectedMessage = "Your Loan request is submitted successfully";
	    Assert.assertEquals("Your Loan request is submitted successfully", actualMessage , expectedMessage);
	}	
	public void scrollDown() {
		js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0, 1200)");
	}
	public void propertyDescription()  {
		Assert.assertTrue("Property description is not visible", description.isDisplayed()); // Ensure the description is visible
	}
	public void clickSearchButtonError() {
		// This method is to click the search button when the form is submitted with incomplete or invalid inputs
		waitUntilWebElementIsVisible(loan); // Wait for the error message to be visible
		loan.click();
	}
	public void errorMessageCity() {
		waitUntilWebElementIsVisible(SelectCityError);
		String cityErrorMessage = SelectCityError.getText().trim();
		String expectedCityErrorMessage = "Please select city";
		Assert.assertEquals("Please select  city", cityErrorMessage, expectedCityErrorMessage);
	}
	public void errorMessageAmount() {
		waitUntilWebElementIsVisible(EnterLoanError);
		String amountErrorMessage = EnterLoanError.getText().trim();
		String expectedAmountErrorMessage = "Please enter loan amount";
		Assert.assertEquals("Please enter loan amount", amountErrorMessage, expectedAmountErrorMessage);
	}
	public void errorMessageIncome() {
		waitUntilWebElementIsVisible(SelectIncomeError);
		String incomeErrorMessage = SelectIncomeError.getText().trim();
		String expectedIncomeErrorMessage = "Please select income";
		Assert.assertEquals("Please select income", incomeErrorMessage, expectedIncomeErrorMessage);
	}
	 public void reloadPage() {
	        driver.navigate().refresh();
	}	 
}
