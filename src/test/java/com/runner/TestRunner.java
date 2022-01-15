package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/com/features"},
		glue= {"stepdefenations", "com/hooks"},
		dryRun=false,
		monochrome = true,
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"},
		publish=true,
		tags="@Regression"
		)


public class TestRunner {

}
