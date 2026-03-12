package pages;

import com.microsoft.playwright.Page;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ContactUsPage {
    private Page page;
    // Selectors for the Login fields
    public String Txt_Contact_Us = "text=Contact ";

    public String InpTxt_Name = "input[name='name']";

    public String InpTxt_Email = "input[name='email']";

    public String InpTxt_Subject = "input[name='subject']";

    public String InpTxt_Message = "input[name='message']";

    public String Btn_Upload_File = "input[name='upload_file']";

    public String Btn_submit = "input[name='submit']";

    public ContactUsPage(Page page) {
        this.page = page;
    }

    public boolean contactUsPageAppears()
    {
        return page.isVisible(Txt_Contact_Us);
    }

    public void contactUsDetails()
    {
        page.fill(InpTxt_Name,"");
        page.fill(InpTxt_Email,"");
        page.fill(InpTxt_Subject,"");
        page.fill(InpTxt_Message,"");

        page.setInputFiles(Btn_Upload_File, Paths.get("screenshots/1773129045787.png"));
        System.out.println("File is attached");
//        page.setInputFiles("#file-upload", new Path[0]);
//        System.out.println("File is deattached");
        page.click(Btn_submit);
    }
}
