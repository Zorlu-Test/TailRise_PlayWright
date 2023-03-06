package com.pom;

import com.Utilities.Annotation.FindByPW;
import com.microsoft.playwright.Locator;

public class Dash_Board extends BasePage{

    @FindByPW(locator = "//*[contains(text(),'Profile')]")
    public Locator profile;




}
