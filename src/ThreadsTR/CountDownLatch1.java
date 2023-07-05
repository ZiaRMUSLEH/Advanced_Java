package ThreadsTR;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch1 {
    public static void main (String[] args) {

        CountDownLatch latch = new CountDownLatch(4);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run () {

                try {latch.await();
                    System.out.println(Thread.currentThread().getName()+" started working");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" finished working");

            }
        });
        thread1.setName("Tester 1");



        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run () {
                try {latch.await();
                    System.out.println(Thread.currentThread().getName()+" started working");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" finished working");
            }
        });
        thread2.setName("Tester 2");



    Developers dev1 = new Developers("DEV-1 ",5000,latch);
    Developers dev2 = new Developers("DEV-2 ",4000,latch);
    Developers dev3 = new Developers("DEV-3 ",6000,latch);
    Developers dev4 = new Developers("DEV-4 ",2000,latch);

        thread1.start();
        thread2.start();
        dev1.start();
        dev2.start();
        dev3.start();
        dev4.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+" is running");


    }
}

class Developers extends Thread{

    private String name;
    private int duration;
    private CountDownLatch latch;

    public Developers (String name, int duration, CountDownLatch latch) {
        super(name);
        this.duration = duration;
        this.latch = latch;
    }

    @Override
    public void run () {
        System.out.println(Thread.currentThread().getName()+" has started working ");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" is finished");
        latch.countDown();
    }
}