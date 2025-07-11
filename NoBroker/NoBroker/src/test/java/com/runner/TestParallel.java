package com.runner;
 
 
import org.testng.annotations.DataProvider;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
//import io.cucumber.junit.CucumberOptions;
 
 
@CucumberOptions(features ="src\\test\\resource\\com.features\\Rent.feature",
glue="com.stepdefinition",
tags =  "@NoBroker" , 
plugin = {"pretty","html:target/Html/cucumberReport.html",
		"json:target/JSONReport/js.json",
		"junit:target/JunitReport/Junit.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}) 
public class TestParallel extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){ 
		return super.scenarios();
	}
}
