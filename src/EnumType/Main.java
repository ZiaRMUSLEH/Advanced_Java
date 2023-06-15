package EnumType;

public class Main {
    public static void main (String[] args) {

        //useConstant(220);
        useEnum(TransactionType.TRANSFER);

    }

    private static void useConstant (int i){
        if(i==TransactionTypeConstant.DEPOSIT){System.out.println("money has been deposited");} else
        if(i==TransactionTypeConstant.WITHDRAW){System.out.println("money has been withdrawn");} else
        if(i==TransactionTypeConstant.TRANSFER){System.out.println("money has been transferred");} else
        if(i==TransactionTypeConstant.PAYMENT){System.out.println("money has been paid");} else
        if(i==TransactionTypeConstant.OTHER){System.out.println("other");}
        else {System.out.println("no transaction type found");}

        }

        private static void useEnum (TransactionType transactionType){
            if(transactionType==TransactionType.DEPOSIT){System.out.println("money has been deposited");} else
            if(transactionType==TransactionType.WITHDRAW){System.out.println("money has been withdrawn");} else
            if(transactionType==TransactionType.TRANSFER){System.out.println("money has been transferred");} else
            if(transactionType==TransactionType.PAYMENT){System.out.println("money has been paid");} else
            if(transactionType==TransactionType.OTHER){System.out.println("other");}

            //Enum Related Concepts
            System.out.println("Enum name: "+transactionType.name());
            System.out.println("Enum code: "+transactionType.getTransactionCode());
            System.out.println("Enum ordinal: "+transactionType.ordinal());


        }




    }

