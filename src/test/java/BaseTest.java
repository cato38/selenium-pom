import constants.BaseTestConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import pages.*;
import util.WebDriverFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected static MyAccountPage myAccountPage;
    protected static ShopPage shopPage;
    protected static MainPage mainPage;
    protected static CartPage cartPage;
    protected static CheckoutPage checkoutPage;

    @BeforeMethod
    public static void setUpSuite() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.createWebDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(BaseTestConstants.URL);
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        myAccountPage = new MyAccountPage(driver);
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterMethod
    public static void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public static void tearDownSuite() throws IOException {
        String processInfoDrivers = getProcessInfo();
        if (processInfoDrivers.contains("chromedriver.exe")) {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
        }
    }

    private static String getProcessInfo() throws IOException {
        StringBuilder processInfo = new StringBuilder();
        Process process = Runtime.getRuntime().exec(
                System.getenv("windir") + "\\system32\\tasklist.exe"
        );
        try (BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = input.readLine()) != null) {
                processInfo.append(line);
            }
        }
        return processInfo.toString();
    }
}
