package com.pages;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesAgreementPage extends BasePage {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	 @FindBy(xpath = "//div[text()='Sales Agreement']")
	    WebElement SalesAgreementButton;
	 
	 @FindBy(xpath = "//div[contains(text(),'Menu')]")
	    WebElement Menu;
	
	 @FindBy(xpath = "//div[contains(text(),'Corporate Enquiry')]")
	    WebElement CorpEnquiry;
	 
	 @FindBy(xpath = "//button[contains(text(),'Know more')]")
	    WebElement knowMorebtn;
	 
	 @FindBy(how=How.ID,using="input_name_id_2")
		WebElement nameField;
	 
	 @FindBy(how=How.ID,using="input_Company_id")
	    WebElement companyField;
	 
	 @FindBy(how=How.ID,using="input_Email_id")
	    WebElement emailField;
	 
	 @FindBy(how=How.ID,using="input_Phone_id")
	    WebElement phoneField;
	 
	 @FindBy(how=How.ID,using="CityId_popup")
	    WebElement cityField;
	 
	 @FindBy(how=How.ID,using="PopupNameOfNumberOFEmpID")
	    WebElement NumOfEmpField;
	 
	 @FindBy(xpath="//button[contains(text(),'Connect with us')]")
	    WebElement ConnectButton;
	 
	public SalesAgreementPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
        if (driver != null) {
            this.action = new Actions(driver);
        } else {
            throw new IllegalArgumentException("Driver cannot be null");
        }
	}

	public void clickSalesAgreement() {
		 waitUntilWebElementIsClickable(SalesAgreementButton);
	     action.moveToElement(SalesAgreementButton).click().build().perform();
	}
	
	public void clickMenuAndselectCorporatEnquiry() throws InterruptedException {
		 //waitUntilWebElementIsClickable(Menu);
		Thread.sleep(3000);
		 Menu.click();
		 
		 Robot robot;
		try {
			robot = new Robot();
			for(int i=0;i<6;i++)
			 {
				 robot.keyPress(KeyEvent.VK_DOWN);
				 robot.keyRelease(KeyEvent.VK_DOWN);
				 Thread.sleep(200);
			 }
			
			waitUntilWebElementIsVisible(CorpEnquiry);
			action.moveToElement(CorpEnquiry).click().build().perform();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void clickKnowMore() {
		 waitUntilWebElementIsClickable(knowMorebtn);
		 knowMorebtn.click();
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void fillForm(String name,String company,String email,String phone,String city,String employees) {
		waitUntilWebElementIsVisible(nameField);
		nameField.sendKeys(name);
		companyField.sendKeys(company);
		emailField.sendKeys(email);	
		phoneField.sendKeys(phone);
		waitUntilWebElementIsClickable(cityField);
			Select select=new Select(cityField);
			select.selectByVisibleText(city); 
		NumOfEmpField.sendKeys(employees);	
	}
	

     public void clickConnect() throws InterruptedException {
    	 try {
			Robot robot=new Robot();
			robot.mouseMove(630,610);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);		}
    	 catch (Exception e) {
			e.printStackTrace();
		}
 }

}
