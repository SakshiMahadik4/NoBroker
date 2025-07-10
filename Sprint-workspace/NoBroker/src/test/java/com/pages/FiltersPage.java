package com.pages;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class FiltersPage extends BasePage {

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
    
    @FindBy(xpath = "//button[@class='w-full btn btn-primary btn-md']")
    public List<WebElement> getOwnerDetails;
 
    public FiltersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        loadProperties();
    }

    public void loadUrl() {
        driver.get(properties.getProperty("filterUrl"));
    }

    public void applyPriceFilter() {
         wait.until(ExpectedConditions.visibilityOf(priceLeftSlider));
         actions.clickAndHold(priceLeftSlider).moveByOffset(130, 0).release().perform();
         actions.clickAndHold(priceRightSlider).moveByOffset(-150, 0).release().perform();
    }

    public void applyFurnishingFilter() {
        js.executeScript("arguments[0].scrollIntoView(true);", propertyStatusDropdown);
        js.executeScript("arguments[0].click();", semiFurnishingCheckbox);
    }

    public void applyPropertyTypeFilter() {
        js.executeScript("arguments[0].scrollIntoView(true);", propertyTypeHeading);
        wait.until(ExpectedConditions.elementToBeClickable(apartmentPropertyType));
        js.executeScript("arguments[0].click();", apartmentPropertyType);
    }

    public void applyParkingFilter() {
        js.executeScript("arguments[0].scrollIntoView(true);", parkingHeading);
        wait.until(ExpectedConditions.elementToBeClickable(parkingCheckbox));
        js.executeScript("arguments[0].click();", parkingCheckbox);
    }

    public void isListingVisible() {
    	wait.until(ExpectedConditions.visibilityOfAllElements(getOwnerDetails));
    	Assert.assertTrue(getOwnerDetails.size() > 0,"Property Listings should be displayed");
    }



}