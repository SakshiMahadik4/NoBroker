package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		PageFactory.initElements(driver, this);
	}

	public void waitUntilWebElementIsClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilWebElementIsVisible(WebElement element) {
		 wait=new WebDriverWait(driver,Duration.ofSeconds(8));
		 wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 

}
