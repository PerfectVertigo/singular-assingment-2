package data;

public final class Constants {
    private Constants() {}

    public static final String BASE_URL = "https://www.saucedemo.com";

    // --- Login Constants ---------------------------------------------------------------------------------------------
    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";

    // --- Product Constants -------------------------------------------------------------------------------------------
    public static final String BACKPACK = "Sauce Labs Backpack";
    public static final String BIKE_LIGHT = "Sauce Labs Bike Light";

    // --- Checkout Constants ------------------------------------------------------------------------------------------
    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Doe";
    public static final String POSTAL_CODE = "12345";
    public static final String PAYMENT_INFO_LABEL = "Payment Information:";
    public static final String SHIPPING_INFO_LABEL = "Shipping Information:";
    public static final String TOTAL_INFO_LABEL = "Price Total";

    // --- Regexes -----------------------------------------------------------------------------------------------------
    public static final String CHECKOUT_PRICE_REGEX = "\\$\\d+\\.\\d{2}";
}
