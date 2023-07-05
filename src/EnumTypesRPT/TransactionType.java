package EnumTypesRPT;

public enum TransactionType {

    DEPOSIT("DEPOSIT"),
    WITHDRAW("WITHDRAW"),
    TRANSFER("TRANSFER"),
    PAYMENT("PAYMENT"),
    OTHER("OTHER");


    private final String value;


    TransactionType (String value) {
        this.value = value;
    }
}
