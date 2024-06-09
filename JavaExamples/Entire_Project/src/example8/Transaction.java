package example8;

public class Transaction implements Comparable<Transaction> {
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

    @Override
    public int compareTo(Transaction other) {
        return Double.compare(this.amount, other.amount);
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
