package pages;

import constants.CheckoutPageTestConstant;
import constants.CheckoutXpathConstants;
import interfaces.CheckoutInterface;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends PageObject implements CheckoutInterface {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterName() {
        super.waitByXpath(CheckoutXpathConstants.NAME_AREA);
        super.enterTextByXpath(CheckoutXpathConstants.NAME_AREA, CheckoutPageTestConstant.NAME);
    }

    @Override
    public void enterSurname() {
        super.waitByXpath(CheckoutXpathConstants.SURNAME_AREA);
        super.enterTextByXpath(CheckoutXpathConstants.SURNAME_AREA, CheckoutPageTestConstant.SURNAME);

    }

    @Override
    public void enterAddress() {
        super.waitByXpath(CheckoutXpathConstants.ADDRESS_AREA);
        super.enterTextByXpath(CheckoutXpathConstants.ADDRESS_AREA, CheckoutPageTestConstant.ADDRESS);
    }

    @Override
    public void enterPostCode() {
        super.waitByXpath(CheckoutXpathConstants.PC_AREA);
        super.enterTextByXpath(CheckoutXpathConstants.PC_AREA, CheckoutPageTestConstant.PC);
    }

    @Override
    public void enterPhone() {
        super.waitByXpath(CheckoutXpathConstants.PHONE_AREA);
        super.enterTextByXpath(CheckoutXpathConstants.PHONE_AREA, CheckoutPageTestConstant.PHONE);
    }

    @Override
    public void enterMail() {
        super.waitByXpath(CheckoutXpathConstants.MAIL_AREA);
        super.enterTextByXpath(CheckoutXpathConstants.MAIL_AREA, CheckoutPageTestConstant.MAIL);
    }

    @Override
    public void placeOrder() {
        super.waitByXpath(CheckoutXpathConstants.PLACE_ORDER);
        super.hoverElementByXpath(CheckoutXpathConstants.PLACE_ORDER);
        // Wait for the button to be clickable again after hover triggers any page update
        super.waitByXpath(CheckoutXpathConstants.PLACE_ORDER);
        super.clickElementByXpath(CheckoutXpathConstants.PLACE_ORDER);
    }

    @Override
    public void enterTown() {
        super.waitByXpath(CheckoutXpathConstants.TOWN_AREA);
        super.enterTextByXpath(CheckoutXpathConstants.TOWN_AREA, CheckoutPageTestConstant.TOWN);

    }

    @Override
    public boolean confirmInvalidMessage() {
        super.waitByXpath(CheckoutXpathConstants.MESSAGE);
        boolean value = isElementExist(CheckoutXpathConstants.MESSAGE);
        return value;
    }
}
