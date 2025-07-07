package com.pages;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CleaningservicePage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    @FindBy(xpath = "//button[text()='Book']")
    WebElement homeCleaning;

    @FindBy(xpath = "//div[@class=' text-14 font-bold flex justify-center items-center']")
    WebElement addToCartButton;

    @FindBy(xpath = "//input[@placeholder='Enter Mobile Number']")
    WebElement PhoneNumber;

    @FindBy(xpath = "//button[contains(text(),'Proceed')]")
    WebElement proceedbutton;

    @FindBy(xpath="//div[contains(@class,'font-bold text-22')]")
    WebElement Schedulepage;

    public CleaningservicePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action = new Actions(driver);
    }

    public void clickBook() {
        wait.until(ExpectedConditions.elementToBeClickable(homeCleaning));
        homeCleaning.click();
    }

    public void addToCart() {
        try {
            Thread.sleep(7000);
            Robot robot = new Robot();
            robot.mouseMove(300, 200);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            Thread.sleep(2000);

            String originalWindow = driver.getWindowHandle();

            // Wait for new window to open
            Set<String> allWindows = driver.getWindowHandles();
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            for (int i = 0; i < 6; i++) {
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                Thread.sleep(200);
            }

            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            addToCartButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(PhoneNumber));
        PhoneNumber.click();
        PhoneNumber.sendKeys("9067958631");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickProceed() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedbutton));
        proceedbutton.click();
    }
    
    public boolean assertSchedulepage() {
    	return Schedulepage.getText().equals("Schedule your Service");
    }
}
