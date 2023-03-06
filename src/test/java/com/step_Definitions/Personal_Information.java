package com.step_Definitions;


import com.Utilities.Driver_PlayWrite;
import com.pom.Dash_Board;
import com.pom.Pages;
import io.cucumber.java.en.*;

public class Personal_Information extends Pages {


    @Given("I am on the Home page.")
    public void i_am_on_the_home_page() {
        Driver_PlayWrite.driver().navigate("http://app.talrise.com.s3-website-eu-west-1.amazonaws.com/");
        logIn().logInMethod();
    }

    @When("I click on profile button at  side nodule")
    public void iClickOnProfileButtonAtSideNodule() {
        dashBoard().profile.click();
        profile().personalInformation.click();
    }


    @When("I select country")
    public void i_select_country() {
        profile().selectCountry();
    }

    @When("I select City")
    public void i_select_city() {
        profile().selectCity();
    }

    @When("I select country code")
    public void i_select_country_code() {
        profile().selectCountryCode("+44");
    }

    @When("I enter mobile phone")
    public void i_enter_mobile_phone() {
        profile().setMobileNumber();
    }

    @When("I click save button")
    public void i_click_save_button() {
        profile().save.click();
    }

    @When("I refresh page")
    public void i_refresh_page() {

    }

    @Then("Verify entered values holding by application")
    public void verify_entered_values_holding_by_application() {

    }


//    @AfterClass
//    public void tearDown() {
//        Driver_PlayWrite.driver().pause();
//        Driver_PlayWrite.context().tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace/trace.zip")));
//        Driver_PlayWrite.closeDriver();
//
//    }

}
