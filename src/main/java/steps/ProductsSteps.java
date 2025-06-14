package steps;

import pages.ProductsPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductsSteps {
    private final ProductsPage productsPage;

    public ProductsSteps(ProductsPage productsPage) {
        this.productsPage = productsPage;
    }

    public ProductsSteps verifyPageIsVisible() {
        assertThat(productsPage.pageTitle).isVisible();
        return this;
    }

    public ProductsSteps addProductToCartByName(String productName) {
        productsPage.addToCartButtonByProductName(productName).click();
        return this;
    }
}
