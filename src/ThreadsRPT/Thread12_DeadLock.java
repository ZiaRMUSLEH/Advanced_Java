package ThreadsRPT;

public class Thread12_DeadLock {
    public static void main (String[] args) {


    final String obj1 = "pencil";
    final String obj2 = "ruler";

    //1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run () {
                synchronized (obj1) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " is using " + obj1);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (obj2){
                        System.out.println(Thread.currentThread().getName() + " wants to use " + obj2);
                        System.out.println(Thread.currentThread().getName() + " completed his drawing");
                    }}
            }
        });
    thread1.setName("john");
    thread1.start();



    //2
    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run () {
synchronized (obj1) {
    try {
        System.out.println(Thread.currentThread().getName() + " is using " + obj1);
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    synchronized (obj2){
    System.out.println(Thread.currentThread().getName() + " wants to use " + obj2);
    System.out.println(Thread.currentThread().getName() + " completed his drawing");
}}
        }
    });
        thread2.setName("jerry");
    thread2.start();

}}
