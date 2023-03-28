public class PaymentHandler {

    public boolean handlePaymentRequest(int cardNumber) {
        if(checkCardNumber(cardNumber)) {
            System.out.println("Processing payment request...");
            return true;
        } else {
            return false;
        }

    }

    private boolean checkCardNumber(int number) {
        int digits = String.valueOf(number).length();
        if(digits == 16)
            return true;
        else
            return false;
        
    }
    
}
