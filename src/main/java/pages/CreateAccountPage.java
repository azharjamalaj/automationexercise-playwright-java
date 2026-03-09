package pages;

import com.microsoft.playwright.Page;

public class CreateAccountPage {

    private Page page;

    public String Txt_Create_Account  = "text=Account Created!";

    public String Txt_Message  = "text=Congratulations! Your new";

    public String Btn_Continue  = "a[data-qa='continue-button']";

    public CreateAccountPage(Page page)
    {
        this.page =page;
    }

    public String verifyAccountIsCreated()
    {
        return page.textContent(Txt_Create_Account);
    }

    public String verifyAccountCreatedMessage()
    {
        return page.textContent(Txt_Message);
    }

    public HomePage clickContinue()
    {
        page.click(Btn_Continue);
        return new HomePage(page);
    }

}
