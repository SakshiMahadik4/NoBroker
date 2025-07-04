package com.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    Actions actions;
    
	@FindBy(xpath = "//div[text()='Buy']")
	public static WebElement buyButton;
	
	@FindBy(xpath = "//div[@class='prop-search-city-selector nb-select form-group nb-select__lg']//div//div[@class='css-1wy0on6 nb-select__indicators']")
	public static WebElement cityBox;
	
	@FindBy(xpath = "//div[contains(text(),'Pune')]")
	public static WebElement puneOption;
	
	@FindBy(id ="listPageSearchLocality")
	public static WebElement localityBox;
	
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

    @FindBy(xpath = "//div[contains(@class,'rc-slider-handle')][1]")
    public WebElement priceLeftSlider;

    @FindBy(xpath = "//div[contains(@class,'rc-slider-handle')][2]")
    public WebElement priceRightSlider;

    @FindBy(xpath = "//div[text()='Furnishing']/following-sibling::div//span[text()='Semi']")
    public WebElement semiFurnishingCheckbox;

    @FindBy(xpath = "//div[text()='Property Type']/following-sibling::div//span[text()='Apartment']")
    public WebElement apartmentPropertyType;

    @FindBy(xpath = "//div[text()='Property Type']")
    public WebElement propertyTypeHeading;

    @FindBy(xpath = "//div[text()='Parking']")
    public WebElement parkingHeading;

    @FindBy(id = "parking_4_wheeler")
    public WebElement parkingCheckbox;

    @FindBy(xpath = "//*[@id='searchCity']/div/div[1]/div")
    public List<WebElement> bhkOptions;
    
    public void goToBuyPage() {
        driver.get("https://www.nobroker.in/");
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


}
