package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.base.BasePage;

public class ProductsPage extends BasePage {

    public final Locator pageTitle;

    public ProductsPage(Page page) {
        super(page);
        pageTitle = $("div[data-test='secondary-header'] > span:text-is('Products')");
    }
    public Locator addToCartButtonByProductName(String productName) {
        return $(".inventory_item:has(.inventory_item_name:text-is('" + productName + "')) button.btn_inventory");
    }
}
