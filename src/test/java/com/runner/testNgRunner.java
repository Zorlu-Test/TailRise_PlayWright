package com.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// PWDEBUG=1 in order to debug
//trace.playwright.dev ## cloud trace
// mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip" ## Local trace
@CucumberOptions
        (

                features = "src/test/resources",
                glue = "com/step_Definitions"

        )

public class testNgRunner extends AbstractTestNGCucumberTests {





}
