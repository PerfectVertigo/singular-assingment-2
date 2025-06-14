package steps;

import pages.CartPage;
import steps.base.AbstractProductListSteps;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartSteps extends AbstractProductListSteps<CartPage> {

    public CartSteps(CartPage page) {
        super(page);
    }

    public CartSteps verifyPageIsVisible() {
        assertThat(page.pageTitle).isVisible();
        return this;
    }

    public CartSteps clickCheckoutButton() {
        page.checkoutButton.click();
        return this;
    }
}
