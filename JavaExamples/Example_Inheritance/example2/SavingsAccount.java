package example2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SavingsAccount extends BankAccount {
    private double interestRate;
    private static final Logger logger = LogManager.getLogger("example2");

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        logger.info("Interest applied: $" + interest);
    }

    @Override
    public void displayBalance() {
        super.displayBalance();
       
    }
}
