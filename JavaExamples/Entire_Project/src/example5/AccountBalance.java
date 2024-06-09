package example5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccountBalance {
	private static final Logger logger = LogManager.getLogger("example5");


    // Account Interface
    interface Account {
        void deposit(double amount);
        void withdraw(double amount);
        double getBalance();
    }

    // SavingsAccount Class implementing Account interface
    static class SavingsAccount implements Account {
        private double balance;

        public SavingsAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        @Override
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                logger.info(amount + " deposited successfully.");
            } else {
            	logger.warn("Invalid amount for deposit.");
            }
        }

        @Override
        public void withdraw(double amount) {
            if (amount > 0 && balance >= amount) {
                balance -= amount;
                logger.info(amount + " withdrawn successfully.");
            } else {
            	logger.warn("Insufficient balance or invalid amount for withdrawal.");
            }
        }

        @Override
        public double getBalance() {
            return balance;
        }
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        // Testing SavingsAccount
        Account savingsAccount = new SavingsAccount(2000.0);
        logger.info("Initial Balance: " + savingsAccount.getBalance());

        savingsAccount.deposit(7500.0);
        logger.info("Balance after deposit: " + savingsAccount.getBalance());

        savingsAccount.withdraw(600.0);
        logger.info("Balance after withdrawal: " + savingsAccount.getBalance());
    }
}
