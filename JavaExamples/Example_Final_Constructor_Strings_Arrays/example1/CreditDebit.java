package example1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreditDebit {

    private static final Logger creditDebitLogger = LogManager.getLogger("example1");

    // Transaction class to store transaction details
    static class Transaction {
        private final String type;
        private final double amount;
        private final String description;

        // Constructor to initialize a transaction
        public Transaction(String type, double amount, String description) {
            this.type = type;
            this.amount = amount;
            this.description = description;
        }

        // Getters for transaction details
        public String getType() {
            return type;
        }

        public double getAmount() {
            return amount;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "Type: " + type + ", Amount: " + amount + ", Description: " + description;
        }
    }

    // FinanceManager class to manage transactions
    static class Manager {
        private final Transaction[] transactions;
        private int count;

        // Constructor to initialize the manager with a specific size
        public Manager(int size) {
            transactions = new Transaction[size];
            count = 0;
        }

        // Method to add a transaction
        public void addTransaction(String type, double amount, String description) {
            if (count < transactions.length) {
                transactions[count++] = new Transaction(type, amount, description);
                creditDebitLogger.info("Added transaction: " + type + ", " + amount + ", " + description);
            } else {
                creditDebitLogger.warn("Transaction list is full!");
            }
        }

        // Method to calculate the total balance
        public double getTotalBalance() {
            double balance = 0.0;
            for (int i = 0; i < count; i++) {
                if (transactions[i].getType().equalsIgnoreCase("credit")) {
                    balance += transactions[i].getAmount();
                } else if (transactions[i].getType().equalsIgnoreCase("debit")) {
                    balance -= transactions[i].getAmount();
                }
            }
            creditDebitLogger.info("Calculated total balance: $" + balance);
            return balance;
        }

        // Method to get details of all transactions
        public String[] getTransactionDetails() {
            String[] details = new String[count];
            for (int i = 0; i < count; i++) {
                details[i] = transactions[i].toString();
            }
            creditDebitLogger.info("Fetched transaction details");
            return details;
        }

        public static void main(String[] args) {
            Manager manager = new Manager(5);

            // Adding transactions
            manager.addTransaction("credit", 1000.0, "Salary");
            manager.addTransaction("debit", 200.0, "Groceries");
            manager.addTransaction("debit", 150.0, "Utilities");
            manager.addTransaction("credit", 500.0, "Freelance Work");
            manager.addTransaction("debit", 100.0, "Internet Bill");

            // Calculating and printing total balance
            creditDebitLogger.info("Total Balance: $" + manager.getTotalBalance());

            // Printing transaction details
            String[] transactionDetails = manager.getTransactionDetails();
            for (String detail : transactionDetails) {
                creditDebitLogger.info(detail);
            }
        }
    }
}
