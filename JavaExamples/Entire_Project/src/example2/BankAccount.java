package example2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccount {
    protected String accountNumber;
    protected double balance;
    private static final Logger logger = LogManager.getLogger("example2");


    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            logger.info("Deposited: $" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            logger.info("Withdrew: $" + amount);
        } else {
            logger.info("Insufficient funds or invalid amount.");
        }
    }

    public void displayBalance() {
        logger.info("Account Number: " + accountNumber);
        logger.info("Balance: $" + balance);
    }
}
