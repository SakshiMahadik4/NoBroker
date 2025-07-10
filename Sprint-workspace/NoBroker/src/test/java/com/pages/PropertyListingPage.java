package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PropertyListingPage extends BasePage{
    
    @FindBy(xpath="//div[contains(text(),'Log in')]")
    public WebElement logIn;
    
    @FindBy(xpath = "//input[@id='signUp-phoneNumber']")
    public WebElement numberInput;
    
    @FindBy(xpath = "//button[text()='Get Owner Details']")
    public List<WebElement> ownerDetailsButton;
    
   @FindBy(id = "signUpSubmit")
    public WebElement continueButton;

    @FindBy(xpath= "//img[@alt='shortlist']")
    public WebElement wishlistBag;
    
    @FindBy(id = "shortlistProperty")
    public List<WebElement> shortlistButton;
    
    @FindBy(xpath = "//*[contains(text(),'added to your wishlist')]")
    public WebElement visibleWishlist;
    
    public PropertyListingPage(WebDriver driver) {
    	super(driver);
        PageFactory.initElements(driver, this);
    }
     
    public void contactLoadUrl() {
        driver.get(properties.getProperty("contactUrl"));
    }
    
    
    public void scrollToListings() {
    	js.executeScript("window.scrollBy(0,1300)");
    }
    
    
    public void clickGetOwnerDetails(int index) {
		ownerDetailsButton.get(index).click();
    }
    
    public void login()
    {
    	
    	logIn.click();
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    	wait.until(ExpectedConditions.visibilityOf(numberInput));
    	//numberInput.sendKeys("9766596623");
    	numberInput.sendKeys(properties.getProperty("mobileno"));
    	try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	continueButton.click();
    }

    public void ownerDetailsSent() {   
    	System.out.println("Details sent");		
    }
  
    public void wishlistButton()  {
    	Robot robot;
		try {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			robot = new Robot();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        robot.mouseMove(970, 365);
	        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);  
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        	
    }
    
    
    public void wishlistBag() {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	wishlistBag.click();
    }
    
    public void isWishlistConfirmed() {
    	Assert.assertTrue(driver.getCurrentUrl().equals("https://www.nobroker.in/profile/shortlist?tab=all&nbFr=my_shortlist_header"));
    }


}
