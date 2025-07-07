package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resource\\com.features\\Rent.feature",
glue={"com.stepdefinition"} , tags= "@loan")

public class TestRunner {
	
	

}
