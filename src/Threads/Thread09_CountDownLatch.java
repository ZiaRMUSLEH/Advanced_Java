package Threads;

import java.util.concurrent.CountDownLatch;

public class Thread09_CountDownLatch {
    public static void main(String[] args) {
        //A synchronization aid that allows one or more threads
        // to wait until a set of operations being performed in other
        // threads completes.
        CountDownLatch latch = new CountDownLatch(4);
        //to denote testers we have created 2 threads and called await method to wait
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Test1 team  is started to to test the App...");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Test2 team  is started to to test the App...");
            }
        });
        t1.start();
        t2.start();

        AssignTaskThread first = new AssignTaskThread(1000, latch, "Dev-1");
        AssignTaskThread second = new AssignTaskThread(2000, latch, "Dev-2");
        AssignTaskThread third = new AssignTaskThread(3000, latch, "Dev-3");
        AssignTaskThread fourth = new AssignTaskThread(4000, latch, "Dev-4");
        first.start();
        second.start();
        third.start();
        fourth.start();


        //if we want to await next lines in main method we can start await() method
        //from CountDownLatch obj
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(Thread.currentThread().getName()+" has finished..");
        System.out.println("App is ready to be released...");

    }
}
class AssignTaskThread extends Thread{
    private int delay; //to set delay time
    private CountDownLatch latch;

    //constructor

    public AssignTaskThread(int delay, CountDownLatch latch, String name) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName()+" started");
            //it will do some task
            Thread.sleep(delay);
            System.out.println(Thread.currentThread().getName()+" finished");
            latch.countDown(); //countDown() Decrements the count of the latch, releasing
            // all waiting threads if the count reaches zero.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}