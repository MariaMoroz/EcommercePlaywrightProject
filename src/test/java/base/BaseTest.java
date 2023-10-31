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
    protected void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @BeforeMethod
    protected void createContextAndPage() {

        context = browser.newContext();
        page = context.newPage();

        page.navigate("https://magento.softwaretestingboard.com/");
    }

    @AfterMethod
    void closeContext() {
        context.close();
    }

    @AfterClass
    protected void closeBrowser() {
        playwright.close();
    }
}
