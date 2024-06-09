package example9;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserBankInterface {
	private static final Logger logger = LogManager.getLogger("example9");
    public static void main(String[] args) {
        
        BankAccount account = new BankAccount(1000); // Initial balance of 1000

        // Create multiple threads to simulate different users
        Thread user1 = new Thread(new User(account), "User 1");
        Thread user2 = new Thread(new User(account), "User 2");
        Thread user3 = new Thread(new User(account), "User 3");

        // Start the threads
        user1.start();
        user2.start();
        user3.start();

        // Wait for all threads to finish
        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final balance
        logger.info("Final balance: " + account.getBalance());
    }
}
