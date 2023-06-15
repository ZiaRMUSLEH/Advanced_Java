package Threads;

public class Thread02_Synchronization {

    public static int counter = 0;

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" is running.");
                Counter.count();
                System.out.println(Thread.currentThread().getName()+" is done.");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" is running.");
                Counter.count();
                System.out.println(Thread.currentThread().getName()+" is done.");
            }
        });

        thread1.setName("T1");
        thread2.setName("T2");

        thread1.start();
        thread2.start();

    }

}

class Counter{

    // counter should be "1000" and "2000" after the count() method finishes.

    public synchronized static void count(){
        for (int i=1; i<=1000; i++){
            Thread02_Synchronization.counter++;
        }
        System.out.println("Counter Value: "+Thread02_Synchronization.counter);
    }

}
