package com.automationexercise.tests;

import com.automationexercise.base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void login()
    {
        loginPage = landingPage.registerUser();
        loginPage.loginUser();
    }

}
