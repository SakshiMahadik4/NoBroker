package com.pages;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait;
	Properties prop;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		PageFactory.initElements(driver, this);
		loadProperties();
	}

	public void waitUntilWebElementIsClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilWebElementIsVisible(WebElement element) {
		 wait=new WebDriverWait(driver,Duration.ofSeconds(8));
		 wait.until(ExpectedConditions.visibilityOf(element));
	 }
	

	public void loadProperties() {
        try {
             prop = new Properties();
            FileInputStream fis = new FileInputStream("C:\\Windows\\System32\\config\\systemprofile\\SprintWorkspace\\NoBroker\\src\\test\\resource\\Properties\\Login.properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	 

}
