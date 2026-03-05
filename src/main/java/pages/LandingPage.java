package pages;

import com.microsoft.playwright.Page;

import java.awt.*;

public class LandingPage {

    private Page page;
    private String Home = "a[href='/']";
    private String Product = "a[href='/products']";
    private String Cart = "a[href='/view_cart']";
    private String SignUpLogin = "a[href='/login']";
    private String TestCases = "a[href='/test_cases']";
    private String ApiTesting= "a[href='/api_list']";
    private String VideoTutorial= "a[href='https://www.youtube.com/c/AutomationExercise']";
    private String Contactus= "a[href='/contact_us']";

    public LandingPage(Page page){
        this.page = page;
    }

    public  String getLandingPageTitle()
    {
        return page.title();
    }

    public  String getUrl()
    {
        return page.url();
    }

    public String menuNavigationHeaders(String menu)
    {
        String actualURL = null;
        switch(menu.toLowerCase()) {
            case "product":
                page.textContent(Product);
                page.waitForLoadState();
                page.click(Product);
                System.out.println(actualURL=page.url());
//                System.out.println(page.title());
//                page.goBack();
                break;
            case "cart":
                page.textContent(Cart);
                page.click(Cart);
                System.out.println(actualURL=page.url());
                System.out.println(page.title());
                page.goBack();
                break;
            default:
                page.textContent(Home);
                System.out.println(actualURL=page.url());
                System.out.println(page.url());
                System.out.println(page.title());
                break;
        }
        return actualURL;
    }
}
