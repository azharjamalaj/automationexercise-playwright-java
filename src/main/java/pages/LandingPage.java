package pages;

import com.microsoft.playwright.Page;

import java.awt.*;

public class LandingPage {

    private Page page;
    private String Home = "a[href='/']";
    private String Product = "a[href='/products']";
    private String Cart = "a[href='/view_cart']";
    private String SignUpLogin = "a:has-text(' Signup / Login')";
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
        String actualMenu = null;
        switch(menu.toLowerCase()) {
            case "product":
                actualMenu=page.textContent(Product);
                page.waitForLoadState();
//                page.click(Product);
//                System.out.println(page.url());
//                System.out.println(page.title());
//                page.goBack();
                break;
            case "cart":
                actualMenu= page.textContent(Cart);
                page.waitForLoadState();
//                page.click(Cart);
//                System.out.println(page.url());
//                System.out.println(page.title());
//                page.waitForLoadState();
//                page.goBack();
                break;
            case "SignUpLogin":
                actualMenu = page.textContent(SignUpLogin);
                page.waitForLoadState();
//                page.click(SignUpLogin);
//                System.out.println(page.url());
//                System.out.println(page.title());
//                page.waitForLoadState();
//                page.goBack();
                break;
            case "TestCases":
                actualMenu= page.locator(TestCases).nth(0).textContent();
                page.waitForLoadState();
//                page.click(TestCases);
//                System.out.println(page.url());
//                System.out.println(page.title());
//                page.waitForLoadState();
//                page.goBack();
                break;
            case "ApiTesting":
                actualMenu= page.textContent(ApiTesting);
                page.waitForLoadState();
//                page.click(ApiTesting);
//                System.out.println(page.url());
//                System.out.println(page.title());
//                page.waitForLoadState();
//                page.goBack();
                break;
            case "VideoTutorial":
                actualMenu=page.textContent(VideoTutorial);
                page.waitForLoadState();
//                page.click(VideoTutorial);
//                System.out.println(page.url());
//                System.out.println(page.title());
//                page.waitForLoadState();
//                page.goBack();
                break;

            case "Contactus":
                actualMenu= page.textContent(Contactus);
                page.waitForLoadState();
//                page.click(Contactus);
//                System.out.println(page.url());
//                System.out.println(page.title());
//                page.waitForLoadState();
//                page.goBack();
                break;
            default:
                actualMenu=page.locator(Home).nth(1).innerText();
                page.waitForLoadState();
//                System.out.println(page.url());
//                System.out.println(page.url());
//                System.out.println(page.title());
//                page.waitForLoadState();
                break;
        }
        System.out.println(actualMenu);
        return actualMenu;
    }
}
