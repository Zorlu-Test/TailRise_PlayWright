package com.Utilities;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.AfterClass;

import java.awt.*;
import java.nio.file.Paths;

public class Driver_PlayWrite {

    static Playwright playwright;
    static Browser browser;

    // New instance for each test method.
    static BrowserContext context;
    static Page page;


    public static Page driver() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        String browserSet = Configuration_Reader.getProperties("browser");

        if (playwright == null) {

            switch (browserSet.toLowerCase()) {

                case "chrome":
                    playwright = Playwright.create();
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
                    context = browser.newContext();
                    context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));


                    page = context.newPage();
                    page.setViewportSize(width, height);
                    break;
                case "firefox":
                    playwright = Playwright.create();
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    context = browser.newContext();
                    page = context.newPage();
                    page.setViewportSize(width, height);
                    break;
                case "webkit":
                    playwright = Playwright.create();
                    browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    context = browser.newContext();
                    page = context.newPage();
                    page.setViewportSize(width, height);
                    break;
                default:
                    System.out.println("Driver is not specified");
                    break;


            }


        }


        return page;
    }

    public static BrowserContext context() {

        return context;
    }


    public static void closeDriver() {

        browser.close();
        context.close();
        page.close();
        playwright.close();

//        browser.close();
//        context.close();

    }


}
