# SauceDemo E2E Tests

A simple Playwright-based end-to-end test suite for the SauceDemo checkout flow, demonstrating QA best practices, a Page‑Object Model, and Allure reporting.

---

## 🔧 Prerequisites

* JDK 8+
* Maven 3.6+
* Chrome or Chromium installed

---

## ⚙️ Setup & Installation

1. (Optional) Configure your test credentials safely via a `.env` file or CI secrets.
   Example `.env`:

   ```text
   SAUCEDEMO_USER=standard_user
   SAUCEDEMO_PASS=<password>
   ```
2. **Install project dependencies and browser binaries**:

   ```bash
   mvn clean install
   ```

   Playwright Java automatically downloads required browser binaries on the first test run.

---

## ⚙️ Setup & Installation

1. **Install Playwright browsers (from intellij or external terminal)**

   ```bash
   mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
   ```
2. **Dependencies** (Maven handles):

   ```bash
   mvn clean install
   ```

---

## 🚀 Running Tests

```bash
mvn test
```

This will execute the E2E suite against **Chromium**.

---

## 📊 Generating & Viewing Allure Report

1. **Ensure Allure Maven plugin** is configured in `pom.xml` (see Test Plan).
2. **Run tests and serve report**:

   ```bash
   mvn clean test
   mvn allure:serve
   ```
3. **Or generate static site**:

   ```bash
   mvn allure:report
   ```

---

## 📋 One-Page Test Plan: SauceDemo Checkout Flow

---

### 1. Purpose & Scope

**Purpose:** Verify the core purchase journey (“happy path”) on SauceDemo (`https://www.saucedemo.com`).

**In-Scope:**

* Login with standard credentials
* Add multiple products to cart
* Navigate to cart and verify correct products
* Complete checkout process (Information → Overview → Finish)

  * Verify product list and overview text structure
* Navigate back to products page

**Out-of-Scope:**

* Error/negative scenarios
* Other site modules not specified in the task (product sorting, burger menu)
* Non-functional tests (performance, security)

---

### 2. Test Approach

* **Type:** End-to-End functional tests via Playwright Test (Java)
* **Design Pattern:** Page-Object Model with fluent steps API
* **Data:** Constants for item titles and user credentials
* **Browser:** Chromium (local execution)

---

### 3. Test Items & Traceability

| Scenario            | Test Steps                                                    | Requirement ID                                 |
| ------------------- | ------------------------------------------------------------- | ---------------------------------------------- |
| Checkout Happy Path | Login → Add products → Open cart → Start checkout → Enter info → Finish → Back | REQ-Login, REQ-Cart, REQ-Checkout, REQ-NavBack |

---

### 4. Pass/Fail & Suspension Criteria

* **Pass:** All verifications succeed; Allure report shows zero failures.
* **Fail:** Any step assertion fails.
* **Suspend Testing If:**

  * Site is unreachable
  * Test user credentials are invalid
  * Critical locators change unexpectedly

---

### 5. Environment & Tools

* **Test Environment:** Public SauceDemo site
* **Automation:** Playwright Test runner (Java), Chromium
* **Reporting:** Allure report

---

### 6. Deliverables & Responsibilities

* **Deliverables:** One-Page Test Plan; Playwright test scripts; Allure report
* **QA Engineer:** Plan, implement, execute, report

---

### 7. Long-Term Improvement Tips

* **Component Reusability:** The selected-products view is abstracted; verify whether this abstraction covers both pages. If they are distinct implementations, maintain separate page objects or adjust the abstraction to handle page-specific behavior without duplication.
* **Locator Strategy:** Instead of selecting products by name, use positional indexes (e.g., first, second item) for selection and then extract their names for verification; this decouples tests from hardcoded titles.
* **Secure Test Credentials:** Remove hardcoded usernames/passwords from source. Store them in environment variables (e.g., using a `.env` file with a library like [dotenv-java](https://github.com/cdimascio/dotenv-java)) or use your CI/CD’s secrets store, and load them at runtime via `System.getenv()`.
* **JS Rewrite:** Rewrite the project in JavaScript — Java was used simply because it was the language I knew best (and not because I enjoy suffering…).
