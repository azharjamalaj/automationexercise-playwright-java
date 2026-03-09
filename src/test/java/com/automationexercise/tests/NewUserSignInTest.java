package com.automationexercise.tests;

import com.automationexercise.base.BaseTest;
import com.automationexercise.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewUserSignInTest extends BaseTest {

    @Test
    public void newUserSignIn()
    {
        // Navigate to url 'http://automationexercise.com'
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
        newUserSignInPage = loginPage.signUpUser(prop.getProperty("username"),prop.getProperty("email"));

        System.out.println(newUserSignInPage);

        //  Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(newUserSignInPage.verifySignUpDetailsPage(),"Enter Account InformationDetails ");
        createAccountPage = newUserSignInPage.signUpDetails(prop.getProperty("password"));

        //  Verify that 'ACCOUNT CREATED!' is visible
        createAccountPage.verifyAccountIsCreated();

        String message = createAccountPage.verifyAccountCreatedMessage();

        Assert.assertEquals(message, AppConstants.CREATE_ACCOUNT_CONFIRMATION);

        //  Click 'Continue' button
        homePage =  createAccountPage.clickContinue();

        //  Verify that 'Logged in as username' is visible
        String loggedInAs= homePage.verifyLoggedInUser();
        Assert.assertTrue(loggedInAs.contains(prop.getProperty("username")));

        //  Click 'Delete Account' button
        deleteAccountPage =homePage.deleteAccount();

        //  Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String dltConfirmation =deleteAccountPage.verifyAccountDeleteConfirmation();
        Assert.assertEquals(dltConfirmation, AppConstants.DELETE_ACCOUNT_CONFIRMATION);

        String dltConfirmationMessage =deleteAccountPage.verifyAccountDeleteMessage();
        Assert.assertEquals(dltConfirmationMessage, AppConstants.DELETE_ACCOUNT_MESSAGE);

        deleteAccountPage.clickContinue();
        Assert.assertEquals(landingPage.getUrl(), prop.getProperty("url"));
    }
}
