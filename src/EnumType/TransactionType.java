package EnumType;

public enum TransactionType {
    DEPOSIT(1),
    WITHDRAW(2),
    TRANSFER(3),
    PAYMENT(4),
    OTHER(100);

    private final int transactionCode;

    private TransactionType (int transactionCode) {
        this.transactionCode = transactionCode;
    }

    public int getTransactionCode () {
        return transactionCode;
    }
}
