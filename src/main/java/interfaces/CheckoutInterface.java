package interfaces;

public interface CheckoutInterface {
    void enterName();
    void enterSurname();
    void enterAddress();
    void enterPostCode();
    void enterPhone();
    void enterMail();
    void placeOrder();
    void enterTown();
    boolean confirmInvalidMessage();
}
