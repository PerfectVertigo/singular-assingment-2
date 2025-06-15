package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static data.Constants.*;

@Epic("Checkout Flow")
@Feature("Purchase Products")
public class PurchaseProductsE2ETests extends BaseTest {
    @Test(description = "Happy path purchase of multiple items")
    @Story("Complete checkout of multiple products")
    @Description("Verifies that standard user can log in, add multiple products to cart, and complete checkout")
    @Severity(SeverityLevel.BLOCKER)
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
