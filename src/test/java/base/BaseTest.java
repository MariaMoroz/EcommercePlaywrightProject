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

    @BeforeClass
    protected void createPlaywright() {
        playwright = Playwright.create();
    }

    @BeforeMethod
    protected void launchBrowser() {
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();

        page.navigate("https://magento.softwaretestingboard.com/");
    }

    @AfterClass
    protected void closeBrowser() {
        context.close();
        playwright.close();
    }
}
