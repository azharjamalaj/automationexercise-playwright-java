package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    // Selectors for the Login fields
    public String InpTxt_Login_Email = "input[data-qa='login-email']";
    public String InpTxt_Login_Password = "input[data-qa='login-password']";
    public String Btn_Login = "button[data-qa='signup-button']";

    // Selectors for the Signup fields
    public String InpTxt_Signup_Name = "input[data-qa='signup-name']";
    public String InpTxt_Signup_Email = "input[data-qa='signup-email']";
    public String Btn_Signup = "button[data-qa='signup-button']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void loginUser()
    {
        page.fill(InpTxt_Login_Email, "azhar@gmail.com");
        page.fill(InpTxt_Login_Password,"Password");
        page.click(Btn_Login);
    }

    public NewUserSignInPage signUpUser(){
        // Enter name and email address
        page.fill(InpTxt_Signup_Name, "azhar");
        page.fill(InpTxt_Signup_Email,"azhar1@gmail.com");

        // Enter the signUp button
        page.click(Btn_Signup);
        return  new NewUserSignInPage();
    }

    public boolean signUpUsersFieldIsVisible()
    {
        return page.isVisible(InpTxt_Signup_Name);
    }

    public boolean LoginUsersFieldIsVisible()
    {
        return page.isVisible(InpTxt_Login_Email);
    }

}
