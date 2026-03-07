package com.automationexercise.tests;
import com.automationexercise.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseTest {

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

    @Test(dataProvider = "navigationData")
    public void navigationMenu(String menuOption)
    {
        String menuActual =landingPage.menuNavigationHeaders(menuOption);
        System.out.println(menuActual);
        Assert.assertTrue(menuActual.trim().contains(menuOption));
    }

    @DataProvider
    public Object[][] navigationData()
    {
        return new Object[][]
                {
                        {"Home"},
                        {"Product"},
                        {"Cart"},
                        {"SignUpLogin"},
                        {"TestCases"},
                        {"ApiTesting"},
                        {"VideoTutorial"},
                        {"Contactus"}
                };
    }
}
