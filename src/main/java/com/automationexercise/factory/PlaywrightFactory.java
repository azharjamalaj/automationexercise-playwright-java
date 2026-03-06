package com.automationexercise.factory;

import com.microsoft.playwright.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;

    Page page;

    Properties prop;
    public Page intiBrowser(Properties prop)
    {
        String browserName = prop.getProperty("browser");

        System.out.println("Launching browser" + browserName);

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
        page.navigate(prop.getProperty("url"));
        return page;
    }

//    This method is used for initialized the property
    public Properties properties_Initialization() throws IOException {
        FileInputStream fs = new FileInputStream("./src/resources/com.automationexercise.config/config.properties");
        prop = new Properties();
        prop.load(fs);
        return prop;
    }
}
