package ThreadsRPT;

public class Thread07_WaitAndNotify {

    static int sharedBalance = 0;

    public static void main (String[] args) {

        Thread07_WaitAndNotify obj = new Thread07_WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run () {
                obj.take(1000);
            }
        });

        thread1.setName("Student");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run () {
           obj.send(1500);
            }
        });

        thread2.setName("Father");
        thread2.start();




    }

    public synchronized void take(int amount){
        System.out.println(Thread.currentThread().getName()+" wants to take money");
        if (sharedBalance<amount || sharedBalance==0) {
            System.out.println("balance is not enough: "+sharedBalance);
            System.out.println("waiting for balance to be sent");

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(sharedBalance>=amount){
                sharedBalance=sharedBalance-amount;
                System.out.println("amount has been took successfully: "+sharedBalance);
            }else {
                System.out.println("balance is not enough: "+sharedBalance);
                System.out.println("tell your parent to send more");
            }
        }else {
            sharedBalance = sharedBalance-amount;
            System.out.println("amount has been took successfully: "+sharedBalance);
        }
    }


    public synchronized void send(int amount){
        System.out.println(Thread.currentThread().getName()+" want to send amount...");
        sharedBalance= sharedBalance+amount;
        System.out.println("the amount is send. current amount is : "+sharedBalance);
        notify();
    }

}
