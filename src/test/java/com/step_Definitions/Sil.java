package com.step_Definitions;

import com.Utilities.Driver_PlayWrite;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.pom.Pages;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.Utilities.Driver_PlayWrite.*;

public class Sil extends Pages {


    @Test
    public void dnmmm() {

        driver().navigate("https://practice.automationtesting.in/my-account/");
        driver().getByLabel("Username or email address *").click();
        driver().getByLabel("Username or email address *").fill("dnm@gmail.com");
        driver().locator("#password").click();
        driver().locator("#password").fill("dnm@gmail.com");
        driver().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();


        Driver_PlayWrite.setAutoLogINContext();


    }

    @Test
    public void dnmmm222() {

        driver().navigate("https://practice.automationtesting.in/my-account/");


    }

    @Test
    public void dbnm333(){

        driver().navigate("http://app.talrise.com.s3-website-eu-west-1.amazonaws.com/");
        logIn().logInMethod();
        Driver_PlayWrite.setAutoLogINContext();

    }


    @Test
    public void dbnm444(){

        driver().navigate("http://app.talrise.com.s3-website-eu-west-1.amazonaws.com/");


    }



    @BeforeClass
    public void setUp() {


    }


    @AfterClass
    public void tearDown() {
        driver().pause();
        driver().close();

    }
}
