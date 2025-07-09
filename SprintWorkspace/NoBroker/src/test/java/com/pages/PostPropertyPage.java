package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostPropertyPage extends BasePage {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	 @FindBy(xpath = "//div[text()='Rental Agreement']")
	    WebElement RentalAgreementButton;
	 
	 @FindBy(xpath = "//div[contains(text(),'Menu')]")
	    WebElement Menu;
	 
	 @FindBy(xpath = "//div[contains(text(),'Post ')]")
	    WebElement postProperty;
	 
	 @FindBy(xpath = "//input[@id='userName']")
	 WebElement userName;
	
	 @FindBy(xpath = "//input[@id='userEmail']")
	 WebElement userEmail;
	 
	 @FindBy(xpath = "//button[contains(text(),'Start Posting Your Ad For FREE')]")
	 WebElement startPostButton;
	 
	 @FindBy(xpath = "//div[@controlid='userEmail']/span")
	 WebElement errorMessage;
	 
	
	 
	 public PostPropertyPage(WebDriver driver) {
			super(driver);
			this.driver = driver;
	        if (driver != null) {
	            this.action = new Actions(driver);
	        } else {
	            throw new IllegalArgumentException("Driver cannot be null");
	        }
		}
	 
	 public void clickRentalAgreement() {
		 waitUntilWebElementIsClickable(RentalAgreementButton);
	     action.moveToElement(RentalAgreementButton).click().build().perform();
	}

	 public void clickMenuAndselectpostproperty() {
		 waitUntilWebElementIsClickable(Menu);
		 Menu.click();
		waitUntilWebElementIsVisible(postProperty);
	    action.moveToElement(postProperty).click().build().perform();				
	 }
	 
	 public void propertyFormData(String user,String email) {
			 waitUntilWebElementIsVisible(userName);
		       userName.sendKeys(user);
		       waitUntilWebElementIsVisible(userEmail);
		       userEmail.sendKeys(email);
		}
	 
	 public void startPosting() {
		 try {
	        	 Thread.sleep(1000);
	        	 JavascriptExecutor js=(JavascriptExecutor)driver;
	     		js.executeScript("window.scrollBy(0,500)");
	            waitUntilWebElementIsClickable(startPostButton);
	            startPostButton.click(); 
	            Thread.sleep(1000);
	            js.executeScript("window.scrollBy(0,-500)");
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public boolean diplayError() {
		 return errorMessage.isDisplayed();
	 }
	 
}
