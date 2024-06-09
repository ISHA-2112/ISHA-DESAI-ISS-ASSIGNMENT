package example6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Custom exception for invalid amount
class InvalidAmountException extends Exception {
	public InvalidAmountException(String message) {
		super(message);
	}
}

//Custom exception for insufficient funds
class InsufficientFundsException extends Exception {
	public InsufficientFundsException(String message) {
		super(message);
	}
}

//BankAccount class with deposit, withdraw, and balance methods
class BankAccount {
	private double balance;

	public BankAccount(double initialBalance) throws InvalidAmountException {
		if (initialBalance < 0) {
			throw new InvalidAmountException("Initial balance cannot be negative.");
		}
		this.balance = initialBalance;
	}

	public void deposit(double amount) throws InvalidAmountException {
		if (amount <= 0) {
			throw new InvalidAmountException("Deposit amount must be positive.");
		}
		balance += amount;
	}

	public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
		if (amount <= 0) {
			throw new InvalidAmountException("Withdrawal amount must be positive.");
		}
		if (amount > balance) {
			throw new InsufficientFundsException("Insufficient funds for this withdrawal.");
		}
		balance -= amount;
	}

	public double getBalance() {
		return balance;
	}
}

//Main class to test the BankAccount class
public class DepositWithdrawal {
	private static final Logger logger = LogManager.getLogger("example6");

	public static void main(String[] args) {
		try {
			BankAccount account = new BankAccount(5000);
			logger.info("Initial balance: $" + account.getBalance());

			// Test deposit
			account.deposit(100);
			logger.info("Balance after deposit: $" + account.getBalance());

			// Test withdrawal with sufficient funds
			account.withdraw(500);
			logger.info("Balance after withdrawal: $" + account.getBalance());

			// Test withdrawal with insufficient funds
			account.withdraw(7500);
		} catch (InvalidAmountException e) {
			logger.warn("Error: " + e.getMessage());
		} catch (InsufficientFundsException e) {
			logger.warn("Error: " + e.getMessage());
		}
	}
}
