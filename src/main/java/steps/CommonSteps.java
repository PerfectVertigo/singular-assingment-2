package steps;

import pages.CommonPage;

public class CommonSteps {
    private final CommonPage commonPage;
    public CommonSteps(CommonPage commonPage) {
        this.commonPage = commonPage;
    }
    public CommonSteps clickCartIcon() {
        commonPage.cartIcon.click();
        return this;
    }
}
