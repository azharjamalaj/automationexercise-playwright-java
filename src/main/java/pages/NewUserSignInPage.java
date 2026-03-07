package pages;
import com.microsoft.playwright.Page;
public class NewUserSignInPage {
    private Page page;
    public String Txt_EnterAccountInformation = "text=Enter Account Information";
    public String Rdo_Mr = "input[value='Mr']";
    public String Rdo_Mrs = "input[value='Mrs']";

    public String InpTxt_Name = "#name:below(label:text('Name '))";
    public String InpTxt_Email = "#email:below(label:text('Email '))";
    public String InpTxt_Password = "#password:below(label:text('Password '))";
    public String DrpDwn_Day = "#days";
    public String DrpDwn_Month = "#months";
    public String DrpDwn_Year = "#years";

    public String ChckBox_Newsletter  = "input[name='newsletter'][type='checkbox']";
    public String ChckBox_Optin  = "input[name='optin'][type='checkbox']";
    public String InpTxt_First_Name  = "#first_name";
    public String InpTxt_Last_Name  = "#last_name";
    public String InpTxt_Company  = "#Company";
    public String InpTxt_Address  = "#address";
    public String InpTxt_Address2  = "#address2";
    public String DrpDwn_Country  = "#country";
    public String InpTxt_State = "#state";
    public String InpTxt_City  = "#city";
    public String InpTxt_ZipCode  = "#zipcode";
    public String InpTxt_MobileNumber  = "#mobile_number";

    public void signUpDetails()
    {
//        9. Fill details: Title, Name, Email, Password, Date of birth
//        10. Select checkbox 'Sign up for our newsletter!'
//        11. Select checkbox 'Receive special offers from our partners!'
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//        13. Click 'Create Account button'
//        14. Verify that 'ACCOUNT CREATED!' is visible
//        15. Click 'Continue' button
//        16. Verify that 'Logged in as username' is visible
//        17. Click 'Delete Account' button
//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        page.click(Rdo_Mr);
    }

    public boolean verifySignUpDetailsPage()
    {
        page.waitForLoadState();
        System.out.println(page.isVisible(Txt_EnterAccountInformation));
        return page.isVisible(Txt_EnterAccountInformation);
    }
}