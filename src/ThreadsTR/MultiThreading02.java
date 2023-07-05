package ThreadsTR;

public class MultiThreading02 {
    public static int counter=0;
    public static void main (String[] args) {


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run () {

                System.out.println(Thread.currentThread().getName()+" has started");
                Counter.increaseCounter();
                System.out.println("other codes are working ");
            }
        });
        thread1.setName("Tom");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run () {

                System.out.println(Thread.currentThread().getName()+" has started");
                Counter.increaseCounter();
                System.out.println("other codes are working ");
            }
        });
        thread2.setName("Jerry");
        thread2.start();

    }
}
class Counter{

    public synchronized static void increaseCounter(){
        for (int i = 1; i < 1001; i++) {
            MultiThreading02.counter++;
        System.out.println(Thread.currentThread().getName()+"Counter : "+MultiThreading02.counter);
    }
    }
}