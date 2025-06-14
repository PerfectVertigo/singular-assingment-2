package steps.base;

import pages.base.AbstractProductListView;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public abstract class AbstractProductListSteps<P extends AbstractProductListView> {
    protected final P page;

    public AbstractProductListSteps(P page) {
        this.page = page;
    }

    public AbstractProductListSteps<P> verifyProductPresent(String name) {
        assertThat(page.productInCartByName(name)).isVisible();
        return this;
    }

    public AbstractProductListSteps<P> verifyAllSelectedProductsArePresent(String... names) {
        for (String n : names) verifyProductPresent(n);
        return this;
    }
}