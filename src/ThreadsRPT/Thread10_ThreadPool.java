package ThreadsRPT;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Thread10_ThreadPool {
    public static void main (String[] args) {

        int availableProcessors= Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors = " + availableProcessors);
        ExecutorService service =Executors.newFixedThreadPool(availableProcessors);
        //ExecutorService service =Executors.newFixedThreadPool(4);

        for (int i = 1; i < 11; i++) {
            Task task = new Task();
            task.setName("task"+i);
            service.execute(task);

        }
        service.shutdown();




    }


}
class Task extends Thread{




    @Override
    public void run () {

        try {
            System.out.println(Thread.currentThread().getName()+" started to run");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" completed its task");
    }
}
