package ThreadsRPT;

public class Thread02_Synchronization {

    public static int counter =0;

    public static void main (String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run () {
                System.out.println(Thread.currentThread().getName()+" is running");
                Counter.count();
                System.out.println(Thread.currentThread().getName()+" is done");
            }
        });



        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run () {
                System.out.println(Thread.currentThread().getName()+" is running");
                Counter.count();
                System.out.println(Thread.currentThread().getName()+" is done");
            }
        });


        thread1.setName("T1");
        thread2.setName("T2");

        thread1.start();
        thread2.start();








    }


}

class Counter{

    public synchronized static void count(){
        for(int i =1; i<=1000; i++ ){
            Thread02_Synchronization.counter++;
        }
        System.out.println("Counter value: "+Thread02_Synchronization.counter);
    }


}
