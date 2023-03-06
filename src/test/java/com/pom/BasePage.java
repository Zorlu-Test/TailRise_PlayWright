package com.pom;

import com.Utilities.Annotation.FindByPW;
import com.Utilities.Annotation.Injector;
import com.github.javafaker.Faker;
import com.microsoft.playwright.Locator;


import java.util.Locale;
import java.util.Random;

import static com.Utilities.Driver_PlayWrite.driver;

public abstract class BasePage extends Injector {

    public Random random = new Random();

    public Faker faker = new Faker(Locale.UK);


    public BasePage() {
        inject(driver(), this);
    }


}
