package HW_55;

/**
 * 24.11.2023
 * Menu
 *
 * @author Mihail nedioglo (AIT TR)
 */
public class Transaction {
    private int amount;
    private TransactionType type;
    private long timestamp;

    public Transaction(int amount, TransactionType type, long timestamp) {
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
    }

    public int getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }
}

