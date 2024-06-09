package example9;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccount {
	private static final Logger logger = LogManager.getLogger("example9");
    
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        logger.info(Thread.currentThread().getName() + " deposited " + amount + ", balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            logger.info(Thread.currentThread().getName() + " withdrew " + amount + ", balance: " + balance);
        } else {
            logger.warn(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient funds, balance: " + balance);
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}
