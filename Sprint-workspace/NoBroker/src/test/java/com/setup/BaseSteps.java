package com.setup;

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
		coptions.addArguments("Incognito");
		coptions.addArguments("disable-notifications");
		coptions.addArguments("disable-popup-blocking");
		
		  driver = new ChromeDriver(coptions);
		  //driver.get("https://www.nobroker.in/"); 
		  driver.get("https://www.nobroker.in/property/sale/pune/Hinjawadi?searchParam=W3sibGF0IjoxOC41OTEyNzE2LCJsb24iOjczLjczODkwODk5OTk5OTk5LCJwbGFjZUlkIjoiQ2hJSjd4c0VTTUM3d2pzUjVkN0R3MXJyeWRBIiwicGxhY2VOYW1lIjoiSGluamF3YWRpIn1d&radius=2.0&type=BHK2&propertyAge=0&city=pune&locality=Hinjawadi");
		
		return driver;
	}
	
	public static WebDriver edgedriver()
	{
		WebDriverManager.edgedriver().setup();
		
		eoptions = new EdgeOptions();
		eoptions.addArguments("--start-maximized");
		eoptions.addArguments("Incognito");
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

}
