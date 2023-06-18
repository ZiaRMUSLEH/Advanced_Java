package Threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread10_ThreadPool {
    public static void main(String[] args) {

        int availableProcessor = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessor);
        //to start thread pool
        //ExecutorService service = Executors.newFixedThreadPool(4);
        ExecutorService service = Executors.newFixedThreadPool(availableProcessor);

        Task task1 = new Task("Task1");
        Task task2 = new Task("Task2");
        Task task3 = new Task("Task3");
        Task task4 = new Task("Task4");
        Task task5 = new Task("Task5");
        Task task6 = new Task("Task6");
        Task task7 = new Task("Task7");
        Task task8 = new Task("Task8");
        Task task9 = new Task("Task9");
        Task task10 = new Task("Task10");
//normally we can start the thread,
//        task1.start();
//        task2.start();
//        task3.start();
//        task4.start();
//        task5.start();
//        task6.start();
//        task7.start();
//        task8.start();
//        task9.start();
//        task10.start();

        service.execute(task1);
        service.execute(task2);
        service.execute(task3);
        service.execute(task4);
        service.execute(task5);
        service.execute(task6);
        service.execute(task7);
        service.execute(task8);
        service.execute(task9);
        service.execute(task10);

        //
        service.shutdown(); //we are terminating started threads after completing their

    }
}

class Task extends Thread{
    private String threadName;
    //constructor

    public Task(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(threadName+" thread started to run ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadName+ "thread completed its task");

    }
}