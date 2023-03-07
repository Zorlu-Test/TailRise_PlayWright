package com.Utilities;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.AfterClass;

import java.awt.*;
import java.nio.file.Paths;

public class Driver_PlayWrite {

    static private Playwright playwright;
    static private Browser browser;

    static private BrowserContext context;
    static private Page page;

    private Driver_PlayWrite() {
    }

    public static Page driver() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        String browserSet = Configuration_Reader.getProperties("browser");

        if (page == null) {

            switch (browserSet.toLowerCase()) {

                case "chrome":
                    playwright = Playwright.create();
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
                 //   context = browser.newContext();
                    context = getAutoLogINContext(); // that part sets auto login if any
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

    /**
     * this method sets json file only use one time in order to generate json file
     * */
    public static BrowserContext setAutoLogINContext() {
        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("autoLogIn.json")));
        return context;
    }

    /**
     * This method sets auto login to context if any
     * */
    public static BrowserContext getAutoLogINContext() {
        try {
            context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("autoLogIn.json")));
        }catch (PlaywrightException e){
            context = browser.newContext();
        }

        return context;
    }






    public static void closeDriver() {

        if (page != null) {
            page.close();
            context.close();
            browser.close();
            playwright.close();
            page = null;
        }


    }


}
