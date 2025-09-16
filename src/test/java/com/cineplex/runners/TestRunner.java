package com.cineplex.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*
 * This class serves as the test runner for Cucumber tests.
 */
@RunWith(Cucumber.class)
@CucumberOptions(

    // Specify the path to the feature files
    features = "src/test/resources/features",

    // Specify the package for step definitions
    glue = {"com.cineplex.stepdefinitions", "com.cineplex.hooks"},

    // Specify the plugin for reporting
    plugin = {"pretty", "html:target/cucumber-reports.html"},

    // Specify the options for the Cucumber runner
    monochrome = true,

    // Publish the Cucumber report
    publish = true
)
public class TestRunner {
    
}
