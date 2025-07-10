package com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resource/Features/Buy.feature",
    glue = { "com.stepDefinition", "com.setup" },
    tags = "@valid",
    plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
)
public class TestRunnerTestng extends AbstractTestNGCucumberTests {

}
