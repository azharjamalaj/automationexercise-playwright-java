package com.automationexercise.base;

import com.automationexercise.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.LandingPage;
import pages.LoginPage;
import pages.NewUserSignInPage;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf ;
    Page page;

    Properties prop;
    protected LandingPage landingPage;
    protected LoginPage loginPage;
    protected NewUserSignInPage newUserSignInPage;
    @BeforeTest
    public void setup() throws IOException {
        pf = new PlaywrightFactory();
        prop =pf.properties_Initialization();
        page =pf.intiBrowser(prop);
        landingPage = new LandingPage(page);
    }

//    @AfterTest
//    public void tearDown()
//    {
//        page.context().browser().close();
//    }
}
