package EnumTypesRPT;

public class Runner {
    public static void main (String[] args) {

//        useConstant("DEPOSIT");
//        useConstant("WITHDRAW");
//        useConstant("TRANSFER");
//        useConstant("PAYMENT");
//        useConstant("OTHER");

        useEnum(TransactionType.DEPOSIT);




    }
    public static void useConstant(String choice){
        switch (choice){
            case TransactionTypeConstant.DEPOSIT : System.out.println("Money deposited");break;
            case TransactionTypeConstant.WITHDRAW:  System.out.println("Money withdrawn");break;
            case TransactionTypeConstant.TRANSFER:  System.out.println("Money transferred");break;
            case TransactionTypeConstant.PAYMENT:  System.out.println("Money paid");break;
            case TransactionTypeConstant.OTHER:  System.out.println("other");break;
            default:  System.out.println("invalid choice");break;

        }
    }

    public static void useEnum(TransactionType value){
        switch (value){
            case DEPOSIT : System.out.println("Money deposited");break;
            case WITHDRAW:  System.out.println("Money withdrawn");break;
            case TRANSFER:  System.out.println("Money transferred");break;
            case PAYMENT:  System.out.println("Money paid");break;
            case OTHER:  System.out.println("other");break;
            default:  System.out.println("invalid choice");break;

        }
    }
}
