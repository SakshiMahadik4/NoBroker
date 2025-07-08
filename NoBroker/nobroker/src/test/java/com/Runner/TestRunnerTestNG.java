package com.Runner;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resource/Feature/Commercial.feature",glue=("com.stepDefinition")
//plugin= {
//		"pretty:target/practo.txt",
//		"html:target/cucumber-testng-report.html",
//		"json:target/cucumber-report.json",
//		"junit:target/cucumber-report.xml"
//}
)

public class TestRunnerTestNG {

}
