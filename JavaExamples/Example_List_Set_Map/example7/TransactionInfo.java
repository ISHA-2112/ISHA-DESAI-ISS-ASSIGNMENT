package example7;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransactionInfo {
	private static final Logger logger = LogManager.getLogger("example7");
    public static void main(String[] args) {
        // List of transactions
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("Isha", 100.0, "Deposit"));
        transactions.add(new Transaction("Reshma", 50.0, "Withdrawal"));
        transactions.add(new Transaction("Isha", 25.0, "Withdrawal"));
        transactions.add(new Transaction("Hemant", 200.0, "Deposit"));
        transactions.add(new Transaction("Reshma", 75.0, "Deposit"));

        // Set of unique users
        Set<String> users = new HashSet<>();
        for (Transaction transaction : transactions) {
            users.add(transaction.getUser());
        }

        // Map to track total balance for each user
        Map<String, Double> userBalances = new HashMap<>();
        for (String user : users) {
            userBalances.put(user, 0.0);
        }

        // Process transactions
        for (Transaction transaction : transactions) {
            String user = transaction.getUser();
            double amount = transaction.getAmount();
            String type = transaction.getType();

            if (type.equals("Deposit")) {
                userBalances.put(user, userBalances.get(user) + amount);
            } else if (type.equals("Withdrawal")) {
                userBalances.put(user, userBalances.get(user) - amount);
            }
        }

        // Print user balances
        for (String user : userBalances.keySet()) {
            logger.info(user + " has a balance of " + userBalances.get(user));
        }
    }
}
