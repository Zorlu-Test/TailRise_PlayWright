package com.pom;

import com.Utilities.Annotation.FindByPW;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;

import java.util.List;
import java.util.Locale;

import static com.Utilities.Driver_PlayWrite.driver;

public class Profile extends BasePage {

    static public String mobileNumberSelected;
    static public String countrySelected;
    static public String citySelected;
    static public String countryCodeSelected;


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

    @FindByPW(locator = "(//div/button[@label='cancel'])[1]")
    public Locator cancel;

    @FindByPW(locator = "//p[@id='text-field-input-helper-text']")
    public Locator mobileErrorMsg;




    /**
     * This method selects random country from list
     */
    public void selectCountry() {
        country.click();
        int randomNumber = random.nextInt(countriesList.count() - 1) + 1;

        countrySelected = countriesList.nth(randomNumber).textContent();
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
                countrySelected = countriesList.nth(i).textContent();
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

        citySelected = cityList.nth(randomNumber).textContent();
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
                citySelected = cityList.nth(i).textContent();
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
        countryCodeSelected = countryCode.nth(randomNumber).textContent();

    }


    /**
     * This method selects specified Country Code if exists or select none.
     */
    public void selectCountryCode(String countryName) {
        countryCode.click();

        for (int i = 0; i < cityList.count(); i++) {
            if (countryCodeList.nth(i).textContent().equals(countryName)) {
                countryCodeList.nth(i).click();
                countryCodeSelected = countryCodeList.nth(i).textContent();
                break;
            }
            if (i == countryCodeList.count() - 1) {
                System.out.println("Country code does not within the list so automatically selected none");
                countryCodeList.nth(0).click();
            }
        }
    }


    /**
     * This method enter random UK mobile number
     */
    public void setMobileNumber() {
        mobileNumberSelected = faker.phoneNumber().cellPhone().replace(" ", "");
        mobile.clear();
        mobile.type(mobileNumberSelected);
    }

    /**
     * This method enter custom mobile number
     */
    public void setMobileNumber(String number) {
        mobileNumberSelected = number;
        mobile.clear();
        mobile.type(mobileNumberSelected);
    }






    /**
     * This method  sets none values at the personal information
     */
    public void setNonePersonalInformation() {

        city.click();
        cityList.nth(0).click();
        countryCode.click();
        countryCodeList.nth(0).click();
        country.click();
        countriesList.nth(0).click();
        mobile.clear();

    }


}
