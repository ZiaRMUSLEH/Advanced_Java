package Threads;

public class Thread12_DeadLock {
    public static void main(String[] args) {
        final String obj1 = "Pencil";
        final String obj2 = "Ruler";
        //thread1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj1){
                    System.out.println(Thread.currentThread().getName()+" is using "+obj1);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (obj2){
                        System.out.println(Thread.currentThread().getName()+" wants use "+obj2);
                    }
                    System.out.println(Thread.currentThread().getName()+" completed his drawing... ");
                }
            }
        });
        thread1.setName("John");
        thread1.start();

        //thread2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj2){
                    System.out.println(Thread.currentThread().getName()+" is using "+obj2);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (obj2){
                        System.out.println(Thread.currentThread().getName()+" wants use "+obj1);
                    }
                }
                System.out.println(Thread.currentThread().getName()+" completed his drawing... ");
            }
        });
        thread2.setName("Jerry");
        thread2.start();
    }
}
