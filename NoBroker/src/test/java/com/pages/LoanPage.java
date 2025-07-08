package com.pages;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoanPage extends BasePage{
	
	@FindBy(xpath = "//h2[@class='flex items-center m-0 heading-6 font-semi-bold']")
	WebElement propertyPage;
	
	@FindBy(xpath = "//div[@class='nb__2bdjR']")
	WebElement ApplyLoan;
	
	@FindBy(xpath = "//input[@placeholder='Enter Mobile Number']")
	WebElement mobileNumberInput;
	
	@FindBy(xpath = "//button[@id='signUpSubmit']")
	WebElement signUpSubmitButton;
	
	@FindBy(xpath = "//input[@id='listPageSearchLocality']")
	WebElement SearchLocality;

	@FindBy(xpath = "//div[@class='cursor-pointer text-primary-color border-0 border-b-4 border-solid border-primary-color font-bold']")
	WebElement Rent;

	@FindBy(xpath = "//div[@class='css-1hwfws3 nb-select__value-container nb-select__value-container--has-value']")
	WebElement locationDropdown;

	@FindBy(xpath = "//div[contains(text(),'Pune')]")
	WebElement locationValue;
	
	@FindBy(xpath = "//div[@id='applyLoanForm-city-nbInput']")
	WebElement SelectCityDropdown;
	
	@FindBy(xpath = "//div[@id='applyLoanForm-income-nbInput']")
	WebElement SelectIncomeDropdown;
	
	@FindBy(xpath = "//input[@placeholder = 'Enter Loan Ammount']")
	WebElement EnterLoanAmount;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//*[@id=\"alertMessageBox\"]/div")
	WebElement loanSuccessMessage;
	
	@FindBy(xpath = "//div[@class='nb__TSdqt']/div[1]")
	WebElement description;
	
	
	PropertyPage property;
	JavascriptExecutor js;
	
	
	public LoanPage(WebDriver driver) {
		super(driver); // Calling BasePage constructor
	}
	
	public void propertyListing() {
		property = new PropertyPage(driver);
		property.RentalPage();
		property.enterLocation();
		property.clickSearchButton();
		waitUntilWebElementIsVisible(propertyPage);
		propertyPage.click();
	}
	public void clickApplyLoan() {
		String originalWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(originalWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		waitUntilWebElementIsVisible(ApplyLoan);
		ApplyLoan.click();
	}
	public void enterMobileNumber(String mobileNumber) throws InterruptedException {
		waitUntilWebElementIsVisible(mobileNumberInput);
		mobileNumberInput.sendKeys(mobileNumber);
		Thread.sleep(20000); // Wait for the input to be processed
		signUpSubmitButton.click();
	}
	public void fillLoanFormWithValidData(String amount) throws InterruptedException {
	    waitUntilWebElementIsVisible(SelectCityDropdown);

	    // Click to open the dropdown menu
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", SelectCityDropdown);
	    Thread.sleep(1000); // Wait for dropdown to load options

	    // Use Actions class to send Arrow Down + Enter
	    Actions actions = new Actions(driver);
	    actions.moveToElement(SelectCityDropdown).click().perform();
	    Thread.sleep(1000); // wait for dropdown options to show
	    actions.sendKeys(Keys.ARROW_DOWN).pause(500).sendKeys(Keys.ENTER).perform();

	    // Enter Loan Amount
	    waitUntilWebElementIsVisible(EnterLoanAmount);
	    EnterLoanAmount.sendKeys(amount);

	    // Click on Income Dropdown using JavaScript
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", SelectIncomeDropdown);
	    Thread.sleep(1000);

	    // Select Income using Keys
	    actions.moveToElement(SelectIncomeDropdown).click().perform();
	    Thread.sleep(1000);
	    actions.sendKeys(Keys.ARROW_DOWN).pause(500).sendKeys(Keys.ENTER).perform();
	}
	public void submitForm() {
		waitUntilWebElementIsVisible(submitButton);
		submitButton.click(); // Click the submit button
	}
	public void verifyLoanSuccessPopup() {
	    // Wait for the popup message to appear and become visible
	   waitUntilWebElementIsVisible(loanSuccessMessage);
	    // Validate the popup text
	    String actualMessage = loanSuccessMessage.getText().trim();
	    String expectedMessage = "Your Loan request is submitted successfully";
	    Assert.assertEquals("Your Loan request is submitted successfully", actualMessage , expectedMessage);
	    driver.close();
	    // Assert.assertEquals(actualMessage, expectedMessage , "Pop-up Message does not match expected text");
	}	
	public void scrollDownInProperty(int times) {
		 // Switch to the property listing window
		
		String originalWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(originalWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 1200)");
	}
	public void propertyDescription() {
		waitUntilWebElementIsVisible(description); // Ensure the description is visible
		Assert.assertTrue("Property description is not visible", description.isDisplayed()); // Ensure the description is visible
	}

}
