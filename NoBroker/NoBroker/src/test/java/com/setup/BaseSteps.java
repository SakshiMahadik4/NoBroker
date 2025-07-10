package com.setup;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.parameters.ConfigReader;

public class BaseSteps{

    private static WebDriver driver;

	public static WebDriver initializeDriver(String browser) {
        try {
            Properties pro = new ConfigReader().propertyReaderMethod();
            String url = pro.getProperty("url");

            // Initializing the driver based on the browser passed
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("start-maximized", "disable-notifications");
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("start-maximized", "disable-notifications");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            driver.get(url);  // Navigate to the URL after initializing the driver
            return driver;

        } catch (Exception e) {
            System.out.println("Error while initializing " + browser + ": " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    
    }
    // Quits the driver
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Reset driver after quitting
        }
    }
}
