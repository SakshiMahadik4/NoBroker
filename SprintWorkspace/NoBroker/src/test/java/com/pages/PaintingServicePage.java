package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaintingServicePage extends BasePage {
    WebDriver driver;
    Actions action;
    WebDriverWait wait;

    public PaintingServicePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        if (driver != null) {
            this.action = new Actions(driver);
        } else {
            throw new IllegalArgumentException("Driver cannot be null");
        }
    }

    @FindBy(xpath = "//div[text()='Painting']")
    WebElement PaintingButton;

    @FindBy(xpath = "//*[@id='app']/div/div/div[2]/div[2]/span/div/div/div[2]/button")
    WebElement SeeAllButton;

    @FindBy(xpath = "//button[text()='Get Estimate']")
    WebElement GetEstimate;

    @FindBy(xpath = "//input[@placeholder='Enter Mobile Number']")
    WebElement PhoneNumber;

    public void ClickPaintingService() {
        waitUntilWebElementIsClickable(PaintingButton);
        action.moveToElement(PaintingButton).click().build().perform();
    }

    public void SeeAllService() {
        waitUntilWebElementIsClickable(SeeAllButton);
        SeeAllButton.click();
    }

    public void GetEstimate() {
        waitUntilWebElementIsClickable(GetEstimate);
        action.moveToElement(GetEstimate).click().build().perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void userlogin() {
        waitUntilWebElementIsClickable(PhoneNumber);
        PhoneNumber.click();
        PhoneNumber.sendKeys(prop.getProperty("phoneNumber"));
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.moveToElement(GetEstimate).click().build().perform();
    }
    
    
}
