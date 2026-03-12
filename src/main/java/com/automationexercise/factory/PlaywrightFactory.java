package com.automationexercise.factory;

import com.microsoft.playwright.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;

    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
    public static Playwright getPlaywright()
    {
        return tlPlaywright.get();
    }
    public static Browser getBrowser()
    {
        return tlBrowser.get();
    }
    public static BrowserContext getBrowserContext()
    {
        return tlBrowserContext.get();
    }
    public static Page getPage()
    {
        return tlPage.get();
    }

    public Page intiBrowser(Properties prop)
    {
        String browserName = prop.getProperty("browser");

        System.out.println("Launching browser " + browserName);

//        playwright = Playwright.create();
        tlPlaywright.set(Playwright.create());

        switch (browserName.toLowerCase())
        {
            case "chromium":
//                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "firefox":
//                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "safari":
//                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            default:
//                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
                break;
        }

//        browserContext = browser.newContext();
        tlBrowserContext.set(getBrowser().newContext());

//        page = browserContext.newPage();
        tlPage.set(getBrowserContext().newPage());

//        page.navigate(prop.getProperty("url"));
        getPage().navigate(prop.getProperty("url"));
        System.out.println(getPage().url());
        return getPage();
    }

//    This method is used for initialized the property
    public Properties properties_Initialization() throws IOException {
        FileInputStream fs = new FileInputStream("./src/resources/com.automationexercise.config/config.properties");
        prop = new Properties();
        prop.load(fs);
        return prop;
    }
//    take screenshots

    public static String takeScreenShot()
    {
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis()+ ".png";
        getPage().screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(path)).setFullPage(true));
        return path;
    }
}
