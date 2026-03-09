package pages;
import com.microsoft.playwright.Page;
public class NewUserSignInPage {
    private Page page;
    public String Txt_EnterAccountInformation = "text='Enter Account Information'";
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
    public String InpTxt_Company  = "#company";
    public String InpTxt_Address  = "#address1";
    public String InpTxt_Address2  = "#address2";
    public String DrpDwn_Country  = "#country";
    public String InpTxt_State = "#state";
    public String InpTxt_City  = "#city";
    public String InpTxt_ZipCode  = "#zipcode";
    public String InpTxt_MobileNumber  = "#mobile_number";

    public String Btn_Create_Account  = "button[data-qa='create-account']";


    public NewUserSignInPage(Page page)
    {
        this.page = page;
    }
    public CreateAccountPage signUpDetails(String password)
    {
        //  Fill details: Title, Name, Email, Password, Date of birth
        page.waitForSelector(Rdo_Mr);

        page.locator(Rdo_Mr).click();

        page.fill(InpTxt_Password, password);

        page.locator(DrpDwn_Day).selectOption("1");

        page.locator(DrpDwn_Month).selectOption("January");
        page.locator(DrpDwn_Year).selectOption("2000");

        //  Select checkbox 'Sign up for our newsletter!'
        page.click(ChckBox_Newsletter);

        //  Select checkbox 'Receive special offers from our partners!'
        page.click(ChckBox_Optin);

        //  Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        page.fill(InpTxt_First_Name, "Azhar");

        page.fill(InpTxt_Last_Name, "Jamal");

        page.fill(InpTxt_Company, "Zensar");

        page.fill(InpTxt_Address, "Bangalore 560001");

        page.fill(InpTxt_Address2, "WhiteField");

        page.locator(DrpDwn_Country).selectOption("India");

        page.fill(InpTxt_State, "Karnataka");

        page.fill(InpTxt_City, "Bengaluru");

        page.fill(InpTxt_ZipCode, "560001");

        page.fill(InpTxt_MobileNumber, "9000090000");

        // Click 'Create Account button'
        page.click(Btn_Create_Account);

        return new CreateAccountPage(page);

    }

    public boolean verifySignUpDetailsPage()
    {
        page.locator(Txt_EnterAccountInformation).waitFor();
        System.out.println(page.isVisible(Txt_EnterAccountInformation));
        return page.isVisible(Txt_EnterAccountInformation);
    }
}