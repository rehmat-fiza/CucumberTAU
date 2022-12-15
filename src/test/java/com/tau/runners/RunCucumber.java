package com.tau.runners;


import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOperations(glue= {com.tau.steps}, features = "src/test/resources", plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json"})


public class RunCucumber {
	
	

}
