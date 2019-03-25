package com.joantolos.kata.mars.rover.acceptance;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:build/reports/acceptance/",
                "json:build/reports/acceptance/report.json"
        },
        features = "src/test/resources/features"
)
public class MarsRoverAcceptanceTests {
}