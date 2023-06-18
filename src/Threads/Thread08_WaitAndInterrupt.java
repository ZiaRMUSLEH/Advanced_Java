package Threads;

public class Thread08_WaitAndInterrupt {
    static public int balance = 0;
    public static void main(String[] args) {
        Thread08_WaitAndInterrupt obj = new Thread08_WaitAndInterrupt();
        //create first thread and named as student thread
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(1000);
            }
        });
        //thread1.run();
        thread1.setName("Student");
        thread1.start();

        //create second thread and set name as Father
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000); //to see what is happening more clearly
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(1500);
                thread1.interrupt();
            }
        });
        thread2.setName("Father");
        thread2.start();

    }

    //withdraw method
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" wants to withdraw money");
        if(balance<=0 || balance<amount) {
            System.out.println("Insufficient balance: " + balance);
            System.out.println("Waiting for the balance to be deposited");
            try {
                wait(); //Causes the current thread to wait until it is awakened, typically by being notified or interrupted.
            } catch (InterruptedException e) {
                //e.printStackTrace();
                if(balance>=amount){
                    balance = balance -amount;
                    System.out.println("Amount has been withdrawn successfully: "+balance);
                }else {
                    System.out.println("Insufficient amount: "+balance);
                    System.out.println("Tell your parents to deposit more))");
                }
            }
        }

    }

    //deposit method
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" wants to deposit amount ...");
        balance = balance+amount;
        System.out.println("The amount is deposited. Current balance is : "+balance);

    }
}
