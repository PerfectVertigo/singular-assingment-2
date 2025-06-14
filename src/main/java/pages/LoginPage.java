package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.base.BasePage;

public class LoginPage extends BasePage {

    public final Locator usernameInput;
    public final Locator passwordInput;
    public final Locator loginButton;

    public LoginPage(Page page) {
        super(page);
        usernameInput = $( "input#user-name" );
        passwordInput = $( "input#password" );
        loginButton = $( "input#login-button" );
    }
}
