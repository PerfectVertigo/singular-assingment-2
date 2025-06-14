package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static data.Constants.*;

public class PurchaseProductsE2ETests extends BaseTest {
    @Test
    public void multipleItemsPurchaseFlow() {
        steps.loginAs(USERNAME, PASSWORD)
                .verifyProductsPageIsVisible()
                .addProductsToCart(BACKPACK, BIKE_LIGHT)
                .openCart()
                .verifyCartPageIsVisible()
                .verifyAllProductsInCart(BACKPACK, BIKE_LIGHT)
                .proceedToCheckout()
                .verifyCheckoutPersonalInfoPageIsVisible()
                .enterCheckoutDetails(FIRST_NAME, LAST_NAME, POSTAL_CODE)
                .continueCheckout()
                .verifyCheckoutOverviewPageIsVisible()
                .verifyAllProductsInCheckoutOverview(BACKPACK, BIKE_LIGHT)
                .verifyCheckoutOverviewTextStructure()
                .verifyCancelButtonIsVisible()
                .finishCheckout()
                .verifyCheckoutCompletePageIsVisible()
                .verifyCheckoutCompletePageText()
                .goBackToProductsPage()
                .verifyProductsPageIsVisible();
    }
}
