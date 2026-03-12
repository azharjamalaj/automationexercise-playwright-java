package com.automationexercise.tests;

import com.automationexercise.base.BaseTest;
import com.automationexercise.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

//    Test Case 2: Login User with correct email and password + Test Case 4: Logout User
    @Test
    public void loginWithValidUser()
    {
        // Verify that home page is visible successfully
        String title = landingPage.getLandingPageTitle();
        Assert.assertEquals(title, "Automation Exercise", "Invalid homepage title");

        // Click on 'Signup / Login' button
        loginPage = landingPage.registerUser();

        // Verify 'New User Signup!' is visible
        Assert.assertTrue(loginPage.signUpUsersFieldIsVisible(),"Sign Up details is not visible");

        // Verify 'Login to your account' is visible
        Assert.assertTrue(loginPage.LoginUsersFieldIsVisible(),"login details is not visible");;

        //  Enter correct email address and password
        homePage =loginPage.loginUser(prop.getProperty("user-email"),prop.getProperty("user-password"));

        //  Verify that 'Logged in as username' is visible
        String loggedInAs= homePage.verifyLoggedInUser();
        Assert.assertTrue(loggedInAs.contains(prop.getProperty("username")));

        //  Click 'Logout' button
        landingPage =homePage.clickLogout();

        //Verify that user is navigated to login page
        Assert.assertEquals(landingPage.getUrl(), prop.getProperty("url")+"login");


    }

//    Test Case 3: Login User with incorrect email and password
    @Test(priority = 2)
    public void loginWithInvalidUser()
    {
        // landingPageURL
        landingPage.landingPageURL(prop.getProperty("url"));

        // Verify that home page is visible successfully
        String title = landingPage.getLandingPageTitle();
        Assert.assertEquals(title, "Automation Exercise", "Invalid homepage title");

        // Click on 'Signup / Login' button
        loginPage = landingPage.registerUser();

        // Verify 'New User Signup!' is visible
        Assert.assertTrue(loginPage.signUpUsersFieldIsVisible(),"Sign Up details is not visible");

        // Verify 'Login to your account' is visible
        Assert.assertTrue(loginPage.LoginUsersFieldIsVisible(),"login details is not visible");;

        //  Enter incorrect email address or password
        loginPage.loginUser(prop.getProperty("user-email"),prop.getProperty("invalid-user-password"));

        //  Verify error 'Your email or password is incorrect!' is visible

        Assert.assertEquals(loginPage.getInvalidTextMessage(),AppConstants.INVALID_ERROR_MESSAGE,"User Successfully Login");
    }
}
