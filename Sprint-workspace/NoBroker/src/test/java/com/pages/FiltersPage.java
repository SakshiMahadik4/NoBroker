package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FiltersPage extends ContactOwnerPage {
	 public FiltersPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			// TODO Auto-generated constructor stub
		}
	
	WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    Actions actions;
    Properties prop;
    
    @FindBy(xpath = "//div[contains(@class,'rc-slider-handle')][1]")
    public WebElement priceLeftSlider;

    @FindBy(xpath = "//div[contains(@class,'rc-slider-handle')][2]")
    public WebElement priceRightSlider;

    @FindBy(xpath = "//div[text()='Furnishing']/following-sibling::div//span[text()='Semi']")
    public WebElement semiFurnishingCheckbox;
    
    @FindBy(xpath = "//div[contains(text(),'Property Status')]")
    public WebElement propertyStatusDropdown;

    @FindBy(xpath = "//div[text()='Property Type']/following-sibling::div//span[text()='Apartment']")
    public WebElement apartmentPropertyType;

    @FindBy(xpath = "//div[text()='Property Type']")
    public WebElement propertyTypeHeading;

    @FindBy(xpath = "//div[text()='Parking']")
    public WebElement parkingHeading;

    @FindBy(id = "parking_4_wheeler")
    public WebElement parkingCheckbox;

    
   

  
    public void loadUrl()
	{
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(prop.getProperty("filterUrl"));
	}
    
    public void applyPriceFilter() {
        try {
            wait.until(ExpectedConditions.visibilityOf(priceLeftSlider));
            actions.clickAndHold(priceLeftSlider).moveByOffset(130, 0).release().perform();
            actions.clickAndHold(priceRightSlider).moveByOffset(-150, 0).release().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void applyFurnishingFilter() {
        js.executeScript("arguments[0].scrollIntoView(true);", propertyStatusDropdown);
        js.executeScript("arguments[0].click();", semiFurnishingCheckbox);
    }
	public void applyPropertyTypeFilter() {
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", propertyTypeHeading);
            wait.until(ExpectedConditions.elementToBeClickable(apartmentPropertyType));
            js.executeScript("arguments[0].click();", apartmentPropertyType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void applyParkingFilter() {
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", parkingHeading);
            wait.until(ExpectedConditions.elementToBeClickable(parkingCheckbox));
            js.executeScript("arguments[0].click();", parkingCheckbox);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean isFilteredListingVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card"))); 
            List<WebElement> listings = driver.findElements(By.cssSelector(".card"));
            return listings.size() > 0 && listings.get(0).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
