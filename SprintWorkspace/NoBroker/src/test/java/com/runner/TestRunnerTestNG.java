package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\Windows\\System32\\config\\systemprofile\\SprintWorkspace\\NoBroker\\src\\test\\resource\\Features\\Painting&Cleaning.feature",
glue="com.stepDefinition",

plugin= {"pretty:target/pretty.txt",
		
		"html:target/cucumberreport/htmlreport.html",
		
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		})


public class TestRunnerTestNG extends AbstractTestNGCucumberTests{

}
