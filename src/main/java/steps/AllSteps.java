package steps;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import io.qameta.allure.Param;
import pages.*;

import static io.qameta.allure.model.Parameter.Mode.HIDDEN;

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
    @Step("Log in as user `{username}`")
    public AllSteps loginAs(String username, @Param(mode=HIDDEN) String password) {
        loginSteps.enterUsername(username)
                  .enterPassword(password)
                  .clickLogin();
        return this;
    }

    // ---- Products Steps ---------------------------------------------------------------------------------------------
    @Step("Verify products page is visible")
    public AllSteps verifyProductsPageIsVisible() {
        productsSteps.verifyPageIsVisible();
        return this;
    }

    @Step("Add products to cart: {productNames}")
    public AllSteps addProductsToCart(String... productNames) {
        for (String name : productNames) {
            productsSteps.addProductToCartByName(name);
        }
        return this;
    }

    @Step("Open the cart")
    public AllSteps openCart() {
        commonSteps.clickCartIcon();
        return this;
    }

    // ---- Cart Steps -------------------------------------------------------------------------------------------------
    @Step("Verify cart page is visible")
    public AllSteps verifyCartPageIsVisible() {
        cartSteps.verifyPageIsVisible();
        return this;
    }

    @Step("Verify cart contains: {productNames}")
    public AllSteps verifyAllProductsInCart(String... productNames) {
        cartSteps.verifyAllSelectedProductsArePresent(productNames);
        return this;
    }

    @Step("Proceed to checkout")
    public AllSteps proceedToCheckout() {
        cartSteps.clickCheckoutButton();
        return this;
    }

    // ---- Checkout Steps ---------------------------------------------------------------------------------------------
    @Step("Enter checkout details: firstName=`{firstName}`, lastName=`{lastName}`, postalCode=`{postalCode}`")
    public AllSteps enterCheckoutDetails(String firstName, String lastName, String postalCode) {
        checkoutSteps.enterFirstName(firstName)
                     .enterLastName(lastName)
                     .enterPostalCode(postalCode);
        return this;
    }

    @Step("Continue checkout")
    public AllSteps continueCheckout() {
        checkoutSteps.clickContinueButton();
        return this;
    }

    @Step("Verify checkout overview section text structure")
    public AllSteps verifyCheckoutOverviewTextStructure() {
        checkoutSteps.verifyOverviewLabelsAndValues();
        return this;
    }

    @Step("Verify cancel button is visible and enabled on overview")
    public AllSteps verifyCancelButtonIsVisible() {
        checkoutSteps.verifyCancelButtonIsVisible();
        return this;
    }

    @Step("Verify checkout overview contains products: {productNames}")
    public AllSteps verifyAllProductsInCheckoutOverview(String... productNames) {
        checkoutSteps.verifyAllSelectedProductsArePresent(productNames);
        return this;
    }

    @Step("Finish checkout")
    public AllSteps finishCheckout() {
        checkoutSteps.clickFinishButton();
        return this;
    }

    @Step("Verify checkout: complete page is visible")
    public AllSteps verifyCheckoutCompletePageIsVisible() {
        checkoutSteps.verifyCheckoutCompletePageIsVisible();
        return this;
    }

    @Step("Verify checkout: your info page is visible")
    public AllSteps verifyCheckoutPersonalInfoPageIsVisible() {
        checkoutSteps.verifyPersonalInfoPageIsVisible();
        return this;
    }

    @Step("Verify checkout: overview page is visible")
    public AllSteps verifyCheckoutOverviewPageIsVisible() {
        checkoutSteps.verifyOverviewPageIsVisible();
        return this;
    }

    @Step("Verify checkout: complete page text")
    public AllSteps verifyCheckoutCompletePageText() {
        checkoutSteps.verifyCheckoutCompletePageText();
        return this;
    }

    @Step("Go back to products page")
    public AllSteps goBackToProductsPage() {
        checkoutSteps.clickBackHomeButton();
        return this;
    }
}