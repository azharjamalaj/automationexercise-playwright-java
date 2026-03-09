package com.automationexercise.base;

import com.automationexercise.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf ;
    Page page;

    protected Properties prop;
    protected LandingPage landingPage;
    protected LoginPage loginPage;
    protected NewUserSignInPage newUserSignInPage;
    protected CreateAccountPage createAccountPage;
    protected DeleteAccountPage deleteAccountPage;
    protected HomePage homePage;
    @BeforeTest
    public void setup() throws IOException {
        pf = new PlaywrightFactory();
        prop =pf.properties_Initialization();
        page =pf.intiBrowser(prop);
        landingPage = new LandingPage(page);
    }
    @AfterTest
    public void tearDown()
    {
        page.context().browser().close();
    }
}
