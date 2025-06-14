package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.base.AbstractProductListView;

public class CheckoutPage extends AbstractProductListView {
    public final Locator infoPageTitle;
    public final Locator overviewPageTitle;
    public final Locator completePageTitle;
    public final Locator firstNameInput;
    public final Locator lastNameInput;
    public final Locator postalCodeInput;
    public final Locator continueButton;
    public final Locator paymentInfoLabel;
    public final Locator shippingInfoLabel;
    public final Locator totalInfoLabel;
    public final Locator subtotalLabel;
    public final Locator taxLabel;
    public final Locator totalLabel;
    public final Locator cancelButton;
    public final Locator finishButton;
    public final Locator checkoutCompleteTitle;
    public final Locator checkoutCompleteContainer;
    public final Locator backHomeButton;

    private Locator pageTitle(String step) {
        return $("div[data-test='secondary-header'] > span:has-text('Checkout: " + step + "')");
    }

    public CheckoutPage(Page page) {
        super(page);

        // Step 1 - Your Information
        infoPageTitle = pageTitle("Your Information");
        firstNameInput = $("input#first-name");
        lastNameInput = $("input#last-name");
        postalCodeInput = $("input#postal-code");
        continueButton = $("input#continue");

        // Step 2 - Overview
        overviewPageTitle = pageTitle("Overview");
        paymentInfoLabel = $("[data-test='payment-info-label']");
        shippingInfoLabel = $("[data-test='shipping-info-label']");
        totalInfoLabel = $("[data-test='total-info-label']");
        subtotalLabel = $("[data-test='subtotal-label']");
        taxLabel = $("[data-test='tax-label']");
        totalLabel = $("[data-test='total-label']");
        cancelButton = $("button#cancel");
        finishButton = $("button#finish");

        // Step 3 - Complete
        completePageTitle = pageTitle("Complete!");
        checkoutCompleteTitle = $("h2.complete-header");
        checkoutCompleteContainer = $("div#checkout_complete_container");
        backHomeButton = $("button#back-to-products");
    }
}
