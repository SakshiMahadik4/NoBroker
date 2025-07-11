package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resource\\com.features\\Rent.feature",
glue={"com.stepdefinition"} , tags= "@location-filters", plugin = {"pretty"})
//		"html:target/CucumberReport.html",
//		"json:target/CucumberReport.json",
//	    "junit:target/CucumberReport.xml"})

public class TestRunnerJUNIT {
	

}
