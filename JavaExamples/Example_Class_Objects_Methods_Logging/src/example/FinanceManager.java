package example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.logging.log4j.Level;

public class FinanceManager {

    // Instance variables
    private double totalIncome;
    private double totalExpenses;
    private static  double current_balance;
    private static final Logger logger = LogManager.getLogger(FinanceManager.class);

    // Constructor
    public FinanceManager() {
        this.totalIncome = 0.0;
        this.totalExpenses = 0.0;
    }

    // Method to add income
    public void addIncome(double amount) {
        if (amount > 0) {
            totalIncome += amount;
            logger.info("Income added: Rs." + amount);
        } else {
            logger.warn("Invalid income amount: Rs." + amount);
        }
    }

    // Method to add expense
    public void addExpense(double amount) {
        if (amount > 0) {
            totalExpenses += amount;
            logger.info("Expense added: Rs." + amount);
        } else {
            logger.warn("Invalid expense amount: Rs." + amount);
        }
    }

    // Method to calculate current balance
    public double getBalance() {
        return totalIncome +current_balance - totalExpenses;
    }

    // Method to display financial summary
    public void displaySummary() {
        String summary = "\nFinancial Summary:\n" +
        		"Carried forward balance: Rs."+current_balance+"\n"+
                "Total Income: Rs." + totalIncome + "\n" +
                "Total Expenses: Rs." + totalExpenses + "\n" +
                "Current Balance: Rs." + getBalance();
        logger.info(summary);
    }
    public static String readLastLine(String filePath) {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            long fileLength = file.length();
            StringBuilder sb = new StringBuilder();

            // Start reading from the end of the file
            for (long pointer = fileLength - 1, newlineCount = 0; pointer >= 0; pointer--) {
                file.seek(pointer);
                char c = (char) file.read();

                // If a newline character is found, increment newlineCount
                if (c == '\n') {
                    newlineCount++;
                    if (newlineCount >= 2) {
                        break;
                    }
                }

                // Append character to StringBuilder
                sb.insert(0, c);
            }

            // Trim any leading newline or carriage return characters
            while (sb.length() > 0 && (sb.charAt(0) == '\n' || sb.charAt(0) == '\r')) {
                sb.deleteCharAt(0);
            }

            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

 public static float getCurrentBalance() {
	 String filePath = "logs/financeapp.log";
     String lastLine = readLastLine(filePath);
     String[] current_balance_split = lastLine.split("Rs.");
     Float curr_bal = Float.parseFloat(current_balance_split[1]);
     return curr_bal;
 }

    // Main method to test the class
    public static void main(String[] args) {
    	try {
    		
    		current_balance = getCurrentBalance();
    	}
       finally {
    	   
       
        // Configure logger programmatically for simplicity
        Configurator.setRootLevel(Level.INFO);

        FinanceManager financeManager = new FinanceManager();

        // Add some incomes and expenses
        financeManager.addIncome(2000);
        financeManager.addIncome(500);
        financeManager.addExpense(300);
        financeManager.addExpense(200);

        // Display financial summary
        financeManager.displaySummary();
    }
    }
}
