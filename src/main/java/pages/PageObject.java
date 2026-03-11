package pages;

import interfaces.PageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class PageObject implements PageInterface {

    private WebDriver driver;
    private WebDriverWait wait;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30);
    }

    @Override
    public void clickElementByXpath(String xpath) {
        waitByXpath(xpath);
        WebElement webElement = this.driver.findElement(By.xpath(xpath));
        webElement.click();
    }

    @Override
    public void hoverElementByXpath(String xpath) {
        waitByXpath(xpath);
        Actions actions = new Actions(driver);
        WebElement webElement = this.driver.findElement(By.xpath(xpath));
        actions.moveToElement(webElement).perform();
    }

    @Override
    public void waitByXpath(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    @Override
    public void waitEditableByXpath(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    /**
     * Waits for at least one element matching xpath to be present in the DOM and returns the locator.
     */
    @Override
    public By wait2(String xpath) {
        By waitBy = By.xpath(xpath);
        try {
            this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(waitBy));
        } catch (Exception e) {
            Assert.fail("No elements found for xpath: " + xpath);
        }
        return waitBy;
    }

    @Override
    public void enterTextByXpath(String xpath, String txt) {
        waitByXpath(xpath);
        WebElement webElement = this.driver.findElement(By.xpath(xpath));
        webElement.sendKeys(txt);
    }

    @Override
    public String getTextOfElement(String xpath) {
        waitByXpath(xpath);
        WebElement webElement = this.driver.findElement(By.xpath(xpath));
        return webElement.getText();
    }

    @Override
    public Boolean isElementExist(String xpath) {
        try {
            this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            return this.driver.findElement(By.xpath(xpath)).isDisplayed();
        } catch (Exception e) {
            Assert.fail(String.format("%s xpath is not visible, %s", xpath, e.getMessage()));
            return false;
        } finally {
            // Restore the default implicit wait so subsequent operations aren't affected
            this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    @Override
    public Boolean isFirstElementExist(String xpath) {
        try {
            By waitBy = wait2(xpath);
            WebElement lastElement = null;
            for (WebElement element : driver.findElements(waitBy)) {
                lastElement = element;
            }
            return lastElement != null && lastElement.isDisplayed();
        } catch (Exception e) {
            Assert.fail("Couldn't find element for xpath: " + xpath);
            return false;
        }
    }
}
