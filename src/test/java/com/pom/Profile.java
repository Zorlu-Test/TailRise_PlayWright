package com.pom;

import com.Utilities.Annotation.FindByPW;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;

import java.util.List;
import java.util.Locale;

import static com.Utilities.Driver_PlayWrite.driver;

public class Profile extends BasePage {


    @FindByPW(locator = "//span[contains(text(),'Personal Information')]")
    public Locator personalInformation;

    @FindByPW(locator = "id=countryId-select-input-id")
    public Locator country;

    @FindByPW(locator = "//ul/li")
    public Locator countriesList;

    @FindByPW(locator = "id=cityId-select-input-id")
    public Locator city;

    @FindByPW(locator = "//div//li")
    public Locator cityList;

    @FindByPW(locator = "id=countryPhoneCode-select-input-id")
    public Locator countryCode;

    @FindByPW(locator = "//div//li")
    public Locator countryCodeList;

    @FindByPW(locator = "//input[@name='mobile']")
    public Locator mobile;

    @FindByPW(locator = "(//div/button[@label='save'])[1]")
    public Locator save;


    /**
     * This method selects random country from list
     */
    public void selectCountry() {
        country.click();
        int randomNumber = random.nextInt(countriesList.count() - 1) + 1;

        countriesList.nth(randomNumber).click();
    }

    /**
     * This method selects specified country if exists or select none.
     */
    public void selectCountry(String countryName) {
        country.click();

        for (int i = 0; i < countriesList.count(); i++) {
            if (countriesList.nth(i).textContent().equals(countryName)) {
                countriesList.nth(i).click();
                break;
            }
            if (i == countriesList.count() - 1) {
                System.out.println("Country does not within the list so automatically selected none");
                countriesList.nth(0).click();
            }
        }

    }


    /**
     * This method selects random city from list
     */
    public void selectCity() {
        city.click();
        int randomNumber = random.nextInt(cityList.count() - 1) + 1;

        cityList.nth(randomNumber).click();
    }


    /**
     * This method selects specified city if exists or select none.
     */
    public void selectCity(String countryName) {
        city.click();

        for (int i = 0; i < cityList.count(); i++) {
            if (cityList.nth(i).textContent().equals(countryName)) {
                cityList.nth(i).click();
                break;
            }
            if (i == cityList.count() - 1) {
                System.out.println("City does not within the list so automatically selected none");
                cityList.nth(0).click();
            }
        }

    }


    /**
     * This method selects random country code from list
     */
    public void selectCountryCode() {
        countryCode.click();
        int randomNumber = random.nextInt(countryCode.count() - 1) + 1;

        countryCode.nth(randomNumber).click();
    }


    /**
     * This method selects specified Country Code if exists or select none.
     */
    public void selectCountryCode(String countryName) {
        countryCode.click();

        for (int i = 0; i < cityList.count(); i++) {
            if (countryCodeList.nth(i).textContent().equals(countryName)) {
                countryCodeList.nth(i).click();
                break;
            }
            if (i == countryCodeList.count() - 1) {
                System.out.println("Country code does not within the list so automatically selected none");
                countryCodeList.nth(0).click();
            }
        }
    }


    /**
     * This method selects specified Country Code if exists or select none.
     */
    public void setMobileNumber() {
        mobile.clear();
        mobile.type(faker.phoneNumber().cellPhone().replace(" ", ""));
    }


}
