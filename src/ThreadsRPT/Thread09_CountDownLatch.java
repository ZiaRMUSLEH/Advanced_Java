package ThreadsRPT;

import java.util.concurrent.CountDownLatch;

public class Thread09_CountDownLatch {

    public static void main (String[] args) {
        //A synchronization aid that allows one or more threads
        // to wait until a set of operations being performed in other
        // threads completes.

        CountDownLatch latch = new CountDownLatch(4);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run () {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Test1 team is started to test the app");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run () {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Test2 team is started to test the app");
            }
        });
        t1.start();
        t2.start();

        AssignTaskThread first = new AssignTaskThread(1000,latch, "Dev-1");
        AssignTaskThread second = new AssignTaskThread(2000,latch, "Dev-2");
        AssignTaskThread third = new AssignTaskThread(3000,latch, "Dev-3");
        AssignTaskThread fourth = new AssignTaskThread(4000,latch, "Dev-4");

        first.start();
        second.start();
        third.start();
        fourth.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+" has finished ....");
        System.out.println("App is ready to deploy");


    }

}

class AssignTaskThread extends Thread {
    private int delay;
    private CountDownLatch latch;

    public AssignTaskThread (int delay, CountDownLatch latch, String name) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run () {

        try {
            System.out.println(Thread.currentThread().getName()+" started");
            Thread.sleep(delay);
            System.out.println(Thread.currentThread().getName()+" finished");
            latch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
