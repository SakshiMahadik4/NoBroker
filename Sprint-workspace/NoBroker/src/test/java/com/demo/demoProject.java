package com.demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demoProject {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nobroker.in/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		

//		WebElement logIn=driver.findElement(By.xpath("//*[@id=\"navHeader\"]/div[5]/div[2]/div[2]/div"));
//	    logIn.click();
////	    
//	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//	    WebElement number=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='tel' and @placeholder='Enter Mobile Number']")));
//	    number.click();
//	    number.sendKeys("9766596623");
//	    Thread.sleep(50000);
//
//	    
//	    WebElement continueButton=driver.findElement(By.xpath("//*[@id=\"signUpSubmit\"]"));
//	    continueButton.click();
	    
		//cick buy on home page
		driver.findElement(By.xpath("//div[text()='Buy']")).click();
		
		//click on dropdown of citybox
		WebElement cityBox=driver.findElement(By.xpath("//div[@class='prop-search-city-selector nb-select form-group nb-select__lg']//div//div[@class='css-1wy0on6 nb-select__indicators']"));
		cityBox.click();
		
		//click pune in citybox
		WebElement puneOption = driver.findElement(By.xpath("//div[contains(text(),'Pune')]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", puneOption);
		
		//click on localitybox
		WebElement localityBox=driver.findElement(By.id("listPageSearchLocality"));
		localityBox.click();
		localityBox.sendKeys("Hinjewadi");
		Thread.sleep(2000);
		//click on hinjewadi suggestion
		WebElement suggestion = driver.findElement(By.xpath( "//div[@class='nb-google-autocomplete nb-google-autocomplete-lg']//div[1]//div[1]//div[2]//div[1]"));
	    suggestion.click();

	    //click in dropdown of bhk
	    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement drop = wait1.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//div[contains(text(),'BHK Type')]")));
	    drop.click();

	    //created a list of bhk type
	    List<WebElement> bhk=driver.findElements(By.xpath("//*[@id=\"searchCity\"]/div/div[1]/div"));
//	    System.out.println(bhk.size());
	    int indexToClick = 4;
	    //click on 2bhk
	    WebElement target = bhk.get(indexToClick);
	    target.click();
	    
	    //click on property status dropdown
	    WebElement dropdown = driver.findElement(By.xpath("//div[contains(text(),'Property Status')]"));
	    dropdown.click();
	    Thread.sleep(1000);
	    
	    //click on ready option in property status
	    WebElement readyOption = driver.findElement(By.xpath("//div[text()='Ready']"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", readyOption);

	    //click on search button
	    WebElement search=driver.findElement(By.xpath("//button[normalize-space()='Search']"));
	    search.click();
	    Thread.sleep(2000);

	    //next page
	   
	    
    //using actions for price slider
	    Actions actions = new Actions(driver);

        // 1. Locate the left and right slider handles
        WebElement leftHandle = driver.findElement(By.xpath("//div[contains(@class,'rc-slider-handle')][1]"));
        WebElement rightHandle = driver.findElement(By.xpath("//div[contains(@class,'rc-slider-handle')][2]"));

        // 2. Drag left handle slightly right 
        actions.clickAndHold(leftHandle).moveByOffset(130, 0).release().perform();
        Thread.sleep(500);

        // 3. Drag right handle slightly left
        actions.clickAndHold(rightHandle).moveByOffset(-150, 0).release().perform();
        Thread.sleep(1000);
        
        
        //scrolling down filter section using a propertystatus element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement propertyStatusSection = driver.findElement(By.xpath("//div[contains(text(),'Property Status')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", propertyStatusSection);
        Thread.sleep(1000);
        
  
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        WebDriverWait wait111 = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 2: Click on the "Semi" checkbox in furnishing
        WebElement semiCheckbox = wait111.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()='Furnishing']/following-sibling::div//span[text()='Semi']")));
        js.executeScript("arguments[0].click();", semiCheckbox);


        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Scroll to Property Type heading
        WebElement propertyTypeHeading = driver.findElement(By.xpath("//div[text()='Property Type']"));
        js.executeScript("arguments[0].scrollIntoView(true);", propertyTypeHeading);
        Thread.sleep(1000);

        // Click on "Apartment"
        WebElement apartmentOption = wait111.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()='Property Type']/following-sibling::div//span[text()='Apartment']")));
        js.executeScript("arguments[0].click();", apartmentOption);
//
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
  
        // Scroll to the "Parking" label text
        WebElement parkingSection = driver.findElement(By.xpath("//div[text()='Parking']"));
        js.executeScript("arguments[0].scrollIntoView(true);", parkingSection);
        Thread.sleep(1000);

        // Locate the actual checkbox by ID
        WebElement checkbox = wait111.until(ExpectedConditions.elementToBeClickable(
                By.id("parking_4_wheeler")));

        // Click using JS 
        js.executeScript("arguments[0].click();", checkbox);

      
     WebElement gotItButton=driver.findElement(By.xpath("//*[@id=\"listPageTop\"]/nav/div/div[2]/div/div/div/div[3]/div/div"));
       gotItButton.click();
       int times = 2;
       for (int i = 0; i < times; i++) {
           ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");
           Thread.sleep(700); // adjust speed as needed
       }
       
       WebElement ownerButton = wait.until(ExpectedConditions.elementToBeClickable(
               By.xpath("(//button[contains(text(),'Get Owner Details')])[1]")
           ));

           // Use JavaScript to ensure it works reliably
           js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", ownerButton);
           js.executeScript("arguments[0].click();", ownerButton);
           
        
   	    WebElement number=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='tel' and @placeholder='Enter Mobile Number']")));
   	    number.click();
   	    number.sendKeys("9766596623");
   	    Thread.sleep(50000);

        


    

	    
	    
	    
	    
		
	    

	
}}

