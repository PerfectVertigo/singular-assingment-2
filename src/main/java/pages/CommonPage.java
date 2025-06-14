package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.base.BasePage;

public class CommonPage extends BasePage {
    public final Locator cartIcon;
    public CommonPage(Page page) {
        super(page);
        cartIcon = $("[data-test='shopping-cart-link']");
    }
}
