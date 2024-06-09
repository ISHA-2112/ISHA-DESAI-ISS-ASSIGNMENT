package example11;
import java.io.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompanyBudget {
	private static final Logger logger = LogManager.getLogger("example11");

    public static void main(String[] args) {
        // Create a sample company
        Company company = new Company("Company A", 1000000, "New York");

        // Write company to JSON file
        writeCompanyToJson(company, "company.json");

        // Read company from JSON file
        Company readCompany = readCompanyFromJson("company.json");
        
       logger.info(readCompany);
    }

    // Method to write a company to JSON file
    private static void writeCompanyToJson(Company company, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(company.toJSON());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read a company from JSON file
    private static Company readCompanyFromJson(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            return Company.fromJSON(jsonString.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// Company class
class Company {
    private String name;
    private int revenue;
    private String location;

    public Company(String name, int revenue, String location) {
        this.name = name;
        this.revenue = revenue;
        this.location = location;
    }

    // Convert Company object to JSON string
    public String toJSON() {
        return String.format("{\"name\":\"%s\",\"revenue\":%d,\"location\":\"%s\"}", name, revenue, location);
    }

    // Convert JSON string to Company object
    public static Company fromJSON(String json) {
        String[] parts = json.substring(1, json.length() - 1).split(",");
        String name = parts[0].split(":")[1].replaceAll("\"", "");
        int revenue = Integer.parseInt(parts[1].split(":")[1]);
        String location = parts[2].split(":")[1].replaceAll("\"", "");
        return new Company(name, revenue, location);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", revenue=" + revenue +
                ", location='" + location + '\'' +
                '}';
    }
}
