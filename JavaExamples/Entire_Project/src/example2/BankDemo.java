package example2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankDemo {
	private static final Logger logger = LogManager.getLogger("example2");
    public static void main(String[] args) {

        BankAccount savings = new SavingsAccount("FFR523", 7600.0, 2.3);


        logger.info("Savings Account Details:");
        savings.displayBalance();
        ((SavingsAccount) savings).applyInterest();
        savings.displayBalance();

    }
}
