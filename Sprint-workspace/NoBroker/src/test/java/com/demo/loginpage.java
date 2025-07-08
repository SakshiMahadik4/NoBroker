package com.demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginpage {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nobroker.in/property/sale/pune/Hinjawadi?searchParam=W3sibGF0IjoxOC41OTEyNzE2LCJsb24iOjczLjczODkwODk5OTk5OTk5LCJwbGFjZUlkIjoiQ2hJSjd4c0VTTUM3d2pzUjVkN0R3MXJyeWRBIiwicGxhY2VOYW1lIjoiSGluamF3YWRpIn1d&radius=2.0&type=BHK2&propertyAge=0&city=pune&locality=Hinjawadi&price=6000000,8000000&furnishing=SEMI_FURNISHED&propType=AP&parking=FOUR_WHEELER");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		 for (int i = 0; i < 1; i++) {
//           js.executeScript("window.scrollBy(0,250)");
//           Thread.sleep(3000);
//       }
//		
//		driver.findElement(By.xpath("//*[@id=\"8a9fb983945f55c501945f741a420920\"]/div/div[2]/div[1]/h2"));
//		
		
		WebElement bag=driver.findElement(By.xpath("//img[@alt='shortlist']"));
		bag.click();
//		 for (int i = 0; i < 2; i++) {
//             js.executeScript("window.scrollBy(0,250)");
//             Thread.sleep(3000);
//         }
//		 
//		 Robot robot = new Robot();
//         Thread.sleep(2000);
//         robot.mouseMove(970, 470);
//         robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//         robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
         
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
//	    List<WebElement> wishlist=driver.findElements(By.xpath("//button[contains(@class,'property-card-action-icon-btn')]"));
//	    js.executeScript("arguments[0].click();", wishlist);
//	    int indexToClick = 0;
//	    WebElement target = wishlist.get(indexToClick);
//	    target.click();
    
	 // Find all wishlist buttons
//	    List<WebElement> wishlistButtons = driver.findElements(
//	        By.xpath("//button[contains(@class,'property-card-action-icon-btn')]")
//	    );

	    
}}
