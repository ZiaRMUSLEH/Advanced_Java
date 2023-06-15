package Threads;

public class Thread01_Creation {

    public static void main(String[] args) {

        System.out.println("Current Thread: "+Thread.currentThread().getName());

        MyThread thread1 = new MyThread();
        thread1.start();        // Creates a thread, then runs the code inside.
        //thread1.run();        // Won't create a thread, just runs like a normal method.

        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();

        // Creating an Anonymous Thread
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Current Thread: "+ Thread.currentThread().getName());
            }
        });
        thread3.setName("Anonymous Thread");
        thread3.start();

        // Creating Threads With Lambda
        Thread thread4 = new Thread(()->{
            System.out.println("Current Thread: "+ Thread.currentThread().getName());
        });
        thread4.setName("Lambda Thread");
        thread4.start();

    }

}

// 1st way to create a Thread: extending the Thread class
class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("MyThread is running.");
    }
}

// 2nd way to create a Thread: implementing the Runnable interface
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("MyRunnable thread is running.");
    }
}
