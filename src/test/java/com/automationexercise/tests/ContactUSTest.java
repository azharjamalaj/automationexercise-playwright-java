package com.automationexercise.tests;

import com.automationexercise.base.BaseTest;
import com.automationexercise.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUSTest extends BaseTest {

    //    Test Case 1: Register User
    @Test
    public void navigateToContactUsPage() {

       /*
        5.
        6.
        10. */

        // Navigate to url 'http://automationexercise.com'
        String url = landingPage.getUrl();
        Assert.assertEquals(url, "https://automationexercise.com/", "Invalid url");

        // Verify that home page is visible successfully
        String title = landingPage.getLandingPageTitle();
        Assert.assertEquals(title, "Automation Exercise", "Invalid homepage title");

        // Click on 'Contact Us' button
        contactUsPage = landingPage.navigateToContactUSPage();

        //  Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(contactUsPage.contactUsPageAppears(), "Sign Up details is not visible");

        //  Enter name, email, subject and message , Upload file ,Click 'Submit' button

        contactUsPage.contactUsDetails("azhar", "jamal@gmail.com", "playwright with java", "Learn PW with Java ");

        //   Click OK button
        System.out.println("Pop up is visible");
        contactUsPage.clickPopUP();

        //  Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertEquals(contactUsPage.successMessage(), AppConstants.CONTACT_US_MESSAGE);

        // Click 'Home' button and verify that landed to home page successfully

        landingPage = contactUsPage.clickHomeButton();
        Assert.assertEquals(landingPage.getUrl(), prop.getProperty("url"));
    }

}
