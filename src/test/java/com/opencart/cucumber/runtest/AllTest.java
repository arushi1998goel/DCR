package com.opencart.cucumber.runtest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/*@RunWith(Cucumber.class)
@CucumberOptions(glue = { "com.dcr.api" },
		//features = "src/test/resources/features/API",
		features = "src/test/resources/features/API",
		format = { "pretty", "html:target/cucumberreports",
		"json:target/cucumber-reports/cucumber.json" }, tags = { "@TC20"})
public class   AllTest {
}*/

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "com.ui.dcr.stepdefs" },
		features = "src/test/resources/features/UI",
		format = { "pretty", "html:target/cucumberreports",
				"json:target/cucumber-reports/cucumber.json" }, tags = { "@UITC23"})
public class   AllTest {
}
