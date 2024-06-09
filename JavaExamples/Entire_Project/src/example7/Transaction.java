package example7;

public class Transaction {
    private String user;
    private double amount;
    private String type; // "Deposit" or "Withdrawal"

    public Transaction(String user, double amount, String type) {
        this.user = user;
        this.amount = amount;
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}
