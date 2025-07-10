package com.pages;

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

public class BasePage {
	
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    Actions actions;
    Properties properties;
    
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

    @FindBy(xpath = "//button[@class='w-full btn btn-primary btn-md']")
    public List<WebElement> getOwnerDetails;

    @FindBy(xpath = "//*[@id='searchCity']/div/div[1]/div")
    public List<WebElement> bhkOptions;
    
    public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;      
		this.actions = new Actions(driver);
		loadProperties();
	}
 
    public void loadProperties() {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("C:\\Windows\\System32\\config\\systemprofile\\Sprint-workspace\\NoBroker\\src\\test\\resource\\Properties\\Buy.properties");
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

	public void goToBuyPage() {
       
        buyButton.click();
    }

	public void selectCity() {
        cityBox.click();
        puneOption.click();
    }

	public void selectLocalityBox(){
		wait.until(ExpectedConditions.elementToBeClickable(localityBox)).click();
	}

	public void enterLocality(String locality) {
         localityBox.sendKeys(locality);
         wait.until(ExpectedConditions.elementToBeClickable(localitySuggestion)).click();
    }

   public void selectBHK(int index) {
        bhkDropdown.click();
        bhkOptions.get(index).click();
    }

   public void applyPropertyStatus() {
         wait.until(ExpectedConditions.elementToBeClickable(propertyStatusDropdown)).click();
         wait.until(ExpectedConditions.elementToBeClickable(readyOption));
         js.executeScript("arguments[0].click();", readyOption);
    }

    public void clickSearch() {
    	wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
    
    public void isListingVisible() {
    	wait.until(ExpectedConditions.visibilityOfAllElements(getOwnerDetails));
    	Assert.assertTrue(getOwnerDetails.size() > 0,"Property Listings should be displayed");
    }

}
