package example4;

public class CreditCardInfo {
    public static void main(String[] args) {
        // Creating a new credit card
        CreditCardLimit creditCard = new CreditCardLimit("1234-5678-9876-5432", "Isha Desai", 5000.00);

        // Displaying card details
        creditCard.displayCardDetails();

        // Making a purchase
        creditCard.makePurchase(1500.00);

        // Making a payment
        creditCard.makePayment(500.00);

        // Displaying updated card details
        creditCard.displayCardDetails();
    }
}
