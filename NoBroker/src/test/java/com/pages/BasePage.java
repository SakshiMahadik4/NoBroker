package com.pages;
 
import java.time.Duration;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class BasePage {
	WebDriver driver;
	WebDriverWait wait;
	BasePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void waitUntilWebElementIsVisible(WebElement element) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void actions(WebElement element) {
		Actions actions = new Actions(driver);
	}
	
}