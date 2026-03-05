package com.automationexercise.tests;

import com.automationexercise.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LandingPage;

public class LandingPageTest {
    PlaywrightFactory pf ;
    Page page;
    LandingPage landingPage;
    @BeforeTest
    public void setup()
    {
        pf = new PlaywrightFactory();
        page =pf.intiBrowser("chromium");
        landingPage = new LandingPage(page);
    }

    @Test
    public void getTheLandingPageTtile()
    {
        String title =landingPage.getLandingPageTitle();
        Assert.assertEquals(title, "Automation Exercise");
    }

    @Test
    public void getTheLandingPageURL()
    {
        String url =landingPage.getUrl();
        Assert.assertEquals(url, "https://automationexercise.com/");
    }

//    @Test
//    public void navigationMenu(String menuName)
//    {
//        String url =landingPage.menuNavigationHeaders("Home");
//        Assert.assertEquals(url, "https://automationexercise.com/");
//    }
    @AfterTest
    public void tearDown()
    {
        page.context().browser().close();
    }
}
