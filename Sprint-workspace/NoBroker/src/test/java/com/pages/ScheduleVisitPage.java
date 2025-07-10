package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
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

public class ScheduleVisitPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'Schedule Visit')]")
    public WebElement scheduleVisitButton ;
    
    @FindBy(xpath = "//div[@class='react-datepicker-wrapper']")
    public WebElement pickDate;
    
    @FindBy(xpath = "//div[@aria-label='day-14']")
    public WebElement date;
    
    @FindBy(xpath = "//div[@class='nb__1mc6o nb__1do9N']")
    public WebElement afternoon;
    
    @FindBy(xpath = "//div[contains(text(),'03:00 PM')]")
    public WebElement time;
    
    @FindBy(xpath = "//div[contains(text(),'Visit Scheduled') or contains(text(),'Thank you')]")
    private WebElement confirmationMessage;

    public ScheduleVisitPage(WebDriver driver) {
    	super(driver);
        PageFactory.initElements(driver, this);  
    }

    public void wishlistLoadUrl() {
        driver.get(properties.getProperty("wishlistUrl"));
    }
    
    public void scrollBy() throws AWTException {
    	Robot robot = new Robot();
    	    robot.keyPress(KeyEvent.VK_DOWN);
    	    robot.keyRelease(KeyEvent.VK_DOWN);
    }
    
    public void scheduleVisit() {
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
	        robot.mouseMove(1100, 500);
	        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);  
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void selectDate() {
    	pickDate.click();
    	date.click();
    	afternoon.click();
    	time.click();
    }
    
    public boolean isScheduleConfirmed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
            return confirmationMessage.isDisplayed();
        } catch (Exception e) {
           return false;
        }
    }
}


