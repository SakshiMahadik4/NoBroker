package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resource\\Features\\Buy.feature",
glue="com.stepDefinition",
tags="@filters")
public class TestRunnerjnuit {

}
