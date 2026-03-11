# Selenium POM - E-Commerce Test Automation Framework

A test automation framework built with **Selenium WebDriver**, **TestNG**, and the **Page Object Model (POM)** design pattern. Tests cover core e-commerce workflows on [training.qastorming.com](http://training.qastorming.com).

---

## Tech Stack

| Tool | Version |
|------|---------|
| Java | 8+ |
| Maven | - |
| Selenium WebDriver | 3.141.59 |
| TestNG | 6.9.8 |
| REST-Assured | 4.3.0 |
| Chrome Browser | - |

---

## Project Structure

```
selenium-pom/
├── src/
│   ├── main/java/
│   │   ├── constants/          # Test data and XPath locator constants
│   │   ├── interfaces/         # Page interface contracts
│   │   ├── pages/              # Page Object classes
│   │   └── util/               # WebDriverFactory
│   └── test/java/
│       ├── BaseTest.java       # Setup/teardown
│       ├── BaseTest.java           # Setup/teardown
│       ├── Case1.java              # Registration test
│       ├── Case2.java              # Login & profile edit test
│       ├── Case3.java              # End-to-end shopping test
│       └── ScreenshotListener.java # Captures screenshot on failure
├── testNGXmlFile/
│   └── testNG.xml              # TestNG suite configuration
├── drivers/
│   └── chromedriver.exe        # ChromeDriver binary (Windows)
└── pom.xml
```

---

## Test Cases

### Case 1 - User Registration
- Navigate to My Account page
- Enter a randomly generated email address
- Click Register
- Assert registration success message is displayed

### Case 2 - Login & Profile Edit
- Navigate to My Account page
- Login with existing credentials
- Edit first name, surname, and password
- Assert profile update confirmation message

### Case 3 - End-to-End Shopping Flow
- Navigate to Shop
- Browse to the Dresses category
- Select a random product
- Verify product description, photo, and price are present
- Add product to cart
- Navigate to cart and verify price consistency
- Proceed to checkout
- Fill in shipping/billing information
- Place order and assert invalid payment method message

---

## Setup & Prerequisites

1. **Java JDK** installed and `JAVA_HOME` configured
2. **Maven** installed
3. **Google Chrome** installed
4. **ChromeDriver** matching your Chrome version placed at `drivers/chromedriver.exe`

---

## Running the Tests

**Run all tests via Maven:**
```bash
mvn test
```

**Run via TestNG XML:**
```
testNGXmlFile/testNG.xml
```

Or run directly from your IDE (IntelliJ IDEA recommended) by right-clicking `testNG.xml` and selecting **Run**.

---

## Architecture

The framework follows the **Page Object Model (POM)** pattern:

- **`PageObject.java`** - Base class with reusable Selenium utilities (click, type, wait, assertions)
- **Page classes** (`MyAccountPage`, `ShopPage`, `CartPage`, `CheckoutPage`) - One class per page, encapsulating locators and actions
- **Interface classes** - Define contracts for each page's operations
- **Constants classes** - Centralize all XPath locators and test data separately

### Wait Strategy
- Implicit wait: 30 seconds
- Explicit wait (WebDriverWait): 30 seconds
- Page load timeout: 30 seconds

---

## Notes

- **Windows only** - ChromeDriver path and process cleanup use Windows-specific commands
- Test emails are auto-generated using a random 2-digit suffix to avoid conflicts
- The checkout test intentionally expects an "Invalid payment method" message — the test site does not process real payments
- On test failure, a screenshot is saved automatically to `test-output/screenshots/`
