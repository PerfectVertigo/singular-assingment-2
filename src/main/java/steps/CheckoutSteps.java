package steps;

import pages.CheckoutPage;
import steps.base.AbstractProductListSteps;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static data.Constants.*;

public class CheckoutSteps extends AbstractProductListSteps<CheckoutPage> {

    public CheckoutSteps(CheckoutPage page) {
        super(page);
    }

    // ---- Personal Information Page ----------------------------------------------------------------------------------
    public CheckoutSteps verifyPersonalInfoPageIsVisible() {
        assertThat(page.infoPageTitle).isVisible();
        return this;
    }

    public CheckoutSteps enterFirstName(String firstName) {
        page.firstNameInput.fill(firstName);
        return this;
    }

    public CheckoutSteps enterLastName(String lastName) {
        page.lastNameInput.fill(lastName);
        return this;
    }

    public CheckoutSteps enterPostalCode(String postalCode) {
        page.postalCodeInput.fill(postalCode);
        return this;
    }

    public CheckoutSteps clickContinueButton() {
        page.continueButton.click();
        return this;
    }

    // ---- Overview Page ----------------------------------------------------------------------------------------------

    public CheckoutSteps verifyOverviewPageIsVisible() {
        assertThat(page.overviewPageTitle).isVisible();
        return this;
    }

    public CheckoutSteps verifyOverviewLabelsAndValues() {
        // labels
        assertThat(page.paymentInfoLabel).hasText(PAYMENT_INFO_LABEL);
        assertThat(page.shippingInfoLabel).hasText(SHIPPING_INFO_LABEL);
        assertThat(page.totalInfoLabel).hasText(TOTAL_INFO_LABEL);

        // verify format of numbers
        assertThat(page.subtotalLabel).hasText(Pattern.compile(CHECKOUT_PRICE_REGEX));
        assertThat(page.taxLabel).hasText(Pattern.compile(CHECKOUT_PRICE_REGEX));
        assertThat(page.totalLabel).hasText(Pattern.compile(CHECKOUT_PRICE_REGEX));
        return this;
    }

    public CheckoutSteps verifyCancelButtonIsVisible() {
        assertThat(page.cancelButton).isVisible();
        assertThat(page.cancelButton).isEnabled();
        return this;
    }

    public CheckoutSteps clickFinishButton() {
        page.finishButton.click();
        return this;
    }

    // ---- Complete Page ----------------------------------------------------------------------------------------------

    public CheckoutSteps verifyCheckoutCompletePageIsVisible() {
        assertThat(page.completePageTitle).isVisible();
        return this;
    }

    public CheckoutSteps verifyCheckoutCompletePageText() {
        assertThat(page.checkoutCompleteContainer).isVisible();
        assertThat(page.checkoutCompleteTitle).hasText("Thank you for your order!");
        return this;
    }

    public CheckoutSteps clickBackHomeButton() {
        page.backHomeButton.click();
        return this;
    }
}
