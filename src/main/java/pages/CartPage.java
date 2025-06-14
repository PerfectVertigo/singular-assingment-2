package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.base.AbstractProductListView;

public class CartPage extends AbstractProductListView {
    public final Locator pageTitle;
    public final Locator cartList;
    public final Locator checkoutButton;

    public CartPage(Page page) {
        super(page);
        pageTitle = $("div[data-test='secondary-header'] > span:text-is('Your Cart')");
        cartList = $("div.cart_list");
        checkoutButton = $("button#checkout");
    }
}
