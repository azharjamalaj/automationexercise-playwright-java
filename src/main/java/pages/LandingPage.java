package pages;

import com.microsoft.playwright.Page;

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
        System.out.println("Page details" + page);
        return page.url();
    }

    public LoginPage registerUser()
    {
        System.out.println("Page details" + page);
        page.click(SignUpLogin);
        return new LoginPage(page);
    }

    public String menuNavigationHeaders(String menu)
    {
        String actualMenu = null;
        switch(menu.toLowerCase()) {
            case "product":
                actualMenu=page.textContent(Product);
                page.waitForLoadState();
                break;
            case "cart":
                actualMenu= page.textContent(Cart);
                page.waitForLoadState();
                break;
            case "SignUpLogin":
                actualMenu = page.textContent(SignUpLogin);
                page.waitForLoadState();
                break;
            case "TestCases":
                actualMenu= page.locator(TestCases).nth(0).textContent();
                page.waitForLoadState();
                break;
            case "ApiTesting":
                actualMenu= page.textContent(ApiTesting);
                page.waitForLoadState();
                break;
            case "VideoTutorial":
                actualMenu=page.textContent(VideoTutorial);
                page.waitForLoadState();
                break;

            case "Contactus":
                actualMenu= page.textContent(Contactus);
                page.waitForLoadState();
                break;
            default:
                actualMenu=page.locator(Home).nth(1).innerText();
                page.waitForLoadState();
                break;
        }
        System.out.println(actualMenu);
        return actualMenu;
    }

    public void landingPageURL(String url)
    {
        page.navigate(url);
    }
}