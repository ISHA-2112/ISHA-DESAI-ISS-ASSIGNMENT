package example12;

import java.io.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompanyBudget {
	private static final Logger logger = LogManager.getLogger("example12");
    public static void main(String[] args) {
        // Create a sample finance data
        FinanceData financeData = new FinanceData("Company A", 10000, "USD");
       
        // Write finance data to XML file
        writeFinanceDataToXML(financeData, "finance_data.xml");
        // Read finance data from XML file
        FinanceData readFinanceData = readFinanceDataFromXML("finance_data.xml");
        logger.info("Read finance data:");
        logger.info(readFinanceData);
    }

    // Method to write finance data to XML file
    private static void writeFinanceDataToXML(FinanceData financeData, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("<financeData>\n");
            writer.write("\t<name>" + financeData.getName() + "</name>\n");
            writer.write("\t<balance>" + financeData.getBalance() + "</balance>\n");
            writer.write("\t<currency>" + financeData.getCurrency() + "</currency>\n");
            writer.write("</financeData>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read finance data from XML file
    private static FinanceData readFinanceDataFromXML(String fileName) {
        String name = "";
        double balance = 0;
        String currency = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("<name>")) {
                    name = line.substring(line.indexOf("<name>") + 6, line.indexOf("</name>"));
                } else if (line.contains("<balance>")) {
                    balance = Double.parseDouble(line.substring(line.indexOf("<balance>") + 9, line.indexOf("</balance>")));
                } else if (line.contains("<currency>")) {
                    currency = line.substring(line.indexOf("<currency>") + 10, line.indexOf("</currency>"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FinanceData(name, balance, currency);
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
