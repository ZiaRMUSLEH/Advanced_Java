package ThreadsRPT;

public class Thread01_Creation {

    public static void main (String[] args) {

        System.out.println("current Thread: "+Thread.currentThread().getName());

        MyThread thread1 = new MyThread();
        thread1.start();
        //thread1.run();





        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run () {
                System.out.println("current Thread: "+Thread.currentThread().getName());
            }
        });
        thread2.setName("Anonymous Thread");
        thread2.start();




        Thread thread3 = new Thread(()->{
            System.out.println("Current Thread: "+ Thread.currentThread().getName());

        });

        thread3.setName("Lambda Thread");
        thread3.start();









    }



}

class MyThread extends Thread {
    @Override
    public void run () {
        System.out.println("MyThread is running. ");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run () {
        System.out.println("MyRunnable is running.");
    }
}
