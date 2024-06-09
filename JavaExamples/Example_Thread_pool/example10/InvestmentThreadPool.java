package example10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvestmentThreadPool {
	private static final Logger logger = LogManager.getLogger("example10");
    public static void main(String[] args) {
        // Create a thread pool with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Create a shared investment portfolio
        InvestmentPortfolio portfolio = new InvestmentPortfolio();

        // Submit investment tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            executor.submit(new InvestmentTask(portfolio, i));
        }

        // Shutdown the executor
        executor.shutdown();
        try {
            // Wait for all tasks to finish
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                // Forcefully shutdown if tasks are not completed within the timeout
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final value of the investment portfolio
        logger.info("Final value of the investment portfolio: $" + portfolio.getTotalValue());
    }
}

class InvestmentPortfolio {
    private double totalValue = 0;

    public synchronized void invest(double amount) {
        totalValue += amount;
    }

    public synchronized double getTotalValue() {
        return totalValue;
    }
}

class InvestmentTask implements Runnable {
	private static final Logger logger = LogManager.getLogger("example10");
    
    private InvestmentPortfolio portfolio;
    private int investorId;

    public InvestmentTask(InvestmentPortfolio portfolio, int investorId) {
        this.portfolio = portfolio;
        this.investorId = investorId;
    }

    @Override
    public void run() {
        // Simulate an investment
        double amount = Math.random() * 1000;
        portfolio.invest(amount);
        logger.info("Investor " + investorId + " invested $" + amount);
    }
}
