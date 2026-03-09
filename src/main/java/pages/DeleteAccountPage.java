package pages;

import com.microsoft.playwright.Page;

public class DeleteAccountPage {

    private Page page;

    public String Txt_Delete_Account_Confrimation = "text='Account Deleted!'";

    public String Txt_Delete_Account_Confrimation_Message  = "text='Your account has been permanently deleted!'";

    public String Btn_Continue  = "a[data-qa='continue-button']";

    public DeleteAccountPage(Page page)
    {
        this.page =page;
    }


    public String verifyAccountDeleteConfirmation()
    {
        return page.textContent(Txt_Delete_Account_Confrimation);
    }

    public String verifyAccountDeleteMessage()
    {
        page.waitForSelector(Txt_Delete_Account_Confrimation_Message);
        return page.textContent(Txt_Delete_Account_Confrimation_Message);
    }

    public void clickContinue()
    {
        page.click(Btn_Continue);
    }

}
