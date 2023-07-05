package ThreadsTR;

public class WaitInterrupt {

    public static int balance  = 0;
    public static void main (String[] args) {

        WaitInterrupt waitInterrupt = new WaitInterrupt();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run () {
                waitInterrupt.withdraw(10000);
            }
        });
        thread1.start();
        thread1.setName("Customer");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run () {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                waitInterrupt.deposit(2000);
                thread1.interrupt();
            }
        });
        thread2.start();
        thread2.setName("Producer");




    }

    public synchronized void withdraw(int amount){
        if(balance>=amount){
            balance=balance-amount;
            System.out.println("remain balance is : "+balance);
        }else {
            System.out.println("not enough balance wait for your parent to deposit");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Customer thread stopped hardly");
                System.out.println("please check your balance again");
            }
            System.out.println("your parent deposit to the balance ");
            if(balance>=amount){
                balance=balance-amount;
                System.out.println("remain balance is : "+balance);
            }else{ System.out.println("not enough balance tell your parent to deposit more");}

        }
    }

    public synchronized void deposit(int amount){
        balance= balance+amount;
        System.out.println("balance deposited");
    }

}
