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

public class PropertyListingPage {
	WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    Actions actions;
    Properties prop;
    
    @FindBy(xpath = "//*[@id=\\\"listPageTop\\\"]/nav/div/div[2]/div/div/div/div[3]/div/div")
    public WebElement gotItButton;
    
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
    
    public PropertyListingPage(WebDriver driver) {
        this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;      
		this.actions = new Actions(driver);
		loadProperties();
    }
    
    
    public void contactLoadUrl() {
        driver.get(prop.getProperty("contactUrl"));
    }
    
    public void loadProperties() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("C:\\Windows\\System32\\config\\systemprofile\\Sprint-workspace\\NoBroker\\src\\test\\resource\\Properties\\Buy.properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
//    public void handlePopup() {
//         gotItButton.click();
//       
//    }
    
    public void scrollToListings() {
    	js.executeScript("window.scrollBy(0,450)");
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

    	//wait.until(ExpectedConditions.visibilityOf(numberInput));
    	numberInput.sendKeys("9766596623");
    	//numberInput.sendKeys(prop.getProperty("mobileno"));
    	try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	continueButton.click();
    }

    public boolean isLoginFieldDisplayed() {
        try {
            return numberInput.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
	  public void handlePopup() {
		  gotItButton.click();
	
	}
    

    public void wishlistButton(int index)  {
    	Robot robot;
		try {
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
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	wishlistBag.click();
    }
    
    public boolean isWishlistConfirmed() {
        try {
            WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'added to your wishlist')]")
            ));
            return toast.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
