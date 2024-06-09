package example8;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ComparatorExample {
	private static final Logger logger = LogManager.getLogger("example8");
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("Isha", 100.0, "Deposit"));
        transactions.add(new Transaction("Reshma", 50.0, "Withdrawal"));
        transactions.add(new Transaction("Hemant", 200.0, "Deposit"));
        transactions.add(new Transaction("Isha", 25.0, "Withdrawal"));
        transactions.add(new Transaction("Reshma", 75.0, "Deposit"));

        // Sort transactions by user name
        Collections.sort(transactions, new Comparators.UserComparator());
        logger.info("\nTransactions sorted by user:");
        for (Transaction transaction : transactions) {
            logger.info(transaction);
        }

        // Sort transactions by type
        Collections.sort(transactions, new Comparators.TypeComparator());
        logger.info("\nTransactions sorted by type:");
        for (Transaction transaction : transactions) {
            logger.info(transaction);
        }
    }
}
