package ThreadsTR;

public class WaitNotify {
    public static int balance  = 0;
    public static void main (String[] args) {

        WaitNotify waitNotify = new WaitNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run () {
                waitNotify.withdraw(500);
            }
        });
        thread1.start();
        thread1.setName("Student");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run () {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                waitNotify.deposit(10000);
            }
        });
        thread2.start();
        thread2.setName("Parent");




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
                throw new RuntimeException(e);
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
        notify();
    }

}
