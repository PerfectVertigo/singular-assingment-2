package pages.base;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public abstract class AbstractProductListView extends BasePage {

    public AbstractProductListView(Page page) {
        super(page);
    }

    public Locator productInCartByName(String productName) {
        return $(".cart_item:has(.inventory_item_name:text-is('" + productName + "'))");
    }
}