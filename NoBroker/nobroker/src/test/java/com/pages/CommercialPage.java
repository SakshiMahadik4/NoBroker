package com.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommercialPage extends BasePage {

	public CommercialPage(WebDriver driver) {
	    super(driver);
	}

	 // Locators
    By commercialTab = By.xpath("//div[contains(text(), 'Commercial') and contains(@class, 'cursor-pointer')]");
    By searchInput = By.id("listPageSearchLocality");
    By searchButton = By.xpath("//button[contains(@class, 'prop-search-button')]");

    // React dropdown city switch
    By cityDropdownInput = By.id("react-select-7-input"); // Adjust if dynamic
    By currentCityText = By.xpath("//div[contains(@class,'nb-select__single-value')]");

    // Property Listings
    By propertyListings = By.xpath("//div[contains(@class, 'nb__1Xz0I')]");
    By locationText = By.xpath(".//div[contains(@class, 'nb__2CMdv')]");
    By priceText = By.xpath(".//div[contains(@class, 'font-semi-bold')]");
    By propertyTypeText = By.xpath(".//div[contains(@class, 'nb__3zRoD')]");


    public void clickCommercialTab() {
        WebElement tab = driver.findElement(commercialTab);
        waitUntilElementClickable(tab);
        tab.click();
    }

    public void searchCommercialPropertyInHinjewadi() {
        // Step 1: Click "Commercial" tab
        WebElement tab = driver.findElement(By.xpath("//div[contains(text(), 'Commercial') and contains(@class, 'cursor-pointer')]"));
        waitUntilElementClickable(tab);
        tab.click();

        // Step 2: Open city dropdown
        WebElement dropdown = driver.findElement(By.cssSelector("div.nb-select__value-container"));
        waitUntilElementClickable(dropdown);
        dropdown.click();

        // Step 3: Select 3rd city option (Pune)
        By cityOptions = By.cssSelector("div[class*='nb-select__menu-list'] div[class*='nb-select__option']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(cityOptions));
        List<WebElement> cities = driver.findElements(cityOptions);
        if (cities.size() >= 3) {
            WebElement puneOption = cities.get(2); // 0-based index
            waitUntilElementClickable(puneOption);
            puneOption.click();
        }

        // Step 4: Enter "Hinjewadi" in location box
        WebElement input = driver.findElement(By.id("listPageSearchLocality"));
        waitUntilElementVisible(input);
        input.click();
        input.clear();
        input.sendKeys("Hinjewadi");
        input.sendKeys(Keys.ENTER);
    }

    public void enterSearchLocation(String location) {
        WebElement input = driver.findElement(searchInput);
        waitUntilElementVisible(input);
        input.click();
        input.clear();
        input.sendKeys(location);

        // Wait for suggestions to load (optional small delay)
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        // Keyboard-based selection
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ENTER);
        input.sendKeys(Keys.ENTER); // Confirm selection
    }

    public void clickSearchButton() {
        WebElement button = driver.findElement(searchButton);
        waitUntilElementClickable(button);
        button.click();
    }

    public boolean isSearchRedirected(String location) {
        return driver.getCurrentUrl().toLowerCase().contains(location.toLowerCase());
    }
    public boolean verifyPropertyListingsVisible() {
        List<WebElement> listings = driver.findElements(propertyListings);
        System.out.println("Total listings found: " + listings.size());

        for (WebElement listing : listings) {
            boolean hasLocation = !listing.findElements(locationText).isEmpty();
            boolean hasPrice = !listing.findElements(priceText).isEmpty();
            boolean hasType = !listing.findElements(propertyTypeText).isEmpty();

            System.out.println("Listing → Location: " + hasLocation + ", Price: " + hasPrice + ", Type: " + hasType);

            if (hasLocation && hasPrice && hasType) {
                return true;
            }
        }
        return false;
    }

}