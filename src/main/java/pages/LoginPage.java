package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    // Selectors for the Login fields
    public String InpTxt_Login_Email = "input[data-qa='login-email']";
    public String InpTxt_Login_Password = "input[data-qa='login-password']";
    public String Btn_Login = "button[data-qa='login-button']";

    // Selectors for the Signup fields
    public String InpTxt_Signup_Name = "input[data-qa='signup-name']";
    public String InpTxt_Signup_Email = "input[data-qa='signup-email']";
    public String Btn_Signup = "button[data-qa='signup-button']";

    public String Txt_Invalid_Error_Mes =  "text=Your email or password is incorrect!";

    public String Txt_AlreadyUsed_Error_Mes = "text=Email Address already exist";

    public LoginPage(Page page) {
        this.page = page;
    }

    public HomePage loginUser(String useremail, String userpassword)
    {
        page.fill(InpTxt_Login_Email, useremail );
        page.fill(InpTxt_Login_Password,userpassword);
        page.click(Btn_Login);

        return new HomePage(page);
    }

    public NewUserSignInPage signUpUser(String username, String email){
        // Enter name and email address
        page.fill(InpTxt_Signup_Name, username);
        page.fill(InpTxt_Signup_Email,email);

        // Enter the signUp button
        page.click(Btn_Signup);
        return  new NewUserSignInPage(page);
    }

    public boolean signUpUsersFieldIsVisible()
    {
        page.waitForSelector(InpTxt_Signup_Email);
        return page.isVisible(InpTxt_Signup_Name);
    }

    public String alreadyEmailUsedErrorMessage()
    {
        return page.textContent(Txt_AlreadyUsed_Error_Mes);
    }

    public boolean LoginUsersFieldIsVisible()
    {
        return page.isVisible(InpTxt_Login_Email);
    }

    public String getInvalidTextMessage()
    {
        return page.textContent(Txt_AlreadyUsed_Error_Mes);
    }

}
