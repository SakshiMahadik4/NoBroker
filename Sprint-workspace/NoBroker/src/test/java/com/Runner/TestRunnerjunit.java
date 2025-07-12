package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resource\\Features\\Buy.feature",
glue="com.stepDefinition",
//tags="@valid"
plugin = {
        "pretty",
        "json:target/jsonreport.json",
        "junit:target/junitReport.xml",
        "html:target/cucumberReport/HtmlReport5.html",
        "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}
)
public class TestRunnerjunit extends AbstractTestNGCucumberTests  {
	
}
