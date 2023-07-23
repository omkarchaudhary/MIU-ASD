package with.templatemethod;

public class Paypal extends PaymentProcessor{
   private String paypalAddress;

    public Paypal(String paypalAddress) {
        this.paypalAddress = paypalAddress;
    }

    public String getPaypalAddress() {
        return paypalAddress;
    }

    public void setPaypalAddress(String paypalAddress) {
        this.paypalAddress = paypalAddress;
    }

    @Override
    public boolean validateCard() {
        // logic to validate paypal address
        System.out.println("Validate paypal address "+paypalAddress);
        return true;
    }
}
