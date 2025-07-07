package com.pages;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactOwnerPage {
	WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    Actions actions;
    Properties prop;
    
    @FindBy(xpath = "//*[@id=\\\"listPageTop\\\"]/nav/div/div[2]/div/div/div/div[3]/div/div")
    public WebElement gotItButton;
    
    @FindBy(xpath = "(//button[contains(text(),'Get Owner Details')])[1]")
    public WebElement ownerDetailsButton;
    
    @FindBy(xpath = "//input[@type='tel' and @placeholder='Enter Mobile Number']")
    public WebElement numberInput;
  
    
    
    public ContactOwnerPage(WebDriver driver) {
        this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;      
		this.actions = new Actions(driver);
		loadProperties();
    }
    
    private void loadProperties() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("C:\\Windows\\System32\\config\\systemprofile\\Sprint-workspace\\NoBroker\\src\\test\\resource\\Properties\\Buy.properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void login()
    {
    	numberInput.sendKeys(prop.getProperty("mobileno"));
    }
    
    public void handlePopup() {
         gotItButton.click();
       
    }
    
    public void scrollToListings(int times) {
        try {
            for (int i = 0; i < times; i++) {
                js.executeScript("window.scrollBy(0,300)");
                Thread.sleep(700);
            }
        } catch (InterruptedException ignored) {}
    }

    public void clickGetOwnerDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(ownerDetailsButton));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", ownerDetailsButton);
        ownerDetailsButton.click();
    }


    public boolean isLoginFieldDisplayed() {
        try {
            return numberInput.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
