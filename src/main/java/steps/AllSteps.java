package steps;

import com.microsoft.playwright.Page;
import pages.*;

public class AllSteps {
    private final LoginSteps loginSteps;
    private final ProductsSteps productsSteps;
    private final CommonSteps commonSteps;
    private final CartSteps cartSteps;
    private final CheckoutSteps checkoutSteps;
    public AllSteps(Page page) {
        LoginPage loginPage = new LoginPage(page);
        loginSteps = new LoginSteps(loginPage);

        ProductsPage productsPage = new ProductsPage(page);
        productsSteps = new ProductsSteps(productsPage);

        CommonPage commonPage = new CommonPage(page);
        commonSteps = new CommonSteps(commonPage);

        CartPage cartPage = new CartPage(page);
        cartSteps = new CartSteps(cartPage);

        CheckoutPage checkoutPage = new CheckoutPage(page);
        checkoutSteps = new CheckoutSteps(checkoutPage);
    }

    // ---- Login Steps ------------------------------------------------------------------------------------------------
    public AllSteps loginAs(String username, String password) {
        loginSteps.enterUsername(username)
                .enterPassword(password)
                .clickLogin();
        return this;
    }

    // ---- Products Steps ---------------------------------------------------------------------------------------------
    public AllSteps verifyProductsPageIsVisible() {
        productsSteps.verifyPageIsVisible();
        return this;
    }

    public AllSteps addProductsToCart(String... productNames) {
        for (String name : productNames) {
            productsSteps.addProductToCartByName(name);
        }
        return this;
    }

    public AllSteps openCart() {
        commonSteps.clickCartIcon();
        return this;
    }

    // ---- Cart Steps -------------------------------------------------------------------------------------------------
    public AllSteps verifyCartPageIsVisible() {
        cartSteps.verifyPageIsVisible();
        return this;
    }

    public AllSteps verifyAllProductsInCart(String... productNames) {
        cartSteps.verifyAllSelectedProductsArePresent(productNames);
        return this;
    }

    public AllSteps proceedToCheckout() {
        cartSteps.clickCheckoutButton();
        return this;
    }

    // ---- Checkout Steps ---------------------------------------------------------------------------------------------

    public AllSteps enterCheckoutDetails(String firstName, String lastName, String postalCode) {
        checkoutSteps.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterPostalCode(postalCode);
        return this;
    }

    public AllSteps continueCheckout() {
        checkoutSteps.clickContinueButton();
        return this;
    }

    public AllSteps verifyCheckoutOverviewTextStructure() {
        checkoutSteps.verifyOverviewLabelsAndValues();
        return this;
    }

    public AllSteps verifyCancelButtonIsVisible() {
        checkoutSteps.verifyCancelButtonIsVisible();
        return this;
    }

    public AllSteps verifyAllProductsInCheckoutOverview(String... productNames) {
        checkoutSteps.verifyAllSelectedProductsArePresent(productNames);
        return this;
    }
    public AllSteps finishCheckout() {
        checkoutSteps.clickFinishButton();
        return this;
    }

    public AllSteps verifyCheckoutCompletePageIsVisible() {
        checkoutSteps.verifyCheckoutCompletePageIsVisible();
        return this;
    }

    public AllSteps verifyCheckoutPersonalInfoPageIsVisible() {
        checkoutSteps.verifyPersonalInfoPageIsVisible();
        return this;
    }

    public AllSteps verifyCheckoutOverviewPageIsVisible() {
        checkoutSteps.verifyOverviewPageIsVisible();
        return this;
    }

    public AllSteps verifyCheckoutCompletePageText() {
        checkoutSteps.verifyCheckoutCompletePageText();
        return this;
    }

    public AllSteps goBackToProductsPage() {
        checkoutSteps.clickBackHomeButton();
        return this;
    }

}