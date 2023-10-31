package base;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public abstract class BaseTest {
    private  Playwright playwright;
    private  Browser browser;

    private BrowserContext context;
    private Page page;

    protected Page getPage() {
        return page;
    }

    @BeforeSuite
    protected void beforeSuite() {
        playwright = Playwright.create();
    }

    @BeforeTest
    protected void beforeTest() {
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeMethod
    protected void beforeMethod() {
        context = browser.newContext();
        page = context.newPage();

        page.navigate("https://magento.softwaretestingboard.com/");
    }

    @AfterMethod
    protected void afterMethod() {
        context.close();
    }

    @AfterSuite
    protected void afterSuits() {
        playwright.close();
    }
}
