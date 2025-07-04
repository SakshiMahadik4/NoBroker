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

    public static WebDriver chromedriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.nobroker.in/home-services-in-chennai?nbFr=Home_page");
        driver.manage().window().maximize();
        System.out.println("ChromeDriver initialized and navigated to the website");
        return driver;
    }

//    public static WebDriver edgedriver() {
//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();
//        driver.get("http://practice.automationtesting.in/");
//        System.out.println("EdgeDriver initialized and navigated to the website");
//        return driver;
//    }

    public void teardown() {
        driver.close();
        System.out.println("Browser closed");
    }
}

