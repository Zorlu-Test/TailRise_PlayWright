package com.step_Definitions;

import com.Utilities.Driver_PlayWrite;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

import java.nio.file.Paths;

import static com.Utilities.Driver_PlayWrite.closeDriver;
import static com.Utilities.Driver_PlayWrite.driver;

public class Hooks {

    @Before
    public void setUP() {


    }


    @After
    public void tearDown(Scenario scenario) {

        // Driver_PlayWrite.context().tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace/trace.zip")));

        String scenarioName = scenario.getName();
        scenarioName="trace/"+scenarioName+".zip";

        if (scenario.isFailed()) {

            byte[] screenshot = driver().screenshot();
            scenario.attach(screenshot, "image/png", scenario.getName());
            Driver_PlayWrite.context().tracing().stop(new Tracing.StopOptions().setPath(Paths.get(scenarioName)));
        }


        driver().pause();
        closeDriver();


    }


}
