package pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;

    public String Txt_LoggedInAs  = "text=' Logged in as'";

    public String Btn_Delete_Account  = "text='Delete Account'";

    public String Btn_Continue  = "a[data-qa='continue-button']";

    public HomePage(Page page)
    {
        this.page =page;
    }

    public String verifyLoggedInUser()
    {
        return page.textContent(Txt_LoggedInAs);
    }

    public DeleteAccountPage deleteAccount()
    {
        page.click(Btn_Delete_Account);
        return new DeleteAccountPage(page);
    }

}
