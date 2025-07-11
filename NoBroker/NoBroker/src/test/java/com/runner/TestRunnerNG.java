package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src\\test\\resource\\com.features\\Rent.feature",
        glue = {"com.stepdefinition"},
        tags = "@NoBroker",
        plugin = {
                "pretty",
                "html:target/cucumberreport.html",
                "json:target/CucumberReport.json",
        	    "junit:target/CucumberReport.xml",									
        		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class TestRunnerNG extends AbstractTestNGCucumberTests {

   
}
