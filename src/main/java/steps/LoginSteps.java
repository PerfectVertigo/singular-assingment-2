package steps;

import pages.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public LoginSteps enterUsername(String username) {
        loginPage.usernameInput.fill(username);
        return this;
    }

    public LoginSteps enterPassword(String password) {
        loginPage.passwordInput.fill(password);
        return this;
    }

    public LoginSteps clickLogin() {
        loginPage.loginButton.click();
        return this;
    }
}
