package com.qa.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(features="C:\\Users\\Ramki\\workspace\\FreeCRMBDDPOMFramework\\src\\main\\java\\com\\qa\\features\\Login.feature",
glue= {"com/qa/stepDefinitions"},
plugin= {"pretty","html:target/html/cucumber.html","json:target/json/cucumber.json",
"junit:target/xml/cucumber.xml"},
monochrome=true,
dryRun=false)

public class MyRunner
{

}
