package com.step_Definitions;


import com.pom.Pages;
import io.cucumber.java.en.*;
import org.testng.Assert;

import static com.Utilities.Driver_PlayWrite.driver;

public class Personal_Information extends Pages {


    @Given("I am on the Home page.")
    public void i_am_on_the_home_page() {
        driver().navigate("http://app.talrise.com.s3-website-eu-west-1.amazonaws.com/");
        logIn().logInMethod();
    }

    @When("I click on profile button at  side nodule")
    public void iClickOnProfileButtonAtSideNodule() {
        driver().waitForTimeout(1500);
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
        driver().reload();
        profile().personalInformation.click();
    }

    @Then("Verify entered values holding by application")
    public void verify_entered_values_holding_by_application() {

        String currentMobile = profile().mobile.getAttribute("value");
        String currentCountry = profile().country.textContent();
        String currentCity = profile().city.textContent();
        String currentCodeCountry = profile().countryCode.textContent();


        Assert.assertEquals(currentMobile, profile().mobileNumberSelected);
        Assert.assertEquals(currentCountry, profile().countrySelected);
        Assert.assertEquals(currentCity, profile().citySelected);
        Assert.assertEquals(currentCodeCountry, profile().countryCodeSelected);


    }

    @And("I set none filled places")
    public void iSetNoneFilledPlaces() {
        profile().setNonePersonalInformation();
    }

    @And("I click on cancel button")
    public void iClickOnCancelButton() {
        profile().cancel.click();
    }

    @And("I enter {string} mobile phone")
    public void iEnterMobilePhone(String mobileNumber) {
        profile().setMobileNumber(mobileNumber);
    }

    @Then("Verify mobile field error message appears")
    public void verifyMobileFieldErrorMessageAppears() {


    }


}
