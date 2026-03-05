package com.automationexercise.factory;

import com.microsoft.playwright.*;

import java.util.Locale;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;

    Page page;
    public Page intiBrowser(String browserName)
    {
        System.out.println("Enter the browser of your choice");

        playwright = Playwright.create();

        switch (browserName.toLowerCase())
        {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://automationexercise.com/");
        return page;
    }
}
