package example8;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ComparableExample {
	private static final Logger logger = LogManager.getLogger("example8");
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("Isha", 100.0, "Deposit"));
        transactions.add(new Transaction("Reshma", 50.0, "Withdrawal"));
        transactions.add(new Transaction("Hemant", 200.0, "Deposit"));
        transactions.add(new Transaction("Isha", 25.0, "Withdrawal"));
        transactions.add(new Transaction("Reshma", 75.0, "Deposit"));

        // Sort transactions by amount (natural order)
        Collections.sort(transactions);

        System.out.println("Transactions sorted by amount:");
        for (Transaction transaction : transactions) {
            logger.info(transaction);
        }
    }
}
