package tests.base;

import com.microsoft.playwright.*;
import org.testng.annotations.*;
import steps.AllSteps;

import static data.Constants.BASE_URL;

public abstract class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected AllSteps steps;

    @BeforeClass
    public void globalSetUp() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                            .launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeMethod
    public void setUp() {
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1280, 800));
        page = context.newPage();
        steps = new AllSteps(page);

        page.navigate(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        context.close();
    }

    @AfterClass
    public void globalTearDown() {
        browser.close();
        playwright.close();
    }
}
