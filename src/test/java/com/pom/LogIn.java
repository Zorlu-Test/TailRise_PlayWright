package com.pom;

import com.Utilities.Annotation.FindByPW;
import com.Utilities.Configuration_Reader;
import com.Utilities.Driver_PlayWrite;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

import static com.Utilities.Driver_PlayWrite.driver;

public class LogIn extends BasePage {

    @FindByPW(locator = "//*[@id='email']")
    public Locator email;

    @FindByPW(locator = "id=password")
    public Locator password;

    @FindByPW(locator = "//*[contains(text(),'LOGIN')]")
    public Locator logIn;

    public void logInMethod() {
        email.type(Configuration_Reader.getProperties("email"));
        password.type(Configuration_Reader.getProperties("password"));
        logIn.click();
    }







}
