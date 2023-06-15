package Threads;

public class CounterWithoutThread {

    private String name;

    public CounterWithoutThread(String name) {
        this.name = name;
    }

    public void countMe(){
        for (int i=1; i<=10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name+" count is: "+i);
        }
    }

    public static void main(String[] args) {
        CounterWithoutThread counter1 = new CounterWithoutThread("Counter1");
        CounterWithoutThread counter2 = new CounterWithoutThread("Counter2");

        long startTime = System.currentTimeMillis();

        counter1.countMe();
        System.out.println("-------------");
        counter2.countMe();

        long endTime = System.currentTimeMillis();

        System.out.println("Duration Without MultiThread: "+ (endTime-startTime));

    }

}
