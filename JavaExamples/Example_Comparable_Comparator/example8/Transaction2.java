package example8;

public class Transaction2 {
    private String user;
    private double amount;
    private String type; // "Deposit" or "Withdrawal"

    public Transaction2(String user, double amount, String type) {
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

    @Override
    public String toString() {
        return "Transaction{" +
                "user='" + user + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
