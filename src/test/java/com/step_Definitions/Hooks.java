package com.step_Definitions;

import com.Utilities.Driver_PlayWrite;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

import java.nio.file.Paths;

public class Hooks {

    @Before
    public void setUP() {


    }


    @After
    public void tearDown() {

        // Driver_PlayWrite.context().tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace/trace.zip")));
        //  Driver_PlayWrite.driver().pause();

        Driver_PlayWrite.closeDriver();


    }


}
