package example4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreditCardLimit {
    // Private variables (data encapsulation)
    private String cardNumber;
    private String cardHolderName;
    private double creditLimit;
    private double balance;
    private static final Logger logger = LogManager.getLogger("example4");

    // Constructor
    public CreditCardLimit(String cardNumber, String cardHolderName, double creditLimit) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.creditLimit = creditLimit;
        this.balance = 0.0;
    }

    // Public getter for card number (read-only)
    public String getCardNumber() {
        return cardNumber;
    }

    // Public getter for card holder name
    public String getCardHolderName() {
        return cardHolderName;
    }

    // Public setter for card holder name
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    // Public getter for credit limit
    public double getCreditLimit() {
        return creditLimit;
    }

    // Public setter for credit limit
    public void setCreditLimit(double creditLimit) {
        if (creditLimit > 0) {
            this.creditLimit = creditLimit;
        } else {
            logger.warn("Invalid credit limit. It must be positive.");
        }
    }

    // Public getter for balance (read-only)
    public double getBalance() {
        return balance;
    }

    // Public method to make a purchase
    public void makePurchase(double amount) {
        if (amount > 0 && (balance + amount) <= creditLimit) {
            balance += amount;
            logger.info("Purchase of " + amount + " made successfully.");
        } else {
        	logger.warn("Purchase amount exceeds credit limit or is invalid.");
        }
    }

    // Public method to make a payment
    public void makePayment(double amount) {
        if (amount > 0) {
            balance -= amount;
            logger.info("Payment of " + amount + " made successfully.");
        } else {
        	logger.warn("Invalid payment amount.");
        }
    }

    // Public method to display card details
    public void displayCardDetails() {
    	logger.info("Card Number: " + cardNumber);
    	logger.info("Card Holder Name: " + cardHolderName);
    	logger.info("Credit Limit: " + creditLimit);
    	logger.info("Balance: " + balance);
    }
}

