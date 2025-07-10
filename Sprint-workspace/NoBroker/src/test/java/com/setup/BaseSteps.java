package com.setup;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSteps {
	public static WebDriver driver;
	public static ChromeOptions coptions;
	public static EdgeOptions eoptions;
	
	public static WebDriver chromedriver()
	{
		WebDriverManager.chromedriver().setup();
		coptions = new ChromeOptions();
		coptions.addArguments("--start-maximized");
		coptions.addArguments("disable-notifications");
		coptions.addArguments("disable-popup-blocking");
		
		  driver = new ChromeDriver(coptions);
		  //driver.get("https://www.nobroker.in/property/buy/2-bhk-apartment-for-sale-in-hinjewadi-pune/8a9fb983945f55c501945f741a420920/detail?nbFr=list-buy");
		  driver.get("https://www.nobroker.in/"); 
		  //driver.get("https://www.nobroker.in/property/sale/pune/Hinjawadi?searchParam=W3sibGF0IjoxOC41OTEyNzE2LCJsb24iOjczLjczODkwODk5OTk5OTk5LCJwbGFjZUlkIjoiQ2hJSjd4c0VTTUM3d2pzUjVkN0R3MXJyeWRBIiwicGxhY2VOYW1lIjoiSGluamF3YWRpIn1d&radius=2.0&type=BHK2&propertyAge=0&city=pune&locality=Hinjawadi&price=6000000,8000000&furnishing=SEMI_FURNISHED&propType=AP&parking=FOUR_WHEELER");
		  //driver.get("https://www.nobroker.in/property/sale/pune/Hinjawadi?searchParam=W3sibGF0IjoxOC41OTEyNzE2LCJsb24iOjczLjczODkwODk5OTk5OTk5LCJwbGFjZUlkIjoiQ2hJSjd4c0VTTUM3d2pzUjVkN0R3MXJyeWRBIiwicGxhY2VOYW1lIjoiSGluamF3YWRpIn1d&radius=2.0&type=BHK2&propertyAge=0&city=pune&locality=Hinjawadi");
		
		return driver;
	}
	
	public static WebDriver edgedriver()
	{
		WebDriverManager.edgedriver().setup();
		
		eoptions = new EdgeOptions();
		eoptions.addArguments("--start-maximized");
		eoptions.addArguments("disable-notifications");
		eoptions.addArguments("disable-popup-blocking");
		
		  driver = new EdgeDriver();
		  driver.get("https://www.nobroker.in/");
		  
		return driver;
	}
	
	public void tearDown()
	{
		driver.close();
	}
	public String takeScreenshot(String prefix) {
		try {
			TakesScreenshot takescreenshot = (TakesScreenshot) driver;
			File src = takescreenshot.getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String fileName = prefix + "_" + timestamp + ".png";
			File dest = new File("Screenshots/" + fileName);
			FileUtils.copyFile(src, dest);
			return dest.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
