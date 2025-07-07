package com.setup;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.parameters.PropertyReader;

public class BaseSetup{

    private static WebDriver driver;

    // This method ensures that only one driver instance is created
    @SuppressWarnings("static-access")
	public static WebDriver initializeDriver(String browser) {
        if (driver != null) {
            return driver;  // Return the existing driver if already initialized
        }
        try {
            Properties pro = new PropertyReader().propertyReaderMethod();
            String url = pro.getProperty("url");  // Reading the URL from properties file

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

    // Returns the existing driver instance
    public static WebDriver getDriver() {
        return driver;
    }

    // Quits the driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Reset driver after quitting
        }
    }
}
