package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src\\test\\resource\\com.features\\Rent.feature",
        glue = {"com.stepdefinition"},
        tags = "@loan",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumberReport-scenarios.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class TestCrossBrowser extends AbstractTestNGCucumberTests {

    //Initialize browser before each test
	@BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(String browser) {
        System.setProperty("browser", browser);
    }
}
