package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ContactUsPage {
    private Page page;
    // Selectors for the Login fields
    private Locator Txt_GetInTouch ;

    private Locator InpTxt_Name ;
    private Locator InpTxt_Email;

    private Locator InpTxt_Subject ;

    private Locator InpTxt_Message ;

    private Locator Btn_Upload_File ;

    private Locator Btn_submit ;

    private Locator Txt_Success_Message;

    private  Locator Btn_Home;

    public ContactUsPage(Page page) {
        this.page =page;
        this.Txt_GetInTouch = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Get In Touch"));//= "text=Contact ";

        this.InpTxt_Name = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Name"));
        this.InpTxt_Email = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email").setExact(true));
        this.InpTxt_Subject = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Subject"));
        this.InpTxt_Message = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Your Message Here"));
        this.Btn_Upload_File = page.locator("input[type='file']");
        this.Btn_submit = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")) ;
        this.Txt_Success_Message = page.locator("#contact-page").getByText("Success! Your details have");
        this.Btn_Home = page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Home"));
    }

    public boolean contactUsPageAppears()
    {
        return Txt_GetInTouch.isVisible();
    }


    public void contactUsDetails(String name, String email, String subject, String message)
    {
        InpTxt_Name.fill(name);
        InpTxt_Email.fill(email);
        InpTxt_Subject.fill(subject);
        InpTxt_Message.fill(message);
        Btn_Upload_File.setInputFiles(Paths.get("screenshots/1773129045787.png"));
        Btn_submit.click();
    }

    public void clickPopUP()
    {
        page.onDialog( dialog -> {
            System.out.println(dialog.message());
            dialog.accept("In Alert prompt text");
        });
    }

    public LandingPage clickHomeButton()
    {
        Btn_Home.click();
        return new LandingPage(page);
    }

    public String successMessage()
    {
        return Txt_Success_Message.textContent();
    }
}
