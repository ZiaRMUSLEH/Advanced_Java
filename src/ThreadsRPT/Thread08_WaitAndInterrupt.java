package ThreadsRPT;

public class Thread08_WaitAndInterrupt {
    public static int balance = 0;

    public static void main (String[] args) {

        Thread08_WaitAndInterrupt obj = new Thread08_WaitAndInterrupt();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run () {
                obj.withdraw(1000);
            }
        });
        thread1.setName("Student");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run () {
                obj.deposit(20000);
                thread1.interrupt();
            }
        });
        thread2.setName("Father");
        thread2.start();



    }

    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+ " wants withdraw money ");
        if(balance==0|| balance<amount){
            System.out.println("not enough money in account: "+balance);
            System.out.println("Waiting for the balance to be deposited");
            try {
                wait();
            } catch (InterruptedException e) {

                if(balance>=amount){
                    balance= balance-amount;
                    System.out.println("amount withdrawn successfully: "+balance);
                }else  {
                    System.out.println("deposited money is not enough: "+balance);
                    System.out.println(" deposit more money");
                }

            }


        }
    }


    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" wants to deposit amount ...");
        balance=balance+amount;
            System.out.println("money deposited: " + balance);



    }

}
