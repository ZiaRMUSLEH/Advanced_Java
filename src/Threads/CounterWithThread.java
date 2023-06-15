package Threads;

public class CounterWithThread extends Thread{

    private String name;

    public CounterWithThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        countMe();
    }

    public void countMe(){
        for (int i=1; i<=10; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name+" count is: "+i);
        }
    }

}

class Main{

    public static void main(String[] args) {

        CounterWithThread counter1 = new CounterWithThread("Counter1");
        CounterWithThread counter2 = new CounterWithThread("Counter2");
        counter1.start();
        counter2.start();
        try {
            counter1.join();
            counter2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------------");



    }

}
