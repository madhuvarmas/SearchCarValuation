package com.valuation.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "target/test-classes"},
        plugin = {
                "pretty", "html:target/Valuation-Search-Test-Report",
                "json:target/Valuation-Search-Test-Report/cucumber.json",
                "rerun:target/Valuation-Search-Test-Report/rerun.txt"},
        tags = "@search",
        glue = {"com/valuation/stepdefinitions/"})
public class TestRunner {
}
