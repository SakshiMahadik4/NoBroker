package com.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginpage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nobroker.in/property/sale/pune/Hinjawadi?searchParam=W3sibGF0IjoxOC41OTEyNzE2LCJsb24iOjczLjczODkwODk5OTk5OTk5LCJwbGFjZUlkIjoiQ2hJSjd4c0VTTUM3d2pzUjVkN0R3MXJyeWRBIiwicGxhY2VOYW1lIjoiSGluamF3YWRpIn1d&radius=2.0&type=BHK2&propertyAge=0&city=pune&locality=Hinjawadi&price=6000000,8000000&furnishing=SEMI_FURNISHED&propType=AP&parking=FOUR_WHEELER");
		driver.manage().window().maximize();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		   WebElement ownerButton = wait1.until(ExpectedConditions.elementToBeClickable(
			         By.xpath("(//button[contains(text(),'Get Owner Details')])[1]")));

			     // Scroll and click
			     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ownerButton);
			     Thread.sleep(3000);
			     ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ownerButton);
			     Thread.sleep(5000);


	    
	}

}
