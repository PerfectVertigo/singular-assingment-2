package utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;

public class AllureUtils {
  public static void attachScreenshot(Page page, String name) {
    byte[] bytes = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
    Allure.addAttachment(name, new ByteArrayInputStream(bytes));
  }
}