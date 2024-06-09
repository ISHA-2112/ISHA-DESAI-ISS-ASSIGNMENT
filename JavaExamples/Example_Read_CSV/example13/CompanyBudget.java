package example13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompanyBudget {
	private static final Logger logger = LogManager.getLogger("example13");
    public static void main(String[] args) {
        // Create some sample finance data
        List<FinanceData> financeDataList = new ArrayList<>();
        financeDataList.add(new FinanceData("Company A", 10000, "USD"));
        financeDataList.add(new FinanceData("Company B", 20000, "EUR"));

        // Write finance data to CSV file
        writeFinanceDataToCSV(financeDataList, "companyCSV.csv");

        // Read finance data from CSV file
        List<FinanceData> readFinanceDataList = readFinanceDataFromCSV("companyCSV.csv");
        logger.info("Read finance data:");
        for (FinanceData financeData : readFinanceDataList) {
            logger.info(financeData);
        }
    }

    // Method to write finance data to CSV file
    private static void writeFinanceDataToCSV(List<FinanceData> financeDataList, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Name,Balance,Currency\n");
            for (FinanceData financeData : financeDataList) {
                writer.write(financeData.getName() + "," + financeData.getBalance() + "," + financeData.getCurrency() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read finance data from CSV file
    private static List<FinanceData> readFinanceDataFromCSV(String fileName) {
        List<FinanceData> financeDataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                double balance = Double.parseDouble(parts[1]);
                String currency = parts[2];
                financeDataList.add(new FinanceData(name, balance, currency));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return financeDataList;
    }
}

// FinanceData class
class FinanceData {
    private String name;
    private double balance;
    private String currency;

    public FinanceData(String name, double balance, String currency) {
        this.name = name;
        this.balance = balance;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "FinanceData{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}
