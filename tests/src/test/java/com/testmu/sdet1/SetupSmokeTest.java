package com.testmu.sdet1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Setup check only. Confirms that Playwright, REST Assured and JUnit 5 work on this machine.
 * Delete or replace once the real tests exist.
 */
class SetupSmokeTest {

    @Test
    void browserCanOpenAPage() {
        // First run downloads browser binaries automatically, so it can take a minute.
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("https://example.com");
            assertEquals("Example Domain", page.title());
        }
    }

    @Test
    void apiCanReturnAResponse() {
        int status = RestAssured.get("https://example.com").statusCode();
        assertTrue(status == 200, "Expected 200 but got " + status);
    }
}
