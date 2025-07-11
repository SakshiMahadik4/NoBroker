package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Windows\\System32\\config\\systemprofile\\SprintWorkspace\\NoBroker\\src\\test\\resource\\Features\\Painting&Cleaning.feature",
     glue="com.stepDefinition",
     tags="@CorporateEnquiry"
     )
public class TestRunnerjunit {

}
