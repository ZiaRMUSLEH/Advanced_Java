package ThreadsTR;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main (String[] args) {

        int availableProcessor = Runtime.getRuntime().availableProcessors();

        ExecutorService service = Executors.newFixedThreadPool(3);

        ThreadCreator thread1 = new ThreadCreator("A");
        ThreadCreator thread2 = new ThreadCreator("B");
        ThreadCreator thread3 = new ThreadCreator("C");
        ThreadCreator thread4 = new ThreadCreator("D");
        ThreadCreator thread5 = new ThreadCreator("E");
        ThreadCreator thread6 = new ThreadCreator("F");

//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();

        service.execute(thread1);
        service.execute(thread2);
        service.execute(thread3);
        service.execute(thread4);
        service.execute(thread5);
        service.execute(thread6);

        service.shutdown();


    }
}

class ThreadCreator extends Thread{
    private String name;

    public ThreadCreator (String name) {
        this.name = name;
    }

    @Override
    public void run () {
       String threadName =  Thread.currentThread().getName();
        System.out.println(threadName+" has started working");
        System.out.println(threadName+" is working on "+name);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" has finished");
    }
}
