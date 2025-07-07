package com.pages;

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

public class BasePage {
	
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    Actions actions;
    
	@FindBy(xpath = "//div[text()='Buy']")
	public WebElement buyButton;
	
	@FindBy(xpath = "//div[@class='prop-search-city-selector nb-select form-group nb-select__lg']//div//div[@class='css-1wy0on6 nb-select__indicators']")
	public WebElement cityBox;
	
	@FindBy(xpath = "//div[contains(text(),'Pune')]")
	public WebElement puneOption;
	
	@FindBy(id ="listPageSearchLocality")
	public WebElement localityBox;
	
	@FindBy(xpath = "//div[@class='nb-google-autocomplete nb-google-autocomplete-lg']//div[1]//div[1]//div[2]//div[1]")
    public WebElement localitySuggestion;

    @FindBy(xpath = "//div[contains(text(),'BHK Type')]")
    public WebElement bhkDropdown;

    @FindBy(xpath = "//div[contains(text(),'Property Status')]")
    public WebElement propertyStatusDropdown;

    @FindBy(xpath = "//div[text()='Ready']")
    public WebElement readyOption;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    public WebElement searchButton;

  

    @FindBy(xpath = "//*[@id='searchCity']/div/div[1]/div")
    public List<WebElement> bhkOptions;
    
    public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 this.js = (JavascriptExecutor) driver;      
		    this.actions = new Actions(driver);   
	}
    
//    private void loadProperties() {
//    	try {
//    		prop = new Properties();
//    		FileInputStream fis = new 
//    	}
//    }

	public void goToBuyPage() {
       
        buyButton.click();
    }

public void selectCity() {
        cityBox.click();
        js.executeScript("arguments[0].click();", puneOption);
    }

public void enterLocality(String locality) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(localityBox)).click();
            localityBox.sendKeys(locality);
            wait.until(ExpectedConditions.elementToBeClickable(localitySuggestion)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public void selectBHK(int index) {
        bhkDropdown.click();
        bhkOptions.get(index).click();
    }

public void applyPropertyStatus() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(propertyStatusDropdown)).click();
            wait.until(ExpectedConditions.elementToBeClickable(readyOption));
            js.executeScript("arguments[0].click();", readyOption);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickSearch() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean isListingVisible() {
        try {
            WebElement listing = driver.findElement(By.cssSelector(".card")); // or adjust locator
            return listing.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
