package ThreadsTR;

public class ThreadCreationWays {
    public static void main (String[] args) {

        System.out.println(Thread.currentThread().getName());


        MyThread thread = new MyThread();
        //thread.run();
        thread.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        //thread1.run();
        thread1.start();

        Thread thread2  = new Thread(new Runnable() {
            @Override
            public void run () {
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("this thread runs by unnamed class");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        thread2.start();

        Thread thread3 = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("this thread runs by lambda");
        });
        thread3.start();


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main thread finished ");








    }

}

class MyThread extends Thread{

    @Override
    public void run () {
        System.out.println(Thread.currentThread().getName());
        System.out.println("MyThread is running");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run () {
        System.out.println(Thread.currentThread().getName());
        System.out.println("MyRunnable is running");
    }
}
