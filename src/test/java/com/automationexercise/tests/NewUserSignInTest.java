package com.automationexercise.tests;

import com.automationexercise.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewUserSignInTest extends BaseTest {

    @Test
    public void newUserSignIn() {
        // Navigate to url 'http://automationexercise.com/'
        String url = landingPage.getUrl();
        Assert.assertEquals(url, "https://automationexercise.com/", "Invalid url");

        // Verify that home page is visible successfully
        String title = landingPage.getLandingPageTitle();
        Assert.assertEquals(title, "Automation Exercise", "Invalid homepage title");

        // Click on 'Signup / Login' button
        loginPage = landingPage.registerUser();

        // Verify 'New User Signup!' is visible
        Assert.assertTrue(loginPage.signUpUsersFieldIsVisible(),"Sign Up details is not visible");

        // Enter the  name, email and click signup button
        newUserSignInPage = loginPage.signUpUser();

        //  Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(newUserSignInPage.verifySignUpDetailsPage(),"Enter Account Information is not visible");

    }
}
