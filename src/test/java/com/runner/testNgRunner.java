package com.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// PWDEBUG=1 in order to debug
//trace.playwright.dev ## cloud trace
// mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip" ## Local trace
@CucumberOptions
        (
                plugin = {
                        "json:target/cucumber.json",
                        "html:target/cucumber-report.html",
                        "rerun:target/rerun.txt",
                        "me.jvt.cucumber.report.PrettyReports:target/cucumber"
                },
                features = "src/test/resources",
                glue = "com/step_Definitions",
                tags = "@dnm"
        )

public class testNgRunner extends AbstractTestNGCucumberTests {





}
