import org.testng.Assert;
import org.testng.annotations.Test;

public class Case3 extends BaseTest {

    @Test
    public void case3() {
        shopPage.goToShopPage();
        shopPage.clickDresses();
        shopPage.clickRandomDress();
        boolean isDescriptionExist = shopPage.confirmDesc();
        boolean isPhotoExist = shopPage.confirmPhoto();
        boolean isPriceExist = shopPage.confirmPrice();
        String price1 = shopPage.getPriceValue();
        Assert.assertTrue(isDescriptionExist);
        Assert.assertTrue(isPhotoExist);
        Assert.assertTrue(isPriceExist);
        shopPage.addProductToChart();
        shopPage.viewCart();
        String price2 =cartPage.getCartValue();
        Assert.assertTrue(price1.contains(price2));
        cartPage.proceedCheckout();
        checkoutPage.enterName();
        checkoutPage.enterSurname();
        checkoutPage.enterAddress();
        checkoutPage.enterPostCode();
        checkoutPage.enterTown();
        checkoutPage.enterPhone();
        checkoutPage.enterMail();
        checkoutPage.placeOrder();
        boolean isInvalid = checkoutPage.confirmInvalidMessage();
        Assert.assertTrue(isInvalid);
    }

}
